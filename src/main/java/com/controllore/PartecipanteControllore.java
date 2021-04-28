package com.controllore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Gara;
import com.model.Partecipante;
import com.service.GaraService;
import com.service.PartecipanteService;


@Controller
@RequestMapping("/part")
public class PartecipanteControllore {

	@Autowired
	private GaraService garaService;

	@Autowired
	private PartecipanteService partecipanteService;

	@PostMapping("/add")
	public String addPartecipante(@RequestParam("nome") String nome, @RequestParam("cognome") String cognome,
			@RequestParam("email") String email, @RequestParam("password") String password, Model model) {

		Partecipante p = partecipanteService.findByMail(email);

		if (p != null) {
			model.addAttribute("result", "L'email è gia presente");
			return "registrazione";
		}

		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
		
		Partecipante partecipante = new Partecipante();
		partecipante.setCognome(cognome);
		partecipante.setNome(nome);
		partecipante.setEmail(email);
		partecipante.setPassword(encoder.encode(password));

		try {

			partecipanteService.save(partecipante);

			model.addAttribute("result", "il partecipante è stato aggiunto");
			return "registrazione";

		} catch (Exception e) {

			model.addAttribute("result", "Errore nel aggiunta del Partecipante");
			return "registrazione";

		}

	}

	@PostMapping("/prenota")
	@ResponseBody
	public String addPartecipante(@RequestParam("id") int idGara, @RequestParam("email") String emailPartecipante) {

		Gara gara = garaService.findById(idGara);
		Set<Partecipante> partecipanti = gara.getPartecipante();

		if (partecipanti == null) {
			
		    partecipanti = new HashSet<Partecipante>();
			gara.setPartecipante(partecipanti);
		}
		
		try {

			garaService.aggiungePartecipanti(gara, emailPartecipante);

			garaService.saveGara(gara);

			return "SUCESSO";

		} catch (Exception e) {
			return "ERRORE";
		}

	}

}

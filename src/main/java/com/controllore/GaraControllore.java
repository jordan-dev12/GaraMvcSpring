package com.controllore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.model.Gara;
import com.model.Partecipante;
import com.service.GaraService;
import com.service.PartecipanteService;

@Controller
@RequestMapping("/gara")
public class GaraControllore {

	@Autowired
	private GaraService garaService;
	
	@Autowired
	private PartecipanteService partecipanteService;

	@PostMapping("/add")
	public String addGara(@RequestParam("nome") String nome, @RequestParam("luogo") String luogo,
			@RequestParam("data") String dataString, Model model) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

		Date date = null;
		try {
			date = (Date) formatter.parse(dataString);
		} catch (ParseException e) {

			model.addAttribute("OK", "La data deve essere formato in modo dd-MM-yyyy");
			return "admin";
		}
		
		Gara gara = new Gara();

		gara.setNome(nome);
		gara.setLuogo(luogo);
		gara.setData(date);
		
		
		try {
			
			garaService.saveGara(gara);

			model.addAttribute("OK", "La Gara e stata aggiunta");
			return "admin";
			
			
			
		} catch (Exception e) {
			
			model.addAttribute("OK", "E presente una gara con lo stesso nome");
			return "admin";
		}


	}

	@GetMapping("/list")
	public String listGara(Model model) {
		
		List<Gara> result = garaService.listGara();

		model.addAttribute("result", result);
		return "listGare";

	}

	@DeleteMapping("/delete")
	public @ResponseBody String delete(@RequestParam("nome") String nome, Model model) {

		try {

			garaService.deleteGara(nome);
			return "SUCESSO";

		} catch (Exception e) {

			return "ERRORE";
		}

	}

	@GetMapping("/ritorno")
	public String ritorno() {
		return "admin";
	}


	
	@GetMapping("/listPartecipante")
	public String list(@RequestParam("id") int idGara,Model model)
	{
		try {
			
			List<Partecipante> result = partecipanteService.findListPartecipante(idGara);
			
			model.addAttribute("result", result);
			return "listPartecipante";
			
		} catch (Exception e) {
			
			return "listGare";
		}
		
	}
	
	


	

}

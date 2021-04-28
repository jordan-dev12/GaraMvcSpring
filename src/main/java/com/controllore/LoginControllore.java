package com.controllore;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.security.CostantiSecurity;
import com.security.JwtUtil;
import com.service.GaraService;
import com.service.PartecipanteService;


@Controller
public class LoginControllore {

	@Autowired
	private PartecipanteService partecipanteService;

	@Autowired
	private GaraService garaService;
	
	@Autowired
    private AuthenticationManager  authenticationManager;

	
	@GetMapping("/")
	public String homePage() {
		
		return "login";
	}

//	@PostMapping("/login")
//	public String homeLogin(@RequestParam("username") String username, @RequestParam("password") String password,
//			Model model) {
//
//		if (username.equals("admin") && password.equals("admin")) {
//
//			return "admin";
//
//		} else {
//
//			Partecipante partecipante = partecipanteService.findByMail(username);
//
//			if (partecipante != null) {
//
//				if (partecipante.getPassword().equals(password)) {
//
//					List<Gara> result = garaService.listGara();
//
//					model.addAttribute("result", result);
//					model.addAttribute("nome", partecipante.getNome());
//					model.addAttribute("email", partecipante.getEmail());
//					return "partecipante";
//				}
//			}
//
//			model.addAttribute("result", "inserisce una password valida");
//			return "login";
//		}
//	}
	
	@PostMapping("/login")
	public String homeLogin( @RequestParam("username") String username, @RequestParam("password") String password,
			Model model,HttpServletResponse response) {
		
		// Effettuo l autenticazione
		
		System.out.println("sono qua");
		
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token= JwtUtil.generateToken(username);
		
		
		response.setHeader(CostantiSecurity.header,token);
		return "admin";

	}

	@GetMapping("/registra")
	public String vaRegistrazione() {

		return "registrazione";
	}

}

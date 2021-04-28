package com.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.model.Partecipante;
import com.repository.PartecipanteRepositroy;


@Service
public class PartecipanteServiceImpl implements PartecipanteService,UserDetailsService{

	@Autowired
	private PartecipanteRepositroy partecipanteRepository;
	
	@Override
	public void save(Partecipante partecipante) {
		
		partecipanteRepository.save(partecipante);
		
	}

	@Override
	public List<Partecipante> listPartecipante() {
		
		return partecipanteRepository.findAll();
	}

	@Override
	public List<Partecipante> findListPartecipante(int idGara) {
		
		return  partecipanteRepository.findListPartecipanteByIdGara(idGara);
	}

	@Override
	public Partecipante findByMail(String email) {
		
		return partecipanteRepository.findByEmail(email);
	}

	@Override
	public void delete(int id) {
		
		partecipanteRepository.deleteById(id);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		  Partecipante partecipante = this.findByMail(username);
		  if(partecipante == null) throw new UsernameNotFoundException(username);
		  
		  Collection<GrantedAuthority> authorities = new ArrayList<>();
		  
		  partecipante.getRuoli().forEach(ruolo -> {
			  authorities.add(new SimpleGrantedAuthority(ruolo.getNome()));
		  });
		  
		  return new User(partecipante.getEmail(),partecipante.getPassword(), authorities);
	}
	
	
//	@Override
//	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
//		System.out.println("------ User Details-----");
//		Dipendente dipendente = this.getUserForLogin(mail);
//		if(dipendente != null){ 
//			Collection<SimpleGrantedAuthority> permessi= new ArrayList<SimpleGrantedAuthority>(); 
//
//			if(!dipendente.isAmministratore())
//				permessi.add(new SimpleGrantedAuthority(Costanti.RD));
//			else
//				permessi.add(new SimpleGrantedAuthority(Costanti.RA));
//			
//			if (dipendente.isResponsabile())
//				permessi.add(new SimpleGrantedAuthority(Costanti.RR));
//
//			boolean utenteAttivo = true;
//			boolean accountNonScaduto = true;
//			boolean credenzialiNonScadute = true;
//			boolean accountNonBloccato = true;
//
//			UserDetails user = new User(dipendente.getMail(), dipendente.getPassword(), utenteAttivo, 
//					accountNonScaduto, credenzialiNonScadute, 
//					accountNonBloccato, permessi);
//			logger.info("Dipendente trovato "+dipendente.getNome()+ " "+dipendente.getCognome());
//			return user;
//		}
//		logger.info("Nessun utente trovato");
//		return null;
//
//	}
	
	
	

}

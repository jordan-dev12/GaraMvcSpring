package com.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Gara;
import com.model.Partecipante;
import com.repository.GaraRepository;
import com.repository.PartecipanteRepositroy;


@Service
public class GaraServiceImpl implements GaraService {

	@Autowired
	private GaraRepository garaRepository;
	
	@Autowired
	private PartecipanteRepositroy partecipanteRepository;

	@Override
	public void saveGara(Gara gara) {

		garaRepository.save(gara);

	}

	@Override
	public void deleleGara(int id) {

		garaRepository.deleteById(id);

	}

	@Override
	public List<Gara> listGara() {

		return garaRepository.findAll();
	}

	@Override
	public Gara findByNome(String nome) {

		return garaRepository.findByNome(nome);
	}

	@Override
	public void deleteGara(String nome) {
		
		Gara gara = garaRepository.findByNome(nome);
		
		garaRepository.delete(gara);
	
	}

	@Override
	public void aggiungePartecipanti(Gara gara, String emailPartecipante) {
		
		
		Partecipante partecipante = partecipanteRepository.findByEmail(emailPartecipante);
	    gara.getPartecipante().add(partecipante);
	    
	    
	 
	}

	@Override
	public Gara findById(int id) {
		
		return garaRepository.findById(id);
		
	}

}

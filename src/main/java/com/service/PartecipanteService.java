package com.service;

import java.util.List;

import com.model.Partecipante;



public interface PartecipanteService {
	
	public void save(Partecipante partecipante);
	public List<Partecipante> listPartecipante();
	public void delete(int id);
	
	public List<Partecipante> findListPartecipante(int idGara);
	public Partecipante findByMail(String email);

}

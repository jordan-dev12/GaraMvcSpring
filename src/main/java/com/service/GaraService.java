package com.service;

import java.util.List;

import com.model.Gara;




public interface GaraService {

	public void saveGara(Gara gara);
	public void deleleGara(int id);
	public List<Gara> listGara();
	public Gara findByNome(String nome);
	public void deleteGara(String nome);
	public Gara findById(int id);
	
	public void aggiungePartecipanti(Gara gara, String emailPartecipante);
	
}

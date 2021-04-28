package com.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Partecipante;


public interface PartecipanteRepositroy extends JpaRepository<Partecipante, Integer> {
	
	public Partecipante findByEmail(String email);
	
	@Query("SELECT p  FROM Partecipante p LEFT JOIN p.gara g  WHERE g.id = :idGara")
    public List<Partecipante> findListPartecipanteByIdGara(@Param("idGara") int idGara);
	

}

package com.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity()
@Table(name="partecipanti")
public class Partecipante {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cognome")
	private String cognome;
	
	@Column(name="email", unique = true,nullable = false)
	private String email;
	
	@Column(name="password" ,nullable = false)
	private String password;
	
	@ManyToMany(mappedBy = "partecipante")
	private Set<Gara> gara;
	
	
	@ManyToMany
	@JoinTable(name ="utente_ruolo" ,joinColumns = {
	@JoinColumn(name = "partecipante_id",updatable = true, insertable = false, referencedColumnName = "id") }, 
	inverseJoinColumns = { @JoinColumn(name = "ruolo_id", updatable = true, insertable = false, referencedColumnName = "id") })
	private Set<Ruolo> ruoli;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Partecipante [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", password="
				+ password + "]";
	}

	public Set<Gara> getGara() {
		return gara;
	}

	public void setGara(Set<Gara> gara) {
		this.gara = gara;
	}

	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}
	
	
	
	
	
	
	
	
	
	

}

package com.projet.parking.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultEntity {
	
	/*	Exemple sortie API 
	"grp_identifiant": "004",
	"grp_nom": "Graslin",
	"grp_statut": 2,
	"grp_disponible": 286,
	"grp_exploitation": 486,
	"grp_complet": 6,
	"grp_horodatage": "2023-09-01T22:53:41+00:00",
	"idobj": "288",
	*/
	
	@JsonProperty(value = "grp_idobj")
	private String idobj;
	
	@JsonProperty(value = "grp_nom")
	private String nom;
	
	@JsonProperty(value = "grp_disponible")
	private int nbPlacesDispo;
	
	@JsonProperty(value = "grp_exploitation")
	private int nbPlacesTotal;
	
	@JsonProperty(value = "grp_statut")
	private String status;
	
	@JsonProperty(value = "grp_complet")
	private String statut;
	
	@JsonProperty(value = "grp_horodatage")
	private String heureMaj;
	public String getNom() {
		return nom;
	}
	

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getNbPlacesDispo() {
		return nbPlacesDispo;
	}
	
	
	public void setNbPlacesDispo(int nbPlacesDispo) {
		this.nbPlacesDispo = nbPlacesDispo;
	}
	public int getNbPlacesTotal() {
		return nbPlacesTotal;
	}
	public void setNbPlacesTotal(int nbPlacesTotal) {
		this.nbPlacesTotal = nbPlacesTotal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getHeureMaj() {
		return heureMaj;
	}
	public void setHeureMaj(String heureMaj) {
		this.heureMaj = heureMaj;
	}


	public String getIdobj() {
		return idobj;
	}


	public void setIdobj(String idobj) {
		this.idobj = idobj;
	}
	
	



}

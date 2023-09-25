package com.projet.parking.dao.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReponseParkingAPIEntity {
	
	@JsonProperty(value = "results")
	public List<ResultEntity> results;

	public List<ResultEntity> getResults() {
		return results;
	}

	public void setResults(List<ResultEntity> results) {
		this.results = results;
	}
	

}

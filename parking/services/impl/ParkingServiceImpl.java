package com.projet.parking.services.impl;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.parking.dao.ParkingAPIDAO;
import com.projet.parking.dao.entity.ReponseParkingAPIEntity;
import com.projet.parking.dao.entity.ResultEntity;
import com.projet.parking.models.Parking;
import com.projet.parking.services.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService {
	
	@Autowired
	public ParkingAPIDAO parkingAPIDAO;

	@Override
	public List<Parking> getListeParkings() {
		
		ReponseParkingAPIEntity reponse = parkingAPIDAO.getListeParkings();
		return transformEntityToModel(reponse);
		// TODO Auto-generated method stub
		/*Parking parkingTest = new Parking();
		parkingTest.setNbPlacesTotal(300);
		parkingTest.setNom("Parking de test");
		parkingTest.setNbPlacesDispo(125);
		parkingTest.setStatus("OUVERT");
		parkingTest.setHeureMaj("20h15");

		ArrayList<Parking> liste = new ArrayList<Parking>();
		liste.add(parkingTest);
		return liste;	
		*/
		
	}

	private List<Parking> transformEntityToModel(ReponseParkingAPIEntity reponse) {
		// TODO Auto-generated method stub
		List<Parking> resultat = new ArrayList<Parking>();
		reponse.getResults();
	
		for (ResultEntity result : reponse.getResults()) {

			Parking parking = new Parking();
			
		//decl parkings 
			
			parking.setNom(result.getNom());
			parking.setNbPlacesDispo(result.getNbPlacesDispo());
			parking.setNbPlacesTotal(result.getNbPlacesTotal());
			parking.setHeureMaj(getHeureMaj(result));
			parking.setStatus(getLibelleStatus(result));
			
			resultat.add(parking);
		}
		return resultat;
	}

	private String getHeureMaj(ResultEntity result) {
		OffsetDateTime dateMaj = OffsetDateTime.parse(result.getHeureMaj());
		OffsetDateTime dateMajWithOffsetPlus2 = dateMaj.withOffsetSameInstant(ZoneOffset.of("+02:00"));
		return dateMajWithOffsetPlus2.getHour() + "h" + dateMajWithOffsetPlus2.getMinute();
	}

	private String getLibelleStatus(ResultEntity result) {
		switch(result.getStatus()) {
		
		case "1":{
			return "Fermé";
		}
		
		case "2":{
			return "Abonnés";
		}
		
		case "5":{
			return "Ouvert";
		}
		}
		return "DOnnées non disponible sur l'api";
	}

}

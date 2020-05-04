package org.formacio.mvc;

import org.formacio.repositori.AgendaService;
import org.formacio.repositori.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controlador {

	@Autowired
	AgendaService agenda;
	
	@RequestMapping(path = "/nombre")
	@ResponseBody
	public String nombre() {
		return Integer.toString(agenda.nombreContactes());
	}
	
	@RequestMapping(path = "/telefon")
	@ResponseBody
	public String telefon(String id) {
		return agenda.recupera(id).getTelefon();
	}
	
	@RequestMapping(path = "/contacte/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Persona> contacte(@PathVariable String id) {
		Persona persona = agenda.recupera(id);
		
		if (persona == null) return new ResponseEntity<Persona>(persona, HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/afegir", method = {RequestMethod.POST})
	@ResponseBody
	public void afegir(String id, String nom, String telefon) {
		agenda.inserta(id, nom, telefon);
	}
	
}

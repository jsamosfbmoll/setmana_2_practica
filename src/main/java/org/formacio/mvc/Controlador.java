package org.formacio.mvc;

import org.formacio.repositori.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}

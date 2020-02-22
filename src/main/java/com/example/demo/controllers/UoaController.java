package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.Uoa;
import com.example.demo.service.UoaService;

import static org.springframework.http.HttpStatus.*;

@Controller
public class UoaController {
	@Autowired
	private UoaService service;
	
	@GetMapping(value = "/api/uoas")
	public ResponseEntity<List<Uoa>> getAllUoas() {
		return new ResponseEntity<List<Uoa>>(service.getUoas(), OK);
	}
	
	@GetMapping(value = "/api/uoas/{code}")
	public ResponseEntity<Uoa> getUoaByCode(@PathVariable("code") String code) {
		Uoa uoa = service.getUoa(code);
		return new ResponseEntity<Uoa>(uoa, uoa == null ? NOT_FOUND : OK);
	}
}

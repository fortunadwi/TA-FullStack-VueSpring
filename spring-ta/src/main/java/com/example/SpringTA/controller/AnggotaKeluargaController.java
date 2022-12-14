package com.example.SpringTA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringTA.model.AnggotaKeluarga;
import com.example.SpringTA.service.IAnggotaKeluargaService;

@RestController
@CrossOrigin (origins = "http://localhost:8081")
@RequestMapping("/api/anggotakeluarga")
public class AnggotaKeluargaController {

	@Autowired
	IAnggotaKeluargaService anggotakeluargaService;
	
	@PostMapping("/insert")
	public AnggotaKeluarga insertAnggotaKeluarga(@RequestBody AnggotaKeluarga anggotakeluarga) {
		return anggotakeluargaService.insertAnggotaKeluarga(anggotakeluarga);
	}
}

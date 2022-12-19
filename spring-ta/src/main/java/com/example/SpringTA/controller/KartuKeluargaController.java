package com.example.SpringTA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringTA.model.KartuKeluarga;
import com.example.SpringTA.service.IKartuKeluargaService;
import com.example.SpringTA.service.impl.KartuKeluargaService;


@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api/kartukeluarga")
public class KartuKeluargaController {

	@Autowired
	IKartuKeluargaService kartukeluargaService;
	
	@PostMapping("/insert")
	public KartuKeluarga insertKartuKeluarga(@RequestBody KartuKeluarga kartukeluarga) {
		return kartukeluargaService.insertKartuKeluarga(kartukeluarga);
	}
	
	@GetMapping("/getAll")
	public List<KartuKeluarga> getAllKartuKeluarga(){
		return kartukeluargaService.getAllKartuKeluarga();
	}
	
	@DeleteMapping("/delete/{id}")
	public KartuKeluarga deleteKartuKeluarga(@PathVariable int id) {
		return kartukeluargaService.deleteKartuKeluarga(id);
	}
	
	@GetMapping("/getId/{id}")
	public KartuKeluarga getIdKartuKeluarga(@PathVariable int id){
		return kartukeluargaService.getIdKartuKeluarga(id);
	}
	
	@PutMapping("/update/{id}")
	public KartuKeluarga updateKartuKeluarga(@PathVariable int id, @RequestBody KartuKeluarga kartukeluarga) {
		return kartukeluargaService.updateKartuKeluarga(id, kartukeluarga);
	}
	

}

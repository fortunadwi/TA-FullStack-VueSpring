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
	
	@GetMapping("/getAll")
	public List<AnggotaKeluarga> getAllAnggotaKeluarga(){
		return anggotakeluargaService.getAllAnggotaKeluarga();
	}
	
	@PutMapping("/update/{id}")
	public AnggotaKeluarga updateAnggotaKeluarga(@PathVariable int id, @RequestBody AnggotaKeluarga anggotakeluarga) {
		return anggotakeluargaService.updateAnggotaKeluarga(id, anggotakeluarga);
	}
	
	@DeleteMapping("/delete/{id}")
	public AnggotaKeluarga deleteAnggotaKeluarga(@PathVariable int id) {
		return anggotakeluargaService.deleteAnggotaKeluarga(id);
	}
	
	@GetMapping("/getId/{id}")
	public AnggotaKeluarga getIdAnggotaKeluarga(@PathVariable int id){
		return anggotakeluargaService.getIdAnggotaKeluarga(id);
	}
	
	@GetMapping("/getIdKk/{id_kk}")
	public List<AnggotaKeluarga> getIdKk(@PathVariable String id_kk){
		return anggotakeluargaService.getIdKk(id_kk);
	}
	
}

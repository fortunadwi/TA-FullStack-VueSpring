package com.example.SpringTA.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringTA.model.KartuKeluarga;
import com.example.SpringTA.repository.IKartuKeluargaRepository;
import com.example.SpringTA.service.IKartuKeluargaService;

@Service
public class KartuKeluargaService implements IKartuKeluargaService {
	@Autowired
	IKartuKeluargaRepository kartukeluargaRepository;

	@Override
	public KartuKeluarga insertKartuKeluarga(KartuKeluarga kartukeluarga) {
		// TODO Auto-generated method stub
		return kartukeluargaRepository.insertKartuKeluarga(kartukeluarga);
	}

	@Override
	public List<KartuKeluarga> getAllKartuKeluarga() {
		// TODO Auto-generated method stub
		return kartukeluargaRepository.getAllKartuKeluarga();
		
	}

	@Override
	public KartuKeluarga deleteKartuKeluarga(int id) {
		// TODO Auto-generated method stub
		return kartukeluargaRepository.deleteKartuKeluarga(id);
	}
	
	@Override
	public KartuKeluarga getIdKartuKeluarga(int id) {
		// TODO Auto-generated method stub
		return kartukeluargaRepository.CariIdKartuKeluarga(id);
	}

	@Override
	public KartuKeluarga updateKartuKeluarga(int id, KartuKeluarga kartukeluarga) {
		// TODO Auto-generated method stub
		return kartukeluargaRepository.updateKartuKeluarga(id, kartukeluarga);
	}
	
	

}

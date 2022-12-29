package com.example.SpringTA.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringTA.model.AnggotaKeluarga;
import com.example.SpringTA.repository.IAnggotaKeluargaRepository;
import com.example.SpringTA.service.IAnggotaKeluargaService;

@Service
public class AnggotaKeluargaService implements IAnggotaKeluargaService {
	@Autowired
	IAnggotaKeluargaRepository anggotakeluargaRepository;
	
	@Override
	public AnggotaKeluarga insertAnggotaKeluarga(AnggotaKeluarga anggotakeluarga) {
		// TODO Auto-generated method stub
		return anggotakeluargaRepository.insertAnggotaKeluarga(anggotakeluarga);
	}

	@Override
	public List<AnggotaKeluarga> getAllAnggotaKeluarga() {
		// TODO Auto-generated method stub
		return anggotakeluargaRepository.getAllAnggotaKeluarga();
	}
	
	@Override
	public AnggotaKeluarga updateAnggotaKeluarga(int id, AnggotaKeluarga anggotakeluarga) {
		// TODO Auto-generated method stub
		return anggotakeluargaRepository.updateAnggotaKeluarga(id, anggotakeluarga);
	}

	@Override
	public AnggotaKeluarga deleteAnggotaKeluarga(int id) {
		// TODO Auto-generated method stub
		return anggotakeluargaRepository.deleteAnggotaKeluarga(id);
	}

	@Override
	public AnggotaKeluarga getIdAnggotaKeluarga(int id) {
		// TODO Auto-generated method stub
		return anggotakeluargaRepository.CariIdAnggotaKeluarga(id);
	}

	@Override
	public List<AnggotaKeluarga> getIdKk(String id_kk) {
		// TODO Auto-generated method stub
		return anggotakeluargaRepository.getIdKk(id_kk);
	}
	
	@Override
	public List<AnggotaKeluarga> deleteIdKk(String id_kk) {
		// TODO Auto-generated method stub
		return anggotakeluargaRepository.deleteIdKk(id_kk);
	}
}

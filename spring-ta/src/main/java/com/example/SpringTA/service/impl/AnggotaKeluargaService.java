package com.example.SpringTA.service.impl;

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
}

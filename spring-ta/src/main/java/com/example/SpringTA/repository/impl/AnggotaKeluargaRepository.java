package com.example.SpringTA.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.SpringTA.model.AnggotaKeluarga;
import com.example.SpringTA.repository.IAnggotaKeluargaRepository;

@Repository
public class AnggotaKeluargaRepository implements IAnggotaKeluargaRepository{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public AnggotaKeluarga insertAnggotaKeluarga(AnggotaKeluarga anggotakeluarga) {
		// TODO Auto-generated method stud
		String query = "INSERT INTO tb_anggota_keluarga (agama, id_kk, jenis_kelamin, kepala_keluarga, nama, nik, pendidikan, tanggal_lahir, tempat_lahir) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, new Object[] {anggotakeluarga.getAgama(), anggotakeluarga.getId_kk(), anggotakeluarga.getJenis_kelamin(), anggotakeluarga.getKepala_keluarga(), anggotakeluarga.getNama(), anggotakeluarga.getNik(), anggotakeluarga.getPendidikan(), anggotakeluarga.getTanggal_lahir(), anggotakeluarga.getTempat_lahir()});
		return anggotakeluarga;
	}

}

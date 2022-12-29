package com.example.SpringTA.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

	@Override
	public List<AnggotaKeluarga> getAllAnggotaKeluarga() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class));
			}

	@Override
	public AnggotaKeluarga CariIdAnggotaKeluarga(int id) {
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class), id);
	}

	@Override
	public AnggotaKeluarga deleteAnggotaKeluarga(int id) {
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class), id);
		
		query = "DELETE FROM tb_anggota_keluarga WHERE id = ?";
		jdbcTemplate.update(query, id);
		
		return result;
	}

	@Override
	public AnggotaKeluarga updateAnggotaKeluarga(int id, AnggotaKeluarga anggotakeluarga) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_anggota_keluarga SET agama = ?, id_kk = ?, jenis_kelamin = ?, kepala_keluarga = ?, nama = ?, "
				+ "nik = ?, pendidikan = ?, tanggal_lahir = ?, tempat_lahir = ? WHERE id = ?";
				
		jdbcTemplate.update(query, new Object[] {anggotakeluarga.getAgama(), anggotakeluarga.getId_kk(), anggotakeluarga.getJenis_kelamin(), anggotakeluarga.getKepala_keluarga(), anggotakeluarga.getNama(), 
				anggotakeluarga.getNik(), anggotakeluarga.getPendidikan(), anggotakeluarga.getTanggal_lahir(), anggotakeluarga.getTempat_lahir(), id});
				
		return anggotakeluarga;
	}

	@Override
	public List<AnggotaKeluarga> getIdKk(String id_kk) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?";
		var result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class),id_kk);
		return result;
		
	}

	@Override
	public List<AnggotaKeluarga> deleteIdKk(String id_kk) {
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?";
		var result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class), id_kk);
		
		query = "DELETE FROM tb_anggota_keluarga WHERE id_kk = ?";
		jdbcTemplate.update(query, id_kk);
		
		return result;
	}

}

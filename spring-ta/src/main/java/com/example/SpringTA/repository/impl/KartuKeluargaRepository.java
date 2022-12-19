package com.example.SpringTA.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.SpringTA.model.KartuKeluarga;
import com.example.SpringTA.repository.IKartuKeluargaRepository;


@Repository
public class KartuKeluargaRepository implements IKartuKeluargaRepository{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public KartuKeluarga insertKartuKeluarga(KartuKeluarga kartukeluarga) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_kartu_keluarga(alamat, desa_kelurahan, kabupaten_kota, kecamatan, kode_pos, nomor_kk, provinsi, rt, rw) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
		jdbcTemplate.update(query, new Object[] {kartukeluarga.getAlamat(), kartukeluarga.getDesa_kelurahan(), kartukeluarga.getKabupaten_kota(), kartukeluarga.getKecamatan(), kartukeluarga.getKode_pos(), kartukeluarga.getNomor_kk(), kartukeluarga.getProvinsi(), kartukeluarga.getRt(), kartukeluarga.getRw()});
		return kartukeluarga;
	}
	
	@Override
	public List<KartuKeluarga> getAllKartuKeluarga() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_kartu_keluarga";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(KartuKeluarga.class));
	}

	@Override
	public KartuKeluarga deleteKartuKeluarga(int id) {
		String query = "SELECT * FROM tb_kartu_keluarga WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(KartuKeluarga.class), id);
		
		query = "DELETE FROM tb_kartu_keluarga WHERE id = ?";
		jdbcTemplate.update(query, id);
		
		return result;
	}
	
	@Override
	public KartuKeluarga CariIdKartuKeluarga(int id) {
		String query = "SELECT * FROM tb_kartu_keluarga WHERE id = ?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(KartuKeluarga.class), id);
	}

	@Override
	public KartuKeluarga updateKartuKeluarga(int id, KartuKeluarga kartukeluarga) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_kartu_keluarga SET alamat = ?, desa_kelurahan = ?, kabupaten_kota = ?, kecamatan = ?, kode_pos = ?, "
				+ "nomor_kk = ?, provinsi = ?, rt = ?, rw = ? WHERE id = ?";
				
		jdbcTemplate.update(query, new Object[] {kartukeluarga.getAlamat(), kartukeluarga.getDesa_kelurahan(), kartukeluarga.getKabupaten_kota(), kartukeluarga.getKecamatan(), 
				kartukeluarga.getKode_pos(), kartukeluarga.getNomor_kk(), kartukeluarga.getProvinsi(), kartukeluarga.getRt(), kartukeluarga.getRw(), id});
				
		return kartukeluarga;
	}

}

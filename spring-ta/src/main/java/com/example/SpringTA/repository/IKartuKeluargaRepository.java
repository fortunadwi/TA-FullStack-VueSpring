package com.example.SpringTA.repository;

import java.util.List;

import com.example.SpringTA.model.KartuKeluarga;

public interface IKartuKeluargaRepository {

	public KartuKeluarga insertKartuKeluarga(KartuKeluarga kartukeluarga);
	public List<KartuKeluarga> getAllKartuKeluarga();
	public KartuKeluarga deleteKartuKeluarga(int id);
	public KartuKeluarga CariIdKartuKeluarga(int id);
	public KartuKeluarga updateKartuKeluarga(int id, KartuKeluarga kartukeluarga);
	
}

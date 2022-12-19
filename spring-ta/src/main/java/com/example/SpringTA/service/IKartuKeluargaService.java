package com.example.SpringTA.service;

import java.util.List;

import com.example.SpringTA.model.KartuKeluarga;

public interface IKartuKeluargaService {

	KartuKeluarga insertKartuKeluarga(KartuKeluarga kartukeluarga);

	List<KartuKeluarga> getAllKartuKeluarga();

	KartuKeluarga deleteKartuKeluarga(int id);

	KartuKeluarga getIdKartuKeluarga(int id);

	KartuKeluarga updateKartuKeluarga(int id, KartuKeluarga kartukeluarga);

}

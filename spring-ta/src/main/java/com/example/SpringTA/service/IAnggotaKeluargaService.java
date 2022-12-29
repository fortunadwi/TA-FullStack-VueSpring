package com.example.SpringTA.service;

import java.util.List;

import com.example.SpringTA.model.AnggotaKeluarga;

public interface IAnggotaKeluargaService {

	AnggotaKeluarga insertAnggotaKeluarga(AnggotaKeluarga anggotakeluarga);

	List<AnggotaKeluarga> getAllAnggotaKeluarga();

	AnggotaKeluarga deleteAnggotaKeluarga(int id);

	AnggotaKeluarga getIdAnggotaKeluarga(int id);

	AnggotaKeluarga updateAnggotaKeluarga(int id, AnggotaKeluarga anggotakeluarga);

	List<AnggotaKeluarga> getIdKk(String id_kk);

	List<AnggotaKeluarga> deleteIdKk(String id_kk);


}

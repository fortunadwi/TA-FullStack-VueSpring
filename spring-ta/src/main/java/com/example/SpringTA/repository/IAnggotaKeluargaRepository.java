package com.example.SpringTA.repository;

import java.util.List;

import com.example.SpringTA.model.AnggotaKeluarga;

public interface IAnggotaKeluargaRepository {

	AnggotaKeluarga insertAnggotaKeluarga(AnggotaKeluarga anggotakeluarga);

	List<AnggotaKeluarga> getAllAnggotaKeluarga();

	AnggotaKeluarga deleteAnggotaKeluarga(int id);

	AnggotaKeluarga updateAnggotaKeluarga(int id, AnggotaKeluarga anggotakeluarga);

	AnggotaKeluarga CariIdAnggotaKeluarga(int id);

	List<AnggotaKeluarga> getIdKk(String id_kk);

}

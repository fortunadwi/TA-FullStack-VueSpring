import http from "../http-common";

class anggotakkService {
    create(data){
        return http.post("/anggotakeluarga/insert",data);
    }

    getAll() {
        return http.get("/anggotakeluarga/getAll");
    }

    deleteKK(id) {
        return http.delete(`/anggotakeluarga/delete/${id}`);
      }
    
      updateAnggotaKK(id, data) {
        return http.put(`/anggotakeluarga/update/${id}`, data);
      }

      selectIdAnggotaKK(id) {
        return http.get(`/anggotakeluarga/getId/${id}`);
      }

      getAnggotaIdKk(id_kk) {
        return http.get(`/anggotakeluarga/getIdKk/${id_kk}`);
    }
}

export default new anggotakkService();
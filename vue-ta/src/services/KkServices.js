import http from "../http-common";

class kkService {
    create(data){
        return http.post("/kartukeluarga/insert",data);
    }

    getAll() {
        return http.get("/kartukeluarga/getAll");
    }

    deleteKK(id) {
        return http.delete(`/kartukeluarga/delete/${id}`);
      }
    
      updateKK(id, data) {
        return http.put(`/kartukeluarga/update/${id}`, data);
      }
}

export default new kkService();
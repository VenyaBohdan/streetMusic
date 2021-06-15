import http from "../http-common"

class BandDataService {
    getAll() {
        return http.get("/band");
    }

    get(id) {
        return http.get("/band/" + id);
    }

    create(data) {
        return http.post("/band", data);
    }

    update(data) {
        return http.post("/band", data);
    }

    delete(id) {
        return http.delete("band/" + id);
    }
}

export default new BandDataService();
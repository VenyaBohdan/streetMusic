import http from "../http-common"

export default class BandService {

    static async getAll() {
        return http.get("/band");
    }

    static async get(id) {
        return http.get("/band/" + id);
    }

    static async create(data) {
        return http.post("/band", data);
    }

    static async delete(id) {
        return http.delete("/band/" + id);
    }
}
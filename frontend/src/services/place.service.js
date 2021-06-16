import http from "../http-common"

export default class PlaceService {

    static async getAll() {
        return http.get("/place");
    }

    static async get(id) {
        return http.get("/place/" + id);
    }

    static async create(data) {
        return http.post("/place", data);
    }

    static async delete(id) {
        return http.delete("/place/" + id);
    }

}
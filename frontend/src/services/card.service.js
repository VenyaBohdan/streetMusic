import http from "../http-common"

export default class CardService {

    static async getAll() {
        return http.get("/card");
    }

    static async get(id) {
        return http.get("/card/" + id);
    }

    static async create(data) {
        return http.post("/card", data);
    }

    static async delete(id) {
        return http.delete("/card/" + id);
    }

}
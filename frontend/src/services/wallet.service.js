import http from "../http-common"

export default class WalletService {

    static async getAll() {
        return http.get("/wallet");
    }

    static async get(id) {
        return http.get("/wallet/" + id);
    }

    static async create(data) {
        return http.post("/wallet", data);
    }

    static async delete(id) {
        return http.delete("/wallet/" + id);
    }

}
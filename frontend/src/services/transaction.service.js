import http from "../http-common"

export default class TransactionService {

    static async getAll() {
        return http.get("/transaction");
    }

    static async get(id) {
        return http.get("/transaction/" + id);
    }

    static async create(data) {
        return http.post("/transaction", data);
    }

    static async delete(id) {
        return http.delete("/transaction/" + id);
    }

}
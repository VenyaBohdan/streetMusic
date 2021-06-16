import http from "../http-common"

export default class AccountService {

    static async getAll() {
        return http.get("/account");
    }

    static async get(id) {
        return http.get("/account/" + id);
    }

    static async create(data) {
        return http.post("/account", data);
    }

    static async delete(id) {
        return http.delete("/account/" + id);
    }

}
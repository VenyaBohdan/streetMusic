import http from "../http-common"

export default class ReviewService {

    static async getAll() {
        return http.get("/review");
    }

    static async get(id) {
        return http.get("/review/" + id);
    }

    static async create(data) {
        return http.post("/review", data);
    }

    static async delete(id) {
        return http.delete("/review/" + id);
    }

}
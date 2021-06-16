import {review} from "./review.model";
import {account} from "./account.model";

export const place = {
    id: null,
    name: "",
    description: "",
    address: "",
    photo: "",
    reviews: [review],
    author: account,
    created_at: ""
}
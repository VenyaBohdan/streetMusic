import * as type from "./type"
import ReviewService from "../../services/review.service";

export const getReview = (id) => async (dispatch) => {
    try {
        const res = await ReviewService.get(id);

        dispatch({
            type: type.GET_REVIEW,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const getReviews = () => async (dispatch) => {
    try {
        const res = await ReviewService.getAll();

        dispatch({
            type: type.GET_REVIEWS,
            payload: res.data
        });
    } catch (err) {
        console.log(err);
    }
}

export const createReview = (data) => async (dispatch) => {
    try {
        const res = await ReviewService.create(data);

        dispatch({
            type: type.CREATE_REVIEW,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const updateReview = (data) => async (dispatch) => {
    try {
        const res = await ReviewService.create(data);

        dispatch({
            type: type.UPDATE_REVIEW,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const deleteReview = (id) => async (dispatch) => {
    try {
        await ReviewService.delete(id);

        dispatch({
            type: type.DELETE_REVIEW,
            payload: {id}
        });
    } catch (err) {
        console.log(err);
    }
}
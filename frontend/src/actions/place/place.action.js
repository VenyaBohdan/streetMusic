import * as type from "./type"
import PlaceService from "../../services/place.service";

export const getPlace = (id) => async (dispatch) => {
    try {
        const res = await PlaceService.get(id);

        dispatch({
            type: type.GET_PLACE,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const getPlaces = () => async (dispatch) => {
    try {
        const res = await PlaceService.getAll();

        dispatch({
            type: type.GET_PLACES,
            payload: res.data
        });
    } catch (err) {
        console.log(err);
    }
}

export const createPlace = (data) => async (dispatch) => {
    try {
        const res = await PlaceService.create(data);

        dispatch({
            type: type.CREATE_PLACE,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const updatePlace = (data) => async (dispatch) => {
    try {
        const res = await PlaceService.create(data);

        dispatch({
            type: type.UPDATE_PLACE,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const deletePlace = (id) => async (dispatch) => {
    try {
        await PlaceService.delete(id);

        dispatch({
            type: type.DELETE_PLACE,
            payload: {id}
        });
    } catch (err) {
        console.log(err);
    }
}
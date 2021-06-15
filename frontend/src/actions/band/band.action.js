import * as type from "./type"
import BandDataService from "../../services/band.service"

export const getBand = (id) => async (dispatch) => {
    try {
        const res = await BandDataService.get(id);

        dispatch({
            type: type.RETRIEVE_BAND,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const retrieveBands = () => async (dispatch) => {
    try {
        const res = await BandDataService.getAll();

        dispatch({
            type: type.RETRIEVE_BANDS,
            payload: res.data
        });
    } catch (err) {
        console.log(err);
    }
}

export const createBand = (name, description) => async (dispatch) => {
    try {
        const res = await BandDataService.create({name, description});

        dispatch({
            type: type.CREATE_BAND,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const updateBand = (data) => async (dispatch) => {
    try {
        const res = await BandDataService.update(data);

        dispatch({
            type: type.UPDATE_BAND,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const deleteBand = (id) => async (dispatch) => {
    try {
        await BandDataService.delete(id);

        dispatch({
            type: type.DELETE_BAND,
            payload: {id}
        });
    } catch (err) {
        console.log(err);
    }
}
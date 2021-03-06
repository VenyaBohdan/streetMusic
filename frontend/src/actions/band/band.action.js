import * as type from "./type"
import BandService from "../../services/band.service"

export const getBand = (id) => async (dispatch) => {
    try {
        const res = await BandService.get(id);

        dispatch({
            type: type.GET_BAND,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const getBands = () => async (dispatch) => {
    try {
        const res = await BandService.getAll();

        dispatch({
            type: type.GET_BANDS,
            payload: res.data
        });
    } catch (err) {
        console.log(err);
    }
}

export const createBand = (name, description) => async (dispatch) => {
    try {
        const res = await BandService.create({name, description});

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
        const res = await BandService.create(data);

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
        await BandService.delete(id);

        dispatch({
            type: type.DELETE_BAND,
            payload: {id}
        });
    } catch (err) {
        console.log(err);
    }
}
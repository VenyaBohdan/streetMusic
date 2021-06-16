import * as type from "./type"
import CardService from "../../services/card.service";

export const getCard = (id) => async (dispatch) => {
    try {
        const res = await CardService.get(id);

        dispatch({
            type: type.GET_CARD,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const getCards = () => async (dispatch) => {
    try {
        const res = await CardService.getAll();

        dispatch({
            type: type.GET_CARDS,
            payload: res.data
        });
    } catch (err) {
        console.log(err);
    }
}

export const createCard = (data) => async (dispatch) => {
    try {
        const res = await CardService.create(data);

        dispatch({
            type: type.CREATE_CARD,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const updateCard = (data) => async (dispatch) => {
    try {
        const res = await CardService.create(data);

        dispatch({
            type: type.UPDATE_CARD,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const deleteCard = (id) => async (dispatch) => {
    try {
        await CardService.delete(id);

        dispatch({
            type: type.DELETE_CARD,
            payload: {id}
        });
    } catch (err) {
        console.log(err);
    }
}
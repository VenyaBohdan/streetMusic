import * as type from "./type"
import AccountService from "../../services/account.service";

export const getAccount = (id) => async (dispatch) => {
    try {
        const res = await AccountService.get(id);

        dispatch({
            type: type.GET_ACCOUNT,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const getAccounts = () => async (dispatch) => {
    try {
        const res = await AccountService.getAll();

        dispatch({
            type: type.GET_ACCOUNTS,
            payload: res.data
        });
    } catch (err) {
        console.log(err);
    }
}

export const createAccount = (data) => async (dispatch) => {
    try {
        const res = await AccountService.create(data);

        dispatch({
            type: type.CREATE_ACCOUNT,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const updateAccount = (data) => async (dispatch) => {
    try {
        const res = await AccountService.create(data);

        dispatch({
            type: type.UPDATE_ACCOUNT,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const deleteAccount = (id) => async (dispatch) => {
    try {
        await AccountService.delete(id);

        dispatch({
            type: type.DELETE_ACCOUNT,
            payload: {id}
        });
    } catch (err) {
        console.log(err);
    }
}
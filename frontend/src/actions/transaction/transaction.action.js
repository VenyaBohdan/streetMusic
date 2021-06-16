import * as type from "./type"
import TransactionService from "../../services/transaction.service";

export const getTransaction = (id) => async (dispatch) => {
    try {
        const res = await TransactionService.get(id);

        dispatch({
            type: type.GET_TRANSACTION,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const getTransactions = () => async (dispatch) => {
    try {
        const res = await TransactionService.getAll();

        dispatch({
            type: type.GET_TRANSACTIONS,
            payload: res.data
        });
    } catch (err) {
        console.log(err);
    }
}

export const createTransaction = (data) => async (dispatch) => {
    try {
        const res = await TransactionService.create(data);

        dispatch({
            type: type.CREATE_TRANSACTION,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const updateTransaction = (data) => async (dispatch) => {
    try {
        const res = await TransactionService.create(data);

        dispatch({
            type: type.UPDATE_TRANSACTION,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const deleteTransaction = (id) => async (dispatch) => {
    try {
        await TransactionService.delete(id);

        dispatch({
            type: type.DELETE_TRANSACTION,
            payload: {id}
        });
    } catch (err) {
        console.log(err);
    }
}
import * as type from "./type"
import WalletService from "../../services/wallet.service";

export const getWallet = (id) => async (dispatch) => {
    try {
        const res = await WalletService.get(id);

        dispatch({
            type: type.GET_WALLET,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const getWallets = () => async (dispatch) => {
    try {
        const res = await WalletService.getAll();

        dispatch({
            type: type.GET_WALLETS,
            payload: res.data
        });
    } catch (err) {
        console.log(err);
    }
}

export const createWallet = (data) => async (dispatch) => {
    try {
        const res = await WalletService.create(data);

        dispatch({
            type: type.CREATE_WALLET,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const updateWallet = (data) => async (dispatch) => {
    try {
        const res = await WalletService.create(data);

        dispatch({
            type: type.UPDATE_WALLET,
            payload: res.data
        });

        return Promise.resolve(res.data);
    } catch (err) {
        return Promise.reject(err);
    }
}

export const deleteWallet = (id) => async (dispatch) => {
    try {
        await WalletService.delete(id);

        dispatch({
            type: type.DELETE_WALLET,
            payload: {id}
        });
    } catch (err) {
        console.log(err);
    }
}
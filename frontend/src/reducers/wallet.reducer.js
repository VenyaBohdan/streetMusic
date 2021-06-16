import * as action_type from "../actions/wallet/type"

const initialState = [];

export default function walletReducer(wallets = initialState, action) {
    const {type, payload} = action;

    switch (type) {
        case action_type.GET_WALLET:
            return [...wallets, payload];

        case action_type.GET_WALLETS:
            return payload;
        case action_type.CREATE_WALLET:
            return [...wallets, payload];
        case action_type.UPDATE_WALLET:
            return wallets.map((wallet) => {
                if(wallet.id === payload.id) {
                    return {
                        ...wallet,
                        ...payload
                    };
                } else {
                    return wallet;
                }
            });
        case action_type.DELETE_WALLET:
            return wallets.filter(({id}) => id !== payload.id);
        default: return initialState;
    }
}
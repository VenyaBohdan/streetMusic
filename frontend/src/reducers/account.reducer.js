import * as action_type from "../actions/account/type"

const initialState = [];

export default function accountReducer(accounts = initialState, action) {
    const {type, payload} = action;

    switch (type) {
        case action_type.GET_ACCOUNT:
            return [...accounts, payload];

        case action_type.GET_ACCOUNTS:
            return payload;
        case action_type.CREATE_ACCOUNT:
            return [...accounts, payload];
        case action_type.UPDATE_ACCOUNT:
            return accounts.map((account) => {
                if(account.id === payload.id) {
                    return {
                        ...account,
                        ...payload
                    };
                } else {
                    return account;
                }
            });
        case action_type.DELETE_ACCOUNT:
            return accounts.filter(({id}) => id !== payload.id);
        default: return initialState;
    }
}
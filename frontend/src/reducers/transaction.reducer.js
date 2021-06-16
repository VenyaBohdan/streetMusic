import * as action_type from "../actions/transaction/type"

const initialState = [];

export default function transactionReducer(transactions = initialState, action) {
    const {type, payload} = action;

    switch (type) {
        case action_type.GET_TRANSACTION:
            return [...transactions, payload];

        case action_type.GET_TRANSACTIONS:
            return payload;
        case action_type.CREATE_TRANSACTION:
            return [...transactions, payload];
        case action_type.UPDATE_TRANSACTION:
            return transactions.map((transaction) => {
                if(transaction.id === payload.id) {
                    return {
                        ...transaction,
                        ...payload
                    };
                } else {
                    return transaction;
                }
            });
        case action_type.DELETE_TRANSACTION:
            return transactions.filter(({id}) => id !== payload.id);
        default: return initialState;
    }
}
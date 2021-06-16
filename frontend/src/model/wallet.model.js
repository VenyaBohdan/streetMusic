import {account} from "./account.model";
import {transaction} from "./transaction.model";

export const wallet = {
    id: null,
    account: account,
    amount: null,
    transactions: [transaction]
}
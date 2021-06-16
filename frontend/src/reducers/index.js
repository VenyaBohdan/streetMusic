import { combineReducers } from "redux";
import bandReducer from "./band.reducer"
import accountReducer from "./account.reducer";
import cardReducer from "./card.reducer";
import placeReducer from "./place.reducer";
import reviewReducer from "./review.reducer";
import transactionReducer from "./transaction.reducer";
import walletReducer from "./wallet.reducer";

export default combineReducers({
    bandState: bandReducer,
    accountState: accountReducer,
    cardState: cardReducer,
    placeState: placeReducer,
    reviewState: reviewReducer,
    transactionState: transactionReducer,
    walletState: walletReducer
});
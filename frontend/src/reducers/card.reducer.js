import * as action_type from "../actions/card/type"

const initialState = [];

export default function cardReducer(cards = initialState, action) {
    const {type, payload} = action;

    switch (type) {
        case action_type.GET_CARD:
            return [...cards, payload];

        case action_type.GET_CARDS:
            return payload;
        case action_type.CREATE_CARD:
            return [...cards, payload];
        case action_type.UPDATE_CARD:
            return cards.map((card) => {
                if(card.id === payload.id) {
                    return {
                        ...card,
                        ...payload
                    };
                } else {
                    return card;
                }
            });
        case action_type.DELETE_CARD:
            return cards.filter(({id}) => id !== payload.id);
        default: return initialState;
    }
}
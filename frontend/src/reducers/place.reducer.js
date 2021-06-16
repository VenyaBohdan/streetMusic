import * as action_type from "../actions/place/type"

const initialState = [];

export default function placeReducer(places = initialState, action) {
    const {type, payload} = action;

    switch (type) {
        case action_type.GET_PLACE:
            return [...places, payload];

        case action_type.GET_PLACES:
            return payload;
        case action_type.CREATE_PLACE:
            return [...places, payload];
        case action_type.UPDATE_PLACE:
            return places.map((place) => {
                if(place.id === payload.id) {
                    return {
                        ...place,
                        ...payload
                    };
                } else {
                    return place;
                }
            });
        case action_type.DELETE_PLACE:
            return places.filter(({id}) => id !== payload.id);
        default: return initialState;
    }
}
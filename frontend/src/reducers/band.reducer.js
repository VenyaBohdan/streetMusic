import * as action_type from "../actions/band/type"

const initialState = [];

export default function bandReducer(bands = initialState, action) {
    const {type, payload} = action;

    switch (type) {
        case action_type.GET_BAND:
            return [...bands, payload];

        case action_type.GET_BANDS:
            return payload;
        case action_type.CREATE_BAND:
            return [...bands, payload];
        case action_type.UPDATE_BAND:
            return bands.map((band) => {
                if(band.id === payload.id) {
                    return {
                        ...band,
                        ...payload
                    };
                } else {
                    return band;
                }
            });
        case action_type.DELETE_BAND:
            return bands.filter(({id}) => id !== payload.id);
        default: return initialState;
    }
}
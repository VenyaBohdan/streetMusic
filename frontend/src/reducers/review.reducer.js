import * as action_type from "../actions/review/type"

const initialState = [];

export default function reviewReducer(reviews = initialState, action) {
    const {type, payload} = action;

    switch (type) {
        case action_type.GET_REVIEW:
            return [...reviews, payload];

        case action_type.GET_REVIEWS:
            return payload;
        case action_type.CREATE_REVIEW:
            return [...reviews, payload];
        case action_type.UPDATE_REVIEW:
            return reviews.map((review) => {
                if(review.id === payload.id) {
                    return {
                        ...review,
                        ...payload
                    };
                } else {
                    return review;
                }
            });
        case action_type.DELETE_REVIEW:
            return reviews.filter(({id}) => id !== payload.id);
        default: return initialState;
    }
}
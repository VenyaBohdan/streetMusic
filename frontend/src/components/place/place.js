import React, { Component } from "react";
import {connect} from "react-redux";

import {deletePlace, updatePlace} from "../../actions/place/place.action";
import PlaceService from "../../services/place.service";
import {place} from "../../model/place.model";

class Place extends Component {
    constructor(props) {
        super(props);

        this.state = {
            place: place
        }
    }

    componentDidMount() {
        this.getPlace(this.props.match.params.id)
    }

    getPlace = (id) => {
        PlaceService.get(id)
            .then(response => {
                this.setState({
                    place: response.data
                });
                console.log(response.data)
            })
            .catch(err => {
                console.log(err);
            });
    }

    render() {
        const { place } = this.state;

        return (
            <div>
                <h1 className="text-center">{place.name}</h1>
                <h5 className="text-justified text-center">{place.description}</h5>
                <p className="text-center"><small>{place.address}</small></p>
                <p className="text-left"><small>Author: {place.author.login}</small></p>
                <h4>Comments</h4>
                {place.reviews.map(review => (
                    <div className="col mb-3">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">{review.title}</h5>
                                <p> </p>
                                <p className="card-text">{review.description}</p>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        )
    }

}

export default connect(null, { updatePlace, deletePlace })(Place)
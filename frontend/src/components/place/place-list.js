import React, { Component } from "react";
import { connect } from "react-redux";
import {getPlaces} from "../../actions/place/place.action";
import {Link} from "react-router-dom";

class PlaceList extends Component {
    constructor(props) {
        super(props);

        this.state = {

        }
    }

    componentDidMount() {
        this.props.getPlaces();
    }

    render() {
        const { places } = this.props;

        return (
            <div className="row">
                {places && places.map(place => (
                    <Link to={"/place/" + place.id} className="col-sm-6 custom-card">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title custom-card">{place.name}</h5>
                                <p className="card-text">{place.description}</p>
                                <p><small>{place.address}</small></p>
                            </div>
                        </div>
                    </Link>
                ))}
            </div>
        )
    }
}

const mapStateToProps = (store) => {
    return {
        places: store.placeState
    };
}

export default connect(mapStateToProps, { getPlaces })(PlaceList)
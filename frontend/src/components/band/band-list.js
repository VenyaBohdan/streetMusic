import React, { Component } from "react";
import { connect } from "react-redux";
import { retrieveBands } from "../../actions/band/band.action";
import { Link } from "react-router-dom";

class BandList extends Component {
    constructor(props) {
        super(props);
        console.log("Props: ");
        console.log(props);
        this.state = {
            currentBand: null,
            currentIndex: -1
        }
    }

    componentDidMount() {
        this.props.retrieveBands();
    }

    setActiveBand = (band, index) => {
        this.setState({
            currentBand: band,
            currentIndex: index
        });
    }

    render() {
        const { currentBand, currentIndex } = this.state;
        const { bands } = this.props;

        return (
            <div className="list row">
                <div className="col-md-6">
                    <h4>Bands List</h4>
                    <ul className="list-group">
                        {bands && bands.map((band, index) => (
                            <li
                                className={
                                    "list-group-item" +
                                    (index === currentIndex ? "active" : "")}
                                    onClick={() => this.setActiveBand(band, index)} key={index}>
                                {band.name}
                            </li>
                        ))}
                    </ul>
                </div>

                <div className="col-md-6">
                    {currentBand ? (
                        <div>
                            <h4>Band</h4>
                            <div>
                                <label>
                                    <strong>Name: </strong>
                                </label>
                                {currentBand.name}
                            </div>
                            <div>
                                <label>
                                    <strong>Description: </strong>
                                </label>
                                {currentBand.description}
                            </div>

                            <Link to={"/band/" + currentBand.id} className="badge badge-warning">
                                Edit
                            </Link>
                        </div>
                    ) : (
                        <div>
                            <br/>
                            <p>Please click on a Band...</p>
                        </div>
                    )}
                </div>

            </div>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        bands: state.bandReducer
    };
}

export default connect(mapStateToProps, { retrieveBands })(BandList)
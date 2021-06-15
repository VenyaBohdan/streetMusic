import React, { Component } from "react";
import { connect } from "react-redux";
import {createBand} from "../../actions/band/band.action";

class AddBand extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: null,
            name: "",
            description: "",
            submitted: false
        };
    }

    onChangeName = (event) => {
        this.setState({
            name: event.target.value
        });
    }

    onChangeDescription = (event) => {
        this.setState({
            description: event.target.value
        });
    }

    saveBand = () => {
        const { name, description }  = this.state;
        this.props
            .createBand(name, description)
            .then((data) => {
                this.setState({
                    id: data.id,
                    name: data.name,
                    description: data.description,
                    submitted: true
                });
                console.log("Saved band: " + data);
            })
            .catch((err) => {
                console.log(err);
            });
    }

    newBand = () => {
        this.setState({
            id: null,
            name: "",
            description: "",
            submitted: false
        });
    }

    render() {
        return (
            <div className="submit-form">
                {this.state.submitted? (
                    <div>
                        <h4>You submitted successfully!</h4>
                        <button className="btn btn-success" onClick={this.newBand}>
                            Add
                        </button>
                    </div>
                ) : (
                    <div>
                        <div className="form-group">
                            <label htmlFor="name">Name</label>
                            <input
                                type="text"
                                className="form-control"
                                id="name"
                                required
                                value={this.state.name}
                                onChange={this.onChangeName}
                                name="name"/>
                        </div>

                        <div className="form-group">
                            <label htmlFor="description">Description</label>
                            <input
                                type="text"
                                className="form-control"
                                id="description"
                                required
                                value={this.state.description}
                                onChange={this.onChangeDescription}
                                name="description"/>
                        </div>

                        <button onClick={this.saveBand} className="btn btn-success">
                            Submit
                        </button>
                    </div>
                )}
            </div>
        );
    }
}

export default connect(null, { createBand })(AddBand)

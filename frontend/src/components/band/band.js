import React, { Component } from "react";
import {connect} from "react-redux";
import { updateBand, deleteBand } from "../../actions/band/band.action";
import BandService from "../../services/band.service";

class Band extends Component {
    constructor(props) {
        super(props);

        this.state = {
            currentBand: {
                id: null,
                name: "",
                description: "",
                published: false
            },
            message: ""
        };
    }

    componentDidMount() {
        this.getBand(this.props.match.params.id)
    }

    getBand = (id) => {
        BandService.get(id)
            .then((response) => {
                this.setState({
                    currentBand: response.data
                });
                console.log("Data: " + response.data);
            })
            .catch((err) => {
                console.log(err)
            })
    }

    onChangeName = (event) => {
        const name = event.target.value;

        this.setState(function(prevState){
            return {
                currentBand: {
                    ...prevState.currentBand,
                    name: name
                }
            };
        });
    }

    onChangeDescription = (event) => {
        const description = event.target.value;

        this.setState(function (prevState) {
            return {
                currentBand: {
                    ...prevState.currentBand,
                    description: description
                }
            };
        });
    }

    updateStatus = (status) => {
        let data = {
            id: this.state.currentBand.id,
            name: this.state.currentBand.name,
            description: this.state.currentBand.description,
            published: status
        };

        this.props
            .updateBand(data)
            .then((response) => {
                console.log("Updated data: " + response)

                this.setState((prevState) => ({
                    currentBand: {
                        ...prevState.currentBand,
                        published: status
                    },
                }));

                this.setState({message: "The status was updated successfully"});
            })
            .catch((err) => {
                console.log(err);
            });
    }

    updateContent = () => {
        this.props
            .updateBand(this.state.currentBand)
            .then((response) => {
                console.log(response);

                this.setState({message: "The band was updated successfully"})
            })
            .catch((err) => {
                console.log(err);
            });
    }

    removeBand = () => {
        this.props
            .deleteBand(this.state.currentBand.id)
            .then(() => {
                this.props.history.push("/band");
            })
            .catch((err) => {
                console.log(err);
            });
    }

    render() {
        const { currentBand } = this.state;

        return (
            <div>
                {currentBand ? (
                    <div className="edit-form">
                        <h4>Band</h4>
                        <form>
                            <div className="form-group">
                                <label htmlFor="name">Title</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="name"
                                    value={currentBand.name}
                                    onChange={this.onChangeName}
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="description">Description</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="description"
                                    value={currentBand.description}
                                    onChange={this.onChangeDescription}
                                />
                            </div>
                            <div className="form-group">
                                <label>
                                    <strong>Status: </strong>
                                </label>
                                {currentBand.published ? "Published" : "Pending"}
                            </div>
                        </form>

                        {currentBand.published ? (
                            <button className="badge badge-primary mr-2" onClick={() => this.updateStatus(false)}>UnPublish</button>
                        ) : (
                            <button className="badge badge-primary mr-2" onClick={() => this.updateStatus(true)}>Publish</button>
                        )}
                        <button className="badge badge-primary mr-2" onClick={this.removeBand}>Remove</button>
                        <button type="submit" className="badge badge-success" onClick={this.updateContent}>Update</button>
                    </div>
                ): (
                    <div>
                        <br/>
                        <p>Please click on a Band...</p>
                    </div>
                )}
            </div>
        )
    }
}

export default connect(null, { updateBand, deleteBand })(Band)
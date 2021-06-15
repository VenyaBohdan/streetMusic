import './App.css';
import React, { Component } from  'react';
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

import AddBand from "./components/band/add-band";
import Band from "./components/band/band";
import BandList from "./components/band/band-list";

class App extends Component {
  render() {
    return (
        <Router>
          <nav className="navbar navbar-expand navbar-dark bg-dark">
            <Link to={"/band"} className="navbar-brand">
              streetMusic
            </Link>
            <div className="navbar-nav mr-auto">
              <li className="nav-item">
                <Link to={"/band"} className="nav-link">
                  Bands
                </Link>
              </li>
              <li className="nav-item">
                <Link to={"/add"} className="nav-link">
                  Add
                </Link>
              </li>
            </div>
          </nav>

          <div className="container mt-3">
            <Switch>
              <Route exact path={["/", "/band"]} component={BandList}/>
              <Route exact path="/add" component={AddBand}/>
              <Route path="/band/:id" component={Band}/>
            </Switch>
          </div>
        </Router>
    )
  }
}

export default App;

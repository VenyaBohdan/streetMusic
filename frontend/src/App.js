import './App.css';
import React, { Component } from  'react';
import "bootstrap/dist/css/bootstrap.min.css";
import "bootswatch/dist/simplex/bootstrap.min.css";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

import AddBand from "./components/band/add-band";
import Band from "./components/band/band";
import BandList from "./components/band/band-list";

class App extends Component {
  render() {
    return (
        <Router>
          <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <div className="container-fluid">
              <Link to={"/band"} className="navbar-brand">
                StreetMusic
              </Link>
              <div className="collapse navbar-collapse" id="navbarColor03">
                <ul className="navbar-nav me-auto">
                  <li className="nav-item">
                    <Link to={"/band"} className="nav-link active">
                      Bands<span className="visually-hidden">(current)</span>
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link to={"/add"} className="nav-link">
                      Add
                    </Link>
                  </li>
                </ul>
                <form className="d-flex">
                  <input className="form-control me-sm-2" type="text" placeholder="Search"/>
                  <button className="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
                </form>
              </div>
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

import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom';
import { Curier, Item, Home } from "../../page";

class Body extends Component {
    constructor(props) {
        super(props);
        this.state = {}
    }
    render() {
        return (
            <div className="container">
                <div className="title-body">
                    WELCOME NAMA PENGGUNA
                </div>
                <Switch>
                    <Route path="/home">
                        <Home></Home>
                    </Route>
                    <Route path="/item">
                        <Item></Item>
                    </Route>
                    <Route path="/curier">
                        <Curier></Curier>
                    </Route>
                    <Route>
                        <div>NOT FOUND</div>
                    </Route>
                </Switch>
               
            </div>);
    }
}

export default Body;
import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom';
import { CourierForm } from '../../component/form';
import { Courier, Item, Home } from "../../page";

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
                    <Route exact path="/home">
                        <Home></Home>
                    </Route>
                    <Route exact path="/item">
                        <Item></Item>
                    </Route>
                    <Route exact path="/courier">
                        <Courier></Courier>
                    </Route>
                    <Route exact path="/courier/gate">
                        <CourierForm></CourierForm>
                    </Route>
                    <Route>
                        <div>NOT FOUND</div>
                    </Route>
                </Switch>
               
            </div>);
    }
}

export default Body;
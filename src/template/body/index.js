import React, { Component } from 'react';
import { Route, Switch, useHistory } from 'react-router-dom';
import { CourierForm, CourierTrxForm, ItemForm } from '../../component/form';
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
                    WELCOME ADMIN
                </div>
                <Switch>
                    <Route path="/home" component={
                        ()=>{
                            let history = useHistory()
                            return <Home history={history}></Home>
                        }
                    }          
                    />
                    <Route exact path="/items">
                        <Item></Item>
                    </Route>
                    <Route exact path="/couriers">
                        <Courier></Courier>
                    </Route>
                    <Route exact path="/courier/gate" component={
                        ()=>{
                            let history = useHistory()
                            return <CourierTrxForm history={history}></CourierTrxForm>
                        }
                    }          
                    />
                    <Route exact path="/courier" component={
                        () => {
                            let history = useHistory()
                            return <CourierForm history={history}></CourierForm>
                        }
                    } />

                    <Route exact path="/item" component={
                        () => {
                            let history = useHistory()
                            return <ItemForm history={history}></ItemForm>
                        }
                    } />

                    <Route>
                        <div>NOT FOUND</div>
                    </Route>
                </Switch>

            </div>);
    }

}
export default Body;
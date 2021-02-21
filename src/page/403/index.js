import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Forbiden extends Component {
    constructor(props) {
        super(props);
        this.state = {}
    }
    render() {
        return (
            <div className="forbiden">
                <div className="isi-forbiden">
                    <h1>403</h1>
                    <h2>Access Denied</h2>
                    <Link to="/home">
                        <button className="back-denied" >Back</button>
                    </Link>
                </div>
            </div>);
    }
}

export default Forbiden;
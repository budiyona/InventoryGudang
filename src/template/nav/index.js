import React, { Component } from 'react';
import { Link } from "react-router-dom"

class Nav extends Component {
    constructor(props) {
        super(props);
        this.state = {}
    }

    render() {
        return (
            <nav className="sidebar">
                
                    <Link className="active">
                        <h3>Inventory-Gudang</h3>
                    </Link>
                    <Link className="nav-link" to="/home">
                        Home
                    </Link>
                    <Link className="nav-link" to="/item">
                        Item
                    </Link>
                    <Link className="nav-link" to="/curier">
                        Curier
                    </Link>
                    <Link className="nav-link" to="/login">
                        Logout
                    </Link>
                
            </nav>
        );
    }
}

export default Nav;
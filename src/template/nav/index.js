import React, { Component } from 'react';
import { connect } from 'react-redux';
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
                <Link className="nav-link" to="/items">
                    Item
                    </Link>
                <Link className="nav-link" to="/couriers">
                    Courier
                    </Link>
                {this.props.status &&
                    <Link className="nav-link" to="/login">
                        <span onClick={this.props.logout}>Logout</span>
                    </Link>
                }
            </nav>
        );
    }
}
const mapStateToProps = state => ({
    status: state.statusLogin,
})
const mapDispatchToProps = dispatch => {
    return {
      logout: () => dispatch({type: "LOGOUT"}),
    }
  }
export default connect(mapStateToProps,mapDispatchToProps)(Nav);
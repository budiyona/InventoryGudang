import './App.css';
import { Body, Footer, Nav } from './template';
import { Login } from './page';
import { connect } from 'react-redux';
import React, { Component } from 'react';
class App extends Component {
  constructor(props) {
    super(props);
    this.state = {}
  }
  render() {
    if (!this.props.status) {
      return (<Login></Login>)
    } else {
      return (
          <div className="container-main">
            <Nav></Nav>
            <Body></Body>
            <Footer></Footer>
          </div>
      );
    }
  }
}

const mapStateToProps = state => {
  return ({ status: state.statusLogin })
}

export default connect(mapStateToProps)(App);

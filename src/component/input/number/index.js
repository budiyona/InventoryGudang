import React, { Component } from 'react';

class Text extends Component {
    constructor(props) {
        super(props);
        this.state = { 
         }
    }
    render() { 
        return ( 
            <div className="mb-3">
                <label className="form-label">{this.props.children}</label>
                <input type="number" className="input"/>
            </div>
         );
    }
}
export default Text;
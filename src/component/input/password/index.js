import React, { Component } from 'react';

class Password extends Component {
    constructor(props) {
        super(props);
        this.state = {
        }
    }
    render() {
        return (
            <div className="input-grup">
                <label className="form-label">{this.props.children}</label>
                <input type="pasword" className="input" />
            </div>
        );
    }
}
export default Password;
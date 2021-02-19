import React, { Component } from 'react';

class Text extends Component {
    constructor(props) {
        super(props);
        this.state = {
        }
    }
    render() {
        return (
            <div className="input-grup">
                <label 
                name={this.props.name}
                className="form-label">{this.props.children}</label>
                <input 
                name={this.props.name}
                type="text" className="input" 
                onChange={this.props.onChange}
                />
            </div>
        );
    }
}
export default Text;
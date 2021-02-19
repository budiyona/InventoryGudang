import React, { Component } from 'react';

class Button extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() { 
        
        return ( 
            <button 
            type="submit" 
            className={this.props.className}
            onClick={this.props.onClick}
            >
                {this.props.children}
            </button>
         );
    }
}
 
export default Button;
import React, { Component } from 'react';
import { connect } from 'react-redux';

class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: "",
            password: ""
        }
    }

    setValue = (el) => {
        this.setState({
            [el.target.name]: el.target.value
        })
    }
    login = () => {
        let { username, password } = this.state
        let data = {
            username,
            password
        }
        this.props.login(data)
    }

    render() {
        return (
            <div className="loginpage">
                <div className="input-grup">
                    <label>Username</label>
                    <input type="text" name="username" placeholder="Username" onChange={this.setValue} />
                </div>
                <div className="input-grup">
                    <label>Password</label>
                    <input type="password" name="password" placeholder="Password" onChange={this.setValue} />
                </div>
                <div className="input-grup">
                    <input type="button" onClick={this.login} value="login" />
                </div>
            </div>
        );
    }
}
const mapStateToProps = state => ({
    statusLogin: state.statusLogin,
})

const mapDispatchToProps = dispatch => {
    return {
        login: (data) => dispatch({ type: "LOGIN", data }),
    }
}


export default connect(mapStateToProps, mapDispatchToProps)(Login);
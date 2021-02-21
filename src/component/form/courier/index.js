import React, { Component } from 'react';
class CourierForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            nameCourier: "",
            usernameCourier: "",
            idVehicle: "",
            err: ""
        }
    }
    setValue = el => {
        console.log("tageeeeeet", el.target);
        this.setState({
            [el.target.name]: el.target.value
        })
    }
    addCourier = () => {
        const { nameCourier, usernameCourier, idVehicle } = this.state
        let courier = {
            nameCourier, usernameCourier, idVehicle
        }
        fetch('http://localhost:8080/api/courier/', {
            method: 'POST',
            body: JSON.stringify(courier),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        })
            .then((response) => {
                if (!response.ok) {
                    console.log("error");
                    return response.json().then(text => {
                        throw new Error(`${text.errorMessage}`)
                    })
                }
            })
            .then(
                this.props.history.push("/couriers")
            )
            .catch(e => {
                alert(e)
            })

    }
    render() {
        return (
            <>
                <div className="form-gate-courier">
                    <div className="input-grup">
                        <label
                            className="form">Courier</label>
                        <input
                            name="nameCourier"
                            type="text" className="input"
                            onChange={this.setValue}
                        />
                    </div>
                    <div className="input-grup">
                        <label
                            className="form">Username</label>
                        <input
                            name="usernameCourier"
                            type="text" className="input"
                            onChange={this.setValue}
                        />
                    </div>
                    <div className="input-grup">
                        <label
                            className="form">ID Vehicle</label>
                        <input
                            name="idVehicle"
                            type="text" className="input"
                            onChange={this.setValue}
                        />
                    </div>

                    <div className="input-grup">
                        <label className="form-label "> -</label>
                        <input type="button" value="add" onClick={this.addCourier} />
                    </div>
                </div>
            </>
        );
    }
}

export default CourierForm;
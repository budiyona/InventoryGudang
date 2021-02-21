import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Courier extends Component {
    constructor(props) {
        super(props);
        this.state = {
            curier: []
        }
    }
    componentDidMount() {
        this.getData()
    }
    getData = () =>{
        fetch('http://localhost:8080/api/couriers?limit=15&offset=0')
            .then(response => response.json())
            .then(json => this.setState({ curier: json, loading: false }))
            .catch((e) => {
                console.log(e);
                alert("failed to fetch data")
            })
            .finally(
                this.setState({
                    loading: true
                })
            )

    }
    delete=(id)=>{
        fetch('http://localhost:8080/api/courier/'+id, {
            method: 'DELETE',
          }).then(this.getData())
    }
    render() {
        let data = this.state.curier.map((el, key) =>
            <tr key={key}>
                <td>{key+1}</td>
                <td>{el.nameCourier}</td>
                <td>{el.usernameCourier}</td>
                <td>{el.idVehicle}</td>
                <td>
                    <input type="button" className="btn-update" value="Update"></input>
                    <input type="button" className="btn-delete" value="Delete" onClick={()=>this.delete(el.idCourier)}></input>
                </td>
            </tr>
        )
        return (

            <>
                <div className="search-bar">
                    <Link to="/courier">
                        <input type="button" value="+" />
                    </Link>
                </div>
                <div className="search-bar">
                    <input type="text" name="search" />
                    <input type="button" value="search" />
                </div>
                <div className="body-container">
                    <table>
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Name</th>
                                <th>Username</th>
                                <th>ID Vehicle</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        {data}
                        </tbody>
                    </table>
                </div>

                <div className="pagination">
                    <a href="/#">Previous</a>
                    <a href="/#">1</a>
                    <a href="/#">2</a>
                    <a href="/#">3</a>
                    <a href="/#">4</a>
                    <a href="/#">5</a>
                    <a href="/#">6</a>
                    <a href="/#">Next</a>
                </div>

            </>
        );
    }
}

export default Courier;
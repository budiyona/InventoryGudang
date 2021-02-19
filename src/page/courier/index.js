import React, { Component } from 'react';

class Courier extends Component {
    constructor(props) {
        super(props);
        this.state = {
            curier: []
        }
    }
    componentDidMount() {
        fetch('http://localhost:8080/api/curiers?limit=15&offset=0')
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
    render() {
        let data = this.state.curier.map((el, key) =>
            <tr key={key}>
                <td>{key+1}</td>
                <td>{el.nameCurier}</td>
                <td>{el.usernameCurier}</td>
                <td>{el.idVehicle}</td>
                <td>
                    <input type="button" class="btn-update" value="Update"></input>
                    <input type="button" class="btn-delete" value="Delete"></input>
                </td>
            </tr>
        )
        return (

            <>
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

                <div class="pagination">
                    <a href="/#">&laquo;</a>
                    <a href="/#">1</a>
                    <a href="/#" class="active">2</a>
                    <a href="/#">3</a>
                    <a href="/#">4</a>
                    <a href="/#">5</a>
                    <a href="/#">6</a>
                    <a href="/#">&raquo;</a>
                </div>

            </>
        );
    }
}

export default Courier;
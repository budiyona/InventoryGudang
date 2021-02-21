import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            transaction: [],
            loading: true
        }
    }
    componentDidMount() {
        fetch('http://localhost:8080/api/transactions?limit=15&offset=0')
            .then(response => response.json())
            .then(json => this.setState({ transaction: json, loading: false }))
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

    getData=()=>{
        fetch('http://localhost:8080/api/transactions?limit=15&offset=0')
            .then(response => response.json())
            .then(json => this.setState({ transaction: json, loading: false }))
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

    delTrx = (id) => {
        fetch('http://localhost:8080/api/transaction/'+id, {
            method: 'DELETE',
          }).then(this.getData())
          .then(this.props.history.push("/home"))
    }

    render() {
        let data = this.state.transaction.map((el, key) =>
            <tr key={key}>
                <td>{key + 1}</td>
                <td>{el.nameItemTrx}</td>
                <td>{el.type}</td>
                <td>{el.courier.nameCourier}</td>
                <td>{el.dateTimeCreated}</td>
                <td>
                    <input type="button" className="btn-update" value="Update"></input>
                    <input type="button" className="btn-delete" value="Delete" onClick={()=>{this.delTrx(el.idItemTrx)}}></input>
                </td>
            </tr>)
        console.log(this.state.transaction);
        return (
            <>
                <div className="search-bar">
                    <Link to="/courier/gate">
                        <input type="button" value="+" />
                    </Link>
                </div>
                <div className="search-bar">
                    <input type="text" name="search" className="search-text" />
                    <input type="button" value="search" className="search-button" />
                </div>
                <div className="body-container">
                    <table>
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>ID Item Transaksi</th>
                                <th>Type</th>
                                <th>Courier</th>
                                <th>Date & time</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {data}
                        </tbody>
                    </table>
                </div>
                <div className="pagination">
                    <button className="ban-button">previous</button>
                    <button className="ban-button">next</button>
                </div>
            </>
        );
    }
}

export default Home;
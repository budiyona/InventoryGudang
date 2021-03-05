import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class item extends Component {
    constructor(props) {
        super(props);
        this.state = {
            item: [],
            loading:true,
            cat: {},
            offset: 0
        }
    }
    componentDidMount() {
        this.getData()
    }

    getData=()=>{
        fetch('http://localhost:8080/api/items?limit=15&&offset='+this.state.offset)
            .then(response => response.json())
            .then(json => this.setState({ item: json, loading: false , cat: json.itemCategory}))
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

    next=()=>{
        this.setState({offset: this.state.offset+15})
        this.getData()
    }

    prev=()=>{
        this.setState({offset: this.state.offset-15})
        this.getData()
    }
    render() {
        let data = this.state.item.map((el,key) => (
            <tr key={key}>
                <td>{key+1}</td>
                <td>{el.nameItem}</td>
                <td>{el.stock}</td>
                <td>{el.itemCategory.nameCategory}</td>
                <td>
                    <input type="button" className="btn-update" value="Update"></input>
                    <input type="button" className="btn-delete" value="Delete"></input>
                </td>
            </tr>
        ))
        return this.state.loading ? (<div>Loading</div>) : (

            <>
                
                <div className="search-bar">
                    <Link to="/item">
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
                                <th>Nama</th>
                                <th>Stok</th>
                                <th>Category</th>
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
                    <button className="ban-button" onClick={this.next}>next</button>
                </div>

            </>

        );
    }
}

export default item;
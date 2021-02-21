import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class item extends Component {
    constructor(props) {
        super(props);
        this.state = {
            item: [],
            loading:true,
            cat: {}
        }
    }
    componentDidMount() {
        fetch('http://localhost:8080/api/items?limit=15&&offset=0')
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
   
    render() {
        // console.log(this.state.item);
        console.log(this.state.cat);
        let data = this.state.item.map((el,key) => (
            <tr key={key}>
                <td>{key+1}</td>
                <td>{el.nameItem}</td>
                <td>{el.stock}</td>
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
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {data}
                        </tbody>
                    </table>
                </div>

                <div class="pagination">
                    <a href="/#">previous</a>
                    <a href="/#">1</a>
                    <a href="/#">2</a>
                    <a href="/#">3</a>
                    <a href="/#">4</a>
                    <a href="/#">5</a>
                    <a href="/#">6</a>
                    <a href="/#">next</a>
                </div>

            </>

        );
    }
}

export default item;
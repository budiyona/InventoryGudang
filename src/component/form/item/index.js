import React, { Component } from 'react';

class ItemForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cat: [],
            nameItem: "",
            idCategory: "",
        }
    }
    componentDidMount() {
        fetch('http://localhost:8080/api/itemcategoriesnolimit')
            .then(response => response.json())
            .then(json => this.setState({ cat: json, loading: false }))
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
    setValue = el => {
        console.log("tageeeeeet", el.target);
        this.setState({
            [el.target.name]: el.target.value
        })
    }
    additem = () => {
        let item = {
            nameItem: this.state.nameItem,
            itemCategory: this.state.cat.find(el => el.idCategory === this.state.idCategory),
            stock: 0
        }
        fetch('http://localhost:8080/api/item/', {
            method: 'POST',
            body: JSON.stringify(item),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        })
            .then((response) => response.json())
            .then((json) => console.log(json))
            .then(this.props.history.push("/items"))
    }
    
    render() {
        console.log(this.state);
        return (
            <>  
                <div className="form-gate-courier">
                    <div className="input-grup">
                        <label
                            className="form">Item</label>
                        <input
                            name="nameItem"
                            type="text" className="input"
                            onChange={this.setValue}
                        />
                    </div>
                    <div className="input-grup">
                        <label className="form-label ">Category</label>
                        <select className="input" name="idCategory" onChange={this.setValue}>
                            <option disabled selected>---Pilh Category---</option>
                            {this.state.cat && this.state.cat.map((el, key) =>
                                <option value={el.idCategory} key={key}>{el.nameCategory}</option>
                            )}
                        </select>
                    </div>
                    <div className="input-grup">
                        <label className="form-label "> -</label>
                        <input type="button" value="add" onClick={this.additem} />
                    </div>
                </div>
            </>
        );
    }
}

export default ItemForm;
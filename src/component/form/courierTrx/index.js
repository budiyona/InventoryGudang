import React, { Component } from 'react';
import moment from "moment";
class CourierTrxForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            datetrx: "",
            inputList: [{ idItem: "", qty: "" }],
            pref: "",
            items: [],
            courier: [],
            idCourier: "",
            type: "",
            curStok: 0,
            masuk: 0,
            keluar: 0
        }
    }
    setValue = el => {
        this.setState({
            [el.target.name]: el.target.value
        })
    }
    handleRemoveClick = index => {
        let tmp = this.state.inputList
        tmp.splice(index, 1);
        this.setState({
            inputList: tmp
        })
    };

    handleAddClick = () => {
        let tmp
        tmp = [...this.state.inputList, { firstName: "", lastName: "" }]
        this.setState({
            inputList: tmp
        })
    };
    handleInputChange = (el, index) => {
        const { name, value } = el.target;
        let tmp = this.state.inputList
        tmp[index][name] = value
        this.setState({
            inputList: tmp
        })
    };
    componentDidMount() {
        this.setTimetoToState()
        this.getCourier()
        this.getItem()
    }
    setTimetoToState = () => {
        let date = new Date()

        this.setState({
            datetrx: moment(date).format('YYYY-MM-DD HH:mm:ss')
        })
    }
    getPrefix = (el) => {
        this.setTimetoToState()
        console.log("GET PREFIX");
        let type = el.target.value
        let date = moment(this.state.datetrx).format('YYYYMM')
        let url = 'http://localhost:8080/api//transaction/prefix/' + type
        fetch(url)
            .then(response => response.json())
            .then(json => this.setState({
                pref: type + date + "-" + json.prefix
            }))
            .catch((e) => {
                console.log(e);
                alert("failed to fetch data")
            })
            .finally(
                this.setState({
                    loading: true
                })
            )
        this.setState({ type })
    }

    getItem = () => {
        fetch('http://localhost:8080/api/itemsnolimit')
            .then(response => response.json())
            .then(json => this.setState({ items: json, loading: false }))
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

    getCourier = () => {
        fetch('http://localhost:8080/api/couriersnolimit')
            .then(response => response.json())
            .then(json => this.setState({ courier: json, loading: false }))
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
    saveData = () => {
        let litem = []
        this.state.inputList.forEach(el => {
            let itembaru = this.state.items.find(e => e.idItem === el.idItem)

            litem.push({
                idItem: itembaru.idItem,
                nameItem: itembaru.nameItem,
                itemCategory: itembaru.itemCategory,
                qty: el.qty
            })
        })
        let trx = {
            nameItemTrx: this.state.pref,
            dateTimeCreated: this.state.datetrx,
            courier: this.state.courier.find(el => el.idCourier === this.state.idCourier),
            type: this.state.type,
            items: litem
        }
        console.log(trx);
        fetch('http://localhost:8080/api/transaction/', {
            method: 'POST',
            body: JSON.stringify(trx),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            }
        }).then((response) => {
            if (!response.ok) {
                console.log("error");
                return response.json().then(text => {
                    throw new Error(`${text.errorMessage}`)
                })
            }
        }).then(()=> {
            if(trx.type==='IN'){
                litem.forEach(el=> this.masuk(el.qty,el.idItem))
            }else{
                litem.forEach(el=> this.keluar(el.qty,el.idItem))
            }
        })
            .then(this.props.history.push("/home"))
            .catch(e => {
                alert(e)
            })


    }
    masuk = (qty, id) => {
        fetch('http://localhost:8080/api/item/inc?id=' + id + "&qty=" + qty, {
            method: 'PUT'
        })
    }
    keluar = (qty, id) => {
        fetch('http://localhost:8080/api/item/dec?id=' + id + "&qty=" + qty, {
            method: 'PUT'
        })
            .then((response) => {
                if (!response.ok) {
                    console.log("error");
                    return response.json().then(text => {
                        throw new Error(`${text.errorMessage}`)
                    })
                }
            })
            .catch(e => {
                alert(e)
            })
    }
    render() {

        // console.log("inputlist", this.state.inputList);
        console.log("prefix", this.state.pref);
        console.log(this.state.datetrx);

        return (
            <>

                <div className="form-gate-courier">
                    <div className="input-grup">
                        <label
                            className="form-label">ID ItemTrx</label>
                        <input
                            name="idItemTrx"
                            value={this.state.pref}
                            disabled
                        />
                        <div></div>
                    </div>

                    <div className="input-grup">
                        <label
                            className="form-label">Date & Time</label>
                        <input
                            name="dateTimeCreated"
                            type="text" className="input"
                            value={moment(this.state.datetrx).format('D MMM YYYY, h:mm')}
                            disabled
                        />
                    </div>

                    <div className="input-grup">
                        <label className="form-label ">Courier</label>
                        <select className="input" onChange={this.setValue} name="idCourier" >
                            <option disabled selected>---Pilh Courier---</option>
                            {this.state.courier && this.state.courier.map((el, key) =>
                                <option value={el.idCourier} key={key}>{el.nameCourier}</option>
                            )}
                        </select>
                    </div>
                    <div className="input-grup">
                        <label className="form-label ">Type</label>
                        <select className="input" onChange={this.getPrefix} >
                            <option disabled selected>---IN/OUT---</option>
                            <option value="IN">IN</option>
                            <option value="OUT">OUT</option>
                        </select>
                    </div>

                </div>

                {this.state.inputList.map((x, i) => {
                    return (
                        <div className="item-gate-field top-nol" key={i}>
                            <div className="input-grup">
                                <label className="form-label ">Item</label>
                                <select className="input" name="idItem" onChange={(el) => this.handleInputChange(el, i)}>
                                    <option disabled selected>---Pilh Item---</option>
                                    {this.state.items && this.state.items.map((el, key) =>
                                        <option value={el.idItem} key={key}>{el.nameItem}</option>
                                    )}
                                </select>
                            </div>

                            <div className="input-grup">
                                <label className="form-label ">Qty</label>
                                <input
                                    className="ml10"
                                    name="qty"
                                    value={x.qty}
                                    onChange={(el) => this.handleInputChange(el, i)}
                                />
                            </div>
                            <div className="input-grup">
                                <label className="form-label ">--</label>
                                <div className="btn-box">
                                    {this.state.inputList.length !== i + 1 && <button className="mr10" onClick={() => this.handleRemoveClick(i)}>Remove</button>}
                                    {this.state.inputList.length - 1 === i && <button onClick={this.handleAddClick}>Add</button>}
                                </div>
                            </div>
                        </div>
                    )
                })}
                <div className="input-grup ">
                    <input className="add-trx" type="button" onClick={this.saveData} value="SAVE" />
                </div>
            </>
        );
    }
}

export default CourierTrxForm;

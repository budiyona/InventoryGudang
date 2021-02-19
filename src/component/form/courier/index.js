import React, { Component } from 'react';
import { Text } from '../../input';

class CourierForm extends Component {
    constructor(props) {
        super(props);
        this.state = {}
    }
    render() {
        return (
            <div className="form-gate-courier">
                <Text>ID Item Trx</Text>
                <Text>Date & Time</Text>
                <Text>Courier*</Text>
                <Text>Type*</Text>
            </div>
        );
    }
}

export default CourierForm;
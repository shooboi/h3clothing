import React from 'react'
import { Header, Table } from '../../components/admin'

const columns = [
    {
        name: 'OrderID',
        selector: row => row.OrderID,
    },
    {
        name: 'CustomerID',
        selector: row => row.CustomerID,
    },
    {
        name: 'EmployeeID',
        selector: row => row.EmployeeID,
    }
];

const data = [
    { OrderID: 10248, CustomerID: 'VINET', EmployeeID: 5 },
    { OrderID: 10249, CustomerID: 'TOMSP', EmployeeID: 6 },
    { OrderID: 10250, CustomerID: 'HANAR', EmployeeID: 4 }
];

const Customers = () => {
    return (

        <div className='rounded-3xl sm:pt-16 m-3 md:m-8 p-5 md:p-10 bg-white '>
            <Header category="Page" title="Customers"></Header>
            {/* <GridComponent dataSource={data} /> */}
            <Table columns={columns} data={data} />
        </div>
    )
}

export default Customers
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
    // { OrderID: 10248, CustomerID: 'VINET', EmployeeID: 5 },
    // { OrderID: 10249, CustomerID: 'TOMSP', EmployeeID: 6 },
    // { OrderID: 10250, CustomerID: 'HANAR', EmployeeID: 4 }
];

const Employees = () => {
    return (
        <div className='rounded-3xl border-radious sm:pt-16 m-3 mt-12 md:m-8 p-5 md:p-10 w-auto h-auto max-w-full max-h-full object-contain bg-white'>
            <Header category="Page" title="Employees"></Header>
            {/* <GridComponent dataSource={data} /> */}
            <Table columns={columns} data={data} />
        </div>
    )
}

export default Employees
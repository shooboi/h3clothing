import React from 'react'

// import { GridComponent, ColumnsDirective, ColumnDirective, Resize, Sort, ContextMenu, Filter, Page, ExcelExport, PdfExport, Edit, Inject } from "@syncfusion/ej2-react-grids"
// import { ordersData, contextMenuItems, ordersGrid } from '../../data/data/dummy'

import { Header, Table } from '../../components/admin'
import OrderServices from '../../services/OrderServices';


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

const respone = OrderServices.getOrderList();

const data = [
    { OrderID: 10248, CustomerID: 'VINET', EmployeeID: 5 },
    { OrderID: 10249, CustomerID: 'TOMSP', EmployeeID: 6 },
    { OrderID: 10250, CustomerID: 'HANAR', EmployeeID: 4 }
];


const Orders = () => {
    const editing = { allowDeleting: true, allowEditing: true };
    console.log(respone);
    return (
        <>
            <div className='rounded-3xl border-radious sm:pt-16 m-3 mt-12 md:m-8 p-5 md:p-10 w-auto h-auto max-w-full max-h-full object-contain bg-white'>
                <Header category="Page" title="Orders"></Header>

                <Table columns={columns} data={data} />
            </div >
        </>
    )
}

export default Orders
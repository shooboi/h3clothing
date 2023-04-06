import React from 'react'
import { GridComponent, ColumnsDirective, ColumnDirective, Resize, Sort, ContextMenu, Filter, Page, ExcelExport, PdfExport, Edit, Inject } from "@syncfusion/ej2-react-grids"

import { ordersData, contextMenuItems, ordersGrid } from '../../data/data/dummy'
import { Header } from '../../components/admin'

const data = [
    { OrderID: 10248, CustomerID: 'VINET', EmployeeID: 5 },
    { OrderID: 10249, CustomerID: 'TOMSP', EmployeeID: 6 },
    { OrderID: 10250, CustomerID: 'HANAR', EmployeeID: 4 }
];


const Orders = () => {
    const editing = { allowDeleting: true, allowEditing: true };

    return (
        <div className='m-3 md:m-8 p-4 md:p-10 bg-white rounded-3xl'>
            <Header category="Page" title="Orders"></Header>
            <GridComponent dataSource={data} />

        </div>
    )
}

export default Orders
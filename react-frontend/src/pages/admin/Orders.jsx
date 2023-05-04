import React from 'react'

import { Header } from '../../components/admin'
import Table, { Actions, StatusPillOrder } from '../../components/admin/Table'
import { Link } from 'react-router-dom'
import { AiOutlinePlus } from 'react-icons/ai'



const getData = () => {
    const data = [
        {
            orderId: 1,
            customerId: 1,
            email: "test@gmail.com",
            customerName: 'Jane',
            status: 'Delivered',
            imgUrl: 'https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/455365/item/vngoods_41_455365.jpg?width=750',
        },
        {
            orderId: 2,
            customerId: 1,
            email: "test@gmail.com",
            customerName: 'Jane',
            status: 'Pending',
            imgUrl: 'https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/455365/item/vngoods_41_455365.jpg?width=750',
        },
        {
            orderId: 2,
            customerId: 1,
            email: "test@gmail.com",
            customerName: 'Jane',
            status: 'Cancelled',
            imgUrl: 'https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/455365/item/vngoods_41_455365.jpg?width=750',
        },

    ]
    return [...data]
}

const Orders = () => {
    const columns = React.useMemo(() => [
        {
            Header: "OrderID",
            accessor: 'orderId',
        },
        {
            Header: "Customer",
            accessor: 'customerName',
        },
        {
            Header: "Email",
            accessor: 'email',
        },
        {
            Header: "Status",
            accessor: 'status',
            Cell: StatusPillOrder
            // Filter: SelectColumnFilter,  // new
            // filter: 'includes',
        },
        {
            Header: "Action",
            accessor: 'id',
            Cell: Actions
        },
    ], [])

    const data = React.useMemo(() => getData(), [])
    return (
        <>
            <div className='rounded-3xl border-radious sm:pt-16 m-3 mt-12 md:m-8 p-5 md:p-10 w-auto h-auto max-w-full max-h-full object-contain bg-white'>
                <Header category="Page" title="Orders"></Header>
                <div className='relative w-full h-10 mb-3 '>
                    <Link to="/admin/order/add" className='absolute text-white border-gray-300 rounded-md shadow-sm p-2 px-3 bottom-2 bg-green-600 flex items-center'><AiOutlinePlus /> Add new </Link>
                </div>
                <Table columns={columns} data={data} />
            </div >
        </>
    )
}

export default Orders
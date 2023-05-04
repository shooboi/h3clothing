import React from 'react'
import { Header } from '../../components/admin'
import Table, { Actions, ProductImage } from '../../components/admin/Table';
import { Link } from 'react-router-dom';
import { AiOutlinePlus } from 'react-icons/ai';
import { useStateContext } from '../../contexts/StateContext';
const getData = () => {
    const data = [
        {
            id: 1,
            name: 'UNIQLO T-shirt',
            price: '9$',
            description: 'loren irum',
            imgUrl: 'https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/455365/item/vngoods_41_455365.jpg?width=750',
        },

    ]
    return [...data]
}
const Products = () => {
    const columns = React.useMemo(() => [
        {
            Header: "Image",
            accessor: 'image',
            Cell: ProductImage,
            imgAccessor: "imgUrl",
        },
        {
            Header: "Name",
            accessor: 'name',
        },
        {
            Header: "Price",
            accessor: 'price',
        },
        {
            Header: "Description",
            accessor: 'description',
            // Filter: SelectColumnFilter,  // new
            // filter: 'includes',
        },
        {
            Header: "Action",
            accessor: 'id',
            Cell: Actions,
        },
    ], [])

    const data = React.useMemo(() => getData(), [])
    const { activeProductSb } = useStateContext();

    return (
        <>
            {/* <ProductSidebar /> */}
            <div className={`${activeProductSb ? "activeProductSb" : ""}rounded-3xl border-radious sm:pt-16 m-3 mt-12 md:m-8 p-5 md:p-10 w-auto h-auto max-w-full max-h-full object-contain bg-white relative `}>
                <Header category="Page" title="Products"></Header>
                <div className='relative w-full h-10 mb-3 '>
                    <Link to="/admin/product/add" className='absolute text-white border-gray-300 rounded-md shadow-sm p-2 px-3 bottom-2 bg-green-600 flex items-center'><AiOutlinePlus /> Add new </Link>
                </div>
                <Table columns={columns} data={data} />
            </div>
        </>
    )
}

export default Products
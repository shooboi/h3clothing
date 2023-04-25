import React from 'react'
import { Header, ProductList } from '../../components/customer'

const pages = [{ 'title': 'Shop' }];
const Product = () => {
    return (
        <div>
            <Header pages={pages} />
            <ProductList />
        </div>
    )
}

export default Product
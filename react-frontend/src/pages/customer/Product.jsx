import React from 'react'
import { Header, ProductList } from '../../components/customer'

const pages = [
    { 'id': 1, 'title': 'Shop' }
];
const background = 'bg-product-banner';
const Product = () => {
    return (
        <div>
            <Header pages={pages} background={background} />
            <ProductList />
        </div>
    )
}

export default Product
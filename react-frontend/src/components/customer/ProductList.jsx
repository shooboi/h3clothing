import React, { useContext } from 'react'
import GridView from './GridView'
import ListView from './ListView'
import useFilterContext from "../../hooks/useFilterContext"
import { ProductContext } from '../../contexts/ProductContext'

let test = [
    {
        "id": "1",
        'title': 'test',
        'image': "/assets/img/product/pro-1.jpg"
    },
    {
        "id": "2",
        'title': 'test',
        'image': "/assets/img/product/pro-1.jpg"
    },
    {
        "id": "3",
        'title': 'test',
        'image': "/assets/img/product/pro-1.jpg"
    },
    {
        "id": "4",
        'title': 'test',
        'image': "/assets/img/product/pro-1.jpg"
    },
]
const ProductList = () => {
    const { filter_products, grid_view } = useFilterContext();
    const { fakeProduct } = useContext(ProductContext);

    let products;

    // let products = fakeProduct;
    if (filter_products?.length) {
        products = filter_products;
    } else {
        products = test;
    }
    if (grid_view === false) {
        return <ListView products={products} />
    }
    if (grid_view === true) {
        return <GridView products={products} />
    }


}

export default ProductList
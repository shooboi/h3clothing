import React, { useContext, useEffect } from 'react'
import { ProductContext } from "../../contexts/ProductContext"
import { ProductCard } from '../../components/customer';
import GridView from '../../components/customer/GridView';
import { CartContext } from '../../contexts/CartContext';

const Main = () => {
    const { products } = useContext(ProductContext);

    const filterProducts = products.filter(item => {
        return item.category === "men's clothing" || item.category === "women's clothing"
    })

    console.log(filterProducts)
    return (
        <div>
            <section className='py-16'>
                <div className='container mx-auto'>
                    <GridView products={filterProducts} />
                </div>
            </section>
        </div>
    )
}

export default Main
import React, { useContext, useEffect } from 'react'
import { ProductContext } from "../../contexts/ProductContext"
import { Hero, ProductCard } from '../../components/customer';
import GridView from '../../components/customer/GridView';
import { CartContext } from '../../contexts/CartContext';

const Main = () => {
    const { products } = useContext(ProductContext);

    const filterProducts = products.filter(item => {
        return item.category === "men's clothing"
    })

    console.log(filterProducts)
    return (
        <div>
            <section>

                <Hero />
                <div className='container mx-auto'>
                    <div className='flex justify-center w-full text-xl pt-10 font-medium'>
                        <h2> Men's clothes</h2>
                    </div>

                    <GridView products={filterProducts} />
                </div>
            </section>
        </div>
    )
}

export default Main
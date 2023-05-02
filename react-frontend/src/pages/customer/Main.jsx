import React, { useContext, useEffect } from 'react'
import { ProductContext } from "../../contexts/ProductContext"
import { Hero, ProductCard } from '../../components/customer';
import GridView from '../../components/customer/GridView';
// import { CartContext } from '../../contexts/CartContext';

const Main = () => {
    const { products } = useContext(ProductContext);

    const filterProducts = products.filter(item => {
        return item.category === "men's clothing"
    })

    return (
        <div>
            <section>

                <Hero />
                <div className='container mx-auto'>
                    <div className='mt-10 p-10'>
                        <div className='flex justify-center w-full text-xl font-medium'>
                            <h2> Men's clothes</h2>
                        </div>

                        <GridView products={filterProducts} />
                    </div>
                </div>
            </section>
        </div>
    )
}

export default Main
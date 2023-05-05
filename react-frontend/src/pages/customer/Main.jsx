import React, { useContext, useEffect } from 'react'
import { ProductContext } from "../../contexts/ProductContext"
import { Hero } from '../../components/customer';
import GridView from '../../components/customer/GridView';
import { Button, Input } from '@material-tailwind/react';
import { AiOutlineArrowRight } from 'react-icons/ai';

const Main = () => {
    const { fakeProduct } = useContext(ProductContext);

    const filterProductsMen = fakeProduct.filter(item => {
        return item.category === "men's clothing"
    })

    const filterProductsWomen = fakeProduct.filter(item => {
        return item.category === "women's clothing"
    })
    return (
        <div>
            <section>
                <Hero />
                <div className='container mx-auto'>
                    <div className='mt-10 p-10'>
                        <div className='flex justify-center w-full text-xl font-medium'>
                            <h2> Men's collection</h2>
                        </div>

                        <GridView products={filterProductsMen} />
                    </div>

                    <div className='mt-10 p-10'>
                        <div className='flex justify-center w-full text-xl font-medium'>
                            <h2> Woman's collection</h2>
                        </div>

                        <GridView products={filterProductsWomen} />
                    </div>

                    <div className='flex flex-col justify-center items-center p-20 gap-10'>
                        <span className='text-5xl'>Subscribe</span>
                        <span>Subscribe to our newsletter to receive news on update</span>
                        <Input placeholder='Your Email Address'></Input>
                        <Button className='text-white' name=''><AiOutlineArrowRight /></Button>
                    </div>
                </div>

            </section>
        </div>
    )
}

export default Main
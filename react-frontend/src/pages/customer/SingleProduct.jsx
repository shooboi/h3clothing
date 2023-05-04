import React, { useEffect } from 'react'
import { useParams } from 'react-router-dom'
import { Header } from '../../components/customer';
import test from "../../assets/img/product/pro-1.jpg"
const pages = [{ 'id': 1, 'title': 'Products' }];
const background = "bg-product-banner"

const SingleProduct = () => {
    const { id } = useParams();
    return (
        <div>
            <Header pages={pages} background={background} />
            <section className='containner px-20 pt-10 '>

                <div className='grid grid-cols-1 lg:grid-cols-2 gap-8'>

                    <img className='w-full' src={test} alt="product" />


                    <div className='space-y-5'>
                        <h2 className='text-3xl w-full'>Product name</h2>
                        <h2 className='text-xl font-semibold w-full'>$90</h2>

                        <p className='font-light'>Lorem ipsum dolor sit amet, consectetur adipisic elit eiusm tempor incidid ut labore et dolore magna aliqua. Ut enim ad minim venialo quis nostrud exercitation ullamco</p>

                        <div>Size</div>

                        <div>Quantity</div>
                        <div>Add to cart</div>

                    </div>
                </div>

            </section>
        </div>
    )
}

export default SingleProduct
import React, { useContext } from 'react'

import { CiHeart } from 'react-icons/ci';
import { AiFillStar } from 'react-icons/ai'
import { AiOutlineShoppingCart } from 'react-icons/ai';
import { AiOutlineEye } from 'react-icons/ai';
import { Link } from 'react-router-dom';
import { CartContext } from '../../contexts/CartContext';
// import logo from "../../assets/img/product/pro-1.jpg"

const ProductCard = ({ product }) => {

    const { id, image, category, title, price } = product;
    const { addToCart } = useContext(CartContext);


    return (
        <div className="group max-w-sm my-8 rounded dark:shadow-gray-900 bg-white dark:bg-gray-800 duration-300 hover:-translate-y-1">
            <div className='relative w-[270px] h-[345px] mx-auto flex justify-center items-center '>

                <img className="max-h-[300px] h rounded-t-lg p-8" src={image} alt={title} />

                <div className='flex absolute gap-x-0.5 w-[270px] bottom-0 ease-in'>
                    <button>
                        <div className="flex justify-center items-center text-lg text-white w-12 h-12 bg-lavender group-hover:opacity-100 opacity-0 group-hover:translate-y-0 translate-y-[10px] transition-all duration-1000 ">
                            <CiHeart />
                        </div>
                    </button>
                    <button onClick={() => addToCart(product, id)}>
                        <div className="flex justify-center items-center text-lg text-white w-[170px] h-12 bg-lavender group-hover:opacity-100 opacity-0 group-hover:translate-y-0 translate-y-[20px] transition-all duration-1000">
                            <AiOutlineShoppingCart />Add to cart
                        </div>
                    </button>
                    <button>
                        <div className="flex justify-center items-center text-lg text-white w-12 h-12 bg-lavender group-hover:opacity-100 opacity-0 group-hover:translate-y-0 translate-y-[30px] transition-all duration-1000">
                            <AiOutlineEye />
                        </div>
                    </button>
                </div>
            </div>


            <div className="px-5 pb-5">
                <div className='h-20'>
                    <Link to={`/product`} >
                        <h3 className="hover:text-lavender text-gray-900 text-lg tracking-tight dark:text-white">{title}</h3>
                    </Link>
                </div>
                <div className="flex items-center mt-2.5 mb-5">
                    <AiFillStar className='w-5 h-5 text-yellow-300' />
                    <AiFillStar className='w-5 h-5 text-yellow-300' />
                    <AiFillStar className='w-5 h-5 text-yellow-300' />
                    <AiFillStar className='w-5 h-5 text-yellow-300' />
                    <AiFillStar className='w-5 h-5 text-yellow-300' />
                    <span className="bg-blue-100 text-blue-800 text-xs font-semibold mr-2 px-2.5 py-0.5 rounded dark:bg-blue-200 dark:text-blue-800 ml-3">5.0</span>
                </div>
                <div className="flex items-center justify-between">
                    <span className="text-3xl font-bold text-gray-900 dark:text-white">$49.99</span>
                </div>
            </div>


        </div >

    )
}

export default ProductCard
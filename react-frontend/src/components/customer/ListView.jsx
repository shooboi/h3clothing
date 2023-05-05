import React from 'react'
import { AiFillStar } from 'react-icons/ai'
import { CartContext } from '../../contexts/CartContext';
import { useContext } from 'react';
import testpic from "../../assets/img/product/pro-1.jpg"

const test = [
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
const ListView = ({ products = test }) => {
    const { addToCart } = useContext(CartContext);

    return (
        <section className=" dark:bg-gray-900 py-10 sm:px-12">
            <div className="grid grid-cols-1 gap-12 text-neutral-600 md:max-w-none mx-auto md:mx-0">
                {products.map((product) => (
                    <div key={product.id} className='max-w-full flex flex-col md:flex-row'>
                        <div className='flex flex-none relative overflow-hidden object-contain  mx-auto justify-center items-center'>
                            <img className='max-w-[300px] md:h-auto p-8' src={product.image ? product.image : testpic} alt="test" />
                        </div>
                        <div className='px-5 flex flex-col flex-1 pt-1 items-start'>
                            <div className='block w-full text-2xl'>{product.title} {product.name} </div>
                            <div className='block w-full'>$60 </div>
                            <div className='block w-full'>
                                <div className="flex items-center mt-2.5 mb-5">
                                    <AiFillStar className='w-5 h-5 text-yellow-300' />
                                    <AiFillStar className='w-5 h-5 text-yellow-300' />
                                    <AiFillStar className='w-5 h-5 text-yellow-300' />
                                    <AiFillStar className='w-5 h-5 text-yellow-300' />
                                    <AiFillStar className='w-5 h-5 text-yellow-300' />
                                    <span className="bg-blue-100 text-blue-800 text-xs font-semibold mr-2 px-2.5 py-0.5 rounded dark:bg-blue-200 dark:text-blue-800 ml-3">5.0</span>
                                </div>
                            </div>
                            <div className='block h-36'> {product.description ? product.description : 'Lorem ipsum dolor sit amet, consecteto adipisic elit eiusm tempor incidid ut labore et dolore magna aliqua Ut enim ad minim'}  </div>
                            <div>
                                <button onClick={() => addToCart(product.id, product)} className='hover:bg-lavender duration-300 transition-all from-lavender to-lavender bg-black text-white p-3 w-44'> Add to cart</button>
                            </div>
                        </div>
                    </div>

                ))}
            </div>
        </section>
    )
}

export default ListView
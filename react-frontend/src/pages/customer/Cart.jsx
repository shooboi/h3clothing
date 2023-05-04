import React, { useContext } from 'react'
import { Header } from '../../components/customer'

import { IoMdClose } from "react-icons/io"
import { AiOutlinePlus, AiOutlineMinus } from 'react-icons/ai'
import { CartContext } from '../../contexts/CartContext'
import { Link } from 'react-router-dom'
const pages = [{ 'id': 1, 'title': 'Shopping cart' }];

const Cart = () => {
    const { cart, itemAmount } = useContext(CartContext);
    return (
        <div>
            <Header pages={pages} background={"bg-banner"} />
            <section className='container mx-auto'>

                <div className='pt-16 px-16'>
                    <div className='text-xl'>
                        Your cart items
                    </div>
                    <div className=''>
                        <div className="flex flex-col">
                            <div className="overflow-x-auto sm:-mx-6 lg:-mx-8">
                                <div className="inline-block min-w-full py-2 sm:px-6 lg:px-8">
                                    <div className="overflow-hidden">
                                        <table className="min-w-full text-left text-sm font-light border">
                                            <thead className="border-b font-medium dark:border-neutral-500">
                                                <tr>
                                                    <th scope="col" className="px-6 py-5">PRODUCT</th>
                                                    <th scope="col" className="px-6 py-4">PRICE</th>
                                                    <th scope="col" className="px-6 py-4">QUANTITY</th>
                                                    <th scope="col" className="px-6 py-4">TOTAL</th>
                                                    <th scope="col" className="px-6 py-4"></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                {cart.length > 0 ?
                                                    "" : <tr><td>No item</td></tr>}
                                                {cart.map(item => {
                                                    return <tr key={item.id} className="border-b dark:border-neutral-500">
                                                        <td className="whitespace-nowrap px-6 py-4">
                                                            <div className='flex flex-row'>
                                                                <div className='max-w-[82px] mr-3'><img src={item.image} alt={item.title} /></div>
                                                                <div className='flex flex-col gap-5 pt-3'>
                                                                    <span className='font-semibold'>{item.title}</span>
                                                                    <span className='text-gray-500 '>Size: n/a</span>
                                                                </div>
                                                            </div>

                                                        </td>

                                                        <td className="whitespace-nowrap px-6 py-4">3$</td>

                                                        <td className="whitespace-nowrap px-6 py-4">
                                                            <div className='flex flex-1 max-w-[100px] items-center h-full border p-2'>
                                                                <div className='flex-1 h-full flex justify-center items-center cursor-pointer active:text-lavender'><AiOutlineMinus /></div>
                                                                <div className='flex-1 h-full flex justify-center items-center px-2'>1</div>
                                                                <div className='flex-1 h-full flex justify-center items-center cursor-pointer active:text-lavender'><AiOutlinePlus /></div>
                                                            </div>
                                                        </td>

                                                        <td className="whitespace-nowrap px-6 py-4">3$</td>

                                                        <td className="whitespace-nowrap px-6 py-4 cursor-pointer active:text-lavender"><IoMdClose /></td>
                                                    </tr>
                                                })}


                                                {/* <tr className="border-b dark:border-neutral-500">
                                    <td className="whitespace-nowrap px-6 py-4 font-medium">2</td>
                                    <td className="whitespace-nowrap px-6 py-4">Jacob</td>
                                    <td className="whitespace-nowrap px-6 py-4">Thornton</td>
                                    <td className="whitespace-nowrap px-6 py-4">@fat</td>
                                </tr>
                                <tr className="border-b dark:border-neutral-500">
                                    <td className="whitespace-nowrap px-6 py-4 font-medium">3</td>
                                    <td className="whitespace-nowrap px-6 py-4">Larry</td>
                                    <td className="whitespace-nowrap px-6 py-4">Wild</td>
                                    <td className="whitespace-nowrap px-6 py-4">@twitter</td>
                                </tr> */}
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    {cart.length > 0 ? <div className='grid grid-cols-1 lg:grid-cols-3 '>
                        <div className='col-span-2'>

                        </div>
                        <div className='col-span-1  bg-main-bg border border-gray-200 rounded-md p-8 space-y-8'>
                            <div className='flex justify-center text-xl'>Cart total | {itemAmount} product(s)</div>

                            <div className='flex justify-between'>
                                Total
                                <div className=''>
                                    3$
                                </div>
                            </div>

                            <div className='flex justify-between'>
                                Total  (include taxes)
                                <div className='text-4xl font-semibold'>
                                    3$
                                </div>
                            </div>
                            <div className='flex flex-col justify-center text-center gap-3'>

                                <Link to="#" className='border bg-lavender text-white p-2'>
                                    Proceed to checkout
                                </Link>
                                <Link to="/" className='border bg-white text-black p-2'>
                                    Keep shopping
                                </Link>

                            </div>
                        </div>


                    </div> : ""}

                </div>


            </section >
        </div >
    )
}

export default Cart
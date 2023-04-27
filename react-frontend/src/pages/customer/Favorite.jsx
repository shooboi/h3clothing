import React from 'react'
import { Header } from "../../components/customer"
import product from "../../assets/img/product/pro-1.jpg"

const pages = [{ 'id': 1, 'title': 'Wishlist' },];
const background = "bg-banner"
const favorite = [{
    'id': 1,
    "title": "test",
    "image": { product },
}]
const Favorite = ({ product }) => {
    return (
        <>
            <Header background={background} pages={pages}></Header>

            <div>
                <div className='pt-16 px-16'>
                    <div className='text-xl'>
                        Wishlist
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
                                                    <th scope="col" className="px-6 py-4">STOCK</th>
                                                    <th scope="col" className="px-6 py-4"></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                {favorite.length > 0 ?
                                                    "" : <tr><td>No item</td></tr>}
                                                {favorite.map(item => {
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

                                                        <td className="whitespace-nowrap px-6 py-4">3</td>

                                                        <td className="whitespace-nowrap px-6 py-4">3$</td>

                                                        <td className="whitespace-nowrap px-6 py-4"><button className='bg-lavender text-white p-2'>Add to cart</button></td>
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
                </div>
            </div>
        </>
    )
}

export default Favorite
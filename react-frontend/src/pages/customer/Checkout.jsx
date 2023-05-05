import React, { useContext, useEffect } from 'react'
import { CartContext } from '../../contexts/CartContext'
import useAuth from '../../hooks/useAuth';

const Checkout = () => {
    const { cart, total } = useContext(CartContext);
    const { auth } = useAuth();
    useEffect(() => {
    })

    function uploadOrder() {
        var date = new Date();
        const order = {
            userId: 1,
            orderDate: date.toLocaleDateString(),
            totalAmount: total,
            paymentMethod: "cash",
            deliveryAddress: "hanoi"
        }
        console.log(order);


    }

    return (
        <div className='flex flex-col w-full justify-center items-center h-[100vh]'>checkout:
            <button className='text-white bg-black hover:bg-lavender p-2' onClick={() => uploadOrder()}>Checkout</button>
        </div>
    )
}

export default Checkout
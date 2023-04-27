import React from 'react'
import { useState } from 'react';
import { createContext } from 'react'

export const CartContext = createContext();
const CartProvider = ({ children }) => {
    const [cart, setCart] = useState([]);
    const addToCart = (id) => {
        console.log(`item ${id} has been added`);
    }


    return <CartContext.Provider value={{ addToCart }}>{children}</CartContext.Provider>;
}

export default CartProvider
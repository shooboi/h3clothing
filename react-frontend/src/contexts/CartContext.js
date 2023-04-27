import React, { useEffect } from 'react'
import { useState } from 'react';
import { createContext } from 'react'

export const CartContext = createContext();
const CartProvider = ({ children }) => {
    const [cart, setCart] = useState([]);
    const [itemAmount, setItemAmount] = useState(0);

    useEffect(() => {
        if (cart) {
            const amount = cart.reduce((accumulator, currentItem) => {
                return accumulator + 1;
            }, 0);
            setItemAmount(amount);
        }
    })

    const addToCart = (product, id) => {
        const newItem = { ...product, amount: 1 }

        const cartItem = cart.find((item) => {
            return item.id === id;
        })
        if (cartItem) {
            const newCart = [...cart].map((item) => {
                if (item.id === id) {
                    return { ...item, amount: cartItem.amount + 1 };
                } else {
                    return item;
                }
            });
            setCart(newCart);
        } else {
            setCart([...cart, newItem])
        }
    }

    return <CartContext.Provider value={{ itemAmount, cart, addToCart }}>{children}</CartContext.Provider>;
}

export default CartProvider
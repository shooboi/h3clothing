import React, { createContext, useEffect, useState } from 'react'
import Axios from '../api/Axios';

export const ProductContext = createContext({});

const ProductProvider = ({ children }) => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        const getProducts = async () => {
            const respone = await Axios.get("https://fakestoreapi.com/products").then();
            const data = respone?.data;
            setProducts(data);
        }
        getProducts();
    }, [])

    return <ProductContext.Provider value={{ products }}>{children}</ProductContext.Provider>;
}

export default ProductProvider;
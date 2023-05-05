import React, { createContext, useEffect, useState } from 'react'
import ProductService from '../services/ProductService';
import { useReducer } from 'react';
import reducer from "../reducer/ProductReducer";

export const ProductContext = createContext({});

const initialState = {
    isLoading: false,
    isError: false,
    products: [],
    featureProducts: [],
    isSingleLoading: false,
    singleProduct: {},
};

const ProductProvider = ({ children }) => {
    const [products, setProducts] = useState([]);
    const [fakeProduct, setFakeProduct] = useState([]);

    const [state, dispatch] = useReducer(reducer, initialState);

    const getProducts = async () => {
        dispatch({ type: "SET_LOADING" });
        try {
            // const res = await axios.get(url);
            const products = await ProductService.getProducts();
            const fakeProduct = await ProductService.getFakeProducts();
            setFakeProduct(fakeProduct);
            // const products = await res.data;
            dispatch({ type: "SET_API_DATA", payload: products });
        } catch (error) {
            dispatch({ type: "API_ERROR" });
        }
    };



    const getSingleProduct = async (id) => {
        dispatch({ type: "SET_SINGLE_LOADING" });
        try {
            // const res = await axios.get(url);
            const singleProduct = await ProductService.getSingleProduct(id);
            dispatch({ type: "SET_SINGLE_PRODUCT", payload: singleProduct });
        } catch (error) {
            dispatch({ type: "SET_SINGLE_ERROR" });
        }
    };

    useEffect(() => {
        getProducts();
    }, []);

    // useEffect(() => {
    //     const getProducts = async () => {
    //         const data = await ProductService.getProducts();
    //         const data2 = await ProductService.getFakeProducts();

    //         // const data = respone?.data;
    //         // console.log(respone);
    //         setFakeProduct(data2);
    //         setProducts(data);
    //     }

    //     getProducts();
    // }, [])

    return <ProductContext.Provider value={{ fakeProduct, products, ...state, getSingleProduct }}>{children}</ProductContext.Provider>;
}

export default ProductProvider;
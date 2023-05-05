import React, { useEffect } from 'react'
import reducer from "../reducer/FilterReducer";
import useProductContext from "../hooks/useProductContext"
import { createContext, useReducer } from "react";


export const FilterContext = createContext();

const initialState = {
  filter_products: [],
  all_products: [],
  grid_view: true,
  sorting_value: "lowest",
  sorting_name: "A-Z",
  filters: {
    text: "",
    category: "all",
    size: "",
    maxPrice: 0,
    price: 0,
    minPrice: 0,
  },
};
const FilterProvider = ({ children }) => {

  const { products } = useProductContext();

  const [state, dispatch] = useReducer(reducer, initialState);

  // update the filter values
  const updateFilterValue = (event) => {
    let name = event.target.name;
    let value = event.target.value;
    console.log(value)
    return dispatch({ type: "UPDATE_FILTERS_VALUE", payload: { name, value } });
  };

  // to set the grid view
  const setGridView = () => {
    return dispatch({ type: "SET_GRID_VIEW" });
  };

  // to set the list view
  const setListView = () => {
    return dispatch({ type: "SET_LIST_VIEW" });
  };

  // sorting function
  const sorting = (event) => {
    let userValue = event.target.value;
    dispatch({ type: "GET_SORT_VALUE", payload: userValue });
  };


  // to sort the product
  useEffect(() => {
    dispatch({ type: "FILTER_PRODUCTS" });
    dispatch({ type: "SORTING_PRODUCTS" });
  }, [products, state.sorting_value, state.filters]);

  // to load all the products for grid and list view
  useEffect(() => {
    dispatch({ type: "LOAD_FILTER_PRODUCTS", payload: products });
  }, [products]);

  // to clear the filter
  const clearFilters = () => {
    dispatch({ type: "CLEAR_FILTERS" });
  };

  return <FilterContext.Provider value={{
    ...state,
    setGridView,
    setListView,
    sorting,
    updateFilterValue,
    clearFilters,
  }}>{children}</FilterContext.Provider>

}

export default FilterProvider


import React from 'react'

import { createContext, useContext, useReducer, useEffect } from "react";


const FilterContext = createContext();

export const FilterProvider = ({ children }) => {
  return (
    <div>FilterContext</div>
  )
}

export default FilterContext
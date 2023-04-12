import React from "react";
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';

import './App.css';
import { useStateContext } from './contexts/StateContext';
import { NoPage } from './pages/others/404';
import Unauthorize from "./pages/others/403";
import Admin from "./Admin";
import Customer from "./Customer";

function App() {
  const { activeMenu } = useStateContext();

  return (

    <BrowserRouter >
      <Routes >
        {/* customer */}
        <Route path="/*" element={<Customer />}></Route>
        {/* admin */}
        <Route path='admin/*' element={<Admin />} />
      </Routes>

    </BrowserRouter>

  );
}

export default App;

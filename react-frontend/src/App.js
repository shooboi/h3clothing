import React from "react";
import { BrowserRouter, Routes, Route, Navigate, RouterProvider } from 'react-router-dom';

import './App.css';
import { useStateContext } from './contexts/StateContext';
import Admin from "./Admin";
import Customer from "./Customer";
import RequireAuth from "./components/RequiredAuth";

function App() {
  const { activeMenu } = useStateContext();
  return (
    <BrowserRouter >
      <Routes >
        {/* customer */}
        <Route path="/*" element={<Customer />}></Route>
        {/* admin */}
        <Route element={<RequireAuth />}>
          <Route path='admin/*' element={<Admin />} />
        </Route>
      </Routes>

    </BrowserRouter>

  );
}

export default App;

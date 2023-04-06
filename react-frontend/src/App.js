import React, { useState } from "react";
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import { Dashboard, Orders, Calendar, Employees, Customers, Kanban, ColorPicker, Editor } from './pages/admin';
import { useStateContext } from './contexts/StateContext';
import AdminLayout from './layouts/AdminLayout';
import { NoPage } from './pages/others/404';
import CustomerLayout from './layouts/CustomerLayout';
import { Main, About } from './pages/customer'

function App() {
  const { activeMenu } = useStateContext();

  return (
    <div className='admin'>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<CustomerLayout />}>
            <Route index element={<Main />} />
            <Route path='about' element={<About />} />
          </Route>

          <Route path='/admin' element={<AdminLayout />}>
            {/*  dashboard */}
            <Route index element={<Dashboard />} />

            <Route path='dashboard' element={<Dashboard />} />
            {/* pages */}
            <Route path='orders' element={<Orders />} />
            <Route path='customers' element={<Customers />} />
            <Route path='employees' element={<Employees />} />
            {/* apps */}

            <Route path='kanban' element={<Kanban />} />
            <Route path='editor' element={<Editor />} />
            <Route path='calendar' element={<Calendar />} />
            <Route path='color-picker' element={<ColorPicker />} />
            {/* others */}
            <Route path='*' element={<NoPage />}></Route>
          </Route>
          <Route path="*" element={<NoPage />} />

        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

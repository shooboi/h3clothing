import React from 'react'
import { Route, Routes } from 'react-router-dom'

import { NoPage } from './pages/others/404';
import Unauthorize from './pages/others/403';
import AdminLayout from './layouts/AdminLayout'
import { Dashboard, Orders, Calendar, Employees, Customers, Kanban, ColorPicker, Editor, Products, ProductForm, OrderForm } from './pages/admin';

export default function Admin() {
    return (
        <div className='admin'>
            <Routes>
                <Route element={<AdminLayout />}>

                    {/*  dashboard */}
                    <Route index element={<Dashboard />} />

                    <Route path='dashboard' element={<Dashboard />} />
                    {/* pages */}
                    <Route path='products' element={<Products />} />
                    <Route path='product/add' element={<ProductForm />} />
                    <Route path='product/edit/:id' element={<ProductForm />} />

                    <Route path='orders' element={<Orders />} />
                    <Route path='order/add/' element={<OrderForm />} />
                    <Route path='product/edit/:id' element={<OrderForm />} />

                    <Route path='customers' element={<Customers />} />
                    <Route path='employees' element={<Employees />} />
                    {/* apps */}

                    <Route path='kanban' element={<Kanban />} />
                    <Route path='editor' element={<Editor />} />
                    <Route path='calendar' element={<Calendar />} />
                    <Route path='color-picker' element={<ColorPicker />} />
                    {/* others */}
                    <Route path="unauthorize" element={<Unauthorize />} />
                    <Route path="*" element={<NoPage />} />
                </Route>
            </Routes>
        </div>
    )
}

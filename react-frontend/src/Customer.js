import React from 'react'
import { Route, Routes } from 'react-router-dom';
import { Main, About, Contact, Authentication, Product, Cart, Favorite, Account, SingleProduct } from './pages/customer'
import CustomerLayout from './layouts/CustomerLayout';
import { NoPage } from './pages/others/404';
import Unauthorize from './pages/others/403';
import RequiredAuth from './components/RequiredAuth'

export default function Customer() {
    return (
        <div className="customer overflow-hidden">
            <Routes>
                <Route element={<CustomerLayout />}>
                    <Route index element={<Main />} />
                    <Route path='about' element={<About />} />
                    <Route path='contact' element={<Contact />} />
                    <Route path='product' element={<Product />} />
                    <Route path='product' element={<Product />} />
                    <Route path="/singleproduct/:id" element={<SingleProduct />} />

                    <Route path='cart' element={<Cart />} />
                    <Route path='favorite' element={<Favorite />} />

                    <Route element={<RequiredAuth />}>
                        <Route path='account' element={<Account />} />
                    </Route>

                    <Route path='auth' element={<Authentication />} />
                    <Route path="unauthorize" element={<Unauthorize />} />
                    <Route path="*" element={<NoPage />} />
                </Route>
            </Routes>
        </div>

    )
}

import React from 'react'
import { Outlet } from 'react-router-dom'
import { Footer, Navbar, Sidebar } from '../components/customer'
const CustomerLayout = () => {

    return (

        <div className={`dark:bg-main-bg bg-white min-h-screen w-full mt-[5.5rem]`}>
            <div className='fixed bg-main-bg dark:bg-main-dark-bg h-[90px] w-full z-20 top-0 left-0 '>
                <Navbar />
            </div>
            <div className=''>
                <Sidebar />
            </div>

            <Outlet />

            <Footer />
        </div>
    )
}

export default CustomerLayout
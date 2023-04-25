import React from 'react'
import { Outlet } from 'react-router-dom'
import { Footer, Navbar, Sidebar } from '../components/customer'
const CustomerLayout = () => {
    const { activeMenu } = true;

    return (

        <div className={`dark:bg-main-bg bg-white min-h-screen w-full ${activeMenu ? ' md:ml-72'
            : ' static'}`}>

            <div className='fixed md:static bg-main-bg dark:bg-main-dark-bg nav-bar h-[90px] w-full '>
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
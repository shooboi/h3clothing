import React from 'react'

import { BrowserRouter, Routes, Route, Switch, Redirect, Outlet } from 'react-router-dom';
import { FiSettings } from "react-icons/fi"
import { TooltipComponent } from "@syncfusion/ej2-react-popups"
import '../App.css';
import "bootstrap/dist/css/bootstrap.min.css"
import { Navbar, Footer, Sidebar, ThemeSetting } from '../components/admin/';
import { useStateContext } from '../contexts/StateContext';

const AdminLayout = ({ children }) => {

    const { activeMenu } = useStateContext();

    return (
        <BrowserRouter>
            <div className='flex relative dark:bg-main-dark-bg'>
                <div className='fixed right-4 bottom-4' style={{ zIndex: '1000' }}>
                    <TooltipComponent content="Settings" position='Top'>
                        <button className='text-3xl p-3 hover:drop-shadow-xl hover:bg-light-gray text-white'
                            style={{ background: "blue", borderRadius: '50%' }}>
                            <FiSettings />
                        </button>
                    </TooltipComponent>
                </div>
                {activeMenu ? (
                    <div className='w-72 fixed sidebar dark:bg-secondary-dark-bg
              bg-white'><Sidebar /></div>
                ) : (
                    <div className='w-0 dark:bg-secondary-dark-bg'>
                        <Sidebar />
                    </div>
                )}
                <div className={`dark:bg-main-bg bg-main-bg min-h-screen w-full ${activeMenu ? ' md:ml-72'
                    : ' flex-2'}`}>
                    <div className='fixed md:static bg-main-bg dark:bg-main-dark-bg nav-bar w-full '>
                        <Navbar />
                    </div>
                    <div>
                        {/* <Routes>
                            dashboard
                            <Route path='/' element={<Dashboard />}></Route>
                            <Route path='/dashboard' element={<Dashboard />}></Route>
                            pages
                            <Route path='/orders' element={<Orders />}></Route>
                            <Route path='/customers' element={<Customers />}></Route>
                            <Route path='/employees' element={<Employees />}></Route>
                            apps

                            <Route path='/kanban' element={<Kanban />}></Route>
                            <Route path='/editor' element={<Editor />}></Route>
                            <Route path='/calander' element={<Calendar />}></Route>
                            <Route path='/color-picker' element={<ColorPicker />}></Route>
                            chart


                        </Routes> */}
                        <Outlet />
                    </div>
                </div>
            </div>
        </BrowserRouter>
    )
}

// const AdminLayoutRoute = ({ component: Component, ...rest }) => {
//     return (
//         <Route {...rest} render={matchProps => (
//             <AdminLayout>
//                 <Component {...matchProps} />
//             </AdminLayout>
//         )} />
//     )
// }

export default AdminLayout; 
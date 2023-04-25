import React, { useContext } from 'react'
import { IoMdArrowForward } from 'react-icons/io'
import { FiTrash2 } from 'react-icons/fi'
import { TfiClose } from 'react-icons/tfi'


import { SidebarContext } from '../../contexts/SidebarContext'
import { Link } from 'react-router-dom'
import { CartContext } from '../../contexts/CartContext'



const Sidebar = () => {
    const { isOpen, handleClose } = useContext(SidebarContext);
    const { cart } = useContext(CartContext);


    return (
        <div className={`${isOpen ? 'left-0' : '-left-full'} bg-white fixed flex top-0 h-full w-[15rem] transition-all duration-500 z-20 px-4 lg:px-[35px]`}>
            <div className='flex pt-10'>
                <div onClick={handleClose}>
                    <TfiClose className='text-xl font-extralight hover:text-lavender ' />
                </div>

                <div className='bg-store-logo bg-no-repeat ' >

                </div>
            </div>
        </div>
    )
}

export default Sidebar
import React from 'react'
import { useStateContext } from '../../contexts/StateContext';

const ProductSidebar = () => {
    const { activeProductSb, setActiveProductSb, screenSize } = useStateContext();
    setActiveProductSb(true);
    return (
        <div className={`
            ${activeProductSb ? 'w-72 fixed z-[900]' : 'hidden'} 
             dark:bg-secondary-dark-bg bg-white right-0  `}>
            <div className='ml-3 h-screen md:overflow-hidden overflow-auto md:hover:overflow-auto pb-10 sidebar'>
                <div className='w-full h-full'></div>
            </div>
        </div>
    )
}

export default ProductSidebar
import React from 'react'
import { Link } from 'react-router-dom'

const Hero = () => {
    return (
        <div className='flex border w-full h-[720px] md:h-[90vh] bg-blue-gray-100 flex-col md:flex-row'>
            <div className='flex flex-col justify-center items-start mt-10 pl-16 w-[100vw] md:w-[40vw] '>
                <div className='font-extralight'>Men's Collection</div>

                <div className="p-4 text-4xl font-light block leading-relaxed">
                    <div className='block'>Feeling relax day, </div>
                    <div className='block'>enjoy weekend</div>
                </div>

                <Link to="/product" className='py-2 px-4 bg-black text-white'>SHOP NOW</Link>
            </div>

            <div className="flex-auto m-3 bg-men-hero bg-no-repeat bg-center bg-contain open: transition-opacity duration-700">
                <div className=''>

                </div>
            </div>
        </div>
    )
}

export default Hero
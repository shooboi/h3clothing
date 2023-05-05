import React from 'react'
import { Link } from "react-router-dom"

export const NoPage = () => {
    return (
        <div className='flex flex-col justify-center items-center gap-3'>
            <span className='text-[16rem] text-lavender'>404</span>
            <span className='text-xl font-bold'>OPPS! PAGE NOT FOUND :( </span>
            <span>Sorry but the page you are looking for does not exist, have been removed, name changed or is temporarity unavailable. </span>
            <Link to="/" className="bg-lavender text-white p-2">Back to home</Link>
        </div >
    )
}

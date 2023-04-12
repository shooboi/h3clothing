import React from 'react'
import { Link } from 'react-router-dom'
import { Breadcrumbs } from "@material-tailwind/react";
import { AiFillHome } from 'react-icons/ai'
const Header = ({ pages }) => {

    return (
        <div className="flex justify-center p-10 bg-main-bg">

            <Breadcrumbs className=''>
                <Link to="/" className="opacity-60 text-xl">
                    <AiFillHome />
                </Link>
                {
                    pages.map((e) => (
                        <Link to={e.page} className="opacity-60 text-xl" key={e.title}>
                            <span>{e.title} {e?.icon}</span>
                        </Link>
                    ))
                }

            </Breadcrumbs >
        </div>
    )
}

export default Header
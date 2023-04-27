import React from 'react'
import { Link } from 'react-router-dom'
import { Breadcrumbs } from "@material-tailwind/react";
import { AiFillHome } from 'react-icons/ai'
const Header = ({ pages, background }) => {
    console.log(background);
    return (
        <div className={`${background} bg-center bg-cover relative p-0 bg-no-repeat h-60`}>
            <div className="container mx-auto flex items-center h-full px-12 gap-3">
                <div className="flex opacity-60 text-xl">
                    <Link to="/" >
                        <AiFillHome />
                    </Link>
                </div>
                <div className='flex opacity-60'>
                    /
                </div>
                {
                    pages.map((e) => (
                        <Link to={e.page} className="text-xl">
                            <span key={e.id}>{e.title} {e?.icon}</span>
                        </Link>
                    ))
                }

                {/* <Breadcrumbs className='bg-none'>



                </Breadcrumbs > */}
            </div>
        </div>
    )
}

export default Header
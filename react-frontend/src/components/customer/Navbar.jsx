import React, { useContext, useState, useRef } from 'react'
import { Link, NavLink } from 'react-router-dom';
import { RiArrowDropDownLine } from 'react-icons/ri'
import { CiSearch } from 'react-icons/ci'
import { RiAccountBoxLine } from 'react-icons/ri'
import { FaBars } from 'react-icons/fa'
import { AiOutlineHeart } from 'react-icons/ai';
import { AiOutlineShoppingCart } from 'react-icons/ai';

import {
    Menu,
    MenuHandler,
    MenuList,
    MenuItem,
    Button,
} from "@material-tailwind/react";
import { SidebarContext } from '../../contexts/SidebarContext';
import { AuthContext } from '../../contexts/AuthContext';

const navigation = {
    categories: [
        {
            id: 'women',
            name: 'Women',
            featured: [
                {
                    name: 'New Arrivals',
                    href: '#',
                    imageSrc: 'https://tailwindui.com/img/ecommerce-images/mega-menu-category-01.jpg',
                    imageAlt: 'Models sitting back to back, wearing Basic Tee in black and bone.',
                },
                {
                    name: 'Basic Tees',
                    href: '#',
                    imageSrc: 'https://tailwindui.com/img/ecommerce-images/mega-menu-category-02.jpg',
                    imageAlt: 'Close up of Basic Tee fall bundle with off-white, ochre, olive, and black tees.',
                },
            ],
            sections: [
                {
                    id: 'clothing',
                    name: 'Clothing',
                    items: [
                        { name: 'Tops', href: '#' },
                        { name: 'Dresses', href: '#' },
                        { name: 'Pants', href: '#' },
                        { name: 'Denim', href: '#' },
                        { name: 'Sweaters', href: '#' },
                        { name: 'T-Shirts', href: '#' },
                        { name: 'Jackets', href: '#' },
                        { name: 'Activewear', href: '#' },
                        { name: 'Browse All', href: '#' },
                    ],
                },
                {
                    id: 'accessories',
                    name: 'Accessories',
                    items: [
                        { name: 'Watches', href: '#' },
                        { name: 'Wallets', href: '#' },
                        { name: 'Bags', href: '#' },
                        { name: 'Sunglasses', href: '#' },
                        { name: 'Hats', href: '#' },
                        { name: 'Belts', href: '#' },
                    ],
                },
                {
                    id: 'brands',
                    name: 'Brands',
                    items: [
                        { name: 'Full Nelson', href: '#' },
                        { name: 'My Way', href: '#' },
                        { name: 'Re-Arranged', href: '#' },
                        { name: 'Counterfeit', href: '#' },
                        { name: 'Significant Other', href: '#' },
                    ],
                },
            ],
        },
        {
            id: 'men',
            name: 'Men',
            featured: [
                {
                    name: 'New Arrivals',
                    href: '#',
                    imageSrc: 'https://tailwindui.com/img/ecommerce-images/product-page-04-detail-product-shot-01.jpg',
                    imageAlt: 'Drawstring top with elastic loop closure and textured interior padding.',
                },
                {
                    name: 'Artwork Tees',
                    href: '#',
                    imageSrc: 'https://tailwindui.com/img/ecommerce-images/category-page-02-image-card-06.jpg',
                    imageAlt:
                        'Three shirts in gray, white, and blue arranged on table with same line drawing of hands and shapes overlapping on front of shirt.',
                },
            ],
            sections: [
                {
                    id: 'clothing',
                    name: 'Clothing',
                    items: [
                        { name: 'Tops', href: '#' },
                        { name: 'Pants', href: '#' },
                        { name: 'Sweaters', href: '#' },
                        { name: 'T-Shirts', href: '#' },
                        { name: 'Jackets', href: '#' },
                        { name: 'Activewear', href: '#' },
                        { name: 'Browse All', href: '#' },
                    ],
                },
                {
                    id: 'accessories',
                    name: 'Accessories',
                    items: [
                        { name: 'Watches', href: '#' },
                        { name: 'Wallets', href: '#' },
                        { name: 'Bags', href: '#' },
                        { name: 'Sunglasses', href: '#' },
                        { name: 'Hats', href: '#' },
                        { name: 'Belts', href: '#' },
                    ],
                },
                {
                    id: 'brands',
                    name: 'Brands',
                    items: [
                        { name: 'Re-Arranged', href: '#' },
                        { name: 'Counterfeit', href: '#' },
                        { name: 'Full Nelson', href: '#' },
                        { name: 'My Way', href: '#' },
                    ],
                },
            ],
        },
    ],
    pages: [
        { name: 'Home', href: '/' },
        { name: 'Shop', href: '/product' },
        { name: 'About', href: '/about' },
        { name: 'Contact', href: '/contact' },
    ],
}

function NavElement({ name, href }) {
    return (<Link to={href} className={"hover:text-lavender flex"}>
        <span>
            {name}
        </span>
        {/* <RiArrowDropDownLine className='text-xl' /> */}
    </Link>);
}


const Navbar = () => {
    const { isOpen, setIsOpen } = useContext(SidebarContext);
    const { auth } = useContext(AuthContext);

    const [isOpenSearch, setIsOpenSearch] = useState(false);
    const search = useRef(null);

    const closeOpenMenus = (e) => {
        if (search.current && isOpenSearch && !search.current.contains(e.target)) {
            setIsOpenSearch(false)
        }
    }
    window.addEventListener('click', closeOpenMenus);


    return (
        <nav className="flex items-center w-full h-full px-10 justify-between border-b-2 border-gray-300">
            <div className='w-[200px]'>
                <NavLink to={'/'}>
                    <img className='absolute max-w-[200px] -translate-y-10' alt="" src={require("../../assets/img/logo/logo-black-removebg.png")} />
                </NavLink>
            </div>
            <div className='with'>
                <ul className='hidden lg:flex h-10 items-center gap-[4vw] justify-center'>
                    {navigation.pages.map((page) => (
                        <li key={page.name}>
                            <NavElement name={page.name} href={page.href} />
                        </li>
                    ))}
                </ul>

            </div>

            <div className="flex justify-end items-center gap-[2vw]" id="search">

                <div ref={search} className="flex items-center justify-center p-15" >
                    <a className="hover:text-lavender" onClick={() => setIsOpenSearch(!isOpenSearch)} href="#"><CiSearch className='text-2xl' /></a>
                    <form action="#" className={`bg-white absolute border mb-4 flex w-[300px] flex-wrap items-stretch p-4  ${isOpenSearch ? "opacity-100 translate-y-[5rem]" : "opacity-0"} translate-y-[4.5rem] transition-all duration-300`}>
                        <input type="text" placeholder="Search" className='relative m-0 block w-[1px] min-w-0 flex-auto rounded-l border border-r-0 border-solid border-neutral-300 bg-transparent bg-clip-padding px-3 py-[0.25rem] text-base font-normal leading-[1.6] text-neutral-700 outline-none transition ease-in-out focus:z-[3] focus:border-primary-600 focus:text-neutral-700 focus:shadow-te-primary focus:outline-none dark:border-neutral-600 dark:text-neutral-200 dark:placeholder:text-neutral-200' />
                        <button className="inline-flex transition hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] hover:bg-main-dark-bg bg-lavender text-white p-2 "><CiSearch className='text-2xl' /></button>
                    </form>
                </div>
                <div className="flex justify-start ">
                    {auth ?
                        <Link to="/account" className='flex justify-center'>
                            {/* link to my account */}
                            <button className="hover:text-lavender"><RiAccountBoxLine className='text-2xl' /></button>
                        </Link>
                        :
                        <Menu>
                            {/* dropdown */}
                            <MenuHandler>
                                <button className="hover:text-lavender"><RiAccountBoxLine className='text-2xl' /></button>
                            </MenuHandler>

                            <MenuList>
                                <MenuItem><NavElement name="Login" href="/Auth" /></MenuItem>
                                <MenuItem><NavElement name="Register" href="" /></MenuItem>
                                {/* <MenuItem><NavElement name="My Account" href="" /></MenuItem>
                            <MenuItem><NavElement name="Wishlist" href="" /></MenuItem> */}
                            </MenuList>
                        </Menu>
                    }
                </div>
                <div className="flex text-xl">
                    <Link to="/favorite" className='hover:text-lavender'>
                        <AiOutlineHeart />
                    </Link>
                </div>
                <div className="flex text-xl">
                    <Link to="/cart" className='hover:text-lavender'>
                        <AiOutlineShoppingCart />
                    </Link>

                </div>
                <div className="flex">
                    <div onClick={() => setIsOpen(!isOpen)} className='hover:text-lavender opacity-100 lg:opacity-0'> <FaBars /></div>
                </div>

            </div>
        </nav >
    )
}

export default Navbar
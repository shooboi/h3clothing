import React from 'react'
import { Link, NavLink } from 'react-router-dom';
import { RiArrowDropDownLine } from 'react-icons/ri'
import { CiSearch } from 'react-icons/ci'
import { RiAccountBoxLine } from 'react-icons/ri'
import {
    Menu,
    MenuHandler,
    MenuList,
    MenuItem,
    Button,
} from "@material-tailwind/react";

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
        { name: 'About', href: '/about' },
        { name: 'Contact', href: '/contact' },
    ],
}

function NavElement({ name, href }) {
    return (<NavLink to={href} className={"hover:text-[#a749ff] flex"}>
        <span>
            {name}
        </span>
        {/* <RiArrowDropDownLine className='text-xl' /> */}
    </NavLink>);
}


const Navbar = () => {
    return (
        <div className="fixed md:static w-screen h-[90px] bg-white">
            <nav className="flex justify-between items-center w-full h-full px-10">
                <div className='flex-1'>
                    <NavLink to={'/'}>
                        <img alt="" src={require("../../assets/img/logo/logo.png")} />
                    </NavLink>
                </div>
                <div className='flex-auto'>
                    <ul className='hidden md:flex h-10 items-center gap-[4vw]'>
                        {navigation.pages.map((page) => (
                            <li key={page.name}>
                                <NavElement name={page.name} href={page.href} />
                            </li>
                        ))}
                        {/* <li> <NavLink to={'/'} className={"hover:text-[#a749ff] flex"}>
                            <span>
                                Home
                            </span>
                            <RiArrowDropDownLine className='text-xl' />
                        </NavLink> */}
                        {/* <NavButton title="Home"
                                    // customFunc={() => setActiveMenu((prevActiveMenu) => !prevActiveMenu)}
                                    icon={<RiArrowDropDownLine />} /> */}

                        {/* <ul className="mega-menu mega-menu-padding">
                                                <li>
                                                    <ul>
                                                        <li className="mega-menu-title"><a href="#">Demo Group 01</a></li>
                                                        <li><a href="index.html">home version 1</a></li>
                                                        <li><a href="index-2.html">home version 2</a></li>
                                                        <li><a href="index-3.html">home version 3</a></li>
                                                        <li><a href="index-4.html">home version 4</a></li>
                                                        <li><a href="index-5.html">home version 5</a></li>
                                                        <li><a href="index-6.html">home version 6</a></li>
                                                    </ul>
                                                </li>
                                                <li>
                                                    <ul>
                                                        <li className="mega-menu-title"><a href="#">Demo Group 02</a></li>
                                                        <li><a href="index-7.html">home version 7</a></li>
                                                        <li><a href="index-8.html">home version 8</a></li>
                                                        <li><a href="index-9.html">home version 9</a></li>
                                                        <li><a href="index-10.html">home version 10</a></li>
                                                        <li><a href="index-11.html">home version 11</a></li>
                                                        <li><a href="index-12.html">home version 12</a></li>
                                                    </ul>
                                                </li>
                                                <li>
                                                    <ul>
                                                        <li className="mega-menu-title"><a href="#">Demo Group 03</a></li>
                                                        <li><a href="index-13.html">home version 13</a></li>
                                                        <li><a href="index-14.html">home version 14</a></li>
                                                        <li><a href="index-15.html">home version 15</a></li>
                                                        <li><a href="index-16.html">home version 16</a></li>
                                                        <li><a href="index-17.html">home version 17</a></li>
                                                        <li><a href="index-18.html">home version 18</a></li>
                                                    </ul>
                                                </li>
                                            </ul> */}
                        {/* </li> */}
                    </ul>

                </div>

                <div className="flex justify-end items-center gap-[2vw]">

                    <div className="flex items-center justify-center p-15">
                        <a className="hover:text-[#a749ff]" href="#"><CiSearch className='text-2xl' /></a>
                        {/* <form action="#" className="bg-white relative mb-4 flex w-full flex-wrap items-stretch">
                            <input type="text" placeholder="Search" className='relative m-0 block w-[1px] min-w-0 flex-auto rounded-l border border-r-0 border-solid border-neutral-300 bg-transparent bg-clip-padding px-3 py-[0.25rem] text-base font-normal leading-[1.6] text-neutral-700 outline-none transition ease-in-out focus:z-[3] focus:border-primary-600 focus:text-neutral-700 focus:shadow-te-primary focus:outline-none dark:border-neutral-600 dark:text-neutral-200 dark:placeholder:text-neutral-200' />
                            <button className="inline-flex transition hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] hover:bg-main-dark-bg bg-[#a749ff] text-white"><CiSearch className='text-2xl' /></button>
                        </form> */}
                    </div>
                    <div className="flex justify-start">
                        <Menu>
                            <MenuHandler>
                                <button className="hover:text-[#a749ff]"><RiAccountBoxLine className='text-2xl' /></button>
                            </MenuHandler>

                            {/* dropdown */}
                            <MenuList>
                                <MenuItem><NavElement name="Login" href="/Auth" /></MenuItem>
                                <MenuItem><NavElement name="Register" href="" /></MenuItem>
                                <MenuItem><NavElement name="My Account" href="" /></MenuItem>
                                <MenuItem><NavElement name="Wishlist" href="" /></MenuItem>
                            </MenuList>
                        </Menu>
                    </div>
                    {/* wishlist */}
                    {/* <div className="same-style header-wishlist">
                            <a href="wishlist.html"><i className="pe-7s-like" /></a>
                        </div> */}
                    <div className="same-style cart-wrap">
                        {/* <button className="icon-cart">
                                <i className="pe-7s-shopbag" />
                                <span className="count-style">02</span>
                            </button> */}
                        {/* <div className="shopping-cart-content"> */}
                        {/* <ul>
                                        <li className="single-shopping-cart">
                                            <div className="shopping-cart-img">
                                                <a href="#"><img alt src={"../../assets/img/cart/cart-1.png"} /></a>
                                            </div>
                                            <div className="shopping-cart-title">
                                                <h4><a href="#">T- Shart &amp; Jeans </a></h4>
                                                <h6>Qty: 02</h6>
                                                <span>$260.00</span>
                                            </div>
                                            <div className="shopping-cart-delete">
                                                <a href="#"><i className="fa fa-times-circle" /></a>
                                            </div>
                                        </li>
                                        <li className="single-shopping-cart">
                                            <div className="shopping-cart-img">
                                                <a href="#"><img alt src={"../assets/img/cart/cart-2.png"} /></a>
                                            </div>
                                            <div className="shopping-cart-title">
                                                <h4><a href="#">T- Shart &amp; Jeans </a></h4>
                                                <h6>Qty: 02</h6>
                                                <span>$260.00</span>
                                            </div>
                                            <div className="shopping-cart-delete">
                                                <a href="#"><i className="fa fa-times-circle" /></a>
                                            </div>
                                        </li>
                                    </ul>
                                    <div className="shopping-cart-total">
                                        <h4>Shipping : <span>$20.00</span></h4>
                                        <h4>Total : <span className="shop-total">$260.00</span></h4>
                                    </div>
                                    <div className="shopping-cart-btn btn-hover text-center">
                                        <a className="default-btn" href="cart-page.html">view cart</a>
                                        <a className="default-btn" href="checkout.html">checkout</a>
                                    </div> */}
                        {/* </div> */}
                    </div>

                </div>


                {/* <div className="mobile-menu-area">
                        <div className="mobile-menu">
                            <nav id="mobile-menu-active">
                                <ul className="menu-overflow">
                                    <li><a href="index.html">HOME</a>
                                        <ul>
                                            <li><a href="index.html">home version 1</a></li>
                                            <li><a href="index-2.html">home version 2</a></li>
                                            <li><a href="index-3.html">home version 3</a></li>
                                            <li><a href="index-4.html">home version 4</a></li>
                                            <li><a href="index-5.html">home version 5</a></li>
                                            <li><a href="index-6.html">home version 6</a></li>
                                            <li><a href="index-7.html">home version 7</a></li>
                                            <li><a href="index-8.html">home version 8</a></li>
                                            <li><a href="index-9.html">home version 9</a></li>
                                            <li><a href="index-10.html">home version 10</a></li>
                                            <li><a href="index-11.html">home version 11</a></li>
                                            <li><a href="index-12.html">home version 12</a></li>
                                            <li><a href="index-13.html">home version 13</a></li>
                                            <li><a href="index-14.html">home version 14</a></li>
                                            <li><a href="index-15.html">home version 15</a></li>
                                            <li><a href="index-16.html">home version 16</a></li>
                                            <li><a href="index-17.html">home version 17</a></li>
                                            <li><a href="index-18.html">home version 18</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="shop.html">Shop</a>
                                        <ul>
                                            <li><a href="#">shop layout</a>
                                                <ul>
                                                    <li><a href="shop.html">standard style</a></li>
                                                    <li><a href="shop-filter.html">Grid filter style</a></li>
                                                    <li><a href="shop-grid-2-col.html">Grid 2 column</a></li>
                                                    <li><a href="shop-no-sidebar.html">Grid No sidebar</a></li>
                                                    <li><a href="shop-grid-fw.html">Grid full wide </a></li>
                                                    <li><a href="shop-right-sidebar.html">Grid right sidebar</a></li>
                                                    <li><a href="shop-list.html">list 1 column box </a></li>
                                                    <li><a href="shop-list-fw.html">list 1 column full wide </a></li>
                                                    <li><a href="shop-list-fw-2col.html">list 2 column  full wide</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="#">product details</a>
                                                <ul>
                                                    <li><a href="product-details.html">tab style 1</a></li>
                                                    <li><a href="product-details-2.html">tab style 2</a></li>
                                                    <li><a href="product-details-3.html">tab style 3</a></li>
                                                    <li><a href="product-details-4.html">sticky style</a></li>
                                                    <li><a href="product-details-5.html">gallery style </a></li>
                                                    <li><a href="product-details-slider-box.html">Slider style</a></li>
                                                    <li><a href="product-details-affiliate.html">affiliate style</a></li>
                                                    <li><a href="product-details-6.html">fixed image style </a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a href="shop.html">Collection</a></li>
                                    <li><a href="#">Pages</a>
                                        <ul>
                                            <li><a href="about.html">about us</a></li>
                                            <li><a href="cart-page.html">cart page</a></li>
                                            <li><a href="checkout.html">checkout </a></li>
                                            <li><a href="wishlist.html">wishlist </a></li>
                                            <li><a href="my-account.html">my account</a></li>
                                            <li><a href="login-register.html">login / register </a></li>
                                            <li><a href="contact.html">contact us </a></li>
                                            <li><a href="404.html">404 page </a></li>
                                        </ul>
                                    </li>
                                    <li><a href="blog.html">Blog</a>
                                        <ul>
                                            <li><a href="blog.html">blog standard</a></li>
                                            <li><a href="blog-no-sidebar.html">blog no sidebar</a></li>
                                            <li><a href="blog-right-sidebar.html">blog right sidebar</a></li>
                                            <li><a href="blog-details.html">blog details 1</a></li>
                                            <li><a href="blog-details-2.html">blog details 2</a></li>
                                            <li><a href="blog-details-3.html">blog details 3</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="about.html">About us</a></li>
                                    <li><a href="contact.html">Contact</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div> */}
            </nav >
        </div >
    )
}

export default Navbar
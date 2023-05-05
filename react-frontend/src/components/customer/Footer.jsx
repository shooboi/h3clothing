import { Input } from '@material-tailwind/react'
import React from 'react'
import { Link } from 'react-router-dom'

const Footer = () => {
    return (
        <div className='md:pt-[100px]'>
            <footer className=" bg-main-bg pt-[100px] pb-[70px]">
                <div className="container">
                    <div className="grid grid-cols-5 mx-10 gap-5">
                        {/* logo */}
                        <div className="col-span-5 lg:col-span-1 md:col-span-5">
                            <div className="">
                                <div className="footer-logo">
                                    <a href="#">
                                        <img className='relavtive w-[200px]' alt="" src={require("../../assets/img/logo/logo-black.png")} />
                                    </a>
                                </div>
                                <p>© 2023 <Link to="#">H3Clothing</Link>. All Rights Reserved</p>
                            </div>
                        </div>
                        {/* About us */}
                        <div className="col-span-5 lg:col-span-1 md:col-span-2">
                            <div className="footer-widget mb-30 ml-30">
                                <div className="font-medium">
                                    <h3>ABOUT US</h3>
                                </div>
                                <div className="font-light">
                                    <ul>
                                        <li><Link to="#" className="hover:text-[#a749ff]">About us</Link></li>
                                        <li><Link to="#" className="hover:text-[#a749ff]">Store location</Link></li>
                                        <li><Link to="#" className="hover:text-[#a749ff]">Contact</Link></li>
                                        <li><Link to="#" className="hover:text-[#a749ff]">Orders tracking</Link></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        {/* useful links */}
                        <div className="col-span-5 lg:col-span-1 md:col-span-3">
                            <div className="footer-widget mb-30 ml-50">
                                <div className="font-medium">
                                    <h3>USEFUL LINKS</h3>
                                </div>
                                <div className="font-light">
                                    <ul>
                                        <li><Link to="#" className="hover:text-[#a749ff]">Returns</Link></li>
                                        <li><Link to="#" className="hover:text-[#a749ff]">Support Policy</Link></li>
                                        <li><Link to="#" className="hover:text-[#a749ff]">Size guide</Link></li>
                                        <li><Link to="#" className="hover:text-[#a749ff]">FAQs</Link></li>
                                        <li><Link to="/admin" className="hover:text-[#a749ff]">Admin</Link></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        {/* follow us */}
                        <div className="col-span-5 lg:col-span-1 md:col-span-2">
                            <div className="footer-widget mb-30 ml-75">
                                <div className="font-medium">
                                    <h3>FOLLOW US</h3>
                                </div>
                                <div className="font-light">
                                    <ul>
                                        <li><Link to="#" className="hover:text-[#a749ff]">Facebook</Link></li>
                                        <li><Link to="#" className="hover:text-[#a749ff]">Twitter</Link></li>
                                        <li><Link to="#" className="hover:text-[#a749ff]">Instagram</Link></li>
                                        <li><Link to="#" className="hover:text-[#a749ff]">Youtube</Link></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        {/* subscribe */}
                        <div className="col-span-5 lg:col-span-1 md:col-span-3">
                            <div className="footer-widget mb-30 ml-70">
                                <div className="font-medium">
                                    <h3>SUBSCRIBE</h3>
                                </div>
                                <div className="font-light">
                                    <p>Get E-mail updates about our latest shop and special offers.</p>
                                    <div className="">
                                        <form className="" noValidate target="_blank">
                                            <div className="">
                                                <Input className="email" type="email" placeholder="Enter your email here.." name="EMAIL" />
                                                {/* <div className="" aria-hidden="true">
                                                    <input type="text" defaultValue tabIndex={-1} />
                                                </div> */}
                                                <div className="clear">
                                                    <input type='button' className="underline underline-offset-2 hover:text-[#a749ff]" value="Subscribe" />
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    )
}

export default Footer
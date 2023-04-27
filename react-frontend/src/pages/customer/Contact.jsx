import React from 'react'
import { Footer, Header } from '../../components/customer';

import { MdLocationOn } from 'react-icons/md';
import { BsFillTelephoneFill } from "react-icons/bs"
import { IoIosMail } from 'react-icons/io'
import { CiClock2 } from 'react-icons/ci';
const pages = [{ 'title': 'Contact' }];

const Contact = () => {
    return (
        <div>
            <Header pages={pages} background={"bg-banner"} />

            <section>
                <div className='flex flex-col justify-center items-center p-24'>
                    <div className='text-4xl p-28'>Contact detail</div>

                    <div className='grid grid-cols-3 gap-4'>

                        <div className='flex gap-2'>
                            <div className='text-gray-500 text-3xl p-2'> <MdLocationOn /></div>
                            <div className='flex flex-col gap-4 text-sm tracking-wider'>
                                <span className=''>
                                    ADDRESS
                                </span>
                                <div className='text-gray-500'>
                                    285 Doi Can, Ba Dinh, Ha Noi, Viet Nam
                                </div>
                            </div>
                        </div>

                        <div className='flex flex-1 justify-center items-start flex-col  gap-2'>

                            <div className="text-sm tracking-wider">
                                <div className='pb-3'>CONTACT</div>

                                <div className='flex items-center justify-start text-gray-500 w-full'>
                                    <div className='text-2xl p-3'> <BsFillTelephoneFill /></div>

                                    <div className='relative'>Mobile: (+84) 88888888</div>
                                </div>
                                <div className='flex justify-center items-center text-gray-500'>
                                    <div className=' text-3xl p-2'><IoIosMail /></div>
                                    <div >Mail: doreply@aptechlearning.vn</div>
                                </div>
                            </div>
                        </div>

                        <div className='flex gap-2'>

                            <div className='flex flex-col gap-4 text-sm tracking-wider'>
                                <div className='text-sm tracking-wider'>
                                    <span className=''>HOUR OF OPERATION</span>

                                    <div className='flex gap-2 text-gray-500 justify-center items-center pt-4'>
                                        <div className='text-3xl'><CiClock2 /></div>

                                        <div className='space-y-4'>
                                            <p>
                                                Monday - Friday: 09:00 - 20:00
                                            </p>

                                            <p>
                                                Sunday & Satuday: 10:30 - 22:00
                                            </p>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                </div>

            </section>
        </div>
    )
}

export default Contact
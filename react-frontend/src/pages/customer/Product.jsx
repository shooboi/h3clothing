import React, { Fragment } from 'react'
import { Disclosure, Menu, Transition } from "@headlessui/react"

import { Header, ProductList } from '../../components/customer'
import { BiFilter, BiGrid, BiListUl } from "react-icons/bi"
import useFilterContext from '../../hooks/useFilterContext';
import { AiOutlineMinus, AiOutlinePlus, AiOutlineSearch } from 'react-icons/ai';
import { FaChevronDown } from 'react-icons/fa';

const pages = [
    { 'id': 1, 'title': 'Shop' }
];

const sortOptions = [
    // { name: 'Best Rating', sort: '#', current: false },
    { name: 'Newest', sort: 'newest', current: true },
    { name: 'Title: A - Z', sort: 'az', current: false },
    { name: 'Title: Z - A', sort: 'za', current: false },
    { name: 'Price: Low to High', sort: 'lowest', current: false },
    { name: 'Price: High to Low', sort: 'highest', current: false },
]
function classNames(...classes) {
    return classes.filter(Boolean).join(' ')
}
const background = 'bg-product-banner';
const Product = () => {
    const {
        filter_products,
        grid_view,
        setGridView,
        setListView,
        sorting
    } =
        useFilterContext();

    return (
        <div>
            <Header pages={pages} background={background} />

            <div className='flex justify-between items-center border-b-2 h-[80px] p-10'>
                <div className='inline-block'>Showing 1-{filter_products.length} of {filter_products.length} result</div>
                <div className='flex relative items-center justify-center'>
                    {/* <button className='flex relative items-center justify-center hover:text-lavender'><BiFilter className='text-xl' />Filter</button> */}
                    <Menu as="div" className="relative inline-block text-left ">
                        <div className='flex relative items-center justify-center'>
                            <Menu.Button className="group inline-flex justify-center text-sm font-medium  hover:text-lavender">
                                <BiFilter className='text-xl' />Filter
                            </Menu.Button>
                        </div>

                        <Transition
                            as={Fragment}
                            enter="transition ease-out duration-100"
                            enterFrom="transform opacity-0 scale-95"
                            enterTo="transform opacity-100 scale-100"
                            leave="transition ease-in duration-75"
                            leaveFrom="transform opacity-100 scale-100"
                            leaveTo="transform opacity-0 scale-95"
                        >
                            <Menu.Items className="absolute right-0 z-10 mt-2 w-40 origin-top-right rounded-md bg-white shadow-2xl ring-1 ring-black ring-opacity-5 focus:outline-none">
                                <div className="py-1">
                                    {sortOptions.map((option) => (
                                        <Menu.Item key={option.name}>
                                            {({ active }) => (
                                                <button
                                                    onClick={sorting}
                                                    value={option.sort}
                                                    className={classNames(
                                                        option.current ? 'font-medium text-gray-900' : 'text-gray-500',
                                                        active ? 'bg-gray-100' : '',
                                                        'block px-4 py-2 text-sm'
                                                    )}
                                                >
                                                    {option.name}
                                                </button>
                                            )}
                                        </Menu.Item>
                                    ))}
                                </div>
                            </Menu.Items>
                        </Transition>
                    </Menu>

                    <div className=' md:justify-between items-center flex text-xl gap-2 px-4  '>
                        <button className={`${grid_view ? "text-lavender" : ""} hover:opacity-50`} onClick={setGridView}><BiGrid /></button>
                        <button className={`${!grid_view ? "text-lavender" : ""} hover:opacity-50`} onClick={setListView}><BiListUl /></button>
                    </div>
                </div>
            </div>
            <div className='flex flex-row md:justify-start'>
                <div className='hidden lg:flex flex-col w-[20vw] sm:ml-14 pt-10 gap-10'>
                    <div className='relavtive items-center flex'>
                        <div className='translate-x-5 inset-0 pointer-events-none inset-y-6'>
                            <AiOutlineSearch></AiOutlineSearch>
                        </div>
                        <input className='flex-none border-b-2 border-gray-600 pb-1 pl-6 hover:border-black outline-none w-[250px]' type="text" placeholder='Search product...'>
                        </input>
                    </div>
                    <div className='flex flex-col justify-start gap-3 pr-3'>

                        <h2 className='text-2xl pb-10'>Product categories</h2>
                        <Disclosure>
                            {({ open }) => (
                                <>
                                    <Disclosure.Button className="flex w-full justify-between rounded-lg">
                                        Men
                                        <FaChevronDown
                                            className={`${open ? 'rotate-180 transform' : ''
                                                } text-xs`}
                                        />

                                        {/* {open ? <AiOutlinePlus /> : <AiOutlineMinus />} */}
                                    </Disclosure.Button>
                                    <Disclosure.Panel>
                                        <Disclosure>
                                            <Disclosure.Button className="pl-3">
                                                shirt
                                            </Disclosure.Button>
                                        </Disclosure>
                                    </Disclosure.Panel>
                                </>
                            )}
                        </Disclosure>
                    </div>
                </div>
                <div className=''>
                    <ProductList />
                </div>
            </div>
        </div >
    )
}

export default Product
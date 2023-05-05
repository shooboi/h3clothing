import React, { useEffect } from 'react'
import { Link, useParams } from 'react-router-dom'
import { Header } from '../../components/customer';
import test from "../../assets/img/product/pro-1.jpg"
import { AiFillStar, AiOutlineMinus, AiOutlinePlus } from 'react-icons/ai';
import useProductContext from '../../hooks/useProductContext';



const SingleProduct = () => {
    const { id } = useParams();
    const { getSingleProduct, isSingleLoading, singleProduct } = useProductContext();

    const { name, category, title, price, description } = singleProduct;
    const pages = [{ 'id': 1, 'title': 'Products', 'path': "/product" },
    { 'id': 2, 'title': `${singleProduct.name}`, 'isChild': true },
    ];
    const background = "bg-product-banner"
    // const [product, setProduct] = useState({
    //     name: "",
    //     category: "",
    //     price: "",
    //     description: "",
    //     price: ""
    // });

    useEffect(() => {
        getSingleProduct(id);
    }, []);


    // const loadProduct = async () => {
    //     const result = await ProductService.getSingleProduct(id);
    //     setProduct(result);
    // };

    // useEffect(() => {
    //     loadProduct();
    // }, []);

    if (isSingleLoading) {
        return <div className="page_loading">Loading.....</div>;
    }

    return (
        <div>
            <Header pages={pages} background={background} />
            <section className='containner px-20 pt-10 '>

                <div className='grid grid-cols-1 lg:grid-cols-2 gap-8'>

                    <img className='w-full' src={test} alt="product" />


                    <div className='space-y-5 pl-10'>
                        <h2 className='text-3xl w-full'>{name}</h2>
                        <h2 className='text-xl font-semibold w-full'>${price}</h2>
                        <div className="flex items-center mt-2.5 mb-5">
                            <AiFillStar className='w-5 h-5 text-yellow-300' />
                            <AiFillStar className='w-5 h-5 text-yellow-300' />
                            <AiFillStar className='w-5 h-5 text-yellow-300' />
                            <AiFillStar className='w-5 h-5 text-yellow-300' />
                            <AiFillStar className='w-5 h-5 text-yellow-300' />
                            <span className="bg-blue-100 text-blue-800 text-xs font-semibold mr-2 px-2.5 py-0.5 rounded dark:bg-blue-200 dark:text-blue-800 ml-3">5.0</span>
                            <span className='px-2'> | </span>
                            <Link to="#" className='text-gray-500 hover:text-lavender'>N/A review</Link>
                        </div>
                        <p className='font-light border-b-1 py-10'>{description}</p>

                        <div className='flex items-center justify-evenly'>
                            <div>
                                <h3 className='text-xl pb-4'>Size</h3>
                                <div className="space-x-3">
                                    <button className='bg-gray-100 hover:bg-lavender text-xs h-6 w-6'>S</button>
                                    <button className='bg-gray-100 hover:bg-lavender text-xs h-6 w-6'>M</button>
                                    <button className='bg-gray-100 hover:bg-lavender text-xs h-6 w-6'>L</button>
                                    <button className='bg-gray-100 hover:bg-lavender text-xs h-6 w-6'>XL</button>
                                    <button className='bg-gray-100 hover:bg-lavender text-xs h-6 w-6'>2XL</button>
                                </div>
                            </div>
                            <div>
                                <h3 className='text-xl pb-2'>Quantity:</h3>
                                <div className='flex flex-1 max-w-[100px] items-center h-full border p-2'>
                                    <div className='flex-1 h-full flex justify-center items-center cursor-pointer active:text-lavender'><AiOutlineMinus /></div>
                                    <div className='flex-1 h-full flex justify-center items-center px-2'>1</div>
                                    <div className='flex-1 h-full flex justify-center items-center cursor-pointer active:text-lavender'><AiOutlinePlus /></div>
                                </div></div>
                        </div>
                        <div className='flex w-full justify-center'>
                            <div><button className='w-36 p-4 font-bold text-white bg-blue-gray-900 hover:bg-lavender'>Add to cart</button></div>
                        </div>
                    </div>
                </div>

            </section>
        </div>
    )
}

export default SingleProduct
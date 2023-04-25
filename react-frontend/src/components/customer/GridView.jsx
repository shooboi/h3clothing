import React from 'react'
import ProductCard from './ProductCard'

const test = [
    {
        'test': 'test'
    },
    {
        'test': 'test'
    },
    {
        'test': 'test'
    },
    {
        'test': 'test'
    },
    {
        'test': 'test'
    }
]
const GridView = ({ products }) => {
    return (
        <div>
            <section className=" dark:bg-gray-900 py-10 px-12">
                <div className="grid grid-flow-row gap-8 text-neutral-600 sm:grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 md:max-w-none mx-auto md:mx-0
                ">
                    {products?.map((product) => (
                        <ProductCard key={product.id} product={product} />
                    ))}
                </div>
            </section>
        </div>
    )
}

export default GridView
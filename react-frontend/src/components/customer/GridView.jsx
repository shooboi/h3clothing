import React from 'react'
import ProductCard from './ProductCard'

const GridView = ({ products = test }) => {
    return (
        <div>
            <section className=" dark:bg-gray-900 md:py-10 md:pr-12">
                <div className="grid text-neutral-600 grid-cols-1 md:grid-cols-3 lg:grid-cols-3 xl:grid-cols-4  md:max-w-none mx-auto md:mx-0
                 max-w-sm">
                    {products?.map((product) => (
                        <ProductCard key={product.id} product={product} />
                    ))}
                </div>
            </section>
        </div>
    )
}

export default GridView
import React from 'react'
import { ProductCard } from '../../components/customer'


const ProductList = () => {
    const { filter_products, grid_view } = useFilterContext();

    return (
        <section class=" dark:bg-gray-900 py-10 px-12">
            <div class="grid grid-flow-row gap-8 text-neutral-600 sm:grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4">
                <div
                    class="my-8 rounded shadow-lg shadow-gray-200 dark:shadow-gray-900 bg-white dark:bg-gray-800 duration-300 hover:-translate-y-1">
                    {products.map((product) => (
                        <ProductCard />
                    ))}
                </div>
            </div>
        </section>


    )
}

export default ProductList
import React from 'react'
import { ProductCard } from '../../components/customer'


const products = [
    {
        image:
            "https://images.unsplash.com/photo-1495474472287-4d71bcdd2085",
        title: "5 Easy Tips That Will Make Your Latte Art Flourish",
        description:
            "Latte art is quite often the most attractive thing for a new barista, and latte art is an excellent gateway to the exciting world of coffee. Latte art easy to start with, but to master latte art patterns, you need a lot practice and determination. Here are my tips that helped me to improve my latte art a few years ago!",
    },
    {
        image:
            "https://images.unsplash.com/photo-1512034400317-de97d7d6c3ed",
        title: "Coffee Roasting Basics: Developing Flavour by Roasting",
        description:
            "Caffé latte and flat white are definitely the most ordered espresso based drinks in cafés around the world but what are they really? Have you ever wondered the difference between caffé latte vs. flat white? Let's see what makes caffé latte and flat white different from each other!",
    },
    {
        image:
            "https://images.unsplash.com/photo-1445077100181-a33e9ac94db0",
        title: "Latte vs. Flat White - What is the Difference?",
        description:
            "I bet roasting is the thing that every barista wants to know about! We can develop flavour by roasting coffee. How can we achieve the best tasting coffee? What actually happens when roasting?",
    },
    {
        image:
            "https://images.unsplash.com/photo-1459257868276-5e65389e2722",
        title: "Creating the Perfect Espresso Recipe",
        description:
            "Espresso recipes are important in cafés in terms of consistency and flavour. How and why are the espresso recipes made and what are the things you should consider when making a recipe for espresso? Let’s dig deeper into the world of espresso!",
    },
];

const ProductList = () => {
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
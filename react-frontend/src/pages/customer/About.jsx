import React from 'react'
import { Footer, Header } from '../../components/customer';


const pages = [{ 'id': 1, 'title': 'About' }];
const background = "bg-banner"
const About = () => {
    return (
        <div>
            <Header pages={pages} background={background} />
            <section>
                <div className='container mx-auto w-[50rem] flex flex-col justify-center items-center gap-8 p-10 '>
                    <div className='block text-sm font-medium tracking-wider'>SIMPLY OR WHITE</div>
                    <div className='text-5xl font-light tracking-wider'>Clever & unique ideas</div>

                    <div className='bg-story bg-no-repeat h-[516px] relative w-[712px]'>
                        <div className='absolute text-white text-4xl tracking-widest font-semibold top-[50%] w-full text-center'>OUR STORY</div>

                    </div>

                    <div className='text-sm text-gray-600 text-center'>Lorem ipsum dolor sit amet, consectetur cing elit. Suspe ndisse suscipit sagittis leo sit met
                        condimentum estibulum is Suspe ndisse suscipit sagittis leo sit met condimentum estibulorem
                        ipsum dolor sit amet, consectetur cing elit.</div>
                </div>


            </section>
        </div>
    )
}

export default About
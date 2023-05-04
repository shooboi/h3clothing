const withMT = require("@material-tailwind/react/utils/withMT");
const colors = require("tailwindcss/colors")

module.exports = withMT({
    content: ['./src/**/*.{js,jsx,ts,tsx}'],
    darkMode: 'class',
    theme: {
        fontFamily: {
            display: ['Poppins', 'Josefin Sans', 'sans-serif'],
            body: ['Poppins', 'Josefin Sans', 'sans-serif'],
        },
        extend: {
            fontSize: {
                14: '14px',
            },
            backgroundColor: {
                'main-bg': '#FAFBFB',
                'main-dark-bg': '#20232A',
                'secondary-dark-bg': '#33373E',
                'light-gray': '#F7F7F7',
                'half-transparent': 'rgba(0, 0, 0, 0.5)',
            },
            colors: {
                'lavender': "#a749ff"
            },
            borderWidth: {
                1: '1px',
            },
            borderColor: {
                color: 'rgba(0, 0, 0, 0.1)',
            },
            width: {
                400: '400px',
                760: '760px',
                780: '780px',
                800: '800px',
                1000: '1000px',
                1200: '1200px',
                1400: '1400px',
            },
            height: {
                80: '80px',
            },
            minHeight: {
                590: '590px',
            },
            backgroundImage: {
                'hero-pattern':
                    "url('/public/assets/img/admin/welcome-bg.svg')",
                'avatar':
                    "url('/public/assets/img/admin/avatar.jpg')",


                'store-logo':
                    "url('/public/assets/img/logo/logo-black-removebg.png')",
                'product-banner':
                    "url('/public/assets/img/banner/shop-banner-fashion.jpg')",
                'banner':
                    "url('/public/assets/img/banner/banner.jpg')",
                'men-hero':
                    "url('/public/assets/img/slider/men.png')",
                'story':
                    "url('/public/assets/img/blog/video-about.png')",

            },
        },
    },
    plugins: [],
});
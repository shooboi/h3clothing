import axios from '../api/Axios';

const POST_PRODUCT_URL = "/api/product/add";
const GET_ALL_PRODUCT_URL = "/api/product/list"
const GET_SINGLE_PRODUCT_URL = "/api/product/get"


async function getFakeProducts() {
    const respone = await axios.get("https://fakestoreapi.com/products").then();
    const data = respone?.data;
    return data;
}

async function getProducts() {
    const respone = await axios.get(GET_ALL_PRODUCT_URL);
    const data = respone?.data;
    return data;
}

async function getSingleProduct(id) {
    const respone = await axios.get(GET_SINGLE_PRODUCT_URL + `/${id}`);
    const data = respone?.data;
    return data;
}

async function postProduct(formData) {
    try {
        const res =

            await axios.post(POST_PRODUCT_URL, formData,
                {
                    headers: {
                        'Content-Type': 'multipart/form-data',
                        'Access-Control-Request-Origin': "localhost:3000/"
                    },
                    withCredentials: false
                })
        // await axios(
        //     {
        //         method: "post",
        //         url: POST_THUMBNAILS_URL,
        //         data: JSON.stringify(formData),
        //         headers: {
        //             'Content-Type': 'multipart/form-data',
        //             'Access-Control-Request-Origin': "localhost:3000/"
        //         },
        //     }
        // );
        console.log(res);
    } catch (error) {
        console.log(error);
    }
}

export default { postProduct, getProducts, getFakeProducts, getSingleProduct }

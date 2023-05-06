import axios from 'axios';
import useAxiosPrivate from '../hooks/useAxiosPrivate';
import Axios from '../api/Axios';

const GET_ORDER_LIST_URL = "api/order/list"
const POST_ORDER_URL = "api/order/add"

async function getOrderList() {
    try {
        const response = await axios.get(GET_ORDER_LIST_URL, (
            {
                headers: {
                    'Content-Type': 'application/json',
                    'Method': 'GET, PUT, DELETE, POST',
                    'Access-Control-Request-Origin': "localhost:3000/"
                },
                withCredentials: true,

            }
        ));
        console.log(JSON.stringify(response?.data))
        return response;
    } catch (error) {
        console.log(error);
    }
}

async function postOrder() {
    try {
        const response = await Axios.get(POST_ORDER_URL);
        console.log(JSON.stringify(response?.data))
        return response;
    } catch (error) {
        console.log(error);
    }
}

export default {
    getOrderList,
    postOrder
}

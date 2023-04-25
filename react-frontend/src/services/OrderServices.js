import axios from 'axios';

const GET_ORDER_LIST_URL = "api/order/list"

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

export default {
    getOrderList
}

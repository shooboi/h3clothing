import React from 'react'

const GET_ALL_CATEGORY_URL = "api/order/list"

async function getCategoryList() {
    try {
        const response = await axios.get(GET_ALL_CATEGORY_URL, (
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
export default { getCategoryList }
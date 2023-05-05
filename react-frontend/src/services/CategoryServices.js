import axios from "../api/Axios";

const GET_ALL_CATEGORY_URL = "api/category/list"

async function getCategoryList() {
    try {
        const response = await axios.get(GET_ALL_CATEGORY_URL, (
            {
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Request-Origin': "localhost:3000/"
                },
            }
        ));
        return response;
    } catch (error) {
        console.log(error);
    }
}
export default { getCategoryList }
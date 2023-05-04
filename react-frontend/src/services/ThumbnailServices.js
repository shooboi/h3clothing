import axios from '../api/Axios';

const POST_THUMBNAILS_URL = "/api/thumbnail/add";

async function postThumbnails(formData) {
    try {
        const res =

            await axios.post(POST_THUMBNAILS_URL, formData,
                {
                    headers: {
                        'Content-Type': 'multipart/form-data',
                        'Access-Control-Request-Origin': "localhost:3000/"
                    },
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

export default { postThumbnails }

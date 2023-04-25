import Axios from "../api/Axios";

const LOGIN_URL = "/api/auth/login";


async function login(credentials) {
    const response = await Axios.post(LOGIN_URL,
        JSON.stringify(
            { credentials },
        ),
        {
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            },
            withCredentials: true,

        }
    );
    // const response = await axios.post(LOGIN_URL,
    //     JSON.stringify(credentials),
    //     {
    //         headers: {
    //             'Content-type': 'application/json'
    //         },
    //         withCredentials: true
    //     }
    // );
    // console.log(JSON.stringify(response?.data))
    return response;
}


export default {
    login
}



// export default class UserSevices extends Component {
//     async login(creadentials) {
//         try {
//             const response = await axios.post(LOGIN_URL,
//                 JSON.stringify(creadentials),
//                 {
//                     headers: { 'Content-type': 'application/json' },
//                     withCredentials: true
//                 }
//             );

//             console.log(JSON.stringify(response?.data))
//         } catch (error) {
//             console.log(error);
//         }
//     }
//     render() {
//         return (
//             <div>UserSevices</div>
//         );
//     }
// }

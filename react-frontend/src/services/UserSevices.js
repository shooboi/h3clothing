import axios from "axios";
import Axios from "../api/Axios";
import React, { Component } from 'react'

const LOGIN_URL = "/api/auth/login";

export default function UserServices() {
    async function login(credentials) {
        try {
            const response = await axios.post(LOGIN_URL,
                JSON.stringify(credentials),
                {
                    headers: {
                        'Content-type': 'application/json'
                    },
                    withCredentials: true,

                }
            );
            console.log(JSON.stringify(response?.data))
            return response;
        } catch (error) {
            console.log(error);
        }

    }
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

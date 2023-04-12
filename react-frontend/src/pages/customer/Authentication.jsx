import React from 'react'

import { Header, Login } from '../../components/customer';

const LOGIN_URL = '/api/auth/login';

const Authentication = () => {

    const pages = [{ 'title': 'Login' }];

    return (
        <>
            <Header pages={pages} />
            <div className="bg-white mt-10 h-50vh top-0 left-0 px-[80px] flex justify-center">
                <Login />
            </div>
        </>
    )

}

export default Authentication
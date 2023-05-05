import React from 'react'
import useAuth from './useAuth'

const useRefeshToken = () => {
    const { setAuth } = useAuth();

    const refresh = async () => {
        const respone =

            setAuth(prev => {
                // console.log(JSON.stringify(prev));
                // cons
            })

        return respone.data.token;
    }
    return refresh;

}

export default useRefeshToken
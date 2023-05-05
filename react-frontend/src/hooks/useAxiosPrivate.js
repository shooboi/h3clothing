import { useEffect } from "react";
import { axiosPrivate } from "../api/Axios";
import useAuth from "./useAuth";
import useRefeshToken from "./useRefeshToken"


const useAxiosPrivate = () => {
    const refresh = useRefeshToken();
    const { auth } = useAuth();
    const requestIntercept = axiosPrivate.interceptors.request.use(
        config => {
            if (!config.headers['Authorization']) {
                config.headers['Authorization'] = `Bearer ${auth?.token}`
            }
            return config;
        }, (error) => Promise.reject(error)
    )
    useEffect(() => {
        const responseIntercept = axiosPrivate.interceptors.response.use(
            response => response,
            async (error) => {
                const prevRequest = error?.config;
                if (error?.response?.status === 403 && !prevRequest.sent) {
                    prevRequest.sent = true;
                    const newToken = await refresh();
                    prevRequest.headers['Authorization'] = `Bearer ${newToken}`;

                    return axiosPrivate(prevRequest);
                }
                return Promise.reject(error);
            }
        );

        return () => {
            axiosPrivate.interceptors.request.eject(responseIntercept);
            axiosPrivate.interceptors.response.eject(responseIntercept);
        }

    }, [auth, refresh])

    return axiosPrivate
}

export default useAxiosPrivate

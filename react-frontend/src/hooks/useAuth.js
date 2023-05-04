import { useContext } from "react";
import { AuthContext } from "../contexts/AuthContext";

const useAuth = () => {
    const { auth } = useContext(AuthContext);
    return useContext(AuthContext);
}

export default useAuth;
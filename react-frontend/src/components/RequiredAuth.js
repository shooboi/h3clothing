import { useLocation, Navigate, Outlet } from "react-router-dom";
import useAuth from "../hooks/useAuth";

const RequireAuth = ({ allowedRoles }) => {
    const { auth } = useAuth();
    const location = useLocation();

    return (
        auth?.email ? (
            auth?.roles?.find(role => allowedRoles?.includes(role))
                ? <Outlet />
                :
                <Navigate to="/unauthorize" state={{ from: location }} replace />
        )
            : <Navigate to="/auth" state={{ from: location }} replace />
    );
}

export default RequireAuth;
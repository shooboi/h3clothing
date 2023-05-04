import { useContext } from "react";
import { ProductContext } from "../contexts/ProductContext";

const useProductContext = () => {
    return useContext(ProductContext);
};
export default useProductContext;
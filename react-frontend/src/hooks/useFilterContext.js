import { useContext } from "react";
import { FilterContext } from "../contexts/FilterContext";

const useFilterContext = () => {
    return useContext(FilterContext);
};
export default useFilterContext;
const FilterReducer = (state, action) => {
    switch (action.type) {

        case "LOAD_FILTER_PRODUCTS":
            // let priceArr = action.payload.map((curElem) => curElem.price);
            // console.log(
            //     "🚀 ~ file: filterReducer.js ~ line 5 ~ filterReducer ~ priceArr",
            //     priceArr
            // );

            // 1way
            // console.log(Math.max.apply(null, priceArr));

            // let maxPrice = priceArr.reduce(
            //   (initialVal, curVal) => Math.max(initialVal, curVal),
            //   0
            // );
            // console.log(
            //   "🚀 ~ file: filterReducer.js ~ line 16 ~ filterReducer ~ maxPrice",
            //   maxPrice
            // );

            // let maxPrice = Math.max(...priceArr);
            // console.log(
            //     "🚀 ~ file: filterReducer.js ~ line 23 ~ filterReducer ~ maxPrice",
            //     maxPrice
            // );

            return {
                ...state,
                filter_products: [...action.payload],
                all_products: [...action.payload],
                // filters: { ...state.filters, maxPrice, price: maxPrice },
            };


        case "GET_SORT_VALUE":
            // let userSortValue = document.getElementById("sort");
            // let sort_value = userSortValue.options[userSortValue.selectedIndex].value;

            return {
                ...state,
                sorting_value: action.payload,
            };

        case "SORTING_PRODUCTS":
            let newSortData;
            // let tempSortProduct = [...action.payload];

            const { filter_products, sorting_value } = state;
            let tempSortProduct = [...filter_products];

            const sortingProducts = (a, b) => {
                if (sorting_value === "lowest") {
                    return a.price - b.price;
                }

                if (sorting_value === "highest") {
                    return b.price - a.price;
                }

                if (sorting_value === "az") {
                    return a.title.localeCompare(b.title);
                }

                if (sorting_value === "za") {
                    return b.title.localeCompare(a.title);
                }
            };
            newSortData = tempSortProduct.sort(sortingProducts);

            return {
                ...state,
                filter_products: newSortData,
            };

        case "SET_GRID_VIEW":
            return {
                ...state,
                grid_view: true,
            };

        case "SET_LIST_VIEW":
            return {
                ...state,
                grid_view: false,
            };

        default:
            return state;
    }
}
export default FilterReducer;

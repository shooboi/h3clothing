import React, { createContext, useContext, useState } from 'react';
import { useEffect } from 'react';

const StateContext = createContext();

const initialState = {
    chat: false,
    cart: false,
    userProfile: false,
    notification: false,
};

export const ContextProvider = ({ children }) => {
    const [screenSize, setScreenSize] = useState(undefined);
    const [activeMenu, setActiveMenu] = useState(true);
    const [activeOrderSb, setActiveOrderSb] = useState(false);
    const [activeProductSb, setActiveProductSb] = useState(false);
    const [isClicked, setIsClicked] = useState(initialState);
    const [openDialog, setOpenDialog] = useState(false);
    const [isUpload, setIsUpload] = useState(false);
    const [images, setImages] = useState([]);

    //   const [currentColor, setCurrentColor] = useState('#03C9D7');
    //   const [currentMode, setCurrentMode] = useState('Light');
    //   const [themeSettings, setThemeSettings] = useState(false);
    //   const setMode = (e) => {
    //     setCurrentMode(e.target.value);
    //     localStorage.setItem('themeMode', e.target.value);
    //   };

    //   const setColor = (color) => {
    //     setCurrentColor(color);
    //     localStorage.setItem('colorMode', color);
    //   };
    const handleOpen = () => { setOpenDialog(!openDialog) };

    const handleClick = (clicked) => setIsClicked({ ...initialState, [clicked]: true });

    useEffect(() => {
        const handleResize = () => setScreenSize(window.innerWidth);
        window.addEventListener('resize', handleResize);
        handleResize();
        return () => window.removeEventListener('resize', handleResize)
    }, []);

    useEffect(() => {
        if (screenSize < 900) {
            setActiveMenu(false);
            setActiveOrderSb(false)
            setActiveProductSb(false)

        } else {
            setActiveMenu(true);
        }
    }, [screenSize]);

    return (
        // eslint-disable-next-line react/jsx-no-constructed-context-values
        <StateContext.Provider value={{ activeMenu, setActiveMenu, openDialog, setOpenDialog, activeOrderSb, setActiveOrderSb, activeProductSb, setActiveProductSb, handleOpen, isClicked, setIsClicked, handleClick, isUpload, setIsUpload, images, setImages, screenSize, setScreenSize, initialState }}>
            {children}
        </StateContext.Provider>
    );
};

export const useStateContext = () => useContext(StateContext);
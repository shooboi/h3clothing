import { useState, useRef, useEffect } from 'react';
import { Header, Login, Footer, Register } from '../../components/customer';


const Authentication = () => {

    const [isLogin, setIsLogin] = useState(true);

    function toggleLogin() {
        setIsLogin(!isLogin)
    }

    const pages = [{ 'title': 'Login' }];

    return (
        <>
            <Header pages={pages} url={"../../assets/img/banner/banner-1.jpg"} />

            <div className='flex justify-center top-0 left-0 text-2xl pt-10'>
                <button onClick={toggleLogin} disabled={isLogin} className={`transition bg-main-bg ${isLogin ? "text-[#a749ff]" : "text-[#333] "}  font-bold  w-20`} type="submit" >Login</button>
                <div className='block p-1 text'>
                    |
                </div>
                {/* hover: */}
                <button onClick={toggleLogin} disabled={!isLogin} className={`transition bg-main-bg ${!isLogin ? "text-[#a749ff]" : "text-[#333] "} font-bold  w-20`} type="submit" >Register</button>
            </div>
            <div className="bg-white mt-10 h-50vh top-0 left-0 px-[80px] flex justify-center">
                {isLogin ? <Login /> : <Register />}

            </div>

            <Footer></Footer>
        </>
    )

}

export default Authentication
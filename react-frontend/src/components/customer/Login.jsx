import { useRef, useState, useEffect } from 'react';
import useAuth from '../../hooks/useAuth';
import Axios from '../../api/Axios';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Checkbox, Input } from '@material-tailwind/react';

import { MdClose } from "react-icons/md";

const LOGIN_URL = '/api/auth/login';

// const USER_REGEX = /^[A-z][A-z0-9-_]{3,23}$/;
const EMAIL_REGEX = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
const PWD_REGEX = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/;

const Login = () => {
    const { setAuth } = useAuth();

    const navigate = useNavigate();
    const location = useLocation();
    const from = location.state?.from?.pathname || "/";


    const emailRef = useRef();
    const errRef = useRef();

    const [email, setEmail] = useState('');
    const [validEmail, setValidEmail] = useState(false);
    const [emailFocus, setEmailFocus] = useState(false);

    const [pwd, setPwd] = useState('');
    const [validPwd, setValidPwd] = useState(false);
    const [pwdFocus, setPwdFocus] = useState(false);

    const [errMsg, setErrMsg] = useState('');

    useEffect(() => {
        emailRef.current.focus();
    }, []);

    useEffect(() => {
        setValidEmail(EMAIL_REGEX.test(email));
    }, [email])

    useEffect(() => {
        setValidPwd(PWD_REGEX.test(pwd));
    }, [pwd])

    useEffect(() => {
        setErrMsg('');
    }, [email, pwd])

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await Axios.post(LOGIN_URL,
                JSON.stringify(
                    { email: email, password: pwd },
                ),
                {
                    headers: {
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': '*'
                    },
                    withCredentials: true,

                }
            );
            const accessToken = response?.data?.accessToken;
            const roles = response?.data?.roles;
            setAuth({ email, pwd, roles, accessToken });
            setEmail('');
            setPwd('');
            navigate(from, { replace: true })
        } catch (err) {
            if (!err?.response) {
                setErrMsg('No Server Response');
            } else if (err.response?.status === 401) {
                setErrMsg('Unauthorized');
            } else {
                setErrMsg('Incorrect username or password.');
            }
            errRef.current.focus();
        }
    }


    return (
        <>
            <section className='inline-grid grid-flow-row-dense border justify-center w-780 p-10 md:px-40' >
                <div className={`${errMsg ? "" : "absolute left-[-9999px] "} col-span-2 w-full p-2 border-t-2 border-red-700 bg-main-bg`}>
                    <div className="flex justify-start items-center"><MdClose className='text-red-500 tracking-wide' /><span className='font-bold text-gray-700'>ERROR: </span><p className='text-gray-700' ref={errRef} aria-live="assertive">{errMsg}</p></div>
                </div>
                <form className='grid grid-cols-2 col-span-2 space-y-8 pt-8' onSubmit={handleSubmit}>
                    <div className="col-span-2">
                        <Input
                            className='w-10 outline-none'
                            type='text'
                            id='email'
                            ref={emailRef}
                            autoComplete='off'
                            onChange={(e) => setEmail(e.target.value)}
                            aria-invalid={validEmail ? "false" : "true"}
                            value={email}
                            label='Email'
                            required
                        />
                    </div>

                    <div className="col-span-2">
                        <Input
                            className='w-10 outline-none'
                            type="password"
                            id="password"
                            onChange={(e) => setPwd(e.target.value)}
                            value={pwd}
                            label='Pasword'
                            required
                        />
                    </div>

                    <Checkbox id='pwdRmb' label="Remember me" />

                    <Link className="relative m-3 text-center p-2 " to="#">Forgot Password</Link>

                    <button className="transition bg-main-bg text-[#333] hover:text-white hover:bg-[#a749ff] w-20 p-2 px-3 border border-gray-300" type="submit" >Login</button>

                </form>

            </section>
        </>
    )

}

export default Login
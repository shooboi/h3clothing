import { useRef, useState, useEffect } from 'react';
import { Input } from '@material-tailwind/react';

import Axios from '../../api/Axios';
import useAuth from '../../hooks/useAuth';
import { MdCheck, MdClose } from 'react-icons/md';

const REGISTER_URL = '/api/user/add';
const EMAIL_REGEX = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
const PWD_REGEX = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[.!@#$%]).{8,24}$/;
const Register = () => {
    const { setAuth } = useAuth();
    const emailRef = useRef();
    const errRef = useRef();

    const [email, setEmail] = useState('');
    const [validEmail, setValidEmail] = useState(false);
    const [emailFocus, setEmailFocus] = useState(false);

    const [pwd, setPwd] = useState('');
    const [validPwd, setValidPwd] = useState(false);
    const [pwdFocus, setPwdFocus] = useState(false);

    const [matchPwd, setMatchPwd] = useState('');
    const [validMatch, setValidMatch] = useState(false);
    const [matchFocus, setMatchFocus] = useState(false);

    const [errMsg, setErrMsg] = useState('');
    const [success, setSuccess] = useState(false);

    useEffect(() => {
        emailRef.current.focus();
    }, []);

    useEffect(() => {
        setValidEmail(EMAIL_REGEX.test(email));
    }, [email])

    useEffect(() => {
        setValidPwd(PWD_REGEX.test(pwd));
        setValidMatch(pwd === matchPwd);
    }, [pwd, matchPwd])

    useEffect(() => {
        setErrMsg('');
    }, [email, pwd, matchPwd])

    const handleSubmit = async (e) => {
        e.preventDefault();
        const v1 = EMAIL_REGEX.test(email);
        const v2 = PWD_REGEX.test(pwd);
        if (!v1 || !v2) {
            setErrMsg("Invalid Entry");
            return;
        }
        try {
            const response = await Axios.post(REGISTER_URL,
                JSON.stringify(
                    { email: email, password: pwd },
                ),
                {
                    headers: {
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': '*',
                    },
                    withCredentials: false
                }
            );
            console.log(JSON.stringify(response));
            const accessToken = response?.data?.accessToken;
            const roles = response?.data?.roles;
            setAuth({ email, pwd, roles, accessToken });
            setEmail('');
            setPwd('');
            setSuccess(true);
        } catch (err) {
            if (!err?.response) {
                setErrMsg('No Server Response');
            } else if (err.response?.status === 409) {
                setErrMsg('Email exist.');
            } else {
                setErrMsg('Registration Failed.')
            }
            errRef.current.focus();
        }
    }


    return (
        <>
            {success ? (
                <section>
                    <h1>Success!</h1>
                    <br />
                    <p>
                        <a href="#">Go to Home</a>
                    </p>
                </section>
            ) : (
                <div>

                    <section className='inline-grid  border justify-center w-full p-10 md:px-40' >
                        <div className={`${errMsg ? "" : "absolute left-[-9999px] "} col-span-2 w-full p-2 border-t-2 border-red-700 bg-main-bg`}>
                            <div className="flex justify-start items-center"><MdClose className='text-red-500 tracking-wide' /><span className='font-bold text-gray-700'>ERROR: </span><p className='text-gray-700' ref={errRef} aria-live="assertive">{errMsg}</p></div>
                        </div>

                        <form className='grid grid-cols-2 col-span-2 space-y-8 pt-8' onSubmit={handleSubmit}>
                            <div className="col-span-2 flex items-center">
                                <Input
                                    className='w-10 outline-none'
                                    type='text'
                                    id='email'
                                    ref={emailRef}
                                    autoComplete='off'
                                    onChange={(e) => setEmail(e.target.value)}
                                    value={email}
                                    label={`Email`}
                                    required
                                    error={emailFocus && email && !validEmail}
                                    onFocus={() => setEmailFocus(true)}
                                    onBlur={() => setEmailFocus(false)}
                                />
                                {validEmail ? <MdCheck className='text-green-700' /> : ""} {validEmail || !email ? "" : <MdClose className='text-red-700' />}
                            </div>

                            <div className="col-span-2 flex items-center">
                                <Input
                                    className='w-10 outline-none'
                                    type="password"
                                    id="password"
                                    onChange={(e) => setPwd(e.target.value)}
                                    value={pwd}
                                    label='Password'
                                    required
                                    error={pwdFocus && !validPwd}
                                    onFocus={() => setPwdFocus(true)}
                                    onBlur={() => setPwdFocus(false)}
                                />
                                {validPwd ? <MdCheck className='text-green-700' /> : ""} {validPwd || !pwd ? "" : <MdClose className='text-red-700' />}

                            </div>

                            <div className="col-span-2 flex items-center">
                                <Input
                                    className='w-10 outline-none'
                                    type="password"
                                    id="re_password"
                                    onChange={(e) => setMatchPwd(e.target.value)}
                                    value={matchPwd}
                                    label='Confirm Password'
                                    required
                                    onFocus={() => setMatchFocus(true)}
                                    onBlur={() => setMatchFocus(false)}
                                />
                                {validMatch && matchPwd ? <MdCheck className='text-green-700' /> : ""} {validMatch || !matchPwd ? "" : <MdClose className='text-red-700' />}
                            </div>
                            <div className={`${emailFocus && email && !validEmail ? "" : "absolute left-[-9999px] "} col-span-2 w-full p-2 border-t-2 border-orange-700 bg-main-bg`}>
                                <div className="flex justify-start items-center"><p className='text-gray-700' >Email is invaild</p></div>
                            </div>
                            <div className={`${pwdFocus && !validPwd ? "" : "absolute left-[-9999px] "} col-span-2 w-full p-2 border-t-2 border-orange-700 bg-main-bg`}>
                                <div className="flex justify-start items-center"><p className='text-gray-700' >Password must be 8 to 24 characters.<br />
                                    Must include uppercase and lowercase letters,<br /> a number and a special character.<br />
                                    Allowed special characters:</p></div>
                            </div>
                            <div className={`${matchFocus && !validMatch ? "" : "absolute left-[-9999px] "} col-span-2 w-full p-2 border-t-2 border-orange-700 bg-main-bg`}>
                                <div className="flex justify-start items-center"><p className='text-gray-700' > Must match the first password input field.</p></div>
                            </div>
                            <div className="col-span-2 relative">
                                <button disabled={!validEmail || !validPwd || !validMatch ? true : false} className=" transition bg-main-bg text-[#333] hover:text-white hover:bg-[#a749ff] w-24 p-2 border border-gray-300" type="submit" >Register</button>
                            </div>
                            <p>
                                <input className='rounded-none border border-spacing-2' type="checkbox" id="" />
                                <span className='p-2'>Receive news from us.</span><br />
                                {/* <span className="hover:text-lavender">
                                <Link to="#">Sign In</Link>
                            </span> */}
                            </p>
                        </form>

                    </section>
                </div>
            )}

        </>
    )

}

export default Register
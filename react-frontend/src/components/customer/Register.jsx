import { useRef, useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { Input } from '@material-tailwind/react';

import Axios from '../../api/Axios';
import useAuth from '../../hooks/useAuth';
const REGISTER_URL = '/api/auth/register';

const Register = () => {
    const { setAuth } = useAuth();
    const emailRef = useRef();
    const errRef = useRef();

    const [email, setEmail] = useState('');
    const [pwd, setPwd] = useState('');
    const [errMsg, setErrMsg] = useState('');
    const [success, setSuccess] = useState(false);

    useEffect(() => {
        emailRef.current.focus();
    }, []);

    useEffect(() => {
        emailRef.current.focus();
    }, []);

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await Axios.post(REGISTER_URL,
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
            // const response = UserSevices.login({ user: user, password: pwd });
            console.log();
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
            } else if (err.response?.status === 400) {
                setErrMsg('Missing Email or Password');
            } else {
                setErrMsg('Register Failed');
            }
            errRef.current.focus();
        }
    }


    return (
        <>
            {success ? (
                <section>
                    <h1>You are logged in!</h1>
                    <br />
                    <p>
                        <a href="#">Go to Home</a>
                    </p>
                </section>
            ) : (
                <section className='inline-grid  border justify-center w-780 p-10 md:px-40' >

                    <form className='grid grid-cols-2 space-y-8 pt-8' onSubmit={handleSubmit}>
                        <div className="col-span-2">
                            <Input
                                className='w-10 outline-none'
                                type='text'
                                id='email'
                                ref={emailRef}
                                autoComplete='off'
                                onChange={(e) => setEmail(e.target.value)}
                                value={email}
                                label='Email'
                                required
                            />
                        </div>

                        <div className="col-span-1">
                            <Input
                                className='w-10 outline-none'
                                type="password"
                                id="password"
                                onChange={(e) => setPwd(e.target.value)}
                                value={pwd}
                                label='Password'
                                required
                            />
                        </div>

                        <div className="col-span-1">
                            <Input
                                className='w-10 outline-none'
                                type="password"
                                id="re_password"
                                // onChange={(e) => setPwd(e.target.value)}
                                // value={pwd}
                                label='Confirm Password'
                                required
                            />
                        </div>
                        <div className="col-span-2">
                            <button className=" transition bg-main-bg text-[#333] hover:text-white hover:bg-[#a749ff] w-20 p-2 " type="submit" >Register</button>
                        </div>
                        <p>
                            Already registered?<br />
                            <span className="line">
                                {/*put router link here*/}
                                <Link to="#">Sign In</Link>
                            </span>
                        </p>
                    </form>
                    <div className='text-red-600 pt-10'>
                        <p ref={errRef} className={errMsg ? "errmsg " : "offscreen col-span-2"} aria-live="assertive">{errMsg}</p>
                    </div>
                </section>

            )}

        </>
    )

}

export default Register
import { useRef, useState, useEffect, useContext } from 'react';
import UserSevices from '../../services/UserSevices';
import AuthContext from '../../contexts/AuthProvider';
import { Link } from 'react-router-dom';
import { Checkbox, Input, Switch } from '@material-tailwind/react';

import Axios from '../../api/Axios';
const LOGIN_URL = '/api/auth/login';

const Login = () => {
    const { setAuth } = useContext(AuthContext);
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
            } else if (err.response?.status === 401) {
                setErrMsg('Unauthorized');
            } else {
                setErrMsg('Login Failed');
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
                <section className='inline-grid grid-flow-row-dense grid-cols-2 grid-rows-4 border justify-center w-780  px-10 md:px-40' >
                    <p ref={errRef} className={errMsg ? "errmsg " : "offscreen col-span-2"} aria-live="assertive">{errMsg}</p>

                    <div className='relative m-3 text-center p-2 '>
                    </div>
                    <form className='grid grid-cols-2 col-span-2 space-y-8' onSubmit={handleSubmit}>
                        <div className="col-span-2">
                            <Input
                                className='w-10 outline-none'
                                type='text'
                                id='email'
                                ref={emailRef}
                                autoComplete='off'
                                onChange={(e) => setEmail(e.target.value)}
                                value={email}
                                placeholder='Email'
                            />
                        </div>

                        <div className="col-span-2">
                            <Input
                                className='w-10 outline-none'
                                type="password"
                                id="password"
                                onChange={(e) => setPwd(e.target.value)}
                                value={pwd}
                                placeholder='Password'
                            />
                        </div>

                        <Checkbox id='pwdRmb' label="Remember me" />

                        <Link className="relative m-3 text-center p-2 " to="#">Forgot Password</Link>

                        <button className=" transition bg-main-bg text-[#333] hover:text-white hover:bg-[#a749ff] w-20 p-2 px-3" type="submit" >Login</button>
                    </form>
                </section>

            )}

        </>
    )

}

export default Login
import React from "react";
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import './App.css';
import Admin from "./Admin";
import Customer from "./Customer";
import RequireAuth from "./components/RequiredAuth";
import ScollIntoView from "./components/ScollIntoView";

const ROLES = [
  'ADMIN',
  'USER',
  "EDITOR"
]

function App() {
  return (
    <BrowserRouter >
      <Routes >
        {/* customer */}
        <Route path="/*" element={<Customer />}></Route>
        {/* admin */}
        {/* <Route element={<RequireAuth allowedRoles={[ROLES.find(e => e === "ADMIN")]} />}> */}
        <Route path='/admin/*' element={<Admin />} />
        {/* </Route> */}
      </Routes>
      <ScollIntoView />
    </BrowserRouter >

  );
}

export default App;

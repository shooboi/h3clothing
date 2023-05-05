import React from 'react'

function login(credentials) {
    return axios.post(USER_API_BASE_URL + "generate-token", credentials);
}

function getUserInfo() {
    return JSON.parse(localStorage.getItem("userInfo"));
}

function getAuthHeader() {
    return { headers: { Authorization: 'Bearer ' + this.getUserInfo().token } };
}

function logOut() {
    localStorage.removeItem("userInfo");
    return axios.post(USER_API_BASE_URL + 'logout', {}, this.getAuthHeader());
}

export default { login, getUserInfo, getAuthHeader, logOut }
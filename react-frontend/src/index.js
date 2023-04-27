import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

import { ContextProvider } from './contexts/StateContext';
import { ThemeProvider } from '@material-tailwind/react';
import ProductProvider from './contexts/ProductContext';
import SidebarProvider from './contexts/SidebarContext';
import CartProvider from './contexts/CartContext';
import AuthProvider from './contexts/AuthContext';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <ProductProvider>
    <SidebarProvider>
      <CartProvider>
        <AuthProvider>
          <React.StrictMode>
            <ThemeProvider>
              <ContextProvider>
                <App />
              </ContextProvider>
            </ThemeProvider>
          </React.StrictMode>
        </AuthProvider>
      </CartProvider>
    </SidebarProvider>
  </ProductProvider>

);


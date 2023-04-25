import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

import { AuthProvider } from './contexts/AuthProvider';
import { ContextProvider } from './contexts/StateContext';
import { ThemeProvider } from '@material-tailwind/react';
import ProductProvider from './contexts/ProductContext';
import SidebarProvider from './contexts/SidebarContext';
import CartProvider from './contexts/CartContext';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <ProductProvider>
    <SidebarProvider>
      <CartProvider>
        <React.StrictMode>
          <ThemeProvider>
            <ContextProvider>
              <AuthProvider>
                <App />
              </AuthProvider>
            </ContextProvider>
          </ThemeProvider>
        </React.StrictMode>
      </CartProvider>
    </SidebarProvider>
  </ProductProvider>

);


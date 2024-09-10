import React from "react";
import Header from "./Header";
import '../css/layout.css'

export default function Layout({ children }) {
    return (
        <div className="app-layout background-img">
            <Header /> 
            <main className="main-area">
                {children} 
            </main>
        </div>
    );
}
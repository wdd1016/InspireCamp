import { BrowserRouter } from "react-router-dom";
import { Routes, Route, Link } from "react-router";
import { useState } from "react";
import Home from "../Home";
import About from "../About";

function MyBrowserRouter() {
  const [count, setCount] = useState(0);

  return (
    <BrowserRouter>
      <ul>
        <li>
          <Link to="/">홈</Link>
        </li>
        <li>
          <Link to="/about">소개</Link>
        </li>
        <li>
          <Link to="/info">정보</Link>
        </li>
      </ul>

      <ul>
        <li>
          <a href="/">홈(anchor tag)</a>
        </li>
        <li>
          <a href="/about">소개(anchor tag)</a>
        </li>
      </ul>

      <h1>{count}</h1>
      <button onClick={() => setCount(count + 1)}>증가</button>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/info" element={<About />} />
      </Routes>
    </BrowserRouter>
  );
}

export default MyBrowserRouter;

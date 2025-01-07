import { BrowserRouter, Routes, Route, Link, Outlet } from "react-router-dom";
import Home from "../Home";
import About from "../About";
import { Profile } from "./Parameter";
import { Profiles } from "./SubRoute";
import "./CommonLayout.css";

function Layout() {
  return (
    <div>
      <header>
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
          <li>
            <Link to="/profiles">프로파일</Link>
          </li>
        </ul>
      </header>
      <main>
        <Outlet />
      </main>
    </div>
  );
}

function CommonLayout() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Layout />}>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/info" element={<About />} />
          <Route path="/profiles" element={<Profiles />}>
            <Route path=":userid" element={<Profile />} />
          </Route>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export { CommonLayout, Layout };

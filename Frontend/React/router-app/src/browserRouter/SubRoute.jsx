import { BrowserRouter, Routes, Route, Link, Outlet } from "react-router-dom";
import Home from "../Home";
import About from "../About";
import { Profile } from "./Parameter";

function Profiles() {
  return (
    <>
      <h1>사용자 목록</h1>
      <ul>
        <li>
          <Link to="/profiles/mrgo">고길동 프로파일</Link>
        </li>
        <li>
          <Link to="/profiles/mrhong">홍길동 프로파일</Link>
        </li>
        <li>
          <Link to="/profiles/none">없는 프로파일</Link>
        </li>
        <hr />
        {/* Route의 children으로 들어오는 JSX 엘리먼트를 보여주는 역할 */}
        <Outlet />
      </ul>
    </>
  );
}

function SubRoute() {
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
        <li>
          <Link to="/profiles">프로파일</Link>
        </li>
      </ul>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/info" element={<About />} />
        <Route path="/profiles" element={<Profiles />}>
          <Route path=":userid" element={<Profile />}></Route>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export { SubRoute, Profiles };

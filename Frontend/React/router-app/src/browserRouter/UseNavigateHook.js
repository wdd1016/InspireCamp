import {
  BrowserRouter,
  Routes,
  Route,
  Link,
  Outlet,
  useNavigate,
} from "react-router-dom";
import Home from "../Home";
import About from "../About";
import { Profile } from "./Parameter";
import { Profiles } from "./SubRoute";
import "./CommonLayout.css";

function UseNavigateComponent() {
  const navigate = useNavigate();

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
        <button onClick={() => navigate(-1)}>이전 페이지로 이동</button>
        <button onClick={() => navigate("/info")}>정보 페이지로 이동</button>
      </header>
      <main>
        <Outlet />
      </main>
    </div>
  );
}

export default function UseNavigateHook() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<UseNavigateComponent />}>
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

import { Link, Outlet, useNavigate, NavLink } from "react-router-dom";
import "../BrowserRouter/LayoutBrowserRouter.css";

export default function RestLayout() {
  const navigate = useNavigate();

  return (
    <div>
      <header>
        <ul>
          <li>
            <Link to="/">홈</Link>
          </li>
          <li>
            <NavLink
              to="/about"
              style={({ isActive }) =>
                isActive ? { color: "red" } : undefined
              }
            >
              소개
            </NavLink>
          </li>
          <li>
            <Link to="/info">정보</Link>
          </li>
          <li>
            <Link to="/profiles">프로파일</Link>
          </li>
          <li>
            <Link to="/mypage">마이페이지</Link>
          </li>
          <li>
            <Link to="/dogsearch">강아지 조회</Link>
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

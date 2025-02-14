import {
  createBrowserRouter,
  Link,
  Outlet,
  RouterProvider,
  useNavigate,
} from "react-router-dom";
import "./App.css";
import BoardList from "./board/BoardList";
import BoardWrite from "./board/BoardWrite";
import BoardDetail from "./board/BoardDetail";
import Login from "./user/Login";
import { jwtDecode } from "jwt-decode";

const Layout = () => {
  const navigate = useNavigate();

  const token = sessionStorage.getItem("token");
  let decoded = "";
  if (token) {
    decoded = jwtDecode(token);
    console.log(decoded.name);
  } else {
    navigate("/");
  }

  const doLogout = (e) => {
    e.preventDefault();
    sessionStorage.removeItem("token");
    // sessionStorage.clear();
    navigate("/");
  };

  return (
    <>
      <nav>
        {token && (
          <>
            "{decoded.name}"님 반갑습니다. [<a onClick={doLogout}>로그아웃</a>]
          </>
        )}
      </nav>
      <Outlet />
    </>
  );
};

const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout />,
    children: [
      { path: "", element: <Login /> },
      { path: "list", element: <BoardList /> },
      { path: "detail/:boardIdx", element: <BoardDetail /> },
      { path: "write", element: <BoardWrite /> },
    ],
  },
]);
export default function App() {
  return <RouterProvider router={router} />;
}

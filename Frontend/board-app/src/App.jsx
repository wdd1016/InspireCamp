import {
  createBrowserRouter,
  Link,
  Outlet,
  RouterProvider,
} from "react-router-dom";
import "./App.css";
import BoardList from "./board/BoardList";
import BoardWrite from "./board/BoardWrite";
import BoardDetail from "./board/BoardDetail";
import Login from "./user/Login";

const Layout = () => (
  <>
    <nav>
      <Link to="/">로그인</Link>:<Link to="/list">게시판 목록</Link>:
      <Link to="/detail/8">게시판 상세</Link>:
      <Link to="/write">게시판 글쓰기</Link>
    </nav>
    <Outlet />
  </>
);

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

import {
  createBrowserRouter,
  Link,
  Outlet,
  RouterProvider,
} from "react-router-dom";
import BookList from "./book/BookList";
import BookDetail from "./book/BookDetail";
import BookRegister from "./book/BookRegister";

const Layout = () => {
  const defaultBookId = 2;
  return (
    <>
      <nav>
        <Link to="/list">책 목록</Link>:
        <Link to={`/detail/${defaultBookId}`}>책 상세</Link>:
        <Link to="/register">책 등록</Link>
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
      { path: "", element: <BookList /> },
      { path: "list", element: <BookList /> },
      { path: "detail/:bookId", element: <BookDetail /> },
      { path: "register", element: <BookRegister /> },
    ],
  },
]);

export default function App() {
  return <RouterProvider router={router} />;
}

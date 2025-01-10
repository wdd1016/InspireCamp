import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { Layout } from "../BrowserRouter/LayoutBrowserRouter";
import Home from "../Home";
import About from "../About";
import { Profiles } from "../BrowserRouter/SubRoute";
import { Profile } from "../BrowserRouter/Parameter";
import Login from "../Login";
import MyPage from "../MyPage";
import { NotFound } from "../BrowserRouter/NotFoundBrowserRouter";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout />,
    children: [
      { path: "/", element: <Home /> },
      { path: "/about", element: <About /> },
      { path: "/info", element: <About /> },
      {
        path: "/profiles",
        element: <Profiles />,
        children: [{ path: ":userid", element: <Profile /> }],
      },
      { path: "/login", element: <Login /> },
      { path: "/mypage", element: <MyPage /> },
    ],
  },
  { path: "*", element: <NotFound /> },
]);

function MyRouterProvider() {
  return <RouterProvider router={router} />;
}

export default MyRouterProvider;

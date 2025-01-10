import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { Layout } from "../browserRouter/LayoutBrowserRouter";
import Home from "../Home";
import About from "../About";
import { Profiles } from "../browserRouter/SubRoute";
import { Profile } from "../browserRouter/Parameter";
import Login from "../Login";
import MyPage from "../MyPage";
import { NotFound } from "../browserRouter/NotFoundBrowserRouter";

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

import { createBrowserRouter, RouterProvider } from "react-router-dom";
import RestLayout from "./RestLayout";
import Home from "../Home";
import About from "../About";
import { Profiles } from "../BrowserRouter/SubRoute";
import { Profile } from "../BrowserRouter/Parameter";
import Login from "../Login";
import MyPage from "../MyPage";
import DogSearch from "../RestAPIApp/DogSearch";
import { NotFound } from "../BrowserRouter/NotFoundBrowserRouter";

const router = createBrowserRouter([
  {
    path: "/",
    element: <RestLayout />,
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
      { path: "/dogsearch", element: <DogSearch /> },
    ],
  },
  { path: "*", element: <NotFound /> },
]);

function MyRestAPIRouterProvider() {
  return <RouterProvider router={router} />;
}

export default MyRestAPIRouterProvider;

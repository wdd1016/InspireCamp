import { createBrowserRouter, RouterProvider } from "react-router-dom";
import MovieLayout from "./MovieLayout";
import Home from "../Home";
import About from "../About";
import { Profiles } from "../BrowserRouter/SubRoute";
import { Profile } from "../BrowserRouter/Parameter";
import Login from "../Login";
import MyPage from "../MyPage";
import { NotFound } from "../BrowserRouter/NotFoundBrowserRouter";
import MovieList from "./MovieList";
import MovieDetail from "./MovieDetail";

const router = createBrowserRouter([
  {
    path: "/",
    element: <MovieLayout />,
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
      { path: "/movieList", element: <MovieList /> },
      { path: "/movieDetail/:movieid", element: <MovieDetail /> },
    ],
  },
  { path: "*", element: <NotFound /> },
]);

function MovieRouterProvider() {
  return <RouterProvider router={router} />;
}

export default MovieRouterProvider;

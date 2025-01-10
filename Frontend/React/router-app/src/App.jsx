import MyBrowserRouter from "./BrowserRouter/MyBrowserRouter";
import { Parameter } from "./BrowserRouter/Parameter";
import QueryString from "./BrowserRouter/QueryString";
import { SubRoute } from "./BrowserRouter/SubRoute";
import { LayoutBrowserRouter } from "./BrowserRouter/LayoutBrowserRouter";
import UseNavigateBrowserRouter from "./BrowserRouter/UseNavigateBrowserRouter";
import { NavLinkBrowserRouter } from "./BrowserRouter/NavLinkBrowserRouter";
import { NotFoundBrowserRouter } from "./BrowserRouter/NotFoundBrowserRouter";
import { NavigateBrowserRouter } from "./BrowserRouter/NavigateBrowserRouter";
import MyRouterProvider from "./RouterProvider/MyRouterProvider";
import MovieRouterProvider from "./MovieApp/MovieRouterProvider";

function App() {
  return (
    <>
      {/* BrowserRouter */}
      {/* <MyBrowserRouter /> */}
      {/* <Parameter /> */}
      {/* <QueryString /> */}
      {/* <SubRoute /> */}
      {/* <LayoutBrowserRouter /> */}
      {/* <UseNavigateBrowserRouter /> */}
      {/* <NavLinkBrowserRouter /> */}
      {/* <NotFoundBrowserRouter /> */}
      {/* <NavigateBrowserRouter /> */}

      {/* RouterProvider */}
      {/* <MyRouterProvider /> */}

      {/* MovieApp */}
      <MovieRouterProvider />
    </>
  );
}

export default App;

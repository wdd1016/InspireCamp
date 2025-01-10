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
import MyRestAPIRouterProvider from "./RestAPIApp/MyRestAPIRouterProvider";

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
      {/* <MovieRouterProvider /> */}

      {/* RestAPI */}
      <MyRestAPIRouterProvider />
    </>
  );
}

export default App;

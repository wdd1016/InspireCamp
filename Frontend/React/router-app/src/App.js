import MyBrowserRouter from "./browserRouter/MyBrowserRouter";
import { Parameter } from "./browserRouter/Parameter";
import QueryString from "./browserRouter/QueryString";
import { SubRoute } from "./browserRouter/SubRoute";
import { LayoutBrowserRouter } from "./browserRouter/LayoutBrowserRouter";
import UseNavigateBrowserRouter from "./browserRouter/UseNavigateBrowserRouter";
import { NavLinkBrowserRouter } from "./browserRouter/NavLinkBrowserRouter";
import { NotFoundBrowserRouter } from "./browserRouter/NotFoundBrowserRouter";
import NavigateBrowserRouter from "./browserRouter/NavigateBrowserRouter";

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
      <NavigateBrowserRouter />
    </>
  );
}

export default App;

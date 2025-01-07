import MyBrowserRouter from "./browserRouter/MyBrowserRouter";
import { Parameter } from "./browserRouter/Parameter";
import QueryString from "./browserRouter/QueryString";
import { SubRoute } from "./browserRouter/SubRoute";
import { CommonLayout } from "./browserRouter/CommonLayout";
import UseNavigateHook from "./browserRouter/UseNavigateHook";
import { NavLinkComponent } from "./browserRouter/NavLinkComponent";
import { NotFound } from "./browserRouter/NotFound";
import NavigateComponent from "./browserRouter/NavigateComponent";

function App() {
  return (
    <>
      {/* <MyBrowserRouter /> */}
      {/* <Parameter /> */}
      {/* <QueryString /> */}
      {/* <SubRoute /> */}
      {/* <CommonLayout /> */}
      {/* <UseNavigateHook /> */}
      {/* <NavLinkComponent /> */}
      {/* <NotFound /> */}
      <NavigateComponent />
    </>
  );
}

export default App;

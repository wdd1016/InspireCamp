import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "../Home";
import About from "../About";
import { NavLinkLayout } from "./NavLinkBrowserRouter";
import { Profile } from "./Parameter";
import { Profiles } from "./SubRoute";
import "./LayoutBrowserRouter.css";

function NotFound() {
  return (
    <div
      style={{
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        fontSize: 64,
        position: "absolute",
        width: "100%",
        height: "100%",
      }}
    >
      404 Not Found
    </div>
  );
}

function NotFoundBrowserRouter() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<NavLinkLayout />}>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/info" element={<About />} />
          <Route path="/profiles" element={<Profiles />}>
            <Route path=":userid" element={<Profile />} />
          </Route>
        </Route>
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}

export { NotFound, NotFoundBrowserRouter };

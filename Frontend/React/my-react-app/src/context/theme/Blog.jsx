import { useContext } from "react";
import ThemeContext from "./ThemeContext";

const Blog = () => {
  // #3 Context 소비
  const { theme } = useContext(ThemeContext);

  return (
    <div
      style={{
        backgroundColor: theme === "light" ? "#fff" : "#333",
        color: theme === "light" ? "#000" : "#fff",
      }}
    >
      <h1>블로그</h1>
      <hr />
      <h2>블로그 제목</h2>
      <p>블로그 내용</p>
    </div>
  );
};

export default Blog;

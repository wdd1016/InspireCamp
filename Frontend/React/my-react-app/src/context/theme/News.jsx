import { useContext } from "react";
import ThemeContext from "./ThemeContext";

const News = () => {
  const { theme } = useContext(ThemeContext);

  return (
    <div
      style={{
        backgroundColor: theme === "light" ? "#fff" : "#333",
        color: theme === "light" ? "#000" : "#fff",
      }}
    >
      <h1>뉴스</h1>
      <hr />
      <h2>뉴스 제목</h2>
      <p>뉴스 내용</p>
    </div>
  );
};
export default News;

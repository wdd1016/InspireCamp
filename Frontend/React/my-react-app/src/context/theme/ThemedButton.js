import { useContext } from "react";
import ThemeContext from "./ThemeContext";

const ThemedButton = () => {
  // #3 Context 소비
  const { theme, changeTheme } = useContext(ThemeContext);

  return (
    <button
      onClick={changeTheme}
      style={{
        backgroundColor: theme === "light" ? "#fff" : "#333",
        color: theme === "light" ? "#000" : "yellow",
      }}
    >
      테마 변경
    </button>
  );
};

export default ThemedButton;

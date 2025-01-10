import ThemeProvider from "./ThemeProvider";
import ThemedButton from "./ThemedButton";
import Contents from "./Contents";
import ThemeContext from "./ThemeContext";
import { useState } from "react";

export default function Theme() {
  return (
    <>
      <ThemeProvider>
        <div>
          <h1>테마가 적용된 페이지</h1>
          <ThemedButton />
          <Contents />
        </div>
      </ThemeProvider>
    </>
  );
}

/*
export default function Theme() {
  const [theme, setTheme] = useState("light");
  const changeTheme = () => setTheme(theme === "light" ? "dark" : "light");

  return (
    <>
      <ThemeContext.Provider value={{ theme, changeTheme }}>
        <div>
          <h1>테마가 적용된 페이지</h1>
          <ThemedButton />
          <Contents />
        </div>
      </ThemeContext.Provider>
    </>
  );
}
*/

/*
// #1 Context 생성
const ThemeContext = createContext();

// #2-1 Provider 정의 
const ThemeProvider = ({ children }) => {
  const [theme, setTheme] = useState("light");
  const changeTheme = () => setTheme(theme === "light" ? "dark" : "light");

  return (
    <ThemeContext.Provider value={{ theme, changeTheme }}>
      {children}
    </ThemeContext.Provider>
  );
}

// const ThemedButton = ({ theme, changeTheme }) => {
const ThemedButton = () => {
  // #3 Context 소비
  const { theme, changeTheme } = useContext(ThemeContext);

  return (
    <button onClick={changeTheme}
      style={{
        backgroundColor: theme === "light" ? "#fff" : "#333",
        color: theme === "light" ? "#000" : "yellow"
      }}>테마 변경</button>
  );
};

// const Blog = ({ theme }) => {
const Blog = () => {
  // #3 Context 소비
  const { theme } = useContext(ThemeContext);

  return (
    <div style={{
      backgroundColor: theme === "light" ? "#fff" : "#333",
      color: theme === "light" ? "#000" : "#fff"
    }}>
      <h1>블로그</h1>
      <hr />
      <h2>블로그 제목</h2>
      <p>블로그 내용</p>
    </div>
  );
};

// const News = ({ theme }) => {
const News = () => {
  // #3 Context 소비
  const { theme } = useContext(ThemeContext);

  return (
    <div style={{
      backgroundColor: theme === "light" ? "#fff" : "#333",
      color: theme === "light" ? "#000" : "#fff"
    }}>
      <h1>뉴스</h1>
      <hr />
      <h2>뉴스 제목</h2>
      <p>뉴스 내용</p>
    </div>
  );
};

// 하위 컴포넌트로 전달을 위한 props 변수 생성(정의)하지 않아도 됨
// const Contents = ({ theme }) => {
//   return (
//     <>
//       <Blog theme={theme} />
//       <News theme={theme} />
//     </>
//   );
// };

const Contents = () => {
  return (
    <>
      <Blog />
      <News />
    </>
  );
};


// 2-2. 컨텍스트 변수를 공유할 컴포넌트를 Provider를 둘러쌈
export default function Theme() {
  // Provider에서 정의
  // const [theme, setTheme] = useState("light");
  // const changeTheme = () => setTheme(theme === "light" ? "dark" : "light");
  
  //  ThemeProvider로 감싸고, props 변수를 삭제 
  return (
    <ThemeProvider>
      <div>
        <h1>테마가 적용된 페이지</h1>
        <ThemedButton />
        <Contents />
      </div>
    </ThemeProvider>
  );
}
*/

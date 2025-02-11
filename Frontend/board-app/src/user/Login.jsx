import axios from "axios";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [redirect, setRedirect] = useState(null); // 리다이렉트할 경로를 저장할 상태

  const changeUsername = (e) => setUsername(e.target.value);
  const changePassword = (e) => setPassword(e.target.value);

  const navigate = useNavigate();

  // redirect 상태가 변경되면 navigate() 호출 (렌더링 이후에 실행됨)
  useEffect(() => {
    if (redirect) {
      navigate(redirect);
    }
  }, [redirect, navigate]);

  const handleSubmit = (e) => {
    e.preventDefault();

    axios({
      method: "POST",
      url: "http://localhost:8080/loginProc",
      data: { username, password },
      headers: { "Content-Type": "application/json" },
    })
      .then((res) => {
        console.log("로그인 성공:", res.data);
        // JWT 토큰을 Session Storage에 저장
        sessionStorage.setItem("token", res.data);
        setRedirect("/list"); // 성공시 list 페이지로 리다이렉트
      })
      .catch((err) => {
        console.error("로그인 실패:", err);
        alert(err.response.data.error);
        setUsername(""); // 아이디 초기화
        setPassword(""); // 비밀번호 초기화
      });
  };

  return (
    <>
      <h1>로그인 페이지</h1>

      <form onSubmit={handleSubmit}>
        Username:{" "}
        <input type="text" value={username} onChange={changeUsername} />
        <br />
        Password:{" "}
        <input type="text" value={password} onChange={changePassword} />
        <br />
        <button type="submit">로그인</button>
      </form>
    </>
  );
}

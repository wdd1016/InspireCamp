import { useState } from "react";

function EventPracticeFunction() {
  /*
  const [message, setMessage] = useState("");
  const [username, setUsername] = useState("");

  const handlerChangeMessage = (e) => {
    setMessage(e.target.value);
  };

  const handlerChangeUsername = (e) => {
    setUsername(e.target.value);
  };
  */

  const [form, setForm] = useState({ message: "", username: "", email: "" });
  const { message, username, email } = form; // 객체 비구조화(구조분해 할당)를 통해 값 추출

  const handlerChange = (e) => {
    /*
    if (e.target.name === "message") {
      setMessage(e.target.value);
    } else if (e.target.name === "username") {
      setUsername(e.target.value);
    }
    */
    const newForm = { ...form, [e.target.name]: e.target.value }; // 기존 form 내용을 복사(Deep copy)한 뒤, 원하는 값을 덮어 씌우기
    setForm(newForm); // setter 함수를 통해 form 값 업데이트
  };

  const handlerClick = () => {
    /*
    setMessage("");
    setUsername("");
    */
    const newForm = { message: "", username: "", email: "" };
    setForm(newForm);
  };

  const handlerKeyUp = (e) => {
    if (e.key === "Enter") {
      handlerClick();
    }
  };

  return (
    <div>
      <h1>이벤트 연습</h1>
      <input
        type="text"
        name="message"
        placeholder="입력해 보세요."
        value={message}
        onChange={handlerChange}
        onKeyUp={handlerKeyUp}
      />
      <input
        type="text"
        name="username"
        placeholder="입력해 보세요."
        value={username}
        onChange={handlerChange}
      />
      <input
        type="email"
        name="email"
        placeholder="이메일을 입력하세요."
        value={email}
        onChange={handlerChange}
      />
      <h2>message: {message}</h2>
      <h2>username: {username}</h2>
      <h2>email: {email}</h2>
      <button onClick={handlerClick}>삭제</button>
    </div>
  );
}

export default EventPracticeFunction;

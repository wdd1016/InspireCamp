import { useState } from "react";

function Form() {
  const [count, setCount] = useState(0);

  const handleSubmit = (e) => {
    // form 태크의 기본 동작이 처리되지 않도록 설정, 서버로 요청이 전달되지 않도록 처리
    e.preventDefault();
    console.log("Submitted");

    // 자바스크립트 코드를 이용해서 서버로 값을 전달하고, 전달받은 값을 사용하는 기능을 구현
  };

  return (
    <>
      <h1>{count}</h1>
      <button onClick={() => setCount(count + 1)}>Increase</button>
      <form onSubmit={handleSubmit}>
        <button type="submit">Submit</button>
      </form>
    </>
  );
}

export default Form;

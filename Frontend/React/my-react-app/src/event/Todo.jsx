import { useState } from "react";

function Title(props) {
  return (
    <>
      <p>현재 카운트는 {props.title}입니다.</p>
    </>
  );
}

function Todo() {
  const [count, setCount] = useState(0);

  return (
    <>
      <Title title={count}></Title>
      <button onClick={() => setCount(count + 1)}>증가</button>
    </>
  );
}

export default Todo;

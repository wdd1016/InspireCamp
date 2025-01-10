import { useEffect, useRef, useState } from "react";

const ChangeCountWithLocalVariable = () => {
  const [message, setMessage] = useState("");
  let count = 0;

  console.log("#1", { message, count });

  // 의존성 배열을 정의하지 않았기 때문에 마운트될 때와 업데이트될 때 이펙트 함수가 실행
  useEffect(() => {
    console.log("렌더링되었습니다.");
    count++;
  });

  return (
    <>
      <h1>지역변수를 사용하는 경우</h1>
      <h2>렌더링 횟수: {count}</h2>
      <input
        type="text"
        value={message}
        onChange={(e) => setMessage(e.target.value)}
      />
    </>
  );
};

const ChangeCountWithStateVariable = () => {
  const [message, setMessage] = useState("");
  const [count, setCount] = useState(0);

  console.log("#2", { message, count });

  // 의존성 배열을 정의하지 않았기 때문에 마운트될 때와 업데이트될 때 이펙트 함수가 실행
  useEffect(() => {
    console.log("렌더링되었습니다.");
    setCount(count + 1);
  });

  return (
    <>
      <h1>useState를 사용하는 경우</h1>
      <h2>렌더링 횟수: {count}</h2>
      <input
        type="text"
        value={message}
        onChange={(e) => setMessage(e.target.value)}
      />
    </>
  );
};

const ChangeCountWithRefVariable = () => {
  const [message, setMessage] = useState("");
  const count = useRef(0);

  console.log("#3", { message, count: count.current });

  // 의존성 배열을 정의하지 않았기 때문에 마운트될 때와 업데이트될 때 이펙트 함수가 실행
  useEffect(() => {
    console.log("렌더링되었습니다.");
    count.current++;
  });

  return (
    <>
      <h1>Ref를 사용하는 경우</h1>
      <h2>렌더링 횟수: {count.current}</h2>
      <input
        type="text"
        value={message}
        onChange={(e) => setMessage(e.target.value)}
      />
    </>
  );
};

function ChangeCountWithVariable() {
  return (
    <>
      <h2>지역변수를 사용하는 경우</h2>
      <ChangeCountWithLocalVariable />

      <h2>useState를 사용하는 경우</h2>
      <ChangeCountWithStateVariable />

      <h2>Ref를 사용하는 경우</h2>
      <ChangeCountWithRefVariable />
    </>
  );
}

export default ChangeCountWithVariable;

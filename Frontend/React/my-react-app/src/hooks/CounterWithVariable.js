import { useEffect, useRef, useState } from "react";

const CounterWithLocalVariable = () => {
  const [count, setCount] = useState(0);

  let intervalId = 0;
  console.log(`렌더링... count: ${count} intervalId: ${intervalId}`);

  const startCounter = () => {
    intervalId = setInterval(() => {
      setCount((count) => count + 1);
    }, 1000);
    console.log(`카운터 시작... intervalId: ${intervalId}`);
  };

  const stopCounter = () => {
    clearInterval(intervalId);
    console.log(`카운터 정지... intervalId: ${intervalId}`);
  };

  return (
    <>
      <p>카운트: {count}</p>
      <button onClick={startCounter}>카운트 시작</button>
      <button onClick={stopCounter}>정지</button>
    </>
  );
};

const CounterWithStateVariable = () => {
  const [count, setCount] = useState(0);
  const [intervalId, setIntervalId] = useState(0);

  console.log(`렌더링... count: ${count} intervalId: ${intervalId}`);

  const startCounter = () => {
    const id = setInterval(() => {
      setCount((count) => count + 1);
    }, 1000);
    setIntervalId(id);
    console.log(`카운터 시작... intervalId: ${intervalId}`);
  };

  const stopCounter = () => {
    clearInterval(intervalId);
    console.log(`카운터 정지... intervalId: ${intervalId}`);
  };

  return (
    <>
      <p>카운트: {count}</p>
      <button onClick={startCounter}>카운트 시작</button>
      <button onClick={stopCounter}>정지</button>
    </>
  );
};

const CounterWithRefVariable = () => {
  const [count, setCount] = useState(0);
  const intervalId = useRef(0);

  console.log(`렌더링... count: ${count} intervalId: ${intervalId.current}`);

  const startCounter = () => {
    intervalId.current = setInterval(() => {
      setCount((count) => count + 1);
    }, 1000);
    console.log(`카운터 시작... intervalId: ${intervalId.current}`);
  };

  const stopCounter = () => {
    clearInterval(intervalId.current);
    console.log(`카운터 정지... intervalId: ${intervalId.current}`);
  };

  return (
    <>
      <p>카운트: {count}</p>
      <button onClick={startCounter}>카운트 시작</button>
      <button onClick={stopCounter}>정지</button>
    </>
  );
};

function CounterWithVariable() {
  return (
    <>
      <h2>지역변수를 사용하는 경우</h2>
      <CounterWithLocalVariable />

      <h2>useState를 사용하는 경우</h2>
      <CounterWithStateVariable />

      <h2>useRef를 사용하는 경우</h2>
      <CounterWithRefVariable />
    </>
  );
}

export default CounterWithVariable;

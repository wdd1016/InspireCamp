import { useState } from "react";

function Child({ increment }) {
  return <button onClick={increment}>하나증가</button>;
}

function Hoisting() {
  const [count, setCount] = useState(0);
  const increment = () => setCount(count + 1);

  return (
    <>
      <h1>{count}</h1>
      <Child increment={increment} />
    </>
  );
}

export default Hoisting;

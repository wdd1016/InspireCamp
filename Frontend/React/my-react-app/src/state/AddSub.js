import { useState } from "react";

function Child({ plusOne, subCount }) {
  return (
    <>
      <button onClick={plusOne}>+1</button>
      <button onClick={subCount}>-1</button>
    </>
  );
}

function AddSub() {
  const [count, setCount] = useState(0);
  const resetCount = () => setCount(0);
  const addCount = () => setCount(count + 1);
  const subCount = () => setCount(count - 1);

  return (
    <>
      <div>{count}</div>
      <button onClick={resetCount}>Reset</button>
      <Child plusOne={addCount} subCount={subCount} />
    </>
  );
}

export default AddSub;

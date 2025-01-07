import { useState } from "react";

function Controller({ plusOne, minusOne }) {
  return (
    <>
      <button onClick={plusOne}>+1</button>
      <button onClick={minusOne}>-1</button>
    </>
  );
}

function Display({ count }) {
  return <h1>{count}</h1>;
}

function StateController() {
  const [count, setCount] = useState(0);
  const reset = () => setCount(0);
  const plusOne = () => setCount(count + 1);
  const minusOne = () => setCount(count - 1);

  return (
    <>
      <button onClick={reset}>Reset</button>
      <Controller plusOne={plusOne} minusOne={minusOne} />
      <Display count={count} />
    </>
  );
}

export default StateController;

import { useState } from "react";

function ChildA(props) {
  return <p>{props.count * 2}</p>;
}

function ChildB({ value }) {
  return <p>{value * 3}</p>;
}

function Drilling() {
  const [count, setCount] = useState(0);

  return (
    <>
      <input
        type="number"
        value={count}
        onChange={(e) => setCount(e.target.value)}
      />
      <ChildA count={count} />
      <ChildB value={count} />
    </>
  );
}

export default Drilling;

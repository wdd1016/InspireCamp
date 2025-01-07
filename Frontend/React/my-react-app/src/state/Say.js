import { useState } from "react";

function Say() {
  const [message, setMessage] = useState("");
  const [color, setColor] = useState("black");

  return (
    <>
      <h1 style={{ color }}>{message}</h1>
      <button onClick={() => setMessage("입장합니다.")}>입장</button>
      <button onClick={() => setMessage("퇴장합니다.")}>퇴장</button>
      <button onClick={() => setColor("red")}>빨간색</button>
      <button onClick={() => setColor("blue")}>파란색</button>
      <button onClick={() => setColor("yellow")}>노란색</button>
    </>
  );
}

export default Say;

import { useState } from "react";

function MyButton() {
  const [isClicked, setIsClicked] = useState(false);

  return (
    <button onClick={() => setIsClicked(!isClicked)}>
      {isClicked ? "클릭되었습니다." : "클릭해 주세요."}
    </button>
  );
}

export default MyButton;

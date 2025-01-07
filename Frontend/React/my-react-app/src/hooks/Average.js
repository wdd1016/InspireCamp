import React, { useRef, useState } from "react";

export default function Average() {
  const [number, setNumber] = useState("");
  const [list, setList] = useState([]);

  const changeNumber = (e) => {
    setNumber(e.target.value);
  };
  const changeList = () => {
    setList([...list, number]);
    // setList(list.concat(number));

    setNumber("");
    refNumber.current.focus();
  };

  // const refNumber = React.createRef();
  const refNumber = useRef();

  return (
    <>
      <div>
        <input
          ref={refNumber}
          type="number"
          value={number}
          onChange={changeNumber}
        />
        <button onClick={changeList}>등록</button>
      </div>
      <div>
        <p>입력값 : {number}</p>
      </div>
      <div>
        등록된 숫자
        <ul>
          {list.map((value, index) => (
            <li key={index}>{value}</li>
          ))}
        </ul>
      </div>
    </>
  );
}

import { useState, useReducer } from "react";

const InfoWithState = () => {
  const [name, setName] = useState("");
  const [nickName, setNickName] = useState("");

  const changeName = (e) => setName(e.target.value);
  const changeNickName = (e) => setNickName(e.target.value);

  return (
    <>
      <div>
        <p>이름: {name}</p>
        <p>별명: {nickName}</p>
      </div>
      <div>
        <p>
          이름: <input type="text" value={name} onChange={changeName} />
        </p>
        <p>
          별명: <input type="text" value={nickName} onChange={changeNickName} />
        </p>
      </div>
    </>
  );
};

// action = { type: 변경할 상태변수, name: 변경할 값 }
// dispatch(action) 함수를 호출 할 때 action 값을 설정해서 전달
const reducer = (state, action) => {
  return { ...state, [action.type]: action.value };
};

const InfoWithReducer = () => {
  const [state, dispatch] = useReducer(reducer, { name: "", nickName: "" });
  const { name, nickName } = state;
  const changeValue = (e) => {
    dispatch({ type: e.target.name, value: e.target.value });
  };

  return (
    <>
      <div>
        <p>이름: {name}</p>
        <p>별명: {nickName}</p>
      </div>
      <div>
        <p>
          이름:{" "}
          <input type="text" name="name" value={name} onChange={changeValue} />
        </p>
        <p>
          별명:{" "}
          <input
            type="text"
            name="nickName"
            value={nickName}
            onChange={changeValue}
          />
        </p>
      </div>
    </>
  );
};

export default function ReducerForInfo() {
  return (
    <>
      <h2>useState Infomation</h2>
      <InfoWithState />
      <br />
      <h2>useReducer Infomation</h2>
      <InfoWithReducer />
    </>
  );
}

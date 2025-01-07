import { useReducer, useState } from "react";

function reducer(state, action) {
  return {
    ...state,
    [action.name]: action.value,
  };
}

function useInputs(initState) {
  const [state, dispatch] = useReducer(reducer, initState);
  const handlerChange = (e) => {
    dispatch(e.target);
  };
  return [state, handlerChange];
}

function CustomHook() {
  /*
  const [state, dispatch] = useReducer(reducer, { name: "", nickname: "" });
  const { name, nickname } = state;
  const handlerChange = (e) => {
    dispatch(e.target);
  };
  */

  const [state, handlerChange] = useInputs({ name: "", nickname: "" });
  const { name, nickname } = state;

  return (
    <>
      <div>
        <p>이름: {name}</p>
        <p>별명: {nickname}</p>
      </div>
      <div>
        <p>
          이름:{" "}
          <input
            type="text"
            value={name}
            name="name"
            onChange={handlerChange}
          />
        </p>
        <p>
          별명:{" "}
          <input
            type="text"
            value={nickname}
            name="nickname"
            onChange={handlerChange}
          />
        </p>
      </div>
    </>
  );
}

export default CustomHook;

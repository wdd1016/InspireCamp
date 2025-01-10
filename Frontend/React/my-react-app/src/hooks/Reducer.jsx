import { useReducer, useState } from "react";

const StateCounter = () => {
  const [count, setCount] = useState(0);

  // 버튼의 내용(contents)이 숫자로 변환 가능하기 때문에 하나의 핸들러 함수로 구현이 가능
  // const changeCount = (e) => setCount(count + Number(e.target.innerText));

  // 버튼의 내용(contents)이 숫자로 변환 불가능하기 때문에 각각의 핸들러 함수로 구현
  const changeCountPlus = () => setCount(count + 1);
  const changeCountMinus = () => setCount(count - 1);

  return (
    <>
      <div>
        현재 카운터 값은 <b>{count}</b>입니다.
      </div>
      <div>
        <button onClick={changeCountPlus}>하나 더하기</button>
        <button onClick={changeCountMinus}>하나 빼기</button>
      </div>
    </>
  );
};

// state: 현재 상태 변수의 값
// action: 상태 변수 변경에 필요한 조건과 값
function reducer(state, action) {
  switch (action.type) {
    case "INCREMENT":
      return { count: state.count + 1 };
    case "DECREMENT":
      return { count: state.count - 1 };
    default:
      return state;
  }
}

const ReducerCounter = () => {
  const [state, dispatch] = useReducer(reducer, { count: 0 });

  return (
    <>
      <div>
        현재 카운터 값은 <b>{state.count}</b>입니다.
      </div>
      <div>
        <button onClick={() => dispatch({ type: "INCREMENT" })}>
          하나 더하기
        </button>
        <button onClick={() => dispatch({ type: "DECREMENT" })}>
          하나 빼기
        </button>
      </div>
    </>
  );
};

function Reducer() {
  return (
    <>
      <h2>useState Counter</h2>
      <StateCounter />
      <br />

      <h2>useReducer Counter</h2>
      <ReducerCounter />
    </>
  );
}

export default Reducer;

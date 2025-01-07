import { useState, createContext, useContext, useReducer } from "react";

// #1 컨택스트 생성
const CounterContext = createContext();

const reducer = (state, action) => {
  switch (action.type) {
    case "reset":
      return { count: 0 };
    case "plusone":
      return { count: state.count + 1 };
    case "minusone":
      return { count: state.count - 1 };
    default:
      return state;
  }
};

// #2 Provider 생성
const CounterProvider = ({ children }) => {
  /*
  const [count, setCount] = useState(0);
  const reset = () => setCount(0);
  const plusOne = () => setCount(count + 1);
  const minusOne = () => setCount(count - 1);
  */

  const [state, dispatch] = useReducer(reducer, { count: 0 });

  return (
    // <CounterContext.Provider value={{ count, reset, plusOne, minusOne }}>
    <CounterContext.Provider
      value={{
        count: state.count,
        reset: () => dispatch({ type: "reset" }),
        plusOne: () => dispatch({ type: "plusone" }),
        minusOne: () => dispatch({ type: "minusone" }),
      }}
    >
      {children}
    </CounterContext.Provider>
  );
};

// #2-1 Provider 적용
function ContextForDisplay() {
  return (
    <CounterProvider>
      <Parent />
    </CounterProvider>
  );
}

// #3 props 변수를 제거하고, useContext 훅을 이용해서 컨텍스트 변수를 가져와서 사용
function Controller() {
  const { plusOne, minusOne } = useContext(CounterContext);
  return (
    <>
      <button onClick={plusOne}> +1 </button>
      <button onClick={minusOne}> -1 </button>
    </>
  );
}

function Display() {
  const { count } = useContext(CounterContext);
  return <h1>{count}</h1>;
}

function Parent() {
  const { reset } = useContext(CounterContext);
  return (
    <>
      <button onClick={reset}>Reset</button>
      <Controller />
      <Display />
    </>
  );
}

export default ContextForDisplay;

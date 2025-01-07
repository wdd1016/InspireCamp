import { useState, createContext, useContext } from "react";

// #1 컨택스트 생성
const CounterContext = createContext();

// #2 Provider 생성
function CounterProvider({ children }) {
  const [count, setCount] = useState(0);
  const addCount = () => setCount(count + 1);
  const subCount = () => setCount(count - 1);
  const resetCount = () => setCount(0);

  return (
    <CounterContext.Provider value={{ count, addCount, subCount, resetCount }}>
      {children}
    </CounterContext.Provider>
  );
}

// #2-1 Provider 적용
function ContextForCounter() {
  return (
    <CounterProvider>
      <Parent />
    </CounterProvider>
  );
}

// #3 props 변수로 전달하는 or 전달받는 코드를 삭제하고,
// useContext() 훅을 이용하여 필요한 컨텍스트 변수를 추출해서 사용
function Parent() {
  const { count, resetCount } = useContext(CounterContext);

  return (
    <>
      <div>{count}</div>
      <button onClick={resetCount}>Reset</button>
      <Child />
    </>
  );
}

function Child() {
  const { addCount: plusOne, subCount } = useContext(CounterContext);
  return (
    <>
      <button onClick={plusOne}>+1</button>
      <button onClick={subCount}>-1</button>
    </>
  );
}

export default ContextForCounter;

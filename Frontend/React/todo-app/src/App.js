import "./App.css";
import TodoTemplate from "./Components/TodoTemplate";
import TodoInsert from "./Components/TodoInsert";
import TodoList from "./Components/TodoList";
import { useRef, useState, createContext } from "react";
import TodoProvider from "./Context/TodoProvider";

/*
function App() {
  const [todos, setTodos] = useState([
    { id: 1, checked: true, text: "자바스크립트 공부하기" },
    { id: 2, checked: false, text: "리액트 공부하기" },
    { id: 3, checked: false, text: "할 일 목록 앱 만들기" },
  ]);

  const nextId = useRef(4);

  const insertTodo = (text) => {
    const newTodos = todos.concat({ id: nextId.current, checked: false, text });
    setTodos(newTodos);
    nextId.current++;
  };

  const removeTodo = (id) => {
    const newTodos = todos.filter((todo) => todo.id !== id);
    setTodos(newTodos);
  };

  // 배열로 상태를 가지고 있을때, 특정 객체의 특정 값을 바꾸는 방법
  const toggleTodo = (id) => {
    const newTodos = todos.map((todo) =>
      todo.id === id ? { ...todo, checked: !todo.checked } : todo
    );
    setTodos(newTodos);
  };

  return (
    <TodoTemplate>
      <TodoInsert insertTodo={insertTodo} />
      <TodoList todos={todos} removeTodo={removeTodo} toggleTodo={toggleTodo} />
    </TodoTemplate>
  );
}
*/

function App() {
  return (
    <TodoProvider>
      <TodoTemplate>
        <TodoInsert />
        <TodoList />
      </TodoTemplate>
    </TodoProvider>
  );
}

export default App;

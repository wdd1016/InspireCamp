import "./TodoList.css";
import TodoListItem from "./TodoListItem";
import { useContext } from "react";
import TodoContext from "../Context/TodoContext";

// { todos, removeTodo, toggleTodo } props -> { todos } context
export default function TodoList() {
  const { todos } = useContext(TodoContext);

  return (
    <div className="TodoList">
      {todos.map((todo) => (
        <TodoListItem key={todo.id} todo={todo} />
      ))}
    </div>
  );
}

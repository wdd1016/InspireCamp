import "./TodoInsert.css";
import { MdAdd } from "react-icons/md";
// https://react-icons.github.io/react-icons/icons/md/
import { useState, useContext } from "react";
import TodoContext from "../Context/TodoContext";

// { insertTodo } props -> { insertTodo } context
const TodoInsert = () => {
  const { insertTodo } = useContext(TodoContext);

  const [value, setValue] = useState("");

  const changeValue = (e) => {
    setValue(e.target.value);
  };

  // form의 submit은 onSubmit 이벤트로 처리 (기본 동작 방지 필수)
  const onSubmit = (e) => {
    e.preventDefault();
    insertTodo(value);
    setValue("");
  };

  return (
    <>
      <form className="TodoInsert" onSubmit={onSubmit}>
        <input
          type="text"
          placeholder="할 일을 입력하세요."
          value={value}
          onChange={changeValue}
        />
        <button type="submit">
          <MdAdd />
        </button>
      </form>
    </>
  );
};

export default TodoInsert;

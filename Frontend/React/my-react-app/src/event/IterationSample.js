import { useState } from "react";

const IterationSample = () => {
  // const words = ["봄", "여름", "가을", "겨울"];
  // const wordsList = words.map((word, index) => <li key={index}>{word}</li>);

  // 목록 데이터를 관리하는 상태변수
  const [words, setWords] = useState([
    { id: 1, word: "봄" },
    { id: 2, word: "여름" },
    { id: 3, word: "가을" },
    { id: 4, word: "겨울" },
  ]);
  const wordsList = words.map((item) => (
    <li key={item.id} onDoubleClick={() => handleDoubleClick(item.id)}>
      {item.word}
    </li>
  ));

  // 입력창 내용을 관리하는 상태변수
  const [inputText, setInputText] = useState("");

  // id를 관리하는 상태변수
  const [nextId, setNextId] = useState(5);

  // 이벤트 핸들러
  const handleChange = (e) => setInputText(e.target.value);
  const handleAddItem = () => {
    // const newWords = [...words, { id: nextId, word: inputText }];
    const newWords = words.concat({ id: nextId, word: inputText });
    setWords(newWords);

    setNextId(nextId + 1);
    setInputText("");
  };

  const handleDoubleClick = (id) => {
    const newWords = words.filter((item) => id !== item.id);
    setWords(newWords);
  };

  return (
    <>
      <input type="text" value={inputText} onChange={handleChange} />
      <button onClick={handleAddItem}>추가</button>
      <ul>{wordsList}</ul>
    </>
  );
};

export default IterationSample;

// 속성 이름(key)과 속성 값(value)을 전달받아 객체를 반환하는 함수를 정의
function returnObject(key, value) {
  /*
  const obj = {};
  obj[key] = value;
  return obj;
  */
  return { [key]: value };
}
console.log(returnObject("name", "John")); // {name: "John"}

// 속성 이름이 일련번호 형태를 가지는 객체를 반환하는 함수
function returnObject2(key, value, no) {
  /*
  const obj = {};
  obj[key + no] = value;
  return obj;
  */
  return { [key + no]: value };
}
console.log(returnObject2("name", "John", 1)); // {name1: "John"}
console.log(returnObject2("name", "Jane", 2)); // {name2: "Jane"}

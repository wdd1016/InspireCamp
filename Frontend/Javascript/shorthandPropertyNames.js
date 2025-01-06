{
  let name = "John";
  const obj = {
    age: 21,
    name: name,
    getName: function getName() {
      return this.name;
    },
  };
  console.log(obj); // {age: 21, name: 'John', getName: ƒ}
  console.log(obj.getName()); // John

  const obj2 = {
    age: 21,
    name, // 속성 이름을 생략
    getName() {
      //
      return this.name;
    },
  };
  console.log(obj2); // {age: 21, name: 'John', getName: ƒ}
  console.log(obj2.getName()); // John
}

// 사용 예1
// 매개변수를 객체로 반환하는 함수를 정의하는 경우
function returnObject(age, name) {
  return { age: age, name: name };
}
console.log(returnObject(20, "홍길동")); // {age: 20, name: "홍길동"}

function returnObject2(age, name) {
  return { age, name };
}
console.log(returnObject2(20, "홍길동")); // {age: 20, name: "홍길동"}

// 사용 예2
// 로그를 출력할 때
// 변수가 가지고 있는 값을 로그로 출력 => 변수 이름과 함께 출력되어야 내용 파악이 용이
console.log("age", age); // age 20
console.log("name", name); // name 홍길동

console.log(`age: ${age}, name: ${name}`); // age: 20, name: 홍길동

console.log({ age, name }); // {age: 20, name: "홍길동"}

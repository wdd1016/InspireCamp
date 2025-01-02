{
  // 객체 선언
  let person = {
    name: "홍길동",
    age: 23,
    isMarraied: false,
    "favorite colors": ["red", "blue"],
    hello: function () {
      console.log(`안녕하세요, 나는 ${this.name}입니다.`);
    },
  };

  // 객체 항목을 참조 => 객체이름.키이름 또는 객체이름["키이름"]
  console.log(person.name);
  console.log(person["name"]);
  console.log(person["favorite colors"]);
  person.hello();

  // 객체 항목의 값을 변경
  person.name = "김철수";
  person.hello();

  // 객체 속성 추가
  person.email = "chulsu@test.com";
  person["address"] = "서울시 강남구";
  console.log(person);
}

{
  // 객체 선언
  let person = {
    name: "홍길동",
    age: 23,
    isMarraied: false,
    "favorite colors": ["red", "blue"],
    hello: function () {
      console.log(`안녕하세요, 나는 ${this.name}입니다.`);
    },
  };

  // 객체의 모든 항목을 가져와서 출력
  console.log("for-in 구문을 이용 => 객체의 키를 반환");
  for (let key in person) {
    console.log(key, person[key]);
  }

  // Uncaught TypeError: person is not iterable ⇐ for of 구문을 사용할 수 없음
  /*
for (let value of person) {
    console.log(value);
}
*/

  // 객체의 키를 배열로 만들어서 반환
  for (let key of Object.keys(person)) {
    console.log(key, person[key]);
  }

  // 함수 선언문 형식으로 콜백 함수를 정의
  function print(key, value) {
    console.log(key, value);
  }
  Object.keys(person).forEach((key) => print(key, person[key]));

  // 익명 함수 표현식 형식으로 콜백 함수를 직접 정의
  Object.keys(person).forEach(function (key) {
    console.log(key, person[key]);
  });

  // 화살표 함수 형식으로 콜백 함수를 직접 정의
  Object.keys(person).forEach((key) => {
    console.log(key, person[key]);
  });

  // 축약된 화살표 함수 형식으로 콜백 함수를 직접 정의
  Object.keys(person).forEach((key) => console.log(key, person[key]));
}

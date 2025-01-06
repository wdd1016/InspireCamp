{
  // 객체 비구조화를 할 때는 객체의 속성명(key)이 중요
  const obj1 = { age: 21, name: "홍길동" };
  const obj2 = { age: 43, name: "고길동" };

  // obj1의 age와 name 속성의 값을 age와 name 변수에 할당
  /*
let age = obj1.age;
let name = obj1.name;
*/
  let { age, name } = obj1; // 객체 비구조화 할당
  console.log({ age, name }); // { age: 21, name: '홍길동' } <= 단축 속성명을 이용해서 변수가 가지고 있는 값을 출력

  // obj1 객체가 가지고 있지 않은 이름을 이용
  let { newAge, newName } = obj1;
  console.log({ newAge, newName }); // {newAge: undefined, newName: undefined}
}

{
  const obj1 = { age: 21, name: "홍길동" };
  const obj2 = { age: 43, name: "고길동" };

  // obj1 객체가 가지고 있는 값을 가져와서 새로운 이름으로 사용
  let { age: newAge, name: newName } = obj1;
  console.log({ newAge, newName }); // { newAge: 21, newName: '홍길동' }
}

{
  const obj1 = { age: 21, name: "홍길동" };
  const obj2 = { age: 43, name: "고길동" };

  // 객체 존재하지 않는 요소를 변수에 할당하려고 하면 undefined가 할당됨
  let { age: newAge, name: newName, email } = obj1;
  console.log({ newAge, newName, email }); // { newAge: 21, newName: '홍길동', email: undefined }
}

{
  const obj1 = { age: 21, name: "홍길동" };
  const obj2 = { age: 43, name: "고길동" };

  // 객체 존재하지 않는 변수의 기본값 설정
  let { age: newAge, name: newName, email = "default" } = obj1;
  console.log({ newAge, newName, email }); // { newAge: 21, newName: '홍길동', email: 'default' }
}

{
  // 객체 비구조화를 할 때는 객체의 속성명(key)이 중요
  const obj1 = { age: 21, name: "홍길동", email: "hong@test.com" };

  // obj1 객체의 age 속성의 값을 hongAge 변수에 할당하고, 나머지 값을 rest 이름의 객체에 할당
  const { age: hongAge, ...rest } = obj1;
  console.log(hongAge); // 21
  console.log(rest); // { name: "홍길동", email: "hong@test.com" }
}

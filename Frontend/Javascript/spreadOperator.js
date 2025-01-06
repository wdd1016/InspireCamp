console.log(Math.max(10, 20, 1, 30, 3, 2)); // 30
console.log(Math.max([10, 20, 1, 30, 3, 2])); // NaN

const numbers = [10, 20, 1, 30, 3, 2];
console.log(Math.max(numbers)); // NaN
console.log(
  Math.max(
    numbers[0],
    numbers[1],
    numbers[2],
    numbers[3],
    numbers[4],
    numbers[5]
  )
); // 30
console.log(Math.max(...numbers)); // 30

console.log(...numbers); // 10 20 1 30 3 2

// 사용 예 1. 배열의 값을 복사
{
  let a = 10;
  let b = a;
  console.log(a); // 10
  console.log(b); // 10

  let arr1 = [1, 2, 3];
  let arr2 = arr1;
  console.log(arr1); // [1, 2, 3]
  console.log(arr2); // [1, 2, 3]

  a = 20;
  console.log(a); // 20
  console.log(b); // 10

  arr1[0] = 10;
  console.log(arr1); // [10, 2, 3]
  console.log(arr2); // [10, 2, 3]

  // 위의 문제(객체와 배열을 복사할 때 참조가 복사되는 문제)를 해결
  // 주소가 아닌 값을 복사하는 것이 필요

  let arr3 = [1, 2, 3];
  let arr4 = [];
  for (let i = 0; i < arr3.length; i++) {
    arr4[i] = arr3[i];
  }
  console.log(arr3); // [1, 2, 3]
  console.log(arr4); // [1, 2, 3]
  arr3[0] = 10;
  console.log(arr3); // [10, 2, 3]
  console.log(arr4); // [1, 2, 3]

  // 전개 연산자를 이용해서 배열의 값을 복사
  let arr5 = [1, 2, 3];
  let arr6 = [...arr5];
  console.log(arr5); // [1, 2, 3]
  console.log(arr6); // [1, 2, 3]
  arr5[0] = 10;
  console.log(arr5); // [10, 2, 3]
  console.log(arr6); // [1, 2, 3]
}

// 사용 예 2. 객체의 값 복사
{
  let obj1 = { age: 23, name: "홍길동" };
  let obj2 = obj1;
  console.log(obj1); // { age: 23, name: '홍길동' }
  console.log(obj2); // { age: 23, name: '홍길동' }
  obj1.age = 200;
  console.log(obj1); // { age: 200, name: '홍길동' }
  console.log(obj2); // { age: 200, name: '홍길동' }

  // 객체 값이 복사
  let obj3 = { age: 23, name: "홍길동" };
  let obj4 = { ...obj3 };
  console.log(obj3); // { age: 23, name: '홍길동' }
  console.log(obj4); // { age: 23, name: '홍길동' }
  obj3.age = 200;
  console.log(obj3); // { age: 200, name: '홍길동' }
  console.log(obj4); // { age: 23, name: '홍길동' }
}

// 사용 예 3. 객체를 복사하는 과정에서 새로운 속성을 추가하거나 속성의 값을 변경하는 경우
{
  let obj1 = { age: 23, name: "홍길동" };
  obj1.age = 40; // 객체의 속성값을 변경
  obj1.colors = ["red", "blue", "green"]; // 객체에 새로운 속성을 추가
  console.log(obj1); // { age: 40, name: '홍길동', colors: [ 'red', 'blue', 'green' ] }

  // obj1과 동일한 속성을 가지는 obj2를 정의하고, name 속성의 값을 고길동으로 변경
  /*
let obj2 = { ...obj1 };
obj2.name = '고길동';  
*/
  // 전개 연산자로 복사한 name 속성의 값을 덮어씀
  let obj2 = { ...obj1, name: "고길동" };
  console.log(obj2); // { age: 40, name: '고길동', colors: [ 'red', 'blue', 'green' ] }

  // obj1과 동일한 속성을 가지는 obj3를 정의하고, email 속성을 추가
  // 전개 연산자로 복사한 객체에 email 속성을 추가
  let obj3 = { ...obj1, email: "go@test.com" };
  console.log(obj3); // { age: 40, name: '홍길동', colors: [ 'red', 'blue', 'green' ], email: 'go@test.com' }
}

// 사용 예 4. 배열 또는 객체를 결합할 때
{
  // 두 배열을 결합
  const arr1 = [1, 2, 3];
  const arr2 = [3, 4, 5];
  const arr3 = [...arr1, ...arr2];
  console.log(arr3); // [ 1, 2, 3, 3, 4, 5 ]
  const arr4 = [...arr2, ...arr1];
  console.log(arr4); // [ 3, 4, 5, 1, 2, 3 ]

  // 두 객체를 결합
  const obj1 = { a: 1, b: 2, c: 3 };
  const obj2 = { c: 33, d: 4, e: 5 };
  const obj3 = { ...obj1, ...obj2 };
  console.log(obj3); // { a: 1, b: 2, c: 33, d: 4, e: 5 }
  const obj4 = { ...obj2, ...obj1 };
  console.log(obj4); // { c: 3, d: 4, e: 5, a: 1, b: 2 }
}

// 사용 예 5. 배열 요소를 함수의 개별 인수로 전달하라 때
{
  function sum(a, b, c) {
    return a + b + c;
  }

  const numbers = [10, 20, 30];
  console.log(sum(...numbers));

  console.log(Math.max(10, 20, 30));
  console.log(Math.max(...numbers));
}

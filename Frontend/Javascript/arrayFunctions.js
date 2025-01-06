{
  const numbers = [1, 2, 3, 4, 5];

  // numbers 배열의 각 항목의 값에 13을 곱한 결과 중 짝수의 합을 구하시오.
  //               ~~~~~~~~~~~~~~~~~~~~    ~~~~~~~~~~   ~~~
  //               map                     filter       reduce
  const f1 = (n) => n * 13;
  const f2 = (n) => n % 2 === 0;
  const f3 = (a, c) => a + c;

  const result = numbers.map(f1).filter(f2).reduce(f3, 0);
  console.log(result); // 78

  const result1 = numbers.map(f1);
  const result2 = result1.filter(f2);
  const result3 = result2.reduce(f3, 0);
  console.log(result1); // [ 13, 26, 39, 52, 65 ]
  console.log(result2); // [ 26, 52 ]
  console.log(result3); // 78

  // 콜백함수를 직접 정의
  const result4 = numbers
    .map((n) => n * 13)
    .filter((n) => n % 2 === 0)
    .reduce((a, c) => a + c, 0);
}

{
  const numbers = [1, 2, 3, 4, 5];

  // numbers 배열의 각 항목의 값에 13을 곱한 결과 중 짝수의 합을 구하시오.
  //               ~~~~~~~~~~~~~~~~~~~~    ~~~~~~~~~~   ~~~
  //               map                     filter       reduce
  const f1 = (n) => n * 13;
  const f2 = (n) => n % 2 === 0;
  const f3 = (a, c) => a + c;

  const result1 = numbers.map(f1).filter(f2).reduce(f3, 0);
  console.log(result1); // 78

  // numbers 배열에서 짝수를 추출해서 13을 곱한 결과의 합계를 구하시오.
  const result2 = numbers.filter(f2).map(f1).reduce(f3, 0);
  console.log(result2); // 78

  const students = [
    { name: "홍길동", age: 16, score: 88 },
    { name: "홍길서", age: 18, score: 78 },
    { name: "홍길남", age: 20, score: 98 },
    { name: "홍길북", age: 22, score: 68 },
  ];
}

{
  const students = [
    { name: "홍길동", age: 16, score: 88 },
    { name: "홍길서", age: 18, score: 78 },
    { name: "홍길남", age: 20, score: 98 },
    { name: "홍길북", age: 22, score: 68 },
  ];

  // 점수가 80점 이상인 학생의 이름을 출력
  const f1 = (student) => student.score >= 80;
  const f2 = (student) => student.name;

  console.log(students.filter(f1).map(f2));
  students
    .filter(f1)
    .map(f2)
    .forEach((name) => console.log(name));

  // 점수가 80점 이상이고, 나이가 20세 이상인 학생의 이름을 출력
  const f3 = (student) => student.age >= 20;
  const result = students.filter(f1).filter(f3).map(f2);
  console.log(result);
}

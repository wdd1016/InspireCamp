{
  // var part

  console.log(x1); // undefined => x1 변수가 hoisting되어 선언된 것으로 처리
  var x1;
  console.log(x1); // undefined

  var x1;
  console.log(x1); // undefined
  console.log(x1); // undefined

  console.log(x1); // undefined => x1 변수가 hoisting되어 선언된 것으로 처리
  var x1;
  console.log(x1); // undefined

  x1 = 100;
  console.log(x1, typeof x1); // 100 'number'

  console.log(x2); // undefined
  var x2 = 100;
  console.log(x2); // 100

  var x2;
  console.log(x2); // undefined
  x2 = 100;
  console.log(x2); // 100
}

{
  // let part

  console.log(x3); // Cannot access 'x3' before initialization
  let x3 = 100;
  console.log(x3); // 100

  let x4; // 변수 선언이 호이스팅되지만 초기화되지 않음
  // ⇒ TDZ 본관 ⇒ 초기화되기 전에 참조할 수 없음
  console.log(x3); // Cannot access 'x3' before initialization
  x4 = 100;
  console.log(x3); // 100
}

{
  // const part

  const a = 100;
  a = 200; // Uncaught TypeError: Assignment to constant variable.
}

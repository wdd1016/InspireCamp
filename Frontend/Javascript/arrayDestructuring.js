{
  // 배열 요소의 값을 변수에 할당
  const arr = [1, 2, 3, 4, 5];

  // 배열 인덱스를 이용해서 개별 변수에 배열이 가지고 있는 값을 할당
  let a = arr[0];
  let b = arr[1];
  console.log({ a, b }); // { a: 1, b: 2 }

  // c, d, e, f 변수에 arr 배열에 첫번째 인덱스의 값부터 차례로 할당
  let [c, d, e, f] = arr;
  console.log({ c, d, e, f }); // { c: 1, d: 2, e: 3, f: 4 }

  // 두 변수의 값을 교환
  let x = 10;
  let y = 20;
  console.log({ x, y }); // {x: 10, y: 20}

  let temp = x;
  x = y;
  y = temp;
  console.log({ x, y }); // {x: 20, y: 10}

  // 배열 비구조화를 이용해서 두 변수의 값을 교환
  x = 10;
  y = 20;
  console.log({ x, y }); // {x: 10, y: 20}

  [x, y] = [y, x];
  //~~~~   ~~~~~~
  //비구조화 배열을 선언
  console.log({ x, y }); // {x: 20, y: 10}
}

{
  // 배열의 크기 보다 변수의 개수가 많은 경우
  const arr = [1, 2];
  const [a, b, c] = arr;
  console.log({ a, b, c }); // { a: 1, b: 2, c: undefined }

  // 기본값 설정이 가능
  const [d, e = 20, f = 30] = arr;
  console.log({ d, e, f }); // { d: 1, e: 2, f: 30 }
}

{
  // 배열의 일부값을 변수에 할당할 경우 => 할당하지 않을 자리는 비워둠
  const arr = [1, 2, 3, 4, 5];
  let [a, b, c, d, e] = arr;
  console.log({ a, b, c, d, e }); // { a: 1, b: 2, c: 3, d: 4, e: 5 }

  // 변수 x에 첫번째 값을, y에 세번째 값을, z에 다섯번째 값을 할당
  let [x, , y, , z] = arr;
  console.log({ x, y, z }); // { x: 1, y: 3, z: 5 }
}

{
  // 배열의 값을 할당하고 남은 나머지를 새로운 배열로 만드는 경우
  var arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

  // arr 배열의 첫번째 값을 first 변수에 넣고, 나머지 값을 rest 이름의 배열에 추가
  const [first, ...rest] = arr;
  console.log(first); // 1
  console.log(rest); // [2, 3, 4, 5, 6, 7, 8, 9, 10]
}

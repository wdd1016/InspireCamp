// source 배열의 값을 두 배수한 결과 배열(twoTimes)을 만들어서 출력
// 방법1. for문을 이용한 방법
{
  const twoTimes = [];
  for (let i = 0; i < source.length; i++) {
    // twoTimes.push(source[i] * 2);
    twoTimes[i] = source[i] * 2;
  }
  console.log(twoTimes); // [2, 8, 18, 32]
}

// 방법2. map() 메서드를 이용
{
  const twoTimes = source.map((value) => value * 2);
  console.log(twoTimes); // [2, 8, 18, 32]
}
{
  const func = (value) => value * 2;
  const twoTimes = source.map(func);
  console.log(twoTimes); // [2, 8, 18, 32]
}
{
  const func = function (value) {
    return value * 2;
  };
  const twoTimes = source.map(func);
  console.log(twoTimes); // [2, 8, 18, 32]
}
{
  const twoTimes = source.map(function (value) {
    return value * 2;
  });
  console.log(twoTimes); // [2, 8, 18, 32]
}
{
  function func(value) {
    return value * 2;
  }
  const twoTimes = source.map(func);
  console.log(twoTimes); // [2, 8, 18, 32]
}

// 여러 맵 함수를 연결해서 사용
{
  const twoTimes = (v) => v * 2;
  const tenTimes = (v) => v * 10;
  const plusTwo = (v) => v + 2;

  const result = source.map(plusTwo).map(twoTimes).map(tenTimes);
  console.log(result); // [ 220, 460, 920, 1840 ]

  result = source.map(twoTimes).map(tenTimes).map(plusTwo);
  console.log(result); // [ 22, 42, 82, 162 ]
}

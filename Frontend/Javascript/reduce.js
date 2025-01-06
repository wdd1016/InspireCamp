const numbers = [1, 2, 3, 4, 5];

// 배열 요소들의 합계
{
  let sum = 0;
  for (let i = 0; i < numbers.length; i++) {
    sum += numbers[i];
  }
  console.log(sum); // 15
}
{
  let sum = numbers.reduce((acc, cur) => acc + cur, 0);
  console.log(sum); // 15
}
{
  // initvalue를 설정한 경우
  let sum = numbers.reduce((acc, cur) => {
    const result = acc + cur;
    console.log(acc, cur, result);
    return result;
  }, 0);
  console.log(sum); // 15
}
{
  // initValue를 생략한 경우
  let sum = numbers.reduce((acc, cur) => {
    const result = acc + cur;
    console.log(acc, cur, result);
    return result;
  });
  console.log(sum); // 15
}

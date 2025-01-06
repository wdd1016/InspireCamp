const words = [
  "spring",
  "summer",
  "fall",
  "winter",
  "destruction",
  "creation",
  "rebirth",
];

// 길이가 여섯 글자 이상인 단어만 추출
{
  const newWords = [];
  for (let i = 0; i < words.length; i++) {
    if (words[i].length >= 6) {
      newWords.push(words[i]);
    }
  }
  console.log(newWords);
}
{
  const newWords = words.filter((w) => w.length >= 6);
  console.log(newWords);
}
{
  function func(w) {
    return w.length >= 6;
  }
  const newWords = words.filter(func);
  console.log(newWords);
}
{
  const func = function (w) {
    return w.length >= 6;
  };
  const newWords = words.filter(func);
  console.log(newWords);
}
{
  const newWords = words.filter(function (w) {
    return w.length >= 6;
  });
  console.log(newWords);
}

const numbers = [1, 3, 4, 6, 11, 14];

// 짝수만 추출해서 10배수한 결과를 출력
console.log(numbers.filter((n) => n % 2 === 0).map((n) => n * 10));

const even = numbers.filter((n) => n % 2 === 0);
const evenTenTimes = even.map((n) => n * 10);
console.log(evenTenTimes); // [ 40, 60, 140 ]

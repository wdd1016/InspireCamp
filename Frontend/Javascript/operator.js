{
  // 나눗셈, 나머지 연산자
  console.log(`7 / 5 = ${7 / 5}`); // 7 / 5 = 1.4
  console.log(`7 % 5 = ${7 % 5}`); // 7 % 5 = 2    <= 나머지
}

{
  // 나머지 연산의 부호는 왼쪽 피연자의 부호를 따름
  console.log(`7 % 5 = ${7 % 5}`); // 7 % 5 = 2
  console.log(`7 % -5 = ${7 % -5}`); // 7 % -5 = 2
  console.log(`-7 % 5 = ${-7 % 5}`); // -7 % 5 = -2
  console.log(`-7 % -5 = ${-7 % -5}`); // -7 % -5 = -2
}

{
  // 문자열 결합
  console.log("Hello, " + "JavaScript" + `!!!!`);
}

{
  // 문자열의 일부를 선택 => 문자열[인덱스]
  //               0         1
  //               012345678901234567
  const message = "Hello, JavaScript!";
  console.log(message[0]); // H   <= 첫번째 글자
  console.log(message[17]); // !
  console.log(message[message.length - 1]); // !   <= 마지막 글자
  console.log(message[18]); // undefined
}

{
  // postfix 방식, prefix 방식
  let x = 100;
  console.log(x); // 100
  if (x++ > 100) {
    console.log("100 초과");
  } else {
    console.log("100 이하"); // 100 이하
  }
  console.log(x); // 101

  let y = 100;
  console.log(y); // 100
  if (++y > 100) {
    console.log("100 초과"); // 100 초과
  } else {
    console.log("100 이하");
  }
  console.log(y); // 101
}

{
  // 동등 연산자(equality operator), 일치 연산자(strict equality operator)
  let n = 100;
  let s = "100";

  console.log(n, s); // 100 "100"
  console.log(typeof n, typeof s); // number string

  if (n == s) {
    console.log("동등 연산자: 같다"); // 같다 <= 두 변수의 값을 비교
  } else {
    console.log("동등 연산자: 다르다");
  }

  if (n === s) {
    // if (typeof n == typeof s && n == s)
    console.log("일치 연산자: 같다");
  } else {
    console.log("일치 연산자: 다르다"); // 다르다 <= 두 변수의 타입과 값을 함께 비교
  }
}

{
  // Object.is() 메소드
  console.log(-0 === +0); // true
  console.log(Object.is(-0, +0)); // false

  console.log(typeof NaN); // number
  console.log(Number.NaN === NaN); // false
  console.log(Object.is(Number.NaN, NaN)); // true
}

{
  // 삼항 연산자 => (조건식) ? 참일 때 : 거짓일 때
  let x = 100;
}

{
  // if - else 구문으로 조건식을 구현
  if (x > 100) {
    console.log("100 초과");
  } else {
    console.log("100 이하");
  }
}

{
  // 동일한 로직을 삼하아 연산자로 표현
  console.log(x > 100 ? "100 초과" : "100 이하");
}

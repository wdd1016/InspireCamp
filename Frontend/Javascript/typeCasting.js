// 강제 자료형 변환
{
  // 문자열로 변환
  console.log(String(52));
  console.log(String(true));

  // 숫자로 변환
  console.log(Number("52"));
  console.log(Number(true)); // 1
  console.log(Number(false)); // 0
  console.log(Number("숫자")); // NaN

  // 숫자로 변환 가능 여부를 확인
  console.log(Number("52") == NaN); // false
  console.log(Number("오십이") == NaN); // false
  console.log(NaN == NaN); // false

  console.log(isNaN(Number("52"))); // false
  console.log(isNaN(Number("오십이"))); // true
  console.log(isNaN(NaN)); // true

  // 불(boolean)으로 변환
  // 0, -0, null, false, NaN, undefined, '' => false
  // 그 외의 값은 true
}

// 자동 자료형 변환
{
  // 숫자와 문자열에 + 연산자를 사용하면 숫자를 문자열로 자동 변환
  // + 연산자는 문자열 결합 연산자로 사용
  console.log(10 + 20); // 30
  console.log("10" + 20); // 1020
  console.log(10 + "20"); // 1020
  console.log("10" + "20"); // 1020

  // 숫자와 문자열에 + 가 아닌 다른 연산자를 사용하면 문자열을 숫자로 자동 변환
  console.log(20 - 10); // 10
  console.log("20" - 10); // 10
  console.log(20 - "10"); // 10
  console.log("20" - "10"); // 10

  console.log("20" * 10); // 200
  console.log("20" / 10); // 2
  console.log("20" % 10); // 0

  // 부정 연산자를 두 번 사용하면 Boolean() 함수를 사용하는 것과 동일
  console.log(Boolean(0), !!0);
  console.log(Boolean(1), !!1);
}

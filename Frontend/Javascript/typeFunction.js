// 함수 종류
// 콜백 함수(callback function)
// 개발자가 코드를 이용해서 명시적으로 호출하는 함수가 아니고,
// 개발자는 단지 함수를 등록하기만 하고,
// 어떤 이벤트가 발생하거나 특정 시점에 도달했을 때 시스템에서 호출하는 함수
// 이벤트 핸들러 ⇒ 특정 이벤트가 발생했을 때 실행되는 함수
// <input type="button" onClick="function() { .... }" />

// 즉시 실행 함수 = 자기 호출 함수
// 함수 정의와 동시에 바로 실행하는 함수

// 익명 함수 표현식을 괄호로 둘러싼 후 바로 호출(실행)할 수 있도록 괄호 쌍을 추가

// ( function (name) { console.log(`${name}는 즉시 실행됩니다.`); } ) ('이 함수');
//                                                                     ~~~~~~~~~
//                                                           함수 실행에 필요한 인자값을 전달

{
  // 화살표 함수
  // https://www.learn-js.org/en/Arrow_Functions
  // https://www.w3schools.com/js/js_arrow_function.asp

  // 익명 함수 표현식을 이용해서 함수를 정의
  const add1 = function (x, y) {
    return x + y;
  };
  console.log(add1(2, 3)); // 5

  // 화살표 함수
  // function 키워드를 제거하고, 함수 파라미터와 본문 사이에 화살표(=>)를 추가
  const add2 = (x, y) => {
    return x + y;
  };
  console.log(add2(2, 3)); // 5

  // 화살표 함수 본문이 결과를 반환하는 구문으로 되어 있는 경우, 중괄호와 return 키워드를 생략할 수 있음
  const add3 = (x, y) => x + y;
  console.log(add3(2, 3)); // 5

  // 매개변수가 하나인 경우, 매개변수를 감싸고 있는 소괄호도 생략이 가능
  const add4 = (x) => x + 4;
  console.log(add4(2)); // 6

  // 객체를 반환하는 경우에는 반환 객체를 소괄호로 감싸야 함
  const add5 = (x, y) => {
    return { result: x + y };
  };
  console.log(add5(2, 3)); // { result: 5 }

  const add6 = (x, y) => ({ result: x + y });
  console.log(add6(2, 3)); // { result: 5 }
}

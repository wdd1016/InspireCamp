{
  // 함수 선언문

  function add(x, y) {
    // 반드시 함수 이름이 정의되어야 함
    return x + y;
  }

  console.log(add(10, 20)); // 함수 이름으로 호출
}

{
  // 함수 표현식

  // 변수는 값을 주고 받을 수 있음
  let a = 100;
  let b = a;
  console.log(a); // 100
  console.log(b); // 100

  // 함수 표현식을 이용하면 함수를 변수처럼 사용할 수 있음
}

{
  // 익명 함수 표현식

  let add = function (x, y) {
    return x + y;
  };
  //  ~~~   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //   |      |
  //   |      +-- 익명 함수 표현식
  //   +-- 함수 변수
  let sum = add;
  console.log(add(10, 20)); // 30
  console.log(sum(10, 20)); // 30
}

{
  // 기명 함수 표현식
  let sum1 = function add(x, y) {
    return x + y;
  };
  //         기명 함수 표현식 	⇒ 함수 외부에서는 함수 이름으로 사용할 수 없으나,
  //                       	   함수 내부에서 자기 호출할 때 사용할 수 있음
  let sum2 = sum1;

  console.log(sum1(10, 20)); // 30
  console.log(sum2(10, 20)); // 30
  console.log(add(10, 20)); // add is not defined

  let myFactoryal = function factory(n) {
    if (n === 1) {
      return 1;
    }
    return n * factory(n - 1);
  };

  console.log(myFactoryal(10));
}

{
  // 함수 선언문으로 정의한 함수는
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~
  // function add (x, y) { return x + y; }
  // 자바스크립트 내부에서 함수 이름과 함수 변수 이름이 동일한 함수 표현식으로 자동 변경
  //                       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //                       let add = function add (x, y) { return x + y; };
}

{
  // Function() 생성자 함수를 이용
  // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Function/Function

  new Function(arg1, arg2, /* …, */ argN, functionBody);

  let add = new Function("x", "y", "return x + y");
}

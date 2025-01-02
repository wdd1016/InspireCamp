{
  // 함수를 다른 함수의 인자로 전달

  let click = function (fname) {
    fname();
  };

  let loginButtonClick = function () {
    console.log("로그인되었습니다.");
  };
  let logoutButtonClick = function () {
    console.log("로그아웃되었습니다.");
  };

  click(loginButtonClick);
  click(logoutButtonClick);

  // -------------------------------------
  let cal = function (f, x, y) {
    switch (f) {
      case "add":
        console.log(`x + y = ${x + y}`);
        break;
      case "sub":
        console.log(`x - y = ${x - y}`);
        break;
      case "mul":
        console.log(`x * y = ${x * y}`);
        break;
      case "div":
        console.log(`x / y = ${x / y}`);
        break;
    }
  };

  let calurator = function (f, x, y) {
    f(x, y);
  };

  let add = function (x, y) {
    console.log(`x + y = ${x + y}`);
  };
  let sub = function (x, y) {
    console.log(`x - y = ${x - y}`);
  };
  let mul = function (x, y) {
    console.log(`x * y = ${x * y}`);
  };
  let div = function (x, y) {
    console.log(`x / y = ${x / y}`);
  };

  calurator(add, 10, 20);
  calurator(sub, 10, 20);
  calurator(mul, 10, 20);
  calurator(div, 10, 20);
}

{
  // 함수를 다른 함수의 리턴값으로 활용
  let foo = function () {
    return function () {
      console.log("반환함수");
    };
  };

  let bar = foo();
  bar();

  // ----------------------------------

  function twoTimes() {
    return function (number) {
      return number * 2;
    };
  }
  const no3 = twoTimes();
  console.log(no3(3));
  const no4 = twoTimes();
  console.log(no4(4));

  function multiflier(factor) {
    return function (number) {
      return number * factor;
    };
  }
  const double = multiflier(2);
  console.log(double(3)); // 6
  console.log(double(4)); // 8
  const triple = multiflier(3);
  console.log(triple(3)); // 9
  console.log(triple(4)); // 12
}

{
  // 팩토리알을 계산하는 함수를 정의

  // 방법1. 반복문을 이용
  function factorial_loop(n) {
    let result = 1;
    for (let i = 1; i <= n; i++) {
      result *= i;
    }
    return result;
  }

  // 방법2. 재귀함수를 이용
  function factorial_recursive(n) {
    if (n === 1) {
      return 1;
    }
    return n * factorial_recursive(n - 1);
  }

  console.log(factorial_loop(10));
  console.log(factorial_recursive(10));
}

{
  // 함수 실행에 소요된 시간을 측정
  // 방법1. 함수 내부에 시작과 끝에 시간을 측정하는 코드를 추가
  //        => 루프 방식은 구현이 가능한데, 재귀함수는 구현이 불가(어려움)
  // 방법2. 함수를 호출하는 부분에 시간을 측정하는 코드를 추가
  let start = performance.now();
  console.log(factorial_loop(10));
  let end = performance.now();
  console.log(`실행시간: ${(end - start).toFixed(10)}ms`);

  start = performance.now();
  console.log(factorial_recursive(10));
  end = performance.now();
  console.log(`실행시간: ${(end - start).toFixed(10)}ms`);
}

{
  // 시간을 측정하고, 계산하고, 출력하는 부분이 중복되어 있음
  function performance_checker(func) {
    return function (n) {
      let start = performance.now();
      console.log(func(n));
      let end = performance.now();
      console.log(`실행시간: ${end - start}ms`);
    };
  }

  performance_checker(factorial_loop)(10);
  performance_checker(factorial_recursive)(10);
}

{
  // 기존 함수의 동작을 확장하거나 새로운 동작을 정의 (기존 함수를 변경하지 않고)
  // 함수 실행에 필요한 인자값과 결과값을 출력하는 함수
  const add = (a, b) => a + b;
  add(10, 20);
  const sub = (a, b) => a - b;

  function logger(func) {
    return function (...args) {
      console.log(`인자값: ${args}`);
      const result = func(...args);
      console.log(`결과값: ${result}`);
      return result;
    };
  }
  logger(add)(10, 20);
  logger(sub)(20, 10);
}

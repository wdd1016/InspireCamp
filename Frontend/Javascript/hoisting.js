{
  hello(); // Hello, JavaScript

  // 함수 선언문 형식으로 정의
  function hello() {
    console.log("Hello, JavaScript");
  }
}

{
  hello(); // Hello, JavaScript

  // var 키워드를 이용해 함수 변수를 정의하는 경우
  hello(); // Uncaught TypeError: hello is not a function

  var hello = function () {
    console.log("Hello, JavaScript!");
  };

  hello(); // Hello, JavaScript!

  /* 
  // 위 코드는 아래와 같이 해석
  var hello; // undefined 상태

  hello(); // Uncaught TypeError: hello is not a function

  hello = function () {
    console.log("Hello, JavaScript!");
  };

  hello(); // Hello, JavaScript!
  */
}

{
  // let 키워드를 이용해 함수 변수를 정의하는 경우
  hello(); // Uncaught ReferenceError: Cannot access 'hello' before initialization

  let hello = function () {
    console.log("Hello, JavaScript!");
  };

  hello(); // Hello, JavaScript!

  /*
  // 위 코드는 아래와 같이 해석
    let hello;      // 초기화되기 전까지 TDZ(Temporal Dead Zone)에 머물러 있다.
    
    hello();        // Uncaught ReferenceError: Cannot access 'hello' before initialization
    
    hello = function() {
        console.log('Hello, JavaScript!');
    };


    hello();        // Hello, JavaScript!
  */
}

{
  // 배열 선언
  let values = ["빨강", "노랑", "파랑", true, 20];
  console.log(values);
  console.dir(values);

  // 배열 길이는 배열 객체의 length 속성(property)을 이용하여 확인할 수 있음
  console.log(values.length);
  console.log(values["length"]);

  // 배열 데이터를 추가
  values.push("검정");
  values[values.length] = "하양";
  console.log(values); // ['빨강', '노랑', '파랑', true, 20, '검정', '하양']
  values[values.length + 10] = "보라";
  console.log(values); // ['빨강', '노랑', '파랑', true, 20, '검정', '하양', <10 empty items>, '보라']
  console.dir(values);
  console.log(values[10]); // undefined
}

{
  // 배열의 모든 요소를 순차적으로 가져와서 출력
  let values = ["빨강", "노랑", "파랑", "초록"];

  console.log("방법1. 개별 요소를 직접 참조해서 출력력");
  console.log(values[0]);
  console.log(values[1]);
  console.log(values[2]);
  console.log(values[3]);

  console.log("방법2. for loop를 이용");
  for (let i = 0; i < values.length; i++) {
    console.log(values[i]);
  }

  console.log("방법3. for - in 구문을 이용 => 개별 요소의 인덱스를 반환");
  for (let index in values) {
    console.log(index, values[index]);
  }

  console.log("방법4. for - of 구문을 이용 => 개별 요소의 값을 반환");
  let idx = 0;
  for (let value of values) {
    console.log(idx++, value);
  }

  // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach
  console.log("방법5-1. forEach => 개별 요소를 콜백 함수로 전달");
  // 함수 선언문 형태로 콜백 함수를 정의
  function printData(data) {
    console.log(data);
  }
  values.forEach(printData);

  console.log("방법5-2. forEach -------");
  // 함수 표현식 형태로 콜백 함수를 정의
  let printData2 = function (data) {
    console.log(data);
  };
  values.forEach(printData2);

  console.log("방법5-3. forEach -------");
  // 콜백 함수를 직접 정정의
  values.forEach(function (data) {
    console.log(data);
  });

  console.log("방법5-4. forEach -------");
  // 화살표 함수로 콜백 함수를 정의
  values.forEach((data) => {
    console.log(data);
  });

  console.log("방법5-5. forEach -------");
  // 화살표 함수로 콜백 함수를 정의 => 화살표 함수 축약
  values.forEach((data) => console.log(data));

  consle.log("인덱스와 값을 함께 출력");
  values.forEach((data, index) => {
    console.log(index, data);
  });

  consle.log("인덱스와 값을 함께 출력 => 화살표 함수 축약");
  values.forEach((data, index) => console.log(index, data));
}

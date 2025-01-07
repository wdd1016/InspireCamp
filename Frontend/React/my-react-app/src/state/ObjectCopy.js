// state 사용 시 주의사항

// state 값을 변경할 때 setState (클래스형 컴포넌트) 또는
// useState 훅 함수가 반환한 셋터 함수 (함수형 컴포넌트)를 이용
// → 변경된 값이 화면에 반영될 수 없음
//   (forceUpdate() 함수를 이용해서 강제로 반영할 수 있으나, 권장하지 않음)

// 배열 또는 객체를 업데이트해야 하는 경우, 그 사본을 만들고 그 사본의 값을 업데이트 후
// setState 또는 세터 함수를 통해서 반영

// 객체의 사본을 만드는 방법 ⇒ 전개 연산자 사용
const obj = { a: 1, b: 2, c: 3 };
const newObj = { ...obj, b: 20 };

// 배열의 사본을 만드는 방법 ⇒ 전개 연산자 또는 배열 내장 함수를 활용
const arr = [1, 2, 3, 4];
const newArr1 = [...arr]; // [ 1, 2, 3, 4 ]
const newArr2 = arr.concat(100); // [ 1, 2, 3, 4, 100 ]
const newArr3 = arr.filter((i) => i % 2 === 0); // [ 2, 4 ]
const newArr4 = arr.map((i) => i * i); // [ 1, 4, 9, 16 ];

// 주의
const newArr5 = arr.push(100); // arr 배열에 100을 추가하고, 배열 길이를 반환

// https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/concat
// https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/push

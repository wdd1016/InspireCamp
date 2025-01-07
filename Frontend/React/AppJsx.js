/*
#1 반드시 부모 요소 하나로 감싸야 한다. 
function App() {
  return (
    <h1>리액트 앱</h1>
    <h2>react app</h2>	⇐ JSX 식에는 부모 요소가 하나 있어야 합니다.
  );
}

export default App;

방법1. 다른 태그를 추가 ⇒ 불필요한 태그가 추가 
function App() {
  return (
    <div>
      <h1>리액트 앱</h1>
      <h2>react app</h2>
    </div>
  );
}
export default App;





방법2. Fragment 컴포넌트를 이용 ⇒ 불필요한 태그 추가를 방지
import { Fragment } from "react";

function App() {
  return (
    <Fragment>
      <h1>리액트 앱</h1>
      <h2>react app</h2>
    </Fragment>
  );
}
export default App;




방법3. Fragment를 축약 방식으로 사용
// import { Fragment } from "react";

function App() {
  return (
    <>
      <h1>리액트 앱</h1>
      <h2>react app</h2>
    </>
  );
}
export default App;


#2 JSX 안에서는 자바스크립트 표현식을 { }로 감싸서 작성
function App() {

  const name = "홍길동";
  const age = 23;

  return (
    <>
      <h1>{`안녕, ${name}`}</h1>
      <h1>안녕, {name}</h1>
      <h2>{age + 2}</h2>
    </>
  );
}
export default App;


#3 JSX 내부에서 자바스크립트의 if 문을 사용할 수 없으므로, 삼항 연산자를 사용해야 함
function App() {

  const name = "홍길동";
  const age = 23;

  return (
    <>
      <h1>{`안녕, ${name}`}</h1>
      <h1>안녕, {name}</h1>
      <h2>${age + 2}</h2>
      <h2>{name === "홍길동" ? "환영합니다." : "환영하지 않습니다."}</h2>
    </>
  );
}
export default App;



#4 조건을 만족할 때만 내용을 보여주는 경우 ⇒ 조건부 렌더링
방법1. 삼항 연산자를 이용하는 방법 ⇒ 조건을 만족하지 않는 경우 null을 반환 
function App() {

  const name = "홍길동x";
  const age = 23;

  return (
    <>
      <h1>{`안녕, ${name}`}</h1>
      <h1>안녕, {name}</h1>
      <h2>${age + 2}</h2>
      <h2>{name === "홍길동" ? "환영합니다." : null}</h2>	
    </>
  );
}
export default App;


방법 2. && 연산을 이용
       ~~
       단락 연산자 (short circuiting operator)
    	https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Logical_AND


function App() {

  const name = "홍길동";
  const age = 23;

  return (
    <>
      <h1>{`안녕, ${name}`}</h1>
      <h1>안녕, {name}</h1>
      <h2>${age + 2}</h2>
      <h2>{name === "홍길동" && "환영합니다."}</h2>
    </>                         ~~~~~~~~~~~~~
  );                            조건을 만족했을 때 출력할 내용 
}
export default App;


#5 인라인 스타일
태그 내에서 style 속성을 이용해서 스타일을 지정하는 방법 

DOM 요소에 스타일을 지정할 때는 객체 형태로 적용해야 하며, 스타일 이름은 카멜 표현식을 사용하고, 숫자 타입의 경우 단위를 생략하면 기본값이 px을 사용 (단위를 포함할 때는 문자열로 표현)


function App() {

  const name = "홍길동";
  const age = 23;

  return (      +-- 표현식 
    <>          | +-- 객체
      <h1 style={ { backgroundColor: "black", color: "yellow", fontSize: 28, padding: '16px' } }>{`안녕, ${name}`}</h1>
      <h1>안녕, {name}</h1>
      <h2>${age + 2}</h2>
      <h2>{name === "홍길동" && "환영합니다."}</h2>
    </>
  );
}
export default App;


인라인 스타일을 별도의 변수로 선언해서 사용
function App() {

  const name = "홍길동";
  const age = 23;
  const myStyle = { backgroundColor: "black", color: "yellow", fontSize: 28, padding: '16px' };

  return (
    <>
      <h1 style={myStyle}>{`안녕, ${name}`}</h1>
      <h1>안녕, {name}</h1>
      <h2>${age + 2}</h2>
      <h2>{name === "홍길동" && "환영합니다."}</h2>
    </>
  );
}
export default App;


여러 스타일을 일괄적으로 선언하고 사용하는 경우
function App() {

  const name = "홍길동";
  const age = 23;
  const myStyle = {
    h1Style: { backgroundColor: "black", color: "yellow", fontSize: 28, padding: '16px' },
    h2Style: { color: "red" }
  };

  return (
    <>
      <h1 style={myStyle.h1Style}>{`안녕, ${name}`}</h1>
      <h1>안녕, {name}</h1>
      <h2>${age + 2}</h2>
      <h2 style={myStyle.h2Style}>{name === "홍길동" && "환영합니다."}</h2>
    </>
  );
}
export default App;



#6 함수가 undefined를 반환하지 않도록 기본값을 설정
function Name() {
  let name;
  return name || "아무개";
}

function App() {
  return (
    <>
      안녕, <Name />!
    </>
  );
}
export default App;


#7 CSS 클래스를 사용할 때 class가 아닌 className으로 설정
<div class="myclass"> ... </div>  ⇒ <div className="myclass"> ... </div>

App.css 파일에 아래의 스타일을 추가 
.react {
  background-color: black;
  color: yellow;
  font-size: 40px;
  padding: 10px;
}


App.js 파일에 App.css 스타일을 임포트한 후 클래스 속성을 추가
import "./App.css";

function App() {
  return (
    <div className="react">홍길동</div>
  );
}
export default App;


#8 모든 태그는 반드시 닫는 태그를 사용 
내용이 없는 태그의 경우에는 self-closing 태그를 사용 
~~~~~~~~~~~~~~~~            ~~~~~~~~~~~~~~~~~
|                           <input /> <img /> <hr /> <br /> ... 
+-- <input> <img> <hr> <br> ... 


import "./App.css";

function App() {
  return (
    <>
      <input type="text" />
      <input type="text"></input>
    </>
  );
}
export default App;

#9 주석(comment)

function App() {


  return (
    // 태그가 시작되기 전에는 자바스크립트 주석 사용이 가능 
    <>
      // 태그가 시작되면 주석이 아닌 일반 문자열로 인식

      { // 인라인 주석을 사용할 때는 유의해야 함 (표현식 끝에 }을 사용하면 주석 처리되어 버림)
      }
      <input type="text" />
      <input type="text"></input>
    </>
  );
}

export default App;
*/

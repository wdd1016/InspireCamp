import { Component } from "react";
import MyComponentClass from "./MyComponentClass";
import MyComponentFunction from "./MyComponentFunction";

const datas = [
  { name: "홍길동", age: 23, nickname: "호부호형을 원하는 자" },
  { name: "고길동", age: 43, nickname: "둘리가 싫은 자" },
  { name: "신길동", age: 50, nickname: "신길동 매운 짬뽕" },
];

class AppComponent extends Component {
  render() {
    return (
      <>
        <h1>클래스형 컴포넌트</h1>
        {datas.map((data) => (
          <MyComponentClass
            name={data.name}
            age={data.age}
            nickname={data.nickname}
          >
            <i>어떤 내용</i>
          </MyComponentClass>
        ))}
        <hr />
        <h1>함수형 컴포넌트</h1>
        {datas.map((data) => (
          <MyComponentFunction
            name={data.name}
            age={data.age}
            nickname={data.nickname}
          >
            <i>또 어떤 내용</i>
          </MyComponentFunction>
        ))}
      </>
    );
  }
}

export default AppComponent;

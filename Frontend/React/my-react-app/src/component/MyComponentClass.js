import { Component } from "react";

class MyComponentClass extends Component {
  render() {
    // console.log(this);
    // console.log(this.props);

    // 객체 비구조화를 이용해서 코드를 간결하게 작성
    const { name, age, nickname } = this.props;
    return (
      <>
        <h1>이름은 {name}입니다.</h1>
        <h2>나이는 {age}살 입니다.</h2>
        <h2>별명은 {nickname}입니다.</h2>
        <div>{this.props.children}</div>
      </>
    );
  }
}

MyComponentClass.defaultProps = {
  name: "아무개",
  age: 0,
  nickname: "없음",
};

export default MyComponentClass;

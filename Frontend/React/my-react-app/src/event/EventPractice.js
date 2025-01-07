import { Component } from "react";

class EventPractice extends Component {
  state = {
    message: "",
    username: "",
  };

  /*
  그냥 함수를 정의하면, constructor에서 this를 bind를 해야 한다.
  constructor(props) {
    super(props);
    this.state = {
      message: "",
    };
    this.handlerChange = this.handlerChange.bind(this);
    this.handlerClick = this.handlerClick.bind(this);
  }
  handlerChange(e) {
    console.log(e.target.value);
    this.setState({ message: e.target.value });
  }
  handlerClick() {
    this.setState({ message: "" });
  }
  */

  /* 두개 -> 하나로 합치기
  handlerChangeMessage = (e) => {
    console.log(e.target.value);
    this.setState({ message: e.target.value });
  };

  handlerChangeUsername = (e) => {
    console.log(e.target.value);
    this.setState({ username: e.target.value });
  };
  */

  handlerChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  handlerClick = () => {
    this.setState({ message: "", username: "" });
  };

  handlerKeyUp = (e) => {
    if (e.key === "Enter") {
      this.handlerClick();
    }
  };

  render() {
    return (
      <div>
        <h1>이벤트 연습</h1>
        <input
          type="text"
          name="message"
          placeholder="입력해 보세요."
          value={this.state.message}
          onChange={this.handlerChange}
          onKeyUp={this.handlerKeyUp}
        />
        <input
          type="text"
          name="username"
          placeholder="입력해 보세요."
          value={this.state.username}
          onChange={this.handlerChange}
        />
        <h2>message: {this.state.message}</h2>
        <h2>username: {this.state.username}</h2>
        <button onClick={this.handlerClick}>삭제</button>
      </div>
    );
  }
}

export default EventPractice;

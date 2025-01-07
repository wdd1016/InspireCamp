import React, { Component } from "react";
import ErrorBoundary from "./ErrorBoundary";

class LifeCycleSampleChild extends Component {
  state = {
    count: 0,
    color: this.props.color,
  };

  constructor(props) {
    super(props);
    console.log("constructor is called");
  }

  changeCount = (e) => {
    console.log("하나 증가 버튼 클릭!!!");
    this.setState({ count: this.state.count + 1 });
  };

  componentDidMount() {
    console.log("componentDidMount is called");
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    console.log("componentDidUpdate is called");

    if (snapshot) {
      console.log(`업데이트 직전의 글자색: ${snapshot}`);
    }
  }

  componentWillUnmount() {
    console.log("componentWillUnmount is called");
  }

  static getDerivedStateFromProps(nextProps, prevState) {
    console.log("getDerivedStateFromProps is called");
    if (nextProps.color !== prevState.color) {
      return { color: nextProps.color };
    }
    return null;
  }

  shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate is called");

    return nextState.count % 2 === 0;
  }

  getSnapshotBeforeUpdate(prevProps, prevState) {
    console.log("getSnapshotBeforeUpdate is called");

    if (prevProps.color !== this.props.color) {
      return prevProps.color;
    }
    return null;
  }

  render() {
    console.log("render is called");

    return (
      <>
        {/* {this.state.missing.value} 정의되지 않은 state 변수를 참조 */}
        <h1>자식 컴포넌트</h1>
        <h1 style={{ color: this.props.color }}>{this.state.count}</h1>
        <h1>color: {this.state.color}</h1>
        <button onClick={this.changeCount}>하나 증가</button>
      </>
    );
  }
}

class LifeCycleSample extends Component {
  state = {
    color: "#000000",
    isVisible: false,
  };

  getRandomColor = () => {
    return "#" + Math.floor(Math.random() * 0xffffff).toString(16);
  };

  changeColor = () => {
    console.log("랜덤 컬러 버튼 클릭!!!");
    this.setState({ color: this.getRandomColor() });
  };

  changeIsVisible = () => {
    console.log(
      `자식 컴포넌트 ${this.state.isVisible ? "숨기기" : "보이기"} 버튼 클릭!!!`
    );
    this.setState({ isVisible: !this.state.isVisible });
  };

  render() {
    return (
      <>
        {/* {this.state.missing.value} 정의되지 않은 state 변수를 참조 */}
        <button onClick={this.changeIsVisible}>
          자식 컴포넌트 {this.state.isVisible ? "숨기기" : "보이기"}
        </button>
        {this.state.isVisible && (
          <div
            style={{
              border: "1px solid red",
              padding: 10,
              margin: 10,
              borderRadius: 10,
            }}
          >
            <button onClick={this.changeColor}>랜덤 컬러</button>
            <ErrorBoundary>
              <LifeCycleSampleChild color={this.state.color} />
            </ErrorBoundary>
          </div>
        )}
      </>
    );
  }
}

export default LifeCycleSample;

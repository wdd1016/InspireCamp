import React, { Component } from "react";

// createRef()를 이용하는 방법
class ScrollBox extends Component {
  myDiv = React.createRef();

  scrollBottom = () => {
    const { scrollHeight, clientHeight } = this.myDiv.current;
    this.myDiv.current.scrollTop = scrollHeight - clientHeight;
  };

  scrollTop = () => {
    this.myDiv.current.scrollTop = 0;
  };

  render() {
    const styles = {
      outer: {
        border: "1px solid black",
        height: 300,
        width: 300,
        overflow: "auto",
      },
      inner: {
        width: "100%",
        height: 650,
        background: "linear-gradient(white, black)",
      },
    };

    return (
      <>
        <div style={styles.outer} ref={this.myDiv}>
          <div style={styles.inner}></div>
        </div>
        <div>
          <button onClick={this.scrollTop}>맨 위로 이동</button>
          <button onClick={this.scrollBottom}>맨 아래로 이동</button>
        </div>
      </>
    );
  }
}

/*
// 콜백 함수를 이용
class ScrollBox extends Component {
  scrollBottom = () => {
    // const scrollHeight = this.myDiv.scrollHeight;
    // const clientHeight = this.myDiv.clientHeight;
    const { scrollHeight, clientHeight } = this.myDiv;
    this.myDiv.scrollTop = scrollHeight - clientHeight;
  };

  scrollTop = () => {
    this.myDiv.scrollTop = 0;
  };

  render() {
    const styles = {
      outer: {
        border: "1px solid black",
        height: 300,
        width: 300,
        overflow: "auto",
      },
      inner: {
        width: "100%",
        height: 650,
        background: "linear-gradient(white, black)",
      },
    };

    return (
      <>
        <div style={styles.outer} ref={(x) => (this.myDiv = x)}>
          <div style={styles.inner}></div>
        </div>
        <div>
          <button onClick={this.scrollTop}>맨 위로 이동</button>
          <button onClick={this.scrollBottom}>맨 아래로 이동</button>
        </div>
      </>
    );
  }
}
*/

export default ScrollBox;

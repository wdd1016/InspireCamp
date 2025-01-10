import { Component } from "react";

class ErrorBoundary extends Component {
  state = {
    error: false,
    message: "",
  };

  componentDidCatch(error, errorInfo) {
    console.log("componentDidCatch is called");
    console.log({ error, errorInfo });

    this.setState({ error: true, message: error.message });
  }

  render() {
    if (this.state.error) {
      return (
        <>
          <h1>자식 컴포넌트에 에러가 발생했습니다.</h1>
          <div>{this.state.message}</div>
        </>
      );
    } else {
      return this.props.children;
    }
  }
}

export default ErrorBoundary;

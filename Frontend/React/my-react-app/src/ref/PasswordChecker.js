import React, { Component } from "react";

class PasswordChecker extends Component {
  state = {
    password: "",
    isValid: false,
  };

  myInput = React.createRef();

  changePassword = (e) => this.setState({ password: e.target.value });
  clickButton = () => {
    if (this.state.password === "0000") {
      this.setState({ isValid: true });
    } else {
      this.setState({ isValid: false });
      // this.myInput.focus();
      this.myInput.current.focus();
    }
  };

  render() {
    return (
      <>
        <input
          type="password"
          value={this.state.password}
          onChange={this.changePassword}
          style={
            this.state.isValid ? { background: "blue" } : { background: "red" }
          }
          // ref={(x) => (this.myInput = x)}
          ref={this.myInput}
        />
        <button onClick={this.clickButton}>패스워드 검증</button>
      </>
    );
  }
}

export default PasswordChecker;

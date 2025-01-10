import React, { Component } from "react";

// createRef()를 이용하는 방법
class IdPwChecker extends Component {
  state = {
    userId: "",
    userPw1: "",
    userPw2: "",
  };

  /*
  changeUserId = e => this.setState({ userId: e.target.value });
  changeUserPw1 = e => this.setState({ userPw1: e.target.value });
  changeUserPw2 = e => this.setState({ userPw2: e.target.value });
  */
  changeUser = (e) => this.setState({ [e.target.name]: e.target.value });
  clickButton = (e) => {
    // Submit 버튼의 기본 동작을 중지
    e.preventDefault();

    // 객체 비구조화(객체 구조 분해)를 통해 상태변수를 지역변수로 변경
    const { userId, userPw1, userPw2 } = this.state;

    // 입력 여부 체크
    if (userId.trim() === "") {
      alert("ID를 입력하세요.");
      this.refUserId.focus();
      return;
    }
    if (userPw1.trim() === "") {
      alert("PW1를 입력하세요.");
      this.refUserPw1.focus();
      return;
    }
    if (userPw2.trim() === "") {
      alert("PW2를 입력하세요.");
      this.refUserPw2.focus();
      return;
    }

    // 패스워드 일치 여부를 확인
    if (userPw1.trim() !== userPw2.trim()) {
      alert("PW와 PW 확인이 일치하지 않습니다.");
      this.setState({ userPw1: "", userPw2: "" });
      this.refUserPw1.focus();
      return;
    }

    // 입력 내용을 alert 창으로 출력
    alert(`ID: ${userId}\nPW1: ${userPw1}\nPW2: ${userPw2}`);
  };

  render() {
    const { userId, userPw1, userPw2 } = this.state;

    return (
      <div>
        ID:{" "}
        <input
          ref={(x) => (this.refUserId = x)}
          type="text"
          value={userId}
          name="userId"
          onChange={this.changeUser}
        />
        <br />
        PW:{" "}
        <input
          ref={(x) => (this.refUserPw1 = x)}
          type="password"
          value={userPw1}
          name="userPw1"
          onChange={this.changeUser}
        />
        <br />
        PW:{" "}
        <input
          ref={(x) => (this.refUserPw2 = x)}
          type="password"
          value={userPw2}
          name="userPw2"
          onChange={this.changeUser}
        />
        <br />
        <button type="submit" onClick={this.clickButton}>
          등록
        </button>
      </div>
    );
  }
}

export default IdPwChecker;

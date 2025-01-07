import { Component } from "react";

class Counter extends Component {
  constructor(props) {
    super(props);
    this.state = {
      number: 0,
      fixedNumber: 10,
    };
  }

  render() {
    const { number, fixedNumber } = this.state;
    return (
      <>
        <h1>{number}</h1>
        <button
          onClick={() => {
            // console.log(number);
            // number += 1;

            /* this.setState({ number: number + 1 });
            // 5번 호출 하더라도 1씩만 증가 <= number가 전부 같은 값을 가짐
            this.setState({ number: number + 1 });
            this.setState({ number: number + 1 });
            this.setState({ number: number + 1 });
            this.setState({ number: number + 1 }); */

            // Updater 함수를 이용
            /* this.setState((prevState) => ({ number: prevState.number + 1 }));
            this.setState((prevState) => ({ number: prevState.number + 1 }));
            this.setState((prevState) => ({ number: prevState.number + 1 }));
            this.setState((prevState) => ({ number: prevState.number + 1 }));
            this.setState((prevState) => ({ number: prevState.number + 1 })); */

            this.setState({ number: number + 1 }, () => {
              console.log(
                "방금 setState가 호출되었습니다.",
                this.state,
                number
              );
            });
          }}
        >
          하나증가
        </button>
        <h1>{fixedNumber}</h1>
      </>
    );
  }
}

export default Counter;

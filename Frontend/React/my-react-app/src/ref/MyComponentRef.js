import { Component, createRef } from "react";

class MyComponentRef extends Component {
  constructor(props) {
    super(props);
    this.myRef = createRef();
  }
  render() {
    return (
      <>
        {/* React.createRef() API */}
        <input ref={this.myRef} />
        <button onClick={this.handler}>포커스전달1</button>

        {/* 콜백 ref */}
        <input ref={(x) => (this.myInput = x)} />
        <button onClick={() => this.myInput.focus()}>포커스전달2</button>
      </>
    );
  }
  handler = () => {
    const node = this.myRef.current;
    node.focus();
  };
}

export default MyComponentRef;

import { useState } from "react";

function BoilingVerdict({ celsius }) {
  if (celsius >= 100) {
    return <div>The water would boil.</div>;
  } else {
    return <div>The water would not boil.</div>;
  }
}

function toCelsius(fahrenheit) {
  return ((fahrenheit - 32) * 5) / 9;
}

function toFahrenheit(celsius) {
  return (celsius * 9) / 5 + 32;
}

// 화씨, 섭씨를 변경하기 전 입력값 검증과 변경 후 일정한 형식으로 반올림하는 로직
function tryConvert(temperature, convert) {
  const input = parseFloat(temperature);
  if (Number.isNaN(input)) {
    return "";
  }

  const output = convert(input);
  const rounded = Math.round(output * 1000) / 1000;
  return rounded.toString();
}

const scaleNames = {
  c: "Celsius",
  f: "Fahrenheit",
};

function Temperature({ scale, changeTemparature, temperature }) {
  /* 변경된 내용을 부모 컴포넌트로 전달하므로, 상태 변수를 부모 컴포넌트에서 관리해야 함
  const [temperature, setTemperature] = useState(0);
  const handleChange = (e) => {
    setTemperature(e.target.value);
  }; */

  const handleChange = (e) => {
    changeTemparature(e.target.value);
  };

  return (
    <>
      <fieldset>
        <legend>Enter temperature in {scaleNames[scale]}:</legend>
        <input value={temperature} onChange={handleChange} />
      </fieldset>
    </>
  );
}

function CelsiusFahrenheit() {
  const [temperature, setTemperature] = useState("");
  const [scale, setScale] = useState("c");

  // 화씨 온도가 입력된 경우 호출될 함수
  const changeFahrenheit = (t) => {
    setTemperature(t);
    setScale("f");
  };

  // 섭씨 온도가 입력된 경우 호출될 함수
  const changeCelsius = (t) => {
    setTemperature(t);
    setScale("c");
  };

  const celsius =
    scale === "f" ? tryConvert(temperature, toCelsius) : temperature;
  const fahrenheit =
    scale === "c" ? tryConvert(temperature, toFahrenheit) : temperature;

  return (
    <>
      <Temperature
        scale="c"
        changeTemparature={changeCelsius}
        temperature={celsius}
      />
      <Temperature
        scale="f"
        changeTemparature={changeFahrenheit}
        temperature={fahrenheit}
      />
      <BoilingVerdict celsius={celsius} />
    </>
  );
}

export default CelsiusFahrenheit;

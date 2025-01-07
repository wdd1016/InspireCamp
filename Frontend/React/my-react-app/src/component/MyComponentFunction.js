// 매개변수를 받을 때, 구조 분해 할당
function MyComponentFunction({
  name = "아무개",
  age = 0,
  nickname = "없음",
  children,
}) {
  // console.log(props);

  // const { name, age, nickname } = props;
  return (
    <>
      <h1>이름은 {name}입니다.</h1>
      <h2>나이는 {age}살 입니다.</h2>
      <h2>별명은 {nickname}입니다.</h2>
      <div>{children}</div>
    </>
  );
}

export default MyComponentFunction;

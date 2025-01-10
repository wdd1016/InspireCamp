import { useEffect, useState } from "react";

// 사용자 이름과 별명을 관리
function InfoChild() {
  const [name, setName] = useState("");
  const [nickname, setNickname] = useState("");

  const changeName = (e) => {
    setName(e.target.value);
  };
  const changeNickname = (e) => {
    setNickname(e.target.value);
  };

  /*
  // 의존성 배열을 생략 => 마운트, 업데이트 모두 이펙트 함수를 실행
  useEffect(() => {
    console.log("렌더링이 완료되었습니다.");
    console.log({
      name,
      nickname,
    });
  });
  */

  // 의존성 배열을 빈 배열로 설정 => 마운트 시에만 이펙트 함수를 실행
  useEffect(() => {
    console.log("렌더링이 완료되었습니다.");
    console.log({
      name,
      nickname,
    });

    // componentWillUnmount 메서드와 동일
    return () => {
      console.log("cleanup", name); // name의 값을 가져올 수 없음 => useRef를 사용해야 한다.
    };
  }, []);

  // // 마운트될 때와 name 상태변수의 값이 변경될 때 이펙트 함수를 실행
  // useEffect(() => {
  //   console.log("렌더링이 완료되었습니다.");
  //   console.log({
  //     name,
  //     nickname,
  //   });

  //   // name 상태변수가 변경되거나 컴포넌트가 언마운트될 때 실행
  //   return () => {
  //     console.log("cleanup", name);
  //   };
  // }, [name]);

  return (
    <>
      <div>
        <p>이름: {name}</p>
        <p>별명: {nickname}</p>
      </div>
      <div>
        <p>
          이름:{" "}
          <input
            type="text"
            name="name"
            value={name}
            onChange={changeName}
          ></input>
        </p>
        <p>
          별명:{" "}
          <input
            type="text"
            name="nickname"
            value={nickname}
            onChange={changeNickname}
          ></input>
        </p>
      </div>
    </>
  );
}

function Info() {
  const [isVisible, setIsVisible] = useState(false);

  const changeIsVisible = () => setIsVisible(!isVisible);

  return (
    <>
      <button onClick={changeIsVisible}>
        {isVisible ? "숨기기" : "보이기"}
      </button>
      {isVisible && <InfoChild />}
    </>
  );
}

export default Info;

import {
  BrowserRouter,
  useParams,
  Routes,
  Route,
  Link,
} from "react-router-dom";
import Home from "../Home";
import About from "../About";

const users = {
  mrgo: {
    name: "고길동",
    desc: "둘리를 싫어하는 자",
  },
  mrhong: {
    name: "홍길동",
    desc: "호부호형을 원하는 자",
  },
};

// http://localhost:3000/profile/mrgo
//                               ~~~~
//                               userid 변수 이름으로 전달
//                               주소에 포함된 사용자 식별자(여기에서는 userid)에 해당하는 사용자 정보를 출력
function Profile() {
  // 주소에 포함된 파라미터를 추출
  const params = useParams(); // -> 객체로 반환됨

  // 파라미터에서 userid의 값을 추출 -> users 객체에서 키로 사용하여 값을 찾아옴
  const profile = users[params.userid];

  return (
    <>
      {profile ? (
        <>
          <h1>{profile.name}</h1>
          <h2>{profile.desc}</h2>
        </>
      ) : (
        <h1>일치하는 사용자가 없습니다.</h1>
      )}
    </>
  );
}

function Parameter() {
  return (
    <BrowserRouter>
      <ul>
        <li>
          <Link to="/">홈</Link>
        </li>
        <li>
          <Link to="/about">소개</Link>
        </li>
        <li>
          <Link to="/info">정보</Link>
        </li>
        <br />
        <li>
          <Link to="/profile/mrgo">고길동 프로파일</Link>
        </li>
        <li>
          <Link to="/profile/mrhong">홍길동 프로파일</Link>
        </li>
        <li>
          <Link to="/profile/none">없는 프로파일</Link>
        </li>
      </ul>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/info" element={<About />} />
        <Route path="/profile/:userid" element={<Profile />} />
      </Routes>
    </BrowserRouter>
  );
}

export { Parameter, Profile };

import {
  BrowserRouter,
  useLocation,
  useSearchParams,
  Routes,
  Route,
  Link,
} from "react-router-dom";
import Home from "../Home";
import qs from "qs";

function QuerySearchParams() {
  const [searchParams, setSearchParams] = useSearchParams();
  const detail = searchParams.get("detail");

  return (
    <div>
      <h1>About</h1>
      <h2>리액트 라우트 연습</h2>
      {/* 쿼리 스트링으로 전달되는 모든 값은 문자열 타입이므로 "true"와 비교 */}
      {detail === "true" && <h2>상세 내역입니다.</h2>}
    </div>
  );
}

function QueryUseLocation() {
  // useLocation 훅 함수 ⇒ location 객체를 반환
  const location = useLocation();
  // pathname: 현재 주소의 경로 (쿼리 스트링 제외)
  // search: ? 문자를 포함한 쿼리 스트링 값 ⇒ 예) ?name=hong&age=23&phone=01029822002
  // hash: 주소의 # 문자열 뒤의 값
  // state: 페이지로 이동할 때 임의로 넣을 수 있는 상태 값
  // key: location 객체의 고유 값

  // 쿼리 문자열을 이름, 값 형식으로 반환 (ex) { name: "hong", age: 23 })
  const queries = qs.parse(location.search, { ignoreQueryPrefix: true });
  console.log(queries);

  return (
    <div>
      <h1>About</h1>
      <h2>리액트 라우트 연습</h2>
      {/* 쿼리 스트링으로 전달되는 모든 값은 문자열 타입이므로 "true"와 비교 */}
      {queries.detail === "true" && <h2>상세 내역입니다.</h2>}
    </div>
  );
}

export default function QueryString() {
  return (
    <BrowserRouter>
      <ul>
        <li>
          <Link to="/">홈</Link>
        </li>
        <li>
          <Link to="/about">소개 useLocation</Link>
        </li>
        <li>
          <Link to="/info">소개 searchParams</Link>
        </li>
      </ul>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<QueryUseLocation />} />
        <Route path="/info" element={<QuerySearchParams />} />
      </Routes>
    </BrowserRouter>
  );
}

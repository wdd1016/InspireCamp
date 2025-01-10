import { Navigate } from "react-router-dom";

export default () => {
  const isLoggedIn = false;

  if (!isLoggedIn) {
    return <Navigate to="/login" replace={true} />;
    // 프로파일에서 마이페이지로 이동하면 히스토리에 다음과 같이 기록 ⇒ /profile → /login
    // 이전 페이지로 이동을 클릭하면 ⇒ /profile ⇐ 프로파일 페이지가 보여짐

    // return <Navigate to="/login" replace={false} />;
    // 프로파일에서 마이페이지로 이동하면 히스토리에 다음과 같이 기록 ⇒ /profile → /mypage → /login
    // 이전 페이지로 이동을 클릭하면 ⇒ /mypage → /login ⇐ 계속해서 로그인 페이지가 보여짐
  }

  return <h1>마이 페이지</h1>;
};

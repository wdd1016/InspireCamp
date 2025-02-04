import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

export default function BoardList() {
  const [datas, setDatas] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/v2/board")
      .then((response) => {
        response && response.data && setDatas(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return (
    <>
      <div className="container">
        <h2>게시판 목록</h2>
        <table className="board_list">
          <colgroup>
            <col width="15%" />
            <col width="*" />
            <col width="15%" />
            <col width="20%" />
          </colgroup>
          <thead>
            <tr>
              <th scope="col">글번호</th>
              <th scope="col">제목</th>
              <th scope="col">조회수</th>
              <th scope="col">작성일</th>
            </tr>
          </thead>
          <tbody>
            {datas.length > 0 &&
              datas.map((board) => (
                <tr key={board.boardIdx}>
                  <td>{board.boardIdx}</td>
                  <td className="title">
                    <Link to={`/detail/${board.boardIdx}`}>{board.title}</Link>
                  </td>
                  <td>{board.hitCnt}</td>
                  <td>{board.createdDt}</td>
                </tr>
              ))}
            {datas.length === 0 && (
              <tr>
                <td colSpan="4">조회된 결과가 없습니다.</td>
              </tr>
            )}
          </tbody>
        </table>
        <Link to="/write" className="btn">
          글쓰기
        </Link>
      </div>
    </>
  );
}

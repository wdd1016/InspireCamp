import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

export default function BookList() {
  const [datas, setDatas] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/book")
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
        <h2>Rest api 책 목록</h2>
        <table className="book_list">
          <colgroup>
            <col width="15%" />
            <col width="*" />
            <col width="15%" />
            <col width="20%" />
          </colgroup>
          <thead>
            <tr>
              <th scope="col">책번호</th>
              <th scope="col">제목</th>
              <th scope="col">작가</th>
              <th scope="col">출판일</th>
            </tr>
          </thead>
          <tbody>
            {datas &&
              datas.length > 0 &&
              datas.map((book) => (
                <tr key={book.bookId}>
                  <td>{book.bookId}</td>
                  <td className="title">
                    <Link to={`/detail/${book.bookId}`}>{book.title}</Link>
                  </td>
                  <td>{book.author}</td>
                  <td>{book.publishedDate}</td>
                </tr>
              ))}
            {datas && datas.length === 0 && (
              <tr>
                <td colSpan="4">조회된 결과가 없습니다.</td>
              </tr>
            )}
          </tbody>
        </table>
        <Link to="/register" className="btn">
          책 등록
        </Link>
      </div>
    </>
  );
}

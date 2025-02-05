import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

export default function BookDetail() {
  const [book, setBook] = useState({});
  const [description, setDescription] = useState("");

  // 객체 비구조화
  const { bookId } = useParams();

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/book/${bookId}`)
      .then((res) => {
        res && res.data && setBook(res.data);
        res && res.data && setDescription(res.data.description);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  const navigate = useNavigate();

  const listButtonClick = (e) => {
    e.preventDefault();
    navigate("/list");
  };

  const updateButtonClick = (e) => {
    e.preventDefault();
    axios
      .put(`http://localhost:8080/api/book/${bookId}`, {
        description,
      })
      .then((res) => {
        res && res.status === 200 && navigate(`/list`);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const deleteButtonClick = (e) => {
    e.preventDefault();
    axios
      .delete(`http://localhost:8080/api/book/${bookId}`)
      .then((res) => {
        res && res.status === 200 && navigate(`/list`);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  return (
    <>
      <div className="container">
        <h2>Rest api 도서 상세</h2>
        <form id="frm" method="post">
          <input type="hidden" name="bookId" value={book.bookId || ""} />

          <table className="book_detail">
            <colgroup>
              <col width="15%" />
              <col width="*" />
              <col width="15%" />
              <col width="35%" />
            </colgroup>
            <tbody>
              <tr>
                <th>도서 제목</th>
                <td>{book.title}</td>
                <th>저자</th>
                <td>{book.author}</td>
              </tr>
              <tr>
                <th>출판사</th>
                <td>{book.publisher}</td>
                <th>출판일</th>
                <td>{book.publishedDate}</td>
              </tr>
              <tr>
                <th>ISBN</th>
                <td>{book.isbn}</td>
              </tr>
              <tr>
                <td colSpan="4">
                  <textarea
                    id="description"
                    name="description"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                  ></textarea>
                </td>
              </tr>
              <tr>
                <th>생성 시각</th>
                <td>{book.createdAt}</td>
                <th>수정 시각</th>
                <td>{book.updatedAt}</td>
              </tr>
            </tbody>
          </table>
        </form>
        {book.fileInfo && (
          <div>
            <a
              href={
                book.fileInfo.imageUrl.startsWith("http")
                  ? book.fileInfo.imageUrl
                  : `http://localhost:8080${book.fileInfo.imageUrl}`
              }
              download
            >
              <img
                src={
                  book.fileInfo.imageUrl.startsWith("http")
                    ? book.fileInfo.imageUrl
                    : `http://localhost:8080${book.fileInfo.imageUrl}`
                }
                alt="이미지"
                style={{
                  maxWidth: "300px",
                  maxHeight: "300px",
                  width: "auto",
                  height: "auto",
                }}
              />
            </a>
          </div>
        )}
        <input
          type="button"
          id="list"
          className="btn"
          value="목록으로"
          onClick={listButtonClick}
        />
        <input
          type="button"
          id="update"
          className="btn"
          value="수정하기"
          onClick={updateButtonClick}
        />
        <input
          type="button"
          id="delete"
          className="btn"
          value="삭제하기"
          onClick={deleteButtonClick}
        />
      </div>
    </>
  );
}

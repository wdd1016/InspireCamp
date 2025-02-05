import axios from "axios";
import { useRef, useState } from "react";
import { useNavigate } from "react-router-dom";

export default function BookRegister() {
  const [title, setTitle] = useState("");
  const [author, setAuthor] = useState("");
  const [publisher, setPublisher] = useState("");
  const [publishedDate, setPublishedDate] = useState("");
  const [isbn, setIsbn] = useState("");
  const [description, setDescription] = useState("");

  const changeTitle = (e) => setTitle(e.target.value);
  const changeAuthor = (e) => setAuthor(e.target.value);
  const changePublisher = (e) => setPublisher(e.target.value);
  const changePublishedDate = (e) => setPublishedDate(e.target.value);
  const changeIsbn = (e) => setIsbn(e.target.value);
  const changeDescription = (e) => setDescription(e.target.value);

  const refFiles = useRef();

  const [files, setFiles] = useState([]);
  const changeFiles = (e) => {
    const files = e.target.files;
    setFiles([...files]);
  };

  const navigate = useNavigate();

  const handlerSubmit = (e) => {
    e.preventDefault();

    const formData = new FormData();

    const data = { title, author, publisher, publishedDate, isbn, description };
    formData.append("book", JSON.stringify(data));
    if (files.length > 0) {
      formData.append("files", files[0]);
    }

    console.log(data);

    axios({
      method: "post",
      url: "http://localhost:8080/api/book",
      data: formData,
      headers: { "Content-Type": "multipart/form-data" },
    })
      .then((res) => {
        res && navigate("/list");
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <>
      <div className="container">
        <h2>Rest api 도서 등록</h2>
        <form id="frm" onSubmit={handlerSubmit}>
          <table className="book_detail">
            <tbody>
              <tr>
                <td>도서 제목</td>
                <td>
                  <input
                    type="text"
                    id="title"
                    name="title"
                    onChange={changeTitle}
                  />
                </td>
              </tr>
              <tr>
                <td>저자</td>
                <td>
                  <input
                    type="text"
                    id="author"
                    name="author"
                    onChange={changeAuthor}
                  />
                </td>
              </tr>
              <tr>
                <td>출판사</td>
                <td>
                  <input
                    type="text"
                    id="publisher"
                    name="publisher"
                    onChange={changePublisher}
                  />
                </td>
              </tr>
              <tr>
                <td>출판일</td>
                <td>
                  <input
                    type="date"
                    id="publishedDate"
                    name="publishedDate"
                    onChange={changePublishedDate}
                  />
                </td>
              </tr>
              <tr>
                <td>ISBN</td>
                <td>
                  <input
                    type="number"
                    id="isbn"
                    name="isbn"
                    onChange={changeIsbn}
                  />
                </td>
              </tr>
              <tr>
                <td colSpan="2">
                  <textarea
                    id="description"
                    name="description"
                    onChange={changeDescription}
                  ></textarea>
                </td>
              </tr>
            </tbody>
          </table>
          <input
            ref={refFiles}
            onChange={changeFiles}
            type="file"
            id="files"
            name="files"
          />
          <input type="submit" id="submit" value="저장" className="btn" />
        </form>
      </div>
    </>
  );
}

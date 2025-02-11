import axios from "axios";
import { useRef, useState } from "react";
import { useNavigate } from "react-router-dom";

export default function BoardWrite() {
  const [title, setTitle] = useState("");
  const [contents, setContents] = useState("");

  const changeTitle = (e) => setTitle(e.target.value);
  const changeContents = (e) => setContents(e.target.value);

  const refFiles = useRef();

  const [files, setFiles] = useState([]);
  const changeFiles = (e) => {
    const files = e.target.files;

    if (files.length > 3) {
      alert("이미지는 최대 3개까지만 업로드 가능합니다.");
      refFiles.current.value = "";
      setFiles([]);
      return;
    }

    setFiles([...files]);
  };

  const formData = new FormData();

  const data = { title, contents };
  formData.append("board", JSON.stringify(data));

  Object.values(files).forEach((file) => {
    formData.append("files", file);
  });

  const navigate = useNavigate();

  const handlerSubmit = (e) => {
    e.preventDefault();

    const token = sessionStorage.getItem("token");

    axios({
      method: "post",
      url: "http://localhost:8080/api/v2/board",
      data: formData,
      headers: {
        "Content-Type": "multipart/form-data",
        Authorization: `Bearer ${token}`,
      },
    })
      .then((res) => {
        res & navigate("/list");
      })
      .catch((err) => {
        console.log(err);
        if (error.status === 401) {
          alert("[인증 토큰 누락] 로그인 후 다시 시도해 주세요.");
        } else if (error.status === 403) {
          alert("[인증 토큰 오류] 로그인 후 다시 시도해 주세요.");
        }
        navigate("/");
      });
  };

  return (
    <>
      <div className="container">
        <h2>게시판 등록</h2>
        <form id="frm" onSubmit={handlerSubmit}>
          <table className="board_detail">
            <tbody>
              <tr>
                <td>제목</td>
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
                <td colSpan="2">
                  <textarea
                    id="contents"
                    name="contents"
                    onChange={changeContents}
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
            multiple="multiple"
          />
          <input type="submit" id="submit" value="저장" className="btn" />
        </form>
      </div>
    </>
  );
}

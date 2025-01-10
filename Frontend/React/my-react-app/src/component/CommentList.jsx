import Comment from "./Comment";

/*
const comments = [
  {
    name: "홍길동",
    comment: "동쪽에 살아요.",
    picture:
      "https://png.pngtree.com/png-clipart/20190705/original/pngtree-vector-business-men-icon-png-image_4186858.jpg",
  },
  {
    name: "홍길남",
    comment: "남쪽에 살아요.",
    picture:
      "https://png.pngtree.com/png-clipart/20190630/original/pngtree-vector-avatar-icon-png-image_4162757.jpg",
  },
  {
    name: "고길동",
    comment: "둘리가 싫어요.",
    picture:
      "https://png.pngtree.com/png-clipart/20190520/original/pngtree-male-worker-icon-graphic-png-image_3668949.jpg",
  },
];
*/

/*
const users = [
  {
    name: "홍길동",
    picture:
      "https://png.pngtree.com/png-clipart/20190705/original/pngtree-vector-business-men-icon-png-image_4186858.jpg",
  },
  {
    name: "홍길남",
    picture:
      "https://png.pngtree.com/png-clipart/20190630/original/pngtree-vector-avatar-icon-png-image_4162757.jpg",
  },
  {
    name: "고길동",
    picture:
      "https://png.pngtree.com/png-clipart/20190520/original/pngtree-male-worker-icon-graphic-png-image_3668949.jpg",
  },
];
*/

const users = [
  {
    name: "홍길동",
    regno: "701010-1457934",
    picture:
      "https://png.pngtree.com/png-clipart/20190705/original/pngtree-vector-business-men-icon-png-image_4186858.jpg",
  },
  {
    name: "홍길남",
    regno: "201010-3457934",
    picture:
      "https://png.pngtree.com/png-clipart/20190630/original/pngtree-vector-avatar-icon-png-image_4162757.jpg",
  },
  {
    name: "고길동",
    regno: "211010-4157934",
    picture:
      "https://png.pngtree.com/png-clipart/20190520/original/pngtree-male-worker-icon-graphic-png-image_3668949.jpg",
  },
];

const comments = [
  {
    name: "홍길동",
    comment: "동쪽에 살아요.",
  },
  {
    name: "홍길남",
    comment: "남쪽에 살아요.",
  },
  {
    name: "고길동",
    comment: "둘리가 싫어요.",
  },
];

function getUserGender(name) {
  const regno = users.find((user) => user.name === name).regno;
  return [1, 3].includes(Number(regno[7])) ? "남" : "여";
}

const commentsWithPicture = comments.map((c) => ({
  ...c,
  picture: users.filter((u) => u.name === c.name)[0].picture,
  name: `${c.name} (${getUserGender(c.name)})`,
}));

function CommentList() {
  return (
    <>
      {/* {
        // 익명 함수 표현식
        comments.map(function (c, i) {
          return (
            <Comment
              key={i}
              name={c.name}
              comment={c.comment}
              picture={c.picture}
            />
          );
        })
      }
      {
        // 화살표 함수
        comments.map((c, i) => {
          return (
            <Comment
              key={i}
              name={c.name}
              comment={c.comment}
              picture={c.picture}
            />
          );
        })
      } */}
      {/* <h1>모두 출력</h1>
      {
        // 화살표 함수 축약
        comments.map((c, i) => (
          <Comment
            key={i}
            name={c.name}
            comment={c.comment}
            picture={c.picture}
          />
        ))
      }
      <h1>홍길동만 출력</h1>
      {
        // filter 메서드를 이용하는 경우
        comments
          .filter((c) => c.name === "홍길동")
          .map((c, i) => (
            <Comment
              key={i}
              name={c.name}
              comment={c.comment}
              picture={c.picture}
            />
          ))
      }
      {
        // && 연산자를 이용한 조건부 렌더링
        comments.map(
          (c, i) =>
            c.name === "홍길동" && (
              <Comment
                key={i}
                name={c.name}
                comment={c.comment}
                picture={c.picture}
              />
            )
        )
      }
      {
        // 삼항연산자를 이용
        comments.map((c, i) =>
          c.name === "홍길동" ? (
            <Comment
              key={i}
              name={c.name}
              comment={c.comment}
              picture={c.picture}
            />
          ) : null
        )
      } */}
      <h1>모두 출력</h1>
      {/* {comments.map((c, i) => (
        <Comment
          key={i}
          name={c.name}
          comment={c.comment}
          picture={users.find((user) => user.name === c.name).picture}
        />
      ))} */}
      {commentsWithPicture.map((c, i) => (
        <Comment
          key={i}
          name={c.name}
          comment={c.comment}
          picture={c.picture}
        />
      ))}
    </>
  );
}

export default CommentList;

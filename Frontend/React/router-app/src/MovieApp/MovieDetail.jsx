import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import YouTube from "react-youtube";

// 뒤로가기 했을때, 검색 결과가 삭제 (상태 삭제) 문제
// React Router로 페이지 전환 시 MovieList 컴포넌트가 완전히 언마운트(unmount)되었다가 다시 마운트(mount)되기 때문에, 컴포넌트 내부 상태(state)가 초기화되어 사라집니다. 이를 방지하려면 크게 2가지 전략이 있습니다.
// URL Query Parameter(쿼리 스트링)에 검색어를 넣어두고, 뒤로 돌아왔을 때도 그대로 유지
// location state(혹은 Context, Redux 등)로 검색 상태를 전역 혹은 상위에서 관리
// 가장 추천되는 방법은 “URL Query Parameter” 방식을 사용하는 것입니다. 이렇게 하면 뒤로가기를 해도 브라우저 주소(URL)에 쿼리 파라미터로 검색 키워드가 남아있어, 해당 값을 다시 불러올 수 있습니다.

const opts = {
  height: "390",
  width: "640",
  playerVars: {
    autoplay: 1,
  },
};

// http://localhost:5173/movieDetail/:movieid
export default function MovieDetail() {
  const params = useParams();
  const movieid = params.movieid;
  const [videos, setVideos] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [key, setKey] = useState("");

  // 컴포넌트가 마운트되었을 때 비디오 클립을 조회
  useEffect(() => {
    const endpoint = `https://api.themoviedb.org/3/movie/${movieid}/videos?api_key=9d2bff12ed955c7f1f74b83187f188ae`;
    axios
      .get(endpoint)
      .then((res) => {
        console.log(res);
        setVideos(res.data.results);
        setIsLoading(false);
      })
      .catch((err) => console.error(err));
  }, []);

  return (
    <>
      {isLoading && <h1>데이터를 가져오고 있습니다.</h1>}
      {!isLoading && videos.length === 0 && (
        <h1>등록된 비디오 클립이 존재하지 않습니다.</h1>
      )}
      {!isLoading &&
        videos.length !== 0 &&
        videos.map((video, index) => (
          <div
            key={index}
            style={{ fontSize: 20 }}
            onClick={() => setKey(video.key)}
          >
            {video.title} (출시일: {video.published_at.substring(0, 10)})
          </div>
        ))}
      {key && <YouTube videoId={key} opts={opts} />}
    </>
  );
}

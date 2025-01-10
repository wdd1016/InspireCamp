import { useState } from "react";
import axios from "axios";
import "./MovieList.css";
import { Link } from "react-router-dom";

export default function MovieList() {
  const [title, setTitle] = useState("");
  const [movies, setMovies] = useState([]);
  const [isSearch, setIsSearch] = useState(false);

  const searchMovie = () => {
    setIsSearch(true);

    const endpoint = `https://api.themoviedb.org/3/search/movie?api_key=9d2bff12ed955c7f1f74b83187f188ae&query=${title}`;

    axios
      .get(endpoint)
      .then((res) => {
        console.log(res);
        setMovies(res.data.results);
      })
      .catch((err) => {
        console.error(err);
      });
  };

  return (
    <div className="container">
      <h1>영화 조회</h1>
      <div className="search">
        <input
          type="text"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        <button onClick={searchMovie}>조회</button>
      </div>
      {isSearch && movies.length === 0 && (
        <div>일치하는 영화가 존재하지 않습니다.</div>
      )}
      {!isSearch && <div>검색할 영화 제목을 입력하세요.</div>}
      {movies.length !== 0 &&
        movies.map((movie, idx) => (
          <div key={movie.id} className="movie">
            <div className="poster">
              <img
                src={`https://image.tmdb.org/t/p/w500${movie.poster_path}`}
                alt={movie.title}
              />
            </div>
            <div className="text">
              <h1>
                <Link to={`/movieDetail/${movie.id}`}>{movie.title}</Link>
              </h1>
              <div>{movie.overview}</div>
            </div>
          </div>
        ))}
    </div>
  );
}

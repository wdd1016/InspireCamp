import News from "./News";
import Blog from "./Blog";

const Contents = ({ theme }) => {
  return (
    <>
      <Blog theme={theme} />
      <News theme={theme} />
    </>
  );
};

export default Contents;

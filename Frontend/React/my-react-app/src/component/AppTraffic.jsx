import TrafficLight from "./TrafficLight";

function AppTraffic() {
  const tlSize = 100;
  const tlColors = ["red", "blue", "green", "yellow"];

  return (
    <>
      <TrafficLight size={tlSize} colors={tlColors} />
    </>
  );
}

export default AppTraffic;

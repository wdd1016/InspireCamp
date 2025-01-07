function Lamp({ size, color }) {
  return (
    <div
      style={{
        width: size,
        height: size,
        borderRadius: size / 2,
        backgroundColor: color,
      }}
    />
  );
}

export default function TrafficLight({ size, colors }) {
  return (
    <>
      {colors.map((color) => {
        return <Lamp color={color} size={size}></Lamp>;
      })}
    </>
  );
}

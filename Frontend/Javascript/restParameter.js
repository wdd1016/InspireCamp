/*
function sum(a, b) {
    const result = a + b;
    console.log(result);
}
*/
function sum(...args) {
  console.log(args);
  let result = 0;
  for (let i = 0; i < args.length; i++) {
    result += args[i];
  }
  console.log(result);
}

sum(10, 20); // 30
sum(10, 20, 30); // 60
sum(10, 20, 30, 40); // 100

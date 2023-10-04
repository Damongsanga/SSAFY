function func() {
  return function (num1, num2) {
    return num1 + num2;
  };
}

function func2() {}

console.log(func()(100, 200));
console.log(func2());
console.log(func()(100));

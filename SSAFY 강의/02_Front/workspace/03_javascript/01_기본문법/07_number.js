let num1 = 10;
let num2 = 3.14;
let num3 = 1e9;
let num4 = Infinity;
let num5 = -Infinity;
let num6 = NaN;
let num7 = 0b01000001; // 2진수 binary
let num8 = 0o101; // 8진수 octal
var num9 = 0x41; // 16진수 hex

// 10 / 5 = 2
// 10 / 3 = 3.3333333 => 정확하지 않음
let x = 0.3 - 0.2; // 컴퓨터에서 부동소수점 근사값이다. 정확하지 않다. 
let y = 0.2 - 0.1;
console.log(x == y);
console.log(x);
console.log(y);

let a = 0.3;
let b = 0.2;
console.log((a * 10 - b * 10) / 10 == 0.1);

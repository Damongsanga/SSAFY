let num1 = 10; 
let num2 = 10.2;
let msg = "hi";
let bool = true; 
let nullVal = null; 
let unVal; 
let obj = {}; 
let obj2 = new Object(); 
let symbol = Symbol();

// 데이터 타입의 확인에는 typeof 연산자 사용
console.log(typeof num1);
console.log(typeof num2);
console.log(typeof msg);
console.log(typeof bool);
console.log(typeof nullVal); // null -> object
console.log(typeof unVal); // undefined -> undefined
console.log(typeof obj);
console.log(typeof obj2);
console.log(typeof symbol);

console.log('-----------------')

let a = "haha";
console.log(typeof a); // string
a = 123;
console.log(typeof a); // number
a = false;
console.log(typeof a); // boolean
a = {
  a: 123,
};
console.log(typeof a); // object
a = [1, 2, 3, 4];
console.log(typeof a); // object
a = null;
console.log(typeof a); // object
a = undefined;
console.log(typeof a); // undefined

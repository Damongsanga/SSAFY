/* let */
// let은 블록 스코프이다.

let age = 222;
{
  let age = 333;
  // let의 입장에서 여기는 다른 세계.
}
console.log(age);
// let age = 111;

// 함수 스코프도 스코프로 인정
let b = 2222;
function fun(){
  let b = 3333;
}
console.log(b);

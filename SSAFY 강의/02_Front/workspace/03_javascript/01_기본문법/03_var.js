/* var */
console.log(bottom); // undefined; => Hoisting
// 1. 준비 단계에서 미리 메모리 공간 확보

var bottom = "Hello";
console.log(bottom); // Hello

var bottom = "Hi"; // 재선언, 재할당 가능
console.log(bottom);

// var -> 함수 스코프 O vs. 블록 스코프 { } X
// 함수 스코프만 스코프로 인정,
// 블록 스코프는 인정하지 않는다.
var age = 30;
function fun(){
  var age = 10;
  console.log(age);
}
fun();
console.log(age);

var age2 = 222;
{
  var age2 = 333;
}
console.log(age2);


let arr = ["kim", "lee", "yeo", "jeon"];

let str = JSON.stringify(arr);
console.log(str);

// JavaScript Array 메서드
// 배열 순회
// - 전통적인 for(for문)
// - for of(for문)
// - forEach(array 메서드)

// cf. for in(for문) => 객체의 속성을 순회할 때

for(student of arr){
  console.log(student);
}
// 이렇게 할수도 있지만...
// forEach(함수)
// 함수의 매개변수에 값이 하나씩 들어온다
arr.forEach(function(student){
  console.log(student);
})

// Array 메서드는 보통 화살표 함수랑 같이 쓰인다.
// 간결하니까..
// 화살표 함수 만드는 법
// 1. function 키워드 제거
// 2. () 안에 파라미터
// 3. ()와 {} 사이에 => 작성
// 4. {} 안에 함수의 내용 작성
// 5. 만약 {}안의 내용이 return 한줄이라면,
//   {}와 return도 생략 가능

arr.forEach((student) => {
  console.log(student);
})

let add = function(a, b){
  return a+b;
}
let add2 = (a,b) => {
  return a+b;
}
let add3 = (a,b) => a+b;

console.log(add(1,2));
console.log(add2(1,2));
console.log(add3(1,2));


// Array 메서드 map, filter
// map -> 새로운 배열을 만들 때
//    => 새로운 값을 반환
// filter -> 원하는 값만 골라내서 새로운 배열을 만들때
//    => true, false 반환 => true이면 포함, false이면 제외

let arr2 = [1, 2, 3, 4];

let arr3 = arr2.map(function(num) {
  return num * 2;
})
console.log(arr3);

// let arr4=[];
// for(let i=0; i<arr2.length; i++){
//   arr4[i] = arr2[i] * 2;
// }

let arr4 = arr2.filter((num) => num % 2 === 1);
console.log(arr4);

let a = 0;
if(a++ === 0){
  console.log("실행될까?");
}

let b = '0';
if(b === 0){
  console.log("실행될까? -2");
}

if(b++ === 0){
  console.log("실행될까? -3");
}

let c = '0';
console.log(typeof c, c);
console.log(c++);
console.log(typeof c);

let d = '0';
console.log(typeof (+d));

let e = '0';
console.log(typeof (-e));

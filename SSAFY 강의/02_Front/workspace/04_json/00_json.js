let student = {
  name: "이호진",
  age: 20,
  hobbies: ["춤추기", "숙면", "클라이밍"],
}

console.log(student);

// JavaScript Object => JSON String
// JSON.stringify

let str = JSON.stringify(student);
console.log(str);

let someStr = '{"name":"이호진","age":20,"hobbies":["춤추기","숙면","클라이밍"]}';

// JSON string(data) => JavaScript Object
// JSON.parse

let student2 = JSON.parse(someStr);
console.log(student2);

console.log(typeof(student)); // () 함수처럼
console.log(typeof str); // 연산자처럼
console.log(typeof(someStr));
console.log(typeof student2);

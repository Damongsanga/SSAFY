let student = {
  name: "김싸피",
  age: 20,
  hobby: ["공부", "숙면"],
  "favorite singer": "아이유",
};

// 프로퍼티 읽기
console.log(student.name);
console.log(student["favorite singer"]);

// 프로퍼티 생성
student.major = "Java";
console.log(student);

// 프로퍼티 수정
student.age = 30;
console.log(student);

// 프로퍼티 제거
delete student.name;
console.log(student);

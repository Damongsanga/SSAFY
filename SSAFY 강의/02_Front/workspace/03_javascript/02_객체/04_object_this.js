// 함수 안에서 this는 함수를 호출한 객체이다.
// 그 메서드를 가지고 있는 객체

let m1 = { name: "홍길동" , msg2: function(){
  console.log(this);
}};
let m2 = { name: "배수지" };

function msg() {
  console.log(this);
  console.log(this.name + "님이 입장합니다.");
}

m1.msg = msg;
m2.msg = msg;
m1.msg();
m1.msg2();
m2.msg();

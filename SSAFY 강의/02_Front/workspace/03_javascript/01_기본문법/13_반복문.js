
outer: for(let i=0; i<10; i++){
  console.log(i)
  for(let j=0; j<10; j++){
    if(i===1 && j===2){
      console.log('for문을 벗어납니다.')
      break outer;
    }
  }
}

let j = 0;
while (j < 10) {
  j++;
}

do {
  j++;
} while (j < 10);


let student = {
  name: "김싸피",
  age: 20,
  hobby: ["공부", "숙면"],
  "favorite singer": "아이유",
  method1: function(){
    console.log()
  }
};
// 객체의 속성을 순회하고 싶을 때 => for in
for(key in student){
  console.log(`${key} => ${student[key]}`);
}


let food = ["김밥", "사이다"];
// 배열을 순회하고 싶을 때 => for of
for(val of food){
  console.log(val);
}

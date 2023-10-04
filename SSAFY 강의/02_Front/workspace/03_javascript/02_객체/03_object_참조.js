let member1 = { id: "hong", email: "hong@a.com" };
let member2 = member1; // 주소 복사
let member3 = { ...member1 }; // 값 복사
member2.id = "yang";

console.log(member1.id);
console.log(member2.id);
console.log(member3.id);

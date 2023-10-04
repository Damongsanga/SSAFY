let arr = [];
// let arr2 = new Array();

arr[0] = 10;
arr[2] = 20;
console.log(arr);
console.log(arr[1]); // undefined

console.log(arr[4]);
console.log(arr);

arr["msg"] = "이게 될까?";
console.log(arr);

// 메서드
arr.push(30); // 배열의 가장 뒤에 추가
console.log(arr);
console.log(arr.pop()); // 배열에서 가장 마지막 제거
console.log(arr);
arr.unshift(-10); // 배열의 가장 앞에 추가
console.log(arr);
console.log(arr.shift()); // 배열의 가장 앞 제거
console.log(arr);
console.log(arr.includes(20));

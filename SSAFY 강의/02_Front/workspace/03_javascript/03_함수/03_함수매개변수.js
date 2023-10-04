function func(c) {
  c("hello");
}

let c = function(msg){
  console.log(msg);
}

function fn(msg) {
  console.log(msg);
}

func(fn);

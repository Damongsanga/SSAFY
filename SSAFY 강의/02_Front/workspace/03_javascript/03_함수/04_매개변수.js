function fn(num) {
  console.log(num);
  console.log(arguments);
}

fn();
fn(100);
fn(100, 100);

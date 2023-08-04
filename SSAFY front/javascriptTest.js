function solution(a, b) {
    let c = String(a) + String(b);
    let d = 2 * a * b;
    if (c < d) c=d;
    return Number(c);
}

console.log(solution(2, 91))
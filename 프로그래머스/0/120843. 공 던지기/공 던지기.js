function solution(numbers, k) {
    let index = 1;
    let thrower = 0;
    for (let i = 0; i < k; i++) {
        if (index === k) {
            return thrower + 1;
        }
        thrower = (thrower + 2) % numbers.length;
        index++;
    }
    return thrower + 1;
}
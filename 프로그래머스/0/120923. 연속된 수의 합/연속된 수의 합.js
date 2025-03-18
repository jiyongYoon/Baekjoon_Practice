function solution(num, total) {
    let middleNum = total / num;
    let count = num % 2 === 0 ? num / 2 : Math.ceil(num / 2) - 1;
    let startNum = Math.ceil(middleNum - count);

    let result = [];
    for (let i = 0; i < num; i++) {
        result.push(startNum++);
    }
    
    return result;
}
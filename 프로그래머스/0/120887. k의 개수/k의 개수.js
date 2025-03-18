function solution(i, j, k) {
    let arr = [];
    for (let l = i; l <= j; l++) {
        arr.push(l);
    }

    let result = 0;
    arr.map((x) => result += countK(x, k));
    return result;
}

function countK(x, k) {
    let splitArr = x.toString().split('');
    let count = 0;
    splitArr.map((x) => x === k.toString() ? count++ : count)
    return count;
}
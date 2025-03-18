function solution(myString, pat) {
    let arr = []
    for (let i = 0; i <= myString.length - pat.length; i++) {
        arr.push(myString.substring(i, i + pat.length));
    }
    
    return arr.filter((x) => x === pat).length;
}
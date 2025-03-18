function solution(myString, pat) {
    let result = 0;
    for (let i = 0; i <= myString.length - pat.length; i++) {
        let checkString = myString.substring(i, i + pat.length);
        if (checkString === pat) {
            result++;
        }
    }
    return result;
}
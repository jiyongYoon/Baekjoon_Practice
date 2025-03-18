const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    str = input[0];
    let inputArr = str.split('');
    let result = '';
    for (const string of inputArr) {
        let lowerCase = string.toLowerCase();
        if (string === lowerCase) {
            result += string.toUpperCase();
        } else {
            result += lowerCase;
        }
    }
    console.log(result);
});
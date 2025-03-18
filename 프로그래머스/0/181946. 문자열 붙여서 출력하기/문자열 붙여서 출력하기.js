const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    let result = '';
    input = line.split(' ');
    console.log(input.join(''));
}).on('close', function () {
    str1 = input[0];
    str2 = input[1];
});
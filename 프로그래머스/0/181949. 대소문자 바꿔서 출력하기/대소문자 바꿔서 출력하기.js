const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
    let inputArr = input[0].split('');
    console.log(inputArr.reduce((p, n) => {
       let toLowerCase = n.toLowerCase();
       if (n === toLowerCase) {
           return p + n.toUpperCase();
       } else {
           return p + toLowerCase;
       }
    }, ''));
}).on('close',function(){
    str = input[0];
});
// ㅇrefetnce.js (참조변수)

//배열선언
const names = ['조수연', '황진주', '권가희', '이유빈'];

for (let i = 0; i < names.length; i++) {
  console.log((i + 1) + '번째 이름 : ' + names[i]);
}

//enhaced for. for(String name : names){}
for (let name of names) {
  console.log(name);
}

const numbers = [23, 44, 38, 12, 56];
for (let num of numbers) {
  if (num > 40)
    console.log(num);
}


// const inputs = [];
// for(let i=0; i<numbers.length; i++){
//   var inputVal = prompt('값을 입력하세요...');
//   console.log(typeof inputVal, inputVal);
//   inputs[i] = inputVal;
// }

// 합계, 평균 :

const inputs = [];
for(let i=0; i<numbers.length; i++){
  var inputVal = prompt ('값을 입력하세요.')
  console.log(typeof inputVal, inputVal);
  inputs[i] = parseInt(inputVal);
}

let sum = 0;
let avg = 0;

for(let i=0; i<numbers.length; i++){
  sum += inputs[i];
}
avg = sum / inputs.length;
console.log(sum,avg);

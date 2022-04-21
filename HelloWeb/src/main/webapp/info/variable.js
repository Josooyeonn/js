// variable.js

var myName = '조수연'; // string
var yourzName; // undefined
myName = 100; // number
myName = true; // boolean
myName = null; // object

console.log(typeof Name);
yourName = "홍길동";
console.log(typeof yourName);

// 전역변수(스크립트 변수), 지역변수(함수안의 변수)

function checkInfo(){
  var myName = 'JoSooyeon';
  console.log(myName);
  var myName = 'JJJ';
}

checkInfo();
console.log(myName);

// ES6 (Ees2015) => lef, const
// let 블럭레벨 변수선언.

function info(checkInfo){
let myName='Hong';
console.log(myName);
}
info();

{
  let myName= 'Hong';
  console.log(myName);
}

{
  let myName= 'Hong';
  console.log(myName);
}

const otherName = 'hong';
// otherName= 'Hwang';

//var, let => 변수선언
//const => 상수선언


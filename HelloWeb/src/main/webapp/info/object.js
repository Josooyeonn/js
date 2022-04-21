// object.js

let member1 = {
  fullName: 'hong',
  age: 20,
  score: 80
};

let member2 = {
  fullName: 'Hwang',
  age: 22,
  score: 88
}

let member3 = {
  fullName: 'Park',
  age: 25,
  score: 92
}
// 자바 클래스의 instance와 유사함, 자바 스크립트 object

member1.fullName = '홍';
console.log(member1.fullName)
console.log(member1.age + member2.age);
// {key : value}, {key : value} = map

document.write('<h3>hong</h3>')

const members = [member1, member2, member3];

// 홍의 나이20, 점수 80입니다.

document.write('<ul>');
for (i = 0; i < members.length; i++) {
  console.log(members[i].fullName + '의 나이는' + members[i].age + '이고 점수는 ' + members[i].score + '입니다.');
  document.write('<li>' + members[i].fullName + '의 나이는' + members[i].age + '이고 점수는 ' + members[i].score + '입니다.' + '</li>' + '<br>')
  document.write(`<li> ${members[i].fullName} 의 나이는 ${members[i].age}이고 점수는 ${members[i].score}점 입니다.</li><br>`)
}
document.write('</ul>');

let welcome = `안녕하세요.
               반갑습니다.`
console.log(welcome)

// 전역병수 (스크립트 변수)


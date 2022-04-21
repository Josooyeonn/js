// page.js
console.log(member1);

let field = 'fullName';
console.log(member1.fullName)
console.log(member2['fullName'])
console.log(member3[field])

//배열 요소를 반복적으로 불러올때 for..of 사용
for(let member of members){
  console.log(`이름은 ${member[field]}이고 나이는 ${member.age}살이고 점수는 ${member.score}점 입니다.`)
}

//오브젝트의 속성(필드)을 반복적으로 for..in

for(let field in member1){
  console.log(`${field} => ${member1[field]}`) ;
}

// 각 배열요소의 각 필드를 출력.



for(let member of members){
  for(let prop in member){
    console.log(`${prop} => ${member[prop]}`);
  }
  console.log(`-----------------------`)
}


document.write('<table border=1>')

let fields = ['fullName','score','age'];
for(let member of members){
  document.write('<tr>')
  for(let prop of fields){
    console.log(`${prop} => ${member[prop]}`);
    document.write(`<td>${member[prop]}</td>`);
  }
  document.write('</tr>')
}
document.write('</table>')

document.write(`--------------------------------`)


document.write('<table border=1>')

let fields1 = ['fullName','score','age'];
for(let member of members){
  document.write('<tr>')
  for(let prop of fields1){
    console.log(`${prop} => ${member[prop]}`);
    document.write(`<td>${member[prop]}</td>`);
  }
  document.write(`<td><button>클릭</button></td>`)
  document.write('</tr>')
}
document.write('</table>')

document.write(`--------------------------------`)

document.write('<table border=1>')

let field2 = ['fullName','score','age'];
for(let member of members){
  document.write('<tr>')
  for(let prop of field2){
    console.log(`${prop} => ${member[prop]}`);
    document.write(`<td>${member[prop]}</td>`);
  }
  document.write(`<td><input type=checkbox></td>`)
  document.write('</tr>')
}
document.write('</table>')
"use strict"
// strict mode will not allow us to declare a vaiable in JavaScript without a keywork
// it must be declared with var, const, or let
// strict mode allows more "secure" javascript

let a = 'hello'; // by default this variable is declared with var

console.log(a);


let templateLiteral = ``;

templateLiteral = ` this is a multi-line template literal... this is
one of the benefits of a tmeplate literal
`;
console.log(templateLiteral);

templateLiteral = `Five plus Five = ${5+5}`;

console.log(templateLiteral);

let food = 'Hamburger';
food = 'Salad';
templateLiteral= `I would like 1 ${food}`;
console.log(templateLiteral);
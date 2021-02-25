/*
In Java
    .equals()
    ==

In JavaScript there are 2 equality operators which are == vs. ===

Both compare the objext on either side.


*/

function compare(first,second){

    console.log(`
    first = ${first}, and is of type ${typeof(first)}
    second = ${second} and is of type ${typeof(second)}

    first == second evaultes to ${first == second}
    first === second evaluates to ${first === second}
    `)
}

compare("10",10)

var obj1 = {
    a:1
}

var obj2 ={
    b:"1"
}

compare(obj1.a,obj2.b);


var me = "sophia";

var product = 'hi'*4;
console.log(product);

console.log(isNaN(product));

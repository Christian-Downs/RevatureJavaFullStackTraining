/*
    JavaScript is by default synchronous.

    This means that it executes our code line by line, block by block, in order.
*/

console.log('1');
console.log('2');
console.log(z);

var z = 7;
doSomething();
function doSomething(){
    console.log("done");
}
/*
    Asynchronous means that something will wait for a time to finish
    or a REQUEST to RESOND while the rest of code continues to executes
*/

console.log('1');

// this takes in a callback function
setTimeout(function afterTwoSeconds(){
       console.log('2')
}, 2000);


console.log('3');

/*
    our application isn't hanging around doing waiting 
*/ 


/*
    2 Main scopes in JS
    1. Global Scope -- variables declared here are accessible from ANYWHERE
        - variables declared outside of the function scope with VAR will be declared on global scope
    2. Functional Scope -- varibales declared within a function's block {}

    3. Lexical/Block scoping -- introduces in 2015 by ES6\
*/

// function funScope(){

//     var x = 'hello';

//     if(true){
//         var y = 'goodbye';
//     }

//     console.log(y);
// }

// console.log(x);

// funScope();
var scope = "I am global";

function whatIsMyScope(){
    var scope = "I am local (or functional)";
    function func(){
        console.log(scope)
    }
    return func();
}


whatIsMyScope();


//blovk scope (or Lexical scope) was introduced in 2015 with Ecma Script 6 aka ES6
// along with const and let
function blockScope(){
    let c = "cat";
    if(true){
        var d ="dog";
    }

    console.log(d);
}

blockScope();

var bob = readline();
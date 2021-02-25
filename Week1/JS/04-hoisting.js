// a hoisted variable measn that it is treated as if it were declared at the top fo the global scope;

console.log(myVariable);
var myVariable = 800;
//if we run the program from here,. it won't throw us an error

//the above is equivelent to:
var myVariable;
console.log(myVariable);
myVariable = 800;




var  myFunc = function(){
    console.log("Func variable is " + funcVariable);
    console.log("ifVairable is " + ifVariable);

    var funcVariable = "In function!";

    if(true){
        var ifVariable = "If block!"
    }
};

myFunc();


// hoisting is a JS mechanism in which variable (and function declarations) are moved to the top
// of their scope before code execution.
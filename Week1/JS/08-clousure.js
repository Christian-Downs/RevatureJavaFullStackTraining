/*
    What is closure? Closure is JS's attempt at encapsulation:
    It allows fo 2 things:
    1. allows for an inner function to acccess and enclosing functions's variables
    2. allows for an inner function to preserve an enclosing function's scope chain whn ecevuting the function

*/

var x = function cake() {
    // some variables declared here
    var flour = true;
    var cornMill = false;
    var cupsOfSugar= 1;

    function bake() {
        var heat = 350;
        console.log("Baking the cake at " + heat +"!");
        console.log(`flour: ${flour}`);
        console.log(`cornMill: ${cornMill}`);
        console.log(`Cups of Sugar: ${cupsOfSugar}`);

        heat++
        flour = !flour;
        cornMill = !cornMill;
        cupsOfSugar++;
        /*
        The bake() function has the following scope chanis:
            -1 The global variable
            -2 the parent variables

        */ 
    
    }

    return bake();
}

x = x(); // this will invoke cake -- by invoking cake we are really calling bake;
// technivca
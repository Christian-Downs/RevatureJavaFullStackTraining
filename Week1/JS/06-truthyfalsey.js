/*
    Javascript has a special way of coercing all d=ifferent values into booleans

    we would say that a value coerced into true= truthy and value coerced into false = falsey.



    there are only a couple falsey values, and everything else is truthy.
    the falsey values are:
    -0
    -null
    -=empty string,
    -false;
    -NaN
    -undefined


    !!(double bang operator) returns a variables truthy value.

*/

function checkTryTruthy(input){
    if(!!input){
        console.log("truthy")
    } else {
        console.log("falsey")
    }

    console.log(`
        input is${input} and is of type ${typeof(input)}
        It has a truthy value of ${!!input}
    `)
}

checkTryTruthy(0);
checkTryTruthy(null);
checkTryTruthy("");
checkTryTruthy(false);
checkTryTruthy(NaN);
checkTryTruthy(undefined);

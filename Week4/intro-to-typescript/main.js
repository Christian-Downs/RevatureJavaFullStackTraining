// TypeScript is a super set of JavaScript
// ALL JS is valid TS ... but not all TypeScript is valid JS
/*
    -TS is OOP -> it allows us more OOP features (interfaces, classes)
    -We get a TS compiler~! Which helps us check for errors
    -TS is strongly typed (we can enforec datatypes)

    TypeScript is transpiled into JavaScript. Browsers can only read javascript
    this mneans that all of our ts code must be transpiled into javascript at comilitation time
    in order for our app to run on the browser
*/
function logIt(message) {
    console.log(message);
}
logIt("Hello world");

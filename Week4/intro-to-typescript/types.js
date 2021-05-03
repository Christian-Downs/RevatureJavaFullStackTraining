var count = 5;
// we can't reassign variables to different types in typescript!
// count = 'apples'; This wil lmake the comiler angry...
// TypeScript is strictly typed.
var a; // We are declaring the types that can be assigned to this variable
var b;
var c;
var d;
d = 98;
d = 'apples';
var f = [1, true, 'apple', false];
var g = [1, 2, 3, 4];
var ColorRed = 0;
var ColorBlue = 1;
var ColorGreen = 2;
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Blue"] = 1] = "Blue";
    Color[Color["Green"] = 2] = "Green";
})(Color || (Color = {}));
var backgroundColor = Color.Blue;

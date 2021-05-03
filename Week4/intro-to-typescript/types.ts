var count = 5;

// we can't reassign variables to different types in typescript!
// count = 'apples'; This wil lmake the comiler angry...

// TypeScript is strictly typed.

let a: number; // We are declaring the types that can be assigned to this variable
let b: boolean;
let c: string;
let d:any;

d= 98;
d='apples';

let f: any[] = [1,true,'apple',false];
let g: number[] = [1,2,3,4];

const ColorRed = 0;
const ColorBlue =1;
const ColorGreen =2;


enum Color {Red, Blue, Green}

let backgroundColor = Color.Blue;


let a = "ten";
let b = 10
let c = true;
let d = {};
let e = null;
let f = "";
let g = (0/0);
let h= [];
let i = function(){};

var list = [a,b,c,d,e,f,g,h,i];

// standard for loop
for (let j = 0; j<list.length;j++){
    console.log(list[j]);
}

for(element in list){
    console.log(element);
    console.log(list[element])
}

list.forEach(
    function(value, index, array){
        console.log(value);
    }
);

//foreach with => arrow notations
list.forEach(
    (item)=>{console.log(item)}
)
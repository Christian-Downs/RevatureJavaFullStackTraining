// First we have to consider that EVERYTHING is treated as an object
// I mean: strings, functions, numbers.. when we covered closures, we saw
// that we can encapsulate data/states/properties/fields within a function ( so the function
// itself is kind of like a class...)


function Computer(compName, ramSizeGb,cpuCores, cpuSpeedGhz){
    this.compName= compName;
    this.ramSizeGb = ramSizeGb;
    this.cpuCores = cpuCores;
    this.cpuSpeedGhz = cpuSpeedGhz;

    this.printSpecs = function (){
        console.log(`This computer is named ${compName}. It has ${ramSizeGb} GB RAM, and a ${cpuCores}-core ${cpuSpeedGhz} GHz processor.`);
    }
}

var myComputer = new Computer("Tim",1,2,3,4);

myComputer.printSpecs();

function ComputerProto(compName, ramSizeGb,cpuCores, cpuSpeedGhz){
    this.compName= compName;
    this.ramSizeGb = ramSizeGb;
    this.cpuCores = cpuCores;
    this.cpuSpeedGhz = cpuSpeedGhz;
}


// every ComputerProto object must have a print specs function

ComputerProto.prototype.printSpecs = function() {
    console.log(`This computer is named ${this.compName}. It has ${this.ramSizeGb} GB RAM, and a ${this.cpuCores}-core ${this.cpuSpeedGhz} GHz processor.`);
}

var myComputerProto = new ComputerProto("MyPC",1,2,3,4);
myComputerProto.printSpecs();


// Now that we have an object with a configured prototype
// we can even inherit from it. In order to inherit, we use the call() function.
// call() allows us to define "this" in  the context of the function.

//Let's define a laptop child class
function Laptop(compName, ramSizeGb,cpuCores, cpuSpeedGhz, weight){
    ComputerProto.call(this,compName, ramSizeGb,cpuCores, cpuSpeedGhz);
    this.weight = weight;
}

var myLaptop = Laptop("MyLapTop",4,5,6,7,8);


var computerCopy = Object.create(ComputerProto.prototype);
computerCopy.constructor = Laptop;
Laptop.prototype = computerCopy;

computerCopy.printSpecs();
var myLaptop2 = new Laptop("MyLapTop",1,2,3,4,5)

myLaptop2.printSpecs();
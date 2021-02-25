let personLiteral = {
    firstName: 'Wilson',
    hairColor: 'hot pink',
    favoriteFood: 'bbq'
}


console.log(personLiteral);


class Person{
    constructor(firstName, hairColor, favFood){
        this.firstName = firstName;
        this.hairColor = hairColor;
        this.favFood = favFood;
    }

    sayHello(){
        console.log(`${this.firstName} says hello!`);
    }

}

var tim = new Person("tim","red","pizza");

tim.sayHello();
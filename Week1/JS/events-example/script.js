// 1. create a funciton called change the text
    // in which I take in some input, and change it to "Changed Text"

function changeTheText(){
    var e = document.getElementById("my_paragraph");
    // change the element's text!
    e.textContent = "Changed Text!"; // another way is e.innderHTML
}


// 2.we will grab the button element FROM the document, and then add an eventListener
var btn = document.querySelector("input");

btn.addEventListener("click",changeTheText);

console.log(document);
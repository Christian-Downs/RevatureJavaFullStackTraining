/*
    JSON = JavaScript Object Notation
        JSON is a standard data interchange format. It sends human-readable text
        to store and transmit data objects.
        there objects have properties made of key-value pairs
*/

let button = document.getElementById("btn");

// add an event listner to our button ("click", ajaxCall)

button.addEventListener("click",ajaxCall);

//capture the p tag
let input = document.getElementById("input");



//define a function for What our ajax call actually does

function ajaxCall(){
    console.log("POKEMON GOTTA CATCH THEM ALLLLLLLLLLL CAUSE YOU ARE MY DESTINY OOOOOO YOU'RE MY BEST FRIEND TO TRAIN THEM IS MY CALLLLL. POKEMON!")

    let number = document.getElementById("field").value;

    // get this number and append it to the url
    
    
    // step 1
    let xhr = new XMLHttpRequest();
    //This object is used for asynchronous requests to a server

    //STEP 2
    xhr.onreadystatechange = function() {


        if(this.readyState == 4 && this.status == 200){
            let data = JSON.parse(xhr.responseText);
            console.log(data);
            renderHTML(data)
        }
    }

    //STEP 3
    // open the request
    xhr.open("GET",`https://pokeapi.co/api/v2/pokemon/${number}`);
    // this is the request to tthe server: includes the method and the url
    
    // Step 4
    xhr.send();

    
}

//this function will render the data of the pokemon recieved
function renderHTML(data){
    // if(input.innerHTML!="")
    //     input.innerHTML = "";
    input.append(`Name: ${data.name}`);
    input.append(document.createElement("br"))
    input.append(`Image: `);
    let image = document.createElement("img");
    image.setAttribute("src", data.sprites.front_default)
    image.setAttribute("style","height : 300px;width : 300px;")
    input.append(image)
    input.append(document.createElement("hr"))
}
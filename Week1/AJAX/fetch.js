/*
    Fetch API:
        What is it? It's a modern interface that allows you to make HTTP requests to servers
        from browsers. It's simpler and cleaner than the XHR (XmlHTTP Object)
*/

window.onload = function (){
    console.log('fetch.js is loaded');
    document.getElementById("btn").addEventListener("click", getPokemon)
}
var pokemon;

function getPokemon(){
    let number = document.getElementById("field").value;

    //the fetch() method requires a param: the url from which we are retrieving data
    fetch(`https://pokeapi.co/api/v2/pokemon/${number}`)

    //the fetch() method returns a promise.
    //a promise is an object that returns a single value at some time in the future

    //the beauty of promises is that it allows us to process them and do cool things like use the then()
    // or handle errors

    .then( (response) => response.json())
    .then( (data)=>{
        console.log(data)
        setPokemonImg(data.sprites.front_default)

        pokemon = data;
    }, (err) => {
        console.log(`error: ${err}`);
    })

}

function setPokemonImg(imgSrc) {
    document.getElementById("pokemonImg").src = imgSrc;
}
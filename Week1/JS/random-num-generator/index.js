window.onload = function(){
    console.log("Starting up");

    let $min = document.getElementById("min");
    let $minOut = document.getElementById("min-output")
    let $max = document.getElementById("max");
    let $maxOutput = document.getElementById("max-output");
    let $generate  = document.getElementById("generate");

    $min.addEventListener('input',(evt)=>{
        console.log('event detected!');
        // console.log($minOut.textContent);
        $minOut.textContent = evt.target.value;
    })

    $max.addEventListener('input',(evt)=>{
        console.log('event detected!');
        $maxOutput.textContent = evt.target.value;
    })

    $generate.addEventListener('click', (evt)=>{
        console.log("going")
        let min = Number($min.value);
        let max = Number($max.value);
        if(min>max){
            window.alert("Minimum must be less than maximum!!!")
            console.error('try again');
        }
        let randomNumber = Math.floor(Math.random() * (max - min + 1) ) + min;
        console.log(randomNumber)
        document.getElementsByClassName("output")[0].innerHTML = randomNumber;
    })

}
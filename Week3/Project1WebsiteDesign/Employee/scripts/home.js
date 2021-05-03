
window.onload = () => {
    var elements = document.getElementsByClassName("insertNameHere");
    Array.from(elements).forEach((e) => {
        e.textContent= "Robert";
    });
}
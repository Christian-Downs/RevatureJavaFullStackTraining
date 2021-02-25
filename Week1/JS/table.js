// 1. create an array of objexts (each obj will have a name, color, cheese)
var arr = [
    {
        firstName: 'Vision',
        color: 'purple',
        cheese:'Bleu'
    },
    {
        firstName: 'Wanda',
        color: 'red',
        cheese: 'Pepperjack'
    },
    {
        firstName:'Agnes',
        color: 'yellow',
        cheese: 'Cheddar'
    }
];
// 2. create a function to populate our table with each obj inside our arr
window.onload = populateTable();

function populateTable(ar){
    var table = document.getElementById("myTable");
    arr.forEach( (obj) => {
        // 1. for each object create a new row (<tr>)
        let tr = document.createElement("tr")
        table.appendChild(tr);
        // 2. for each obj enter some data (<td>)
            //-first name        
            let td = document.createElement("td");
            tr.appendChild(td);
            td.innerHTML = obj.firstName;
            //-color
            td = document.createElement("td");
            tr.appendChild(td);
            td.innerHTML = obj.color;
            td.style.backgroundColor= obj.color;
            //-cheese
            td=document.createElement("td");
            tr.appendChild(td);
            td.innerHTML = obj.cheese;
            


    })
}
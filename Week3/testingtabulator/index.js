


window.onload = () => {
    let xhr = new XMLHttpRequest();



    xhr.onreadystatechange = function() {

        if(this.readyState ==4 && this.status == 200){
            console.log(xhr.responseText);

            let recievedText = JSON.parse(xhr.responseText);
            console.log(recievedText);

            

            // var tabledata = [{id:7}]
            // var table = new Tabulator("#example-table",{
            //     data:tabledata,
            //     autoColumns:true,
            //     rowClick:function(e, row){ //trigger an alert message when the row is clicked
            //     alert("Row " + row.getData().id + " Clicked!!!!");
            //     },

            // });
        }
    }
    var url = 'http://localhost:8090/project-1/allReimbursements'
    xhr.open("GET", url );

    let loginTemplate = {
        username: "Test",
        password: "password"
    }

    xhr.send(JSON.stringify(loginTemplate));
};

function changeInfo(){
    tabledata = [{name:'tim'}];
    console.log(tabledata)
}
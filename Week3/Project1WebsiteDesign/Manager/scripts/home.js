let h = document.getElementById("header");

let ses = sessionStorage;
let user = JSON.parse(ses.getItem('currentUser'));
var td;
// var uName = user["username"];

var tabledata = [
    {
        id:1,
        amount:200,
        submitted:1342234234,
        resolved:"",
        description:"Time is of the essense",
        receipt:"",
        authorId:2,
        resolverId: null,
        status:"PENDING",
        type:"LODGING"
    },{
        id: 1,
            amount: 200,
            submitted: 1342234234,
            resolved: "",
            description: "Time is of the essense",
            receipt: "",
            authorId: 2,
            resolverId: 1,
            status: "APPROVED",
            type: "LODGING"
    }

];

window.onload = (() => {
    console.log(ses.getItem('currentUser'));

    // h.innerHTML += (" " + uName);
    // AllReimbursements();
    console.log(tabledata);
    table.setData(tabledata);
});

var rowMenu = [{
        label: "<i class='fas fa-user'></i> Approve",
        action: function (e, row) {


            // let xhr = new XMLHttpRequest();

            // xhr.onreadystatechange = function () {
            //     if (this.readyState === 4 && this.status === 200) {
            //         var tabledata = this.responseText;
            //         //console.log(tabledata);
            //         table.setData(tabledata);
            //     }
            // }

            // xhr.open("POST", `http://localhost:8090/project-1/${row.getData()["id"]}.ReimbursementApproved`)

            // xhr.send();
        }
    },
    {
        label: "<i class='fas fa-check-square'></i> UnApprove",
        action: function (e, row) {



            // let xhr = new XMLHttpRequest();

            // xhr.onreadystatechange = function () {
            //     if (this.readyState === 4 && this.status === 200) {
            //         var tabledata = this.responseText;
            //         //console.log(tabledata);
            //         table.setData(tabledata);
            //     }
            // }

            // xhr.open("POST", `http://localhost:8090/project-1/${row.getData()["id"]}.ReimbursementUnapporved`)

            // xhr.send();
        }
    },
    {
        label:'info',
        action: function (e, row) {
            var rowData = row.getData();
            let holder = document.getElementById("infoSpot")
            holder.innerHTML ="";
            for (var key in rowData){
                var row = document.createElement("div");
                row.className='row';
                holder.appendChild(row);
                var firstDiv = document.createElement("div");
                firstDiv.className="col-sm-4";
                firstDiv.style = "background-color:beige;";
                row.appendChild(firstDiv);
                var firstSpan = document.createElement("span");
                firstSpan.className= "float-right";
                firstDiv.appendChild(firstSpan);
                firstSpan.innerHTML = `${key}:`;                
                var secondDiv = document.createElement('div');
                secondDiv.className = "col-sm-8";
                secondDiv.style="background-color:aqua;";
                row.appendChild(secondDiv); 
                if (key == 'resolverId' ) {
                    var resolverIdSpan = document.createElement("span");
                    resolverIdSpan.className = 'float-left';
                    secondDiv.appendChild(resolverIdSpan);
                    console.log(rowData[key])
                    if(rowData[key] != null){
                        console.log(rowData[key])
                        fetch(`http://localhost:8090/project-1/GetEmployeeById/${rowData[key]}`)
                        .then((response) => response.json())
                        .then((data) => {
                            resolverIdSpan.innerHTML = data.username;
                        })
                    } else{
                        secondSpan.innerHTML = `Unresolved`;
                    }
                } else {
                    var secondSpan = document.createElement("span");
                    secondSpan.className = 'float-left';
                    secondDiv.appendChild(secondSpan);
                    secondSpan.innerHTML = `${rowData[key]}`;
                }

               
                

            };
        }
    }
]



var table = new Tabulator("#example-table", {
    height: 205, // set height of table (in CSS or here), this enables the Virtual DOM and improves render speed dramatically (can be any valid css height value)
    layout: "fitColumns", //fit columns to width of table (optional)
    autoColumns: true,
    rowContextMenu: rowMenu,
    rowClick: function (e, row) { //trigger an alert message when the row is clicked
        ses.setItem('currentReimbursementId', row.getData()["id"]);
    },
});

function AllReimbursements() {


    // let xhr = new XMLHttpRequest();

    // xhr.onreadystatechange = function () {
    //     if (this.readyState === 4 && this.status === 200) {
    //         var tabledata = this.responseText;
    //         //console.log(tabledata);
    //         table.setData(tabledata);
    //     }
    // }

    // xhr.open("GET", "http://localhost:8090/project-1/AllReimbursements")

    // xhr.send(JSON.stringify(uName));

}

function AllPendingReimbursements() {


    // let xhr = new XMLHttpRequest();

    // xhr.onreadystatechange = function () {
    //     if (this.readyState === 4 && this.status === 200) {
    //         var tabledata = this.responseText;
    //         //console.log(tabledata);
    //         table.setData(tabledata);
    //     }
    // }

    // xhr.open("GET", "http://localhost:8090/project-1/GetAllReimbursementsOfAGivenType/Pending")

    // xhr.send(JSON.stringify(uName));

}

function AllApprovedReimbursements() {
    // let xhr = new XMLHttpRequest();

    // xhr.onreadystatechange = function () {
    //     if (this.readyState === 4 && this.status === 200) {
    //         var tabledata = this.responseText;
    //         //console.log(tabledata);
    //         table.setData(tabledata);
    //     }
    // }

    // xhr.open("GET", "http://localhost:8090/project-1/GetAllReimbursementsOfAGivenType/Approved")

    // xhr.send(JSON.stringify(uName));

}

function AllUnapprovedReimbursements() {
    // let xhr = new XMLHttpRequest();

    // xhr.onreadystatechange = function () {
    //     if (this.readyState === 4 && this.status === 200) {
    //         var tabledata = this.responseText;
    //         //console.log(tabledata);
    //         table.setData(tabledata);
    //     }
    // }

    // xhr.open("GET", "http://localhost:8090/project-1/GetAllReimbursementsOfAGivenType/Unapproved")

    // xhr.send(JSON.stringify(uName));

}
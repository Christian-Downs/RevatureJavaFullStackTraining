 function sendLogin(){
	console.log("send login triggered");
    let uName = document.getElementById('uName').value;
    let pWord = document.getElementById('pWord').value;

    console.log(`Username: ${uName}`);
    console.log(`Password: ${pWord}`);

    let loginTemplate = {
        username: uName,
        password: pWord
    }



    let xhr = new XMLHttpRequest();


    xhr.onreadystatechange = function(){
        console.log("I'm here")
        if(this.readyState===4 && this.status ===200){
            console.log("Success");

            sessionStorage.setItem('currentUser',this.responseText);

            window.location = "http://localhost:8090/EmployeeDBServlet/home.html";

            console.log(sessionStorage.getItem('currentUser'));
        }
        
        if(this.readyState===4 && this.status === 204){ // 204 means no content found (but connection was made)
            console.log("failed to find user")

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "failed to login! username or password is incorrect";
        }
    }

    xhr.open("POST","http://localhost:8090/EmployeeDBServlet/login");

    console.log("Now I'm down here")
    xhr.send(JSON.stringify(loginTemplate));

}
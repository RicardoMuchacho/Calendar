var editBtn = document.getElementById("editBtn");
var confirmBtn = document.getElementById("confirmBtn");
var deleteBtn = document.getElementById("deleteBtn");
var cancelBtn = document.getElementById("cancelBtn");
var nameInput = document.getElementById("name");
var emailInput = document.getElementById("email");
var passInput = document.getElementById("pass");
var userInput = document.getElementById("userid");
var div = document.getElementById("cont1");

fetch("userinfo", {
    headers: {
        "Content-Type": "application/json",
    },
    method: "get",
}).then(response=>{
    console.log(response);
    return response.json();
}).then(data =>{
    console.log(data);
    nameInput.value = data.name;
    emailInput.value = data.email;
    passInput.value = data.pass;
    userInput.value = data.userid;
    //result.textContent=r.result;
}).catch(err => console.log(err));

function edit(){
	editBtn.disabled = true;
    confirmBtn.disabled = false;
    cancelBtn.disabled = false;
    nameInput.disabled = false;
    emailInput.disabled = false;
    passInput.disabled = false;
 }

function deleteUser(){
    fetch("signout", {
        method: "post",
    }).then(response=>{
        console.log(response);
     }).catch(err => console.log(err));
    window.location.href = "index.html";
}

function confirm(){
	//var name = nameInput.value;
	//var email = emailInput.value;
	//var pass = passInput.value;
	
	//console.log(name, email, pass);
	
	
	//var p = document.createElement("p");
	//cont1.appendChild(p);
	//p.innerHTML = "Succesfully updated";
}

function cancel(){
	editBtn.disabled = false;
    confirmBtn.disabled = true;
    cancelBtn.disabled = true;
    nameInput.disabled = true;
    emailInput.disabled = true;
    passInput.disabled = true;
}


var editBtn = document.getElementById("editBtn");
var confirmBtn = document.getElementById("confirmBtn");
var cancelBtn = document.getElementById("cancelBtn");
var nameInput = document.getElementById("name");
var emailInput = document.getElementById("email");
var passInput = document.getElementById("pass");
var div = document.getElementById("cont1");


function edit(){
	editBtn.disabled = true;
    confirmBtn.disabled = false;
    cancelBtn.disabled = false;
    nameInput.disabled = false;
    emailInput.disabled = false;
    passInput.disabled = false;
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


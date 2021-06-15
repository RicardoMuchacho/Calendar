const days = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']
let clicked = null;

const newEventModal = document.getElementById('newEventModal');
const newCalendarModal = document.getElementById('newCalendarModal');
const deleteEventModal = document.getElementById('deleteEventModal');
const backDrop = document.getElementById('modalBackDrop');
const eventTitleInput = document.getElementById('eventTitleInput');
const calendarTitleInput = document.getElementById('calendarTitleInput');
const title1 = document.getElementById("t1");
const signOut = document.getElementById("signOut");


var today = new Date();
var dd = String(today.getDate()).padStart(2, '0');
var mm = String(today.getMonth() + 1).padStart(2, '0'); 
var yy = today.getFullYear();

var todayStr = today.toString();

weekday = todayStr.slice(0, 3);

dateStr = weekday + ", "+mm + '/' + dd + '/' + yy;

title1.textContent = dateStr;

//const cells = document.querySelectorAll('.cell');
//
//cells.style.backgroundColor = "red";

function openModal(elementId) {
  clicked = elementId;

  newEventModal.style.display = 'block';
  backDrop.style.display = 'block';
}

function closeModal() {
  eventTitleInput.classList.remove('error');
  newEventModal.style.display = 'none';
  newCalendarModal.style.display = 'none';
  deleteEventModal.style.display = 'none';
  backDrop.style.display = 'none';
  eventTitleInput.value = '';
  calendarTitleInput.value = '';
  clicked = null;
}

function saveEvent() {
  if (eventTitleInput.value) {
    eventTitleInput.classList.remove('error');

    fetch("events", {
        body: new URLSearchParams({
            'calendarid': 2,
            'date': 2,
            'description': 'Tarea Mat'
        }),
        headers: {
            "Content-Type": "application/x-www-form-urlencoded",
        },
        method: "post",
    }).then(response=>{
        console.log(response);
     }).catch(err => console.log(err));
    
    document.getElementById(clicked).textContent = eventTitleInput.value;
    document.getElementById(clicked).style.backgroundColor = "lightblue";

    closeModal();
  } else {
    eventTitleInput.classList.add('error');
  }
}

function deleteEvent() {

  closeModal();
}

document.getElementById("saveButton").addEventListener('click', saveEvent)
document.getElementById("cancelButton").addEventListener('click', closeModal)
document.getElementById("saveButtonCalendar").addEventListener('click', saveCalendar)
document.getElementById("cancelButtonCalendar").addEventListener('click', closeModal)

counter=0;
document.querySelectorAll('#myTable td').forEach(e=>{
  e.setAttribute('id', 'cell'+counter);
  e.addEventListener('click', () => openModal(e.id));
  counter++;
});


function createCalendar(){
  openCalendarModal();
}

function openCalendar(){

}

function saveCalendar() {
  if (calendarTitleInput.value) {
	  
    calendarTitleInput.classList.remove('error');

    fetch("calendar", {
        body: new URLSearchParams({
            'title': calendarTitleInput.value
        }),
        headers: {
            "Content-Type": "application/x-www-form-urlencoded",
        },
        method: "post",
    }).then(response=>{
        console.log(response);
     }).catch(err => console.log(err));
       
    var sideUl = document.getElementById("sideList");
    var li = document.createElement("li");
    li.classList.add('nav-item');
    var a = document.createElement("a");
    a.innerHTML = calendarTitleInput.value;
    a.classList.add("nav-link");
    li.appendChild(a);  
    sideUl.appendChild(li);
    
    closeModal();
  } else {
    calendarTitleInput.classList.add('error');
  }
}

function openCalendarModal() {
  newCalendarModal.style.display = 'block';
  backDrop.style.display = 'block';
}

/*
  		fetch('calendar', {
  		  method: "GET",
  		  headers: {"Content-type": "application/json;charset=UTF-8"}
  		})
  		.then(response => response.json()) 
  		.then(json => console.log(json))
  	    .catch(err => console.log(err));*/




const days = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']
let clicked = null;

const newEventModal = document.getElementById('newEventModal');
const newCalendarModal = document.getElementById('newCalendarModal');
const deleteEventModal = document.getElementById('deleteEventModal');
const backDrop = document.getElementById('modalBackDrop');
const eventTitleInput = document.getElementById('eventTitleInput');
const calendarTitleInput = document.getElementById('calendarTitleInput');
const title1 = document.getElementById("t1");


var today = new Date();
var dd = String(today.getDate()).padStart(2, '0');
var mm = String(today.getMonth() + 1).padStart(2, '0'); 
var yyyy = today.getFullYear();

var todayStr = today.toString();

weekday = todayStr.slice(0, 3);

dateStr = weekday + ", "+mm + '/' + dd + '/' + yyyy;

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

    var sideUl = document.getElementById("sideList");
    var li = document.createElement("li");
    li.classList.add('nav-item');
    li.addEventListener('click', () => openCalendar());
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
var peticion = new Request('http://localhost:3000/client',{ 
    method: 'POST',
    body:{
        "n1": n1,
        "n2": n2
    }
  });
  
function solve(){
  fetch('home',{
      method: 'GET',
      headers: new Headers({
    // Encabezados
   'Content-Type': 'text/html'
    }),
      body: JSON.stringify(
    {
    "n1": n1.value,
    "n2": n2.value
    })
    
  }).then(respuesta=>{
     console.log(respuesta);
     return respuesta.json();
  }).then(r =>{
      console.log(r);
      result.textContent=r.result;
  })
}*/


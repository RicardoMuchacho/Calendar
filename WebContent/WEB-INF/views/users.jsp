<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="public/styles/styleUsers.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Users</title>
</head>
<body>
  <div class="topnav">
    <a id="userBtn" href="users"> User</a>
    <a class="center" href="home">Calendars</a>
  </div>
<div id class="container" >
  <form id="userForm" action="users" method="post">
  <div class="row">
    <div class="col-15">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" placeholder="${name}" disabled>
    </div>
  </div>
  <div class="row">
    <div class="col-15">
      <label for="lname">Email</label>
    </div>
    <div class="col-75">
      <input type="text" id="email" name="email" placeholder="${email}" disabled>
    </div>
  </div>
  <div class="row">
    <div class="col-15">
      <label for="password">Password</label>
    </div>
    <div class="col-75">
      <input type="password" id="pass" name="pass" placeholder="${password}" disabled>
    </div>
  </div>
<div class="row">
    <div class="col-15">
      <label for="userid">User id</label>
    </div>
    <div class="col-75">
      <input type="number" id="userid" name="userid" placeholder="${userid}" disabled>
    </div>
  </div>
     <button id="confirmBtn" onclick="confirm()" disabled> Confirm</button>
  </form>
   <button id="editBtn" onclick="edit()"> Edit</button>
   <button id="cancelBtn" onclick="cancel()" disabled> Cancel </button>
  </div>

</body>
<footer>
 <p> Ricardo Muchacho. Ci:27849052 </p>
</footer>
<script src="public/scripts/users.js"></script>
</html>
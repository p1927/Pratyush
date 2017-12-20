window.onload = function() {
  AddAccount(false);
  Clear(false);
}

var Users = [{
  username: "AceXintense",
  firstname: "Sam",
  lastname: "Grew",
  age: 19,
  email: "",
  gender: "Male",
  location: "Birmingham",
  job: "Software Engineer",
} ];

function PullSearch() {
  var Search = document.getElementById("search").value;
  for (var index = 0; index < Users.length; index++) {
    if (document.getElementById("filter-main").value === "filter" && document.getElementById("type").value === "username" && Users[index].username === Search) {
      PushData(index);
    } else if (document.getElementById("filter-main").value === "filter" && document.getElementById("type").value === "firstname" && Users[index].firstname === Search) {
      PushData(index);
    } else if (document.getElementById("filter-main").value === "filter" && document.getElementById("type").value === "lastname" && Users[index].lastname === Search) {
      PushData(index);
    } else if (document.getElementById("filter-main").value === "filter" && document.getElementById("type").value === "gender" && Users[index].gender === Search) {
      PushData(index);
    } else if (document.getElementById("filter-main").value === "filter" && document.getElementById("type").value === "age" && Users[index].age === Search) {
      PushData(index);
    } else if (document.getElementById("filter-main").value === "filter" && document.getElementById("type").value === "job" && Users[index].job === Search) {
      PushData(index);
    } else if (document.getElementById("filter-main").value === "filter" && document.getElementById("type").value === "location" && Users[index].location === Search) {
      PushData(index);
    } else if (document.getElementById("filter-main").value === "filter" && document.getElementById("type").value === "email" && Users[index].email === Search) {
      PushData(index);
    }
  }
  document.getElementById("search").value = "";
}

function PushData(index) {
  document.getElementById("output").value +=
    "\nAccount " + index + " {\n" + 
    "	Username : " + Users[index].username + "\n" + 
    "	Firstname : " + Users[index].firstname + "\n" + 
    "	Lastname : " + Users[index].lastname + "\n" + 
    "	Age : " + Users[index].age + "\n" + 
    "	Email : " + Users[index].email + "\n" + 
    "	Gender : " + Users[index].gender + "\n" + 
    "	Location : " + Users[index].location + "\n" + 
    "	Job : " + Users[index].job + "\n}";
}

function AddAccount(boolean) {
  if (boolean) {
    var AccountDetails = [
      Username = document.getElementById("username-input").value,
      Firstname = document.getElementById("firstname-input").value,
      Lastname = document.getElementById("lastname-input").value,
      Age = document.getElementById("age-input").value,
      Email = document.getElementById("email-input").value,
      Gender = document.getElementById("gender-input").value,
      Location = document.getElementById("location-input").value,
      Job = document.getElementById("job-input").value
    ];
    if (document.getElementById("username-input").value === "") {
      document.getElementById("username-input").className = "error-data";
    }
    if (document.getElementById("firstname-input").value === "") {
      document.getElementById("firstname-input").className = "error-data";
    }
    if (document.getElementById("lastname-input").value === "") {
      document.getElementById("lastname-input").className = "error-data";
    }
    if (document.getElementById("age-input").value === "") {
      document.getElementById("age-input").className = "error-data";
    }
    if (document.getElementById("email-input").value === "") {
      document.getElementById("email-input").className = "error-data";
    }
    if (document.getElementById("gender-input").value === "") {
      document.getElementById("gender-input").className = "error-data";
    }
    if (document.getElementById("location-input").value === "") {
      document.getElementById("location-input").className = "error-data";
    }
    if (document.getElementById("job-input").value === "") {
      document.getElementById("job-input").className = "error-data";
    }

    if (Username && Firstname && Lastname && Email && Age && Gender && Location && Job) {
      document.getElementById("output").value = "Database is Ready for Queries!";
      document.getElementById("output").className = "";
      document.getElementById("accounts").className = "";
      document.getElementById("search").className = "";
      document.getElementById("alert").className = "complete show";
      document.getElementById("error").className = "error hide";
      document.getElementById("name").innerHTML = "" + Username;

      ClearError();

      Users.push({
        username: AccountDetails[0],
        firstname: AccountDetails[1],
        lastname: AccountDetails[2],
        age: AccountDetails[3],
        email: AccountDetails[4],
        gender: AccountDetails[5],
        location: AccountDetails[6],
        job: AccountDetails[7]
      });

      document.getElementById("username-input").value = "";
      document.getElementById("firstname-input").value = "";
      document.getElementById("lastname-input").value = "";
      document.getElementById("age-input").value = "";
      document.getElementById("email-input").value = "";
      document.getElementById("gender-input").value = "";
      document.getElementById("location-input").value = "";
      document.getElementById("job-input").value = "";
      
      AddAccount(false);
    } else {
      document.getElementById("alert").className = "complete hide";
      document.getElementById("error").className = "error show";
      document.getElementById("error-info").innerHTML = "Missing Fields!";
    }
  } else {
    document.getElementById("accounts").value = "";
    for (var a = 0; a < Users.length; a++) {
      document.getElementById("accounts").value +=
        "\nAccount " + a + " {" + "\n" + "	Username : " + Users[a].username + "\n" + "	Firstname : " + Users[a].firstname + "\n" + "	Lastname : " + Users[a].lastname + "\n" + "	Age : " + Users[a].age + "\n" + "	Email : " + Users[a].email + "\n" + "	Gender : " + Users[a].gender + "\n" + "	Location : " + Users[a].location + "\n" + "	Job : " + Users[a].job + "\n }";
    }
  }
}

function CloseComplete() {
  document.getElementById("alert").className = "complete hide";
  document.getElementById("completed").className = "complete hide";
  document.getElementById("error").className = "error hide";
}

function ClearError() {
  document.getElementById("username-input").className = "";
  document.getElementById("firstname-input").className = "";
  document.getElementById("lastname-input").className = "";
  document.getElementById("age-input").className = "";
  document.getElementById("email-input").className = "";
  document.getElementById("gender-input").className = "";
  document.getElementById("location-input").className = "";
  document.getElementById("job-input").className = "";
}

window.setInterval(function() {
  if(document.getElementById("type").value === "username"){
    console.log("I");
  }
  if (document.getElementById("username-input").value.length > 0) {
    document.getElementById("username-input").className = "";
  }
  if (document.getElementById("firstname-input").value.length > 0) {
    document.getElementById("firstname-input").className = "";
  }
  if (document.getElementById("lastname-input").value.length > 0) {
    document.getElementById("lastname-input").className = "";
  }
  if (document.getElementById("age-input").value.length > 0) {
    document.getElementById("age-input").className = "";
  }
  if (document.getElementById("email-input").value.length > 0) {
    document.getElementById("email-input").className = "";
  }
  if (document.getElementById("gender-input").value.length > 0) {
    document.getElementById("gender-input").className = "";
  }
  if (document.getElementById("location-input").value.length > 0) {
    document.getElementById("location-input").className = "";
  }
  if (document.getElementById("job-input").value.length > 0) {
    document.getElementById("job-input").className = "";
  }
}, 500);

function Clear(boolean) {
  if (boolean) {
    Users = [];
    document.getElementById("accounts").value = "No Accounts in Database Refresh or Create new Database.";
    document.getElementById("output").value = "Cannot Query Database without any Accounts in the Database. Refresh or Start a new Database.";
    document.getElementById("output").className = "error-data";
    document.getElementById("accounts").className = "error-data";
    document.getElementById("search").className = "error-data";
    ClearError();
    CloseComplete();
  } else {
    document.getElementById("output").value = "Database is Ready for Queries!";
  }
}

function Save(boolean) {
  var downloadLink = document.createElement("a");
  downloadLink.innerHTML = "Download File";

  if (boolean) {
    var textToWrite = document.getElementById("output").value;
    var textFileAsBlob = new Blob([textToWrite], {
      type: 'text/plain'
    });
    var fileNameToSaveAs = document.getElementById("output").value;

    downloadLink.download = "Query File";
    document.getElementById("complete-info").innnerHTML = "SAVE TO FILE";

    if (window.webkitURL != null) {
      downloadLink.href = window.webkitURL.createObjectURL(textFileAsBlob);
    } else {
      downloadLink.href = window.URL.createObjectURL(textFileAsBlob);
      downloadLink.onclick = destroyClickedElement;
      downloadLink.style.display = "none";
      document.body.appendChild(downloadLink);
    }
    downloadLink.click();
  } else {
    var textToWrite = document.getElementById("accounts").value;
    var textFileAsBlob = new Blob([textToWrite], {
      type: 'text/plain'
    });
    var fileNameToSaveAs = document.getElementById("accounts").value;
    downloadLink.download = "Database File";

    if (window.webkitURL != null) {
      downloadLink.href = window.webkitURL.createObjectURL(textFileAsBlob);
    } else {
      downloadLink.href = window.URL.createObjectURL(textFileAsBlob);
      downloadLink.onclick = destroyClickedElement;
      downloadLink.style.display = "none";
      document.body.appendChild(downloadLink);
    }
    downloadLink.click();
  }
}
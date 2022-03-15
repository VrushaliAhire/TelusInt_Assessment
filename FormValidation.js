function validateForm() {
                 
    var Name = document.getElementById("txtName");
    var Email = document.getElementById("txtEmail");
    var availability = document.getElementById("numavailability");
    //var validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    var validRegex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/; 
   var num = availability.value;

    
    //alert(len);
    if (Name.value.length <3 || Name.value.length >= 100) {
        window.alert("Please enter your full name,between 3 to 100 characters ");
        //name.focus();
        return false;
    }

    
     if(Email.value.match(validRegex)){
        
     }
     else
     {
         if(Email.value== ""){
            
             }
             else
             {
                window.alert("Please enter valid email ID");
                return false;
             }
     }

    
         
    if (availability.disabled == false && availability.value =="") {
        window.alert(
          "Please enter availability days");
        //email.focus();
        return false;
    }
    
    if (availability.disabled == false && num != "" && isNaN(num))
    {
        console.log(availability.disabled);
        console.log(isNaN(num));
        alert("Please enter availablity days in number");
        return false;
    }
   // return true;

   Submit(Name, Email,availability);
}

function checkBoxClicked(e) {
    if(e.target.checked){
        document.getElementById('numavailability').disabled = true;
    }
    else
        document.getElementById('numavailability').disabled = false;

}



function Submit(name, email, available)
{
    
    alert("Name: " + name.value  +  "\nEmail: "+ email.value  + "\nAvailable in:  " + available.value + " Days" );
    
}


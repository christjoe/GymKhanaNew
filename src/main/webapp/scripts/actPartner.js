/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function addPlanWith(ID,Name) {
    document.getElementsByName("planWithID")[0].value = ID;
    document.getElementsByName("planWithName")[0].value = Name;
    document.getElementById("plan").submit();
    console.log("form submitted");
}



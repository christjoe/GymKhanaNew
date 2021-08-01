/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function ignoreReq(ID,A_ID){
 document.getElementsByName("responseTo")[0].value = ID;
 document.getElementsByName("response")[0].value = "ignored";
 document.getElementsByName("A_ID")[0].value = A_ID;
    document.getElementById("planForm").submit();
    console.log("form submitted");
}
function acceptReq(ID,A_ID){
 document.getElementsByName("responseTo")[0].value = ID;
 document.getElementsByName("response")[0].value = "confirmed";
 document.getElementsByName("A_ID")[0].value = A_ID;
 document.getElementById("planForm").submit();
    console.log("form submitted");
}


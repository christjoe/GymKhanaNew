/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function ignoreReq(ID){
 document.getElementsByName("responseTo")[0].value = ID;
 document.getElementsByName("response")[0].value = "ignored";
    document.getElementById("resForm").submit();
    console.log("form submitted");
}
function acceptReq(ID){
 document.getElementsByName("responseTo")[0].value = ID;
 document.getElementsByName("response")[0].value = "accepted";
 document.getElementById("resForm").submit();
    console.log("form submitted");
}
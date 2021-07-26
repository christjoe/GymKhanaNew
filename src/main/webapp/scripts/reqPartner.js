/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function addValsub(ID) {
    document.getElementsByName("requested")[0].value = ID;
    document.getElementById("reqForm").submit();
    console.log("form submitted");
}


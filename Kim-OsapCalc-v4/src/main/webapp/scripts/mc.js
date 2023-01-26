function validate(){
var ok = true;
var p = document.getElementById("principal").value;
if (isNaN(p) || p <= 0) {
alert("Principal invalid!");
document.getElementById("principalerror").style.display = "inline";
document.getElementById("principalerror").style.color = "red";
ok = false;
} else {
document.getElementById("principalerror").style.display = "none";
}
if (!ok)
return false;
p = document.getElementById("interest").value;
if (isNaN(p) || p <= 0 || p >= 100) {
alert("Invalid. Must be in (0,100).");
document.getElementById("interesterror").style.display = "inline";
document.getElementById("interesterror").style.color = "red";
ok = false;
} else {
document.getElementById("interesterror").style.display = "none";
}
//add your code to check the load period

p = document.getElementById("period").value;
if (isNaN(p) || p <= 0) {
alert("Principal invalid!");
document.getElementById("perioderror").style.display = "inline";
document.getElementById("perioderror").style.color = "red";
ok = false;
} else {
document.getElementById("perioderror").style.display = "none";
}
if (!ok)
return false;
}
function doSimpleAjax(address){
 var request = new XMLHttpRequest();
 var data="";
 /* add your code here to grab all parameters from form*/
 
data += "principal=" + document.getElementById("principal").value + "&";
data += "interest=" + document.getElementById("interest").value + "&";
data += "period=" + document.getElementById("period").value + "&" ;
data += "out=text";
var add = address + "?"+data;
 request.open("GET", add,true);
 request.onreadystatechange = function() {
 handler(request);
 };
 request.send(null);
} 
function handler(request){
 if ((request.readyState == 4) && (request.status == 200)){
 var target = document.getElementById("result");
 target.innerHTML = request.responseText;
 //here you want to add parse the json and display individual key,
 //values pairs as html elements ( tables, paragraphs, etc..)
 var rs=JSON.parse(request.responseText);
 addParagraphs(target, rs.pr, rs.mp);
  }
 }
 function addParagraphs(parent, p1, p2){
	parent.innerHTML += "<br />"+"Principal:" +p1;
	parent.innerHTML += "<br />"+"Monthly Payment:" +p2;
	
}
 
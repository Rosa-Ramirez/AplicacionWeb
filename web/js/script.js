/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

function enviarForm(){ 
var myForm = document.getElementById("contact-form");

document.getElementById("btn3").addEventListener("click", function(){
  myForm.submit();  
});

 };
 
 
 
 
 
 
 
 // function enviarFormOpUno(){  
//     alert("Formulario Enviado");
// };

 //function enviarFormulario(){
//	let request = new XMLHttpRequest();
//request.open('POST', '/php/email-sender.php', true);
//request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
//
//request.onreadystatechange = function() {
//  if (request.readyState == XMLHttpRequest.DONE) {
//    // Peticion terminada.
//    if (request.status == 200) {
//      // Todo salio bien
//      console.log(request.response);
//    } else {
//      console.log("Error en el envío " + request.response);
//    }
//  }
//};
//var formData = new FormData(document.getElementById('contact-form'));
//request.send(formData);
//}

//function enviarFormularioDos(){
//    const XHR = new XMLHttpRequest();
//        var formData = new FormData(document.getElementById('contact-form'));
//        
//        XHR.addEventListener("load", (event) => {
//            alert("Formulario Enviado Correctamente");
//        });
//        
//        XHR.addEventListener("error", (event) => {
//            alert("Hubo un error al intentar enviar el formulario.");
//        });
//        XHR.open("POST", 'ClienteController');
//        XHR.send(formData);
//        
//        }
 
// function enviarFormularioOpcionInge(){
//	const XHR = new XMLHttpRequest();
//	  var formData = new FormData(document.getElementById('contact-form'));
//
//	  // Define what happens on successful data submission
//	  XHR.addEventListener('load', (event) => {
//	    alert('Yeah! Data sent and response loaded.');
//	  });
//
//	  // Define what happens in case of error
//	  XHR.addEventListener('error', (event) => {
//	    alert('Oops! Something went wrong.');
//	  });
//
//	  // Set up our request
//	  XHR.open('POST', 'ClienteController');
//
//	  // Send our FormData object; HTTP headers are set automatically
//	  XHR.send(formData);
//	
//}
 

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
 
 function enviarFormularioOpcionDos(){
	const XHR = new XMLHttpRequest();
	  var formData = new URLSearchParams(new FormData(document.getElementById('form'))).toString();

	  // Define what happens on successful data submission
//	  XHR.addEventListener('click', (event) => {
//	    alert('Yeah! Data sent and response loaded.');
//	  });

	  // Define what happens in case of error
	  XHR.addEventListener('error', (event) => {
	    alert('Oops! Something went wrong.');
	  });

	  // Set up our request
	  XHR.open('POST', 'ClienteController', true);
                    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    
                    XHR.onload = () => {
                        if (XHR.readyState === XHR.DONE && XHR.status === 200) {
                            console.log("response => " + XHR.response);
                            document.getElementById("bodyTable").innerHTML=XHR.response;
                            mostrarMensaje();
                        }
                    };
	  // Send our FormData object; HTTP headers are set automatically
            console.log(formData);
	  XHR.send(formData);
//	console.log(formData);
}

function deleteData(position){
                        let formData = "position=" + position;
    
                     const XHR = new XMLHttpRequest();

	  // Define what happens in case of error
	  XHR.addEventListener('error', (event) => {
	    alert('Oops! Something went wrong.');
	  });

	  // Set up our request
	  XHR.open('POST', 'ClienteController', true);
                    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    
                    XHR.onload = () => {
                        if (XHR.readyState === XHR.DONE && XHR.status === 200) {
                            console.log("response => " + XHR.response);
                            document.getElementById("Table").innerHTML=XHR.response;
                            mostrarMensajeDelete();
                        }
                    };
	  XHR.send(formData);
    
}


 function mostrarMensaje(){
  Swal.fire({
  title: 'Cliente Registrado',
  width: 600,
  padding: '3em',
  color: '#716add',
  background: '#fff url(Images/fondo.jpg)',
  backdrop: `
    rgba(0,0,123,0.4)
    url("Images/nyan-cat.gif")
    left top
    no-repeat
  `
})
}
function mostrarMensajeDelete(){
  Swal.fire({
  title: 'Cliente Eliminado',
  width: 600,
  padding: '3em',
  color: '#716add',
  background: '#fff url(Images/fondo.jpg)',
  backdrop: `
    rgba(0,0,123,0.4)
    url("Images/nyan-cat.gif")
    left top
    no-repeat
  `
})
}

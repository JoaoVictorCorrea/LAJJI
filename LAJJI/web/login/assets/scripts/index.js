/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function validaLogin(){
    
    var ajax = false;

        if (window.XMLHttpRequest)
            ajax = new XMLHttpRequest();
        else if (window.ActiveXObject)
            ajax = new ActiveXObject("Microsoft.XMLHTTP");
        
        if (ajax){
                    
            ajax.open("GET", "http://localhost:8080/LAJJI/SConsultarLogin", true);
                    
            ajax.onreadystatechange = function(){
                        
            if (ajax.readyState == 4){
                                
                var dados;
                            
                try {
                    
                    dados = JSON.parse(ajax.responseText);
                }
                catch(e){
                                
                    dados = eval('(' + ajax.responseText + ')');
                    dados.logado = false;
                }
                            
                if(!dados.logado){
                                
                    alert("Email/senha inválidos");
                }
            }
        };
                    
        ajax.send(null);
    }
    else
        alert("Erro");
}

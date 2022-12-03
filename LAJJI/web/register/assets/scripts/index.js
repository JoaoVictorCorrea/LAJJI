/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function validaDados(){
    
    var nome = "", rg = "", telefone = "", cpf = "", data = "",
            endereco = "", email = "", senha = "", aux;
    
    nome = document.getElementById("idNome").value;
    rg = document.getElementById("idRG").value;
    telefone = document.getElementById("idTelefone").value;
    cpf = document.getElementById("idCPF").value;
    data = document.getElementById("idData").value;
    endereco = document.getElementById("idEndereco").value;
    email = document.getElementById("idEmail").value;
    senha = document.getElementById("idSenha").value;
    aux = data.split("-");
    data = aux[0];
    
    if(nome.length <= 50){
        if(rg.length == 9){
            if(telefone.length == 11){
                if(cpf.length == 11){
                    if(calculaIdade(data) >= 18){
                        if(endereco.length <= 75){
                            if(email.length <= 50){
                                if(senha.length <= 20){
                                    alert("Cadastro realizado!");
                                    return true;
                                }
                                else{
                                    alert("A senha deve conter no máximo 20 caracteres!");
                                    document.getElementById("idSenha").focus();
                                    return(false);
                                }
                            }
                            else{
                                alert("O email deve conter no máximo 50 caracteres!");
                                document.getElementById("idEmail").focus();
                                return(false);
                            }
                        }
                        else{
                            alert("O enedereço deve conter no máximo 75 caracteres!");
                            document.getElementById("idEndereco").focus();
                            return(false);
                        }
                    }
                    else{
                        alert("Funcionário deve ser maior de idade!");
                        document.getElementById("idData").focus();
                        return(false);
                    }
                }
                else{
                    alert("CPF inválido, deve conter 11 caracteres");
                    document.getElementById("idCPF").focus();
                    return(false);
                }
            }
            else{
                alert("Telefone inválido, deve conter 11 numeros");
                document.getElementById("idTelefone").focus();
                return(false);
            }
        }
        else{
            alert("RG inválido, deve conter 9 caracteres");
            document.getElementById("idRG").focus();
            return(false);
        }
    }
    else{
       alert("O nome deve conter no máximo 50 caracteres!");
       document.getElementById("idNome").focus();
       return(false); 
    }
}

function calculaIdade(data){
    
    var dataAtual = new Date();
    var anoAtual = dataAtual.getFullYear();
    var mesAtual = dataAtual.getMonth() + 1;
    
    var anoNascParts = data.split('-');
    var diaNasc = anoNascParts[2];
    var mesNasc = anoNascParts[1];
    var anoNasc = anoNascParts[0];
    
    var idade = anoAtual - anoNasc;
    
    if(mesAtual < mesNasc)
        idade--;
    else{
        if(mesAtual == mesNasc){
            
            if(dataAtual.getDate() < diaNasc)
                idade--;
        }
    }
    
    return idade;
}

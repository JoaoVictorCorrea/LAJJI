var sideBar = document.getElementById("mobile-nav");
var openSidebar = document.getElementById("openSideBar");
var closeSidebar = document.getElementById("closeSideBar");
sideBar.style.transform = "translateX(-260px)";

function sidebarHandler(flag) {
    if (flag) {
        sideBar.style.transform = "translateX(0px)";
        openSidebar.classList.add("hidden");
        closeSidebar.classList.remove("hidden");
    } else {
        sideBar.style.transform = "translateX(-260px)";
        closeSidebar.classList.add("hidden");
        openSidebar.classList.remove("hidden");
    }
}

function validaDados(){
    
    var descricao = "", marca = "", tipo = "";
    var precoUnitario = 0.0, precoCompra = 0.0;
    var codigo = 0, quantidade = 0, quantidadeMinima = 0;

    tipo = document.getElementById("idBotao").value;
    
    if(tipo == 'Remover'){
        codigo = document.getElementById("idCodigo").value;
        
        if(codigo >= 0){
            alert("Produto de código " + codigo + " removido com sucesso!");
            return true;
        }
        else{
            alert("Código não pode ser negativo!");
            document.getElementById("idCodigo").value = "";
            return false;
        }
    }
    
    descricao = document.getElementById("idDescricao").value;
    marca = document.getElementById("idMarca").value;
    precoUnitario = parseFloat(document.getElementById("idPrecoUnitario").value);
    precoCompra = parseFloat(document.getElementById("idPrecoCompra").value);
    quantidade = document.getElementById("idQuantidade").value;
    quantidadeMinima = document.getElementById("idQuantidadeMinima").value;
    
    if(descricao.length <= 100){
        if(marca.length <= 50){
            if(precoUnitario >= 0.0){
                if(precoCompra >= 0.0){
                    if(quantidade >= 0){
                        if(quantidadeMinima >= 0){
                            if(tipo == 'Cadastrar')
                                alert(descricao + " cadastrado com sucesso!");
                            else{
                                if(tipo == 'Alterar'){
                                    codigo = document.getElementById("idCodigo").value;
                                    alert("Produto de código " + codigo + " alterado com sucesso!");
                                }
                            }
                            
                            return true;
                        }
                        else{
                            alert("A quantidade minima não pode ser negativa!");
                            document.getElementById("idQuantidadeMinima").focus();
                            document.getElementById("idQuantidadeMinima").value = "";
                            return(false);
                        }
                    }
                    else{
                        alert("A quantidade não pode ser negativa!");
                        document.getElementById("idQuantidade").focus();
                        document.getElementById("idQuantidade").value = "";
                        return(false);
                    }
                }
                else{
                    alert("O preço de compra não pode ser negativo!");
                    document.getElementById("idPrecoCompra").focus();
                    document.getElementById("idPrecoCompra").value = "";
                    return(false);
                }
            }
            else{
                alert("O preço unitário não pode ser negativo!");
                document.getElementById("idPrecoUnitario").focus();
                document.getElementById("idPrecoUnitario").value = "";
                return(false);
            }
        }
        else{
            alert("Marca inválida, deve conter no máximo 50 caracteres!");
            document.getElementById("idMarca").focus();
            document.getElementById("idMarca").value = "";
            return(false);
        }
    }
    else{
       alert("Nome inválido, deve conter no máximo 100 caracteres!");
       document.getElementById("idDescricao").focus();
       document.getElementById("idDescricao").value = "";
       return(false); 
    }
}
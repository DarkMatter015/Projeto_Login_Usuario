$("#goCadAluno").click(function(){
    $.ajax({
        url: "/cadAluno",
        method: "GET",
        data: {},
        success: function(pagina){
            $("#mainContainer").html(pagina);
            ativaClickAluno()
        },
        error: function(){
            alert("Deu ruim =(");
        }
    })
})

function ativaClickAluno(){
    $("#liveToastBtn").click(function(){
        let nome = $("#nome").val();
        let dtNascimento = $("#dtNascimento").val();
        let email = $("#email").val();

        $.ajax({
            url: "/cadAluno",
            method: "POST",
            data: {
                nome: nome,
                dtNascimento: dtNascimento,
                email: email
            },
            success: function(data){
                alert(data);
            },
            error: function(){
                alert("falha ao salvar");
            }
        })
    })
}


$("#goCadTurma").click(function(){
    $.ajax({
        url: "/cadTurma",
        method: "GET",
        data: {},
        success: function(pagina){
            $("#mainContainer").html(pagina);
            ativaClickTurma()
        },
        error: function(){
            alert("Deu ruim =(");
        }
    })
})

function ativaClickTurma(){
    $("#btCadTurma").click(function(){
        let nome = $("#nome").val();
        let ano = $("#ano").val();

        $.ajax({
            url: "/cadTurma",
            method: "POST",
            data: {
                nome: nome,
                ano: ano,
            },
            success: function(data){
                alert(data);
            },
            error: function(){
                alert("falha ao salvar");
            }
        })
    })
}
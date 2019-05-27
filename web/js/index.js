
function GuardarCliente(Identificacion, Nombre) {
    $.ajax({
        type: "POST",
        url: "ClienteService",
        data: {
            "Accion": "Registrar",
            "Identificacion": Identificacion,
            "Nombre": Nombre
        }
    })
            .done(function (response) {
                var json = JSON.parse(response);
                console.log(json);
                if (json.estado == true) {
                    Swal.fire({
                        type: 'success',
                        title: 'God job...',
                        text: json.mensaje
                    });
                } else {
                    Swal.fire({
                        type: 'error',
                        title: 'Oops...',
                        text: json.mensaje
                    });
                }
                cargarTablaCliente();
                console.log("success ");
            })
            .fail(function () {
                console.log("error ");
            })
            .always(function () {
                console.log("complete ");
            });
}
/**
 * Comment
 */
function cargarTablaCliente() {
    $.ajax({
        type: "POST",
        url: "ClienteService",
        data: {
            "Accion": "ObtenerTodos"
        }
    })
            .done(function (response) {
                $("#table-body").html(response);
                console.log("success ");
            })
            .fail(function () {
                console.log("error ");
            })
            .always(function () {
                console.log("complete ");
            });
}
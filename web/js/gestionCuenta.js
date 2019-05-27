
function ConsultarCliente(Identificacion) {
    $.ajax({
        url: "ClienteService",
        type: "POST",
        data: {
            "Accion": "Consultar",
            "Identificacion": Identificacion
        }
    })
            .done(function (response) {
                console.log(response);
                var json;
                try {
                    json = JSON.parse(response);
                } catch (e) {

                }
                console.log(json);
                if (json[1].estado === true) {
                    $("#staticNombre").val("Nombre: " + json[0].nombre);
                    $("#contenedorGestion").removeClass("d-none");
                    $("#contenedorGestion").addClass("d-block");
                    listadoCuentas(Identificacion);
                } else {
                    Swal.fire({
                        type: 'error',
                        title: 'Oops...',
                        text: json[1].mensaje
                    });
                    $("#staticNombre").val("");
                    $("#contenedorGestion").addClass("d-none");
                    $("#contenedorGestion").removeClass("d-block");
                }
                //$("#staticNombre").val();
                console.log("success ");
            })
            .fail(function () {
                console.log("error ");
            })
            .always(function () {
                console.log("complete ");
            });
}

function listadoCuentas(codigoCliente) {
    $.ajax({
        url: "ClienteService",
        type: "POST",
        data: {
            "Accion": "ObtenerTodasCuentas",
            "codigoCliente": codigoCliente
        }
    })
            .done(function (response) {
                console.log(response);
                $("#tbodyCuentas").html(response);
                //$("#staticNombre").val();
                console.log("success ");
            })
            .fail(function () {
                console.log("error ");
            })
            .always(function () {
                console.log("complete ");
            });
}
function GuardarCuentaAhorro(codigoCliente, saldo, numeroTarjeta, fechaVencimiento) {
    $.ajax({
        url: "ClienteService",
        type: "POST",
        data: {
            "Accion": "RegistrarCuentaBancariaAhorro",
            "codigoCliente": codigoCliente,
            "saldo": saldo,
            "numeroTarjeta": numeroTarjeta,
            "fechaVencimiento": fechaVencimiento
        }
    })
            .done(function (response) {
                var json = JSON.parse(response);
                console.log(json);
                if (json.estado === true) {
                    Swal.fire({
                        type: 'success',
                        title: 'God job...',
                        text: json.mensaje
                    });
                    listadoCuentas(codigoCliente);
                    $("#txtSaldo").val("");
                    $("#txtNumeroTarjeta").val("");
                    $("#txtFechaVencimiento").val("");
                } else {
                    Swal.fire({
                        type: 'error',
                        title: 'Oops...',
                        html: json.mensaje
                    });
                }
                //$("#staticNombre").val();
                console.log("success ");
            })
            .fail(function () {
                console.log("error ");
            })
            .always(function () {
                console.log("complete ");
            });
}



function Consignar(codigoCliente, numeroTarjeta, valor) {
    $.ajax({
        url: "ClienteService",
        type: "POST",
        data: {
            "Accion": "Consignar",
            "codigoCliente": codigoCliente,
            "codigoCuenta": numeroTarjeta,
            "valor": valor
        }
    })
            .done(function (response) {
                var json = JSON.parse(response);
                console.log(json);
                if (json.estado === true) {
                    Swal.fire({
                        type: 'success',
                        title: 'God job...',
                        html: json.mensaje
                    });
                    listadoCuentas(codigoCliente);
                } else {
                    Swal.fire({
                        type: 'error',
                        title: 'Oops...',
                        html: json.mensaje
                    });
                }
                //$("#staticNombre").val();
                console.log("success ");
            })
            .fail(function () {
                console.log("error ");
            })
            .always(function () {
                console.log("complete ");
            });
}

function Retirar(codigoCliente, numeroTarjeta, valor) {
    $.ajax({
        url: "ClienteService",
        type: "POST",
        data: {
            "Accion": "Retirar",
            "codigoCliente": codigoCliente,
            "codigoCuenta": numeroTarjeta,
            "valor": valor
        }
    })
            .done(function (response) {
                var json = JSON.parse(response);
                console.log(json);
                if (json.estado === true) {
                    Swal.fire({
                        type: 'success',
                        title: 'God job...',
                        html: json.mensaje
                    });
                    listadoCuentas(codigoCliente);

                } else {
                    Swal.fire({
                        type: 'error',
                        title: 'Oops...',
                        html: json.mensaje
                    });
                }
                //$("#staticNombre").val();
                console.log("success ");
            })
            .fail(function () {
                console.log("error ");
            })
            .always(function () {
                console.log("complete ");
            });
}

function Consultar(codigoCliente, numeroTarjeta) {
    $.ajax({
        url: "ClienteService",
        type: "POST",
        data: {
            "Accion": "ConsultarCuenta",
            "codigoCliente": codigoCliente,
            "codigoCuenta": numeroTarjeta
        }
    })
            .done(function (response) {
                if (response !== null) {
                    var json = JSON.parse(response);
                    console.log(json);
                    if (json.estado === true) {
                        $("#contenedorSaldoConsultar").html("<b>" + json.mensaje + "</b>");
                    } else {
                        $("#contenedorSaldoConsultar").html("----");
                        Swal.fire({
                            type: 'error',
                            title: 'Oops...',
                            html: json.mensaje
                        });
                    }

                }
                //$("#staticNombre").val();
                console.log("success ");
            })
            .fail(function () {
                console.log("error ");
            })
            .always(function () {
                console.log("complete ");
            });
}
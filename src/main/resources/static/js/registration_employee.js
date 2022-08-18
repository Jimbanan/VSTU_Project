function pageOpenAuthorization(port) {
    const result = confirm("Вы хотите отменить регистрацию?");
    if (result) {
        const url = 'http://localhost:' + port + "/authorization";
        window.location.href = url
    }
}
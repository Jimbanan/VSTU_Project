function pageOpenAuthorization() {
    const result = confirm("Вы хотите отменить регистрацию?");
    if (result) {
        window.location.href = "http://localhost:8080/authorization"
    }
}
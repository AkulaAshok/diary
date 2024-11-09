<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>OTP Verification</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Enter OTP</h2>
        <form action="/verify-otp" method="post">
            <div class="mb-3">
                <label for="otp" class="form-label">OTP</label>
                <input type="text" class="form-control" id="otp" name="otp" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Verify OTP</button>
        </form>
        <c:if test="${not empty errorMsg}">
            <div class="alert alert-danger mt-3">${errorMsg}</div>
        </c:if>
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration Successful</title>
    <!-- Bootstrap 5.3 CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <!-- Header -->
    <header class="bg-success text-white text-center py-3">
        <h1>Digital Diary</h1>
    </header>

    <!-- Main Content -->
    <div class="container mt-5 text-center">
        <h2 class="text-success">Response from Server</h2>
        <p>${msg}</p>
        <a href="/" class="btn btn-primary mt-3">Go to Login</a>
    </div>

    <!-- Bootstrap JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

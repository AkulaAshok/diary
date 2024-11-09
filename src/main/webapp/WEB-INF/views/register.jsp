<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <!-- Bootstrap 5.3 CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <!-- Header -->
    <header class="bg-primary text-white text-center py-3">
        <h1>Digital Diary - Register</h1>
    </header>

    <!-- Main Content -->
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h2 class="card-title text-center mb-4">Create an Account</h2>
                        
                        <form action="register" method="post"> 
                            <div class="mb-3">
                                <label for="name" class="form-label">Full Name</label>
                                <input type="text" class="form-control" id="name" name="name" required>
                            </div>
                            <div class="mb-3">
                                <label for="email" class="form-label">Email address</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                                <c:if test="${not empty errorMsg}">
                                    <div class="text-danger mt-1">${errorMsg}</div>
                                </c:if>
                            </div>
                            
                            
                            <button type="submit" class="btn btn-primary w-100">Register</button>
                        </form>

                        <div class="text-center mt-3">
                            <p>Already have an account? <a href="/">Login here</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer class="bg-light text-center py-3 mt-5">
        <p class="mb-0">&copy; 2024 Digital Diary. All rights reserved.</p>
    </footer>
    
    <!-- Bootstrap JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

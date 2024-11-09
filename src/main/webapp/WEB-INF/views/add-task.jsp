<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Task</title>
    
    <!-- Bootstrap 5.3 CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    
    <style>
        /* Internal CSS */
        body {
            background-color: #f8f9fa;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        header, footer {
            background-color: #343a40;
            color: white;
            padding: 10px 0;
        }
        h2 {
            color: #343a40;
        }
        footer {
            margin-top: auto;
            text-align: center;
        }
    </style>
</head>
<body>

    <!-- Header -->
    <header>
        <div class="container">
            <h1 class="text-center">My Diary Application</h1>
        </div>
    </header>
    
    <!-- Main Content -->
    <div class="container mt-5">
        <h2 class="text-center mb-4">Add New Task</h2>
        
        <form action="/tasks/save" method="post">
            <div class="mb-3">
                <label for="taskName" class="form-label">Task Name</label>
                <input type="text" class="form-control" id="taskName" name="title" required>
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
            </div>
            <div class="mb-3">
                <label for="date" class="form-label">Date</label>
                <input type="date" class="form-control" id="date" name="createdDate" required>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-primary">Add Task</button>
                <a href="/tasks" class="btn btn-secondary">Cancel</a>
            </div>
        </form>
    </div>

    <!-- Footer -->
    <footer>
        <div class="container">
            <p>&copy; 2024 My Diary Application. All rights reserved.</p>
        </div>
    </footer>

    <!-- Bootstrap JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

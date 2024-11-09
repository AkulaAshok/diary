<%@page import="main.java.com.apps.diary.entity.UserEntity"%>
<%@page import="main.java.com.apps.diary.entity.TaskEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Task Dashboard</title>
    
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
        .table th {
            background-color: #007bff;
            color: white;
        }
        .table td {
            vertical-align: middle;
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

    <%
        // Retrieve userId from session
        UserEntity user = (UserEntity) session.getAttribute("user");
    
    String name=user.getName();
    
    System.out.print(user.toString());
           %>
    
    
    <div class="d-flex justify-content-center my-4">
    <h5 class="text-primary fw-bold">
        <%= name %>
    </h5>
</div>

    
    <!-- Main Content -->
    <div class="container mt-5">
        <h2 class="text-center mb-4">Task Dashboard</h2>
        
        <!-- Add Task Button -->
        <div class="mb-3 text-end">
            <a href="/tasks/add" class="btn btn-success">Add Task</a>
        </div>

        <!-- Task Table -->
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Task Name</th>
                    <th>Description</th>
                    <th>Date</th> <!-- Added Date column -->
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<TaskEntity> tasks = (List<TaskEntity>) request.getAttribute("tasks");
                    if (tasks != null && !tasks.isEmpty()) {
                        for (TaskEntity task : tasks) {
                %>
                            <tr>
                                <td><%= task.getId() %></td>
                                <td><%= task.getTitle() %></td>
                                <td><%= task.getDescription() %></td>
                                <td><%= task.getCreatedDate() %></td>
                                
                                <td>
                                    <!-- Edit Button -->
                                    <a href="/tasks/edit/<%= task.getId() %>" class="btn btn-warning btn-sm">Edit</a>
                                    <!-- Delete Button -->
                                    <form action="/tasks/delete/<%= task.getId() %>" method="post" style="display:inline;">
                                        <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this task?');">Delete</button>
                                    </form>
                                </td>
                            </tr>
                <%
                        }
                    } else {
                %>
                        <tr>
                            <td colspan="5" class="text-center">No tasks available.</td> <!-- Adjusted colspan -->
                        </tr>
                <%
                    }
                %>
            </tbody>
        </table>

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

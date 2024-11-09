<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 60%;
            margin: 0 auto;
            padding: 20px;
            background: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
            animation: fadeIn 1.5s;
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
        }
        p {
            color: #666;
            margin-bottom: 20px;
        }
        form {
            margin: 10px 0;
        }
        input[type="submit"] {
            background-color: #555;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s, transform 0.3s;
        }
        input[type="submit"]:hover {
            background-color: lightgreen;
            transform: scale(1.1);
        }
        .footer {
            margin-top: 20px;
            color: #888;
            font-size: 14px;
        }
    </style>
</head>

<body>
    <div class="container">
        <h2>WELCOME</h2>
        <p>Welcome to the Student Database. Manage your student records efficiently and effectively.</p>
        <form action="reg">
            <input type="submit" value="Register"/>
        </form>
        <form action="show">
            <input type="submit" value="Show All"/>
        </form>
        <form action="log">
            <input type="submit" value="Login"/>
        </form>
        <form action="adminLogin">
            <input type="submit" value="Admin Login"/>
        </form>
        <div class="footer">
            &copy; 2024 Student Database. All rights reserved.
        </div>
    </div>
</body>
</html>

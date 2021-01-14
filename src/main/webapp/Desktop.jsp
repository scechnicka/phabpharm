<%--
  Created by IntelliJ IDEA.
  User: Sarah
  Date: 14/01/2021
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h1>Welcome to the Phab Pharmacy online store!</h1>
    <p>Pick the relevant options in each dropdown menu or search for the medicine you are looking for and checkout to order your drug.</p>

    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">
    <style>
        * {box-sizing: border-box;}

        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif
        }

        .topnav {
            overflow: hidden;
            background-color: #e9e9e9;
        }
        .topnav a {
            float: left;
            display: block;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        .topnav a.active {
            background-color: #2196F3;
            color: white;
        }

        .topnav .search-container {
            float: right;
        }

        .topnav input[type=text] {
            padding: 6px;
            margin-top: 8px;
            font-size: 17px;
            border: none;
        }

        .topnav .search-container button {
            float: right;
            padding: 6px 10px;
            margin-top: 8px;
            margin-right: 16px;
            background: #ddd;
            font-size: 17px;
            border: none;
            cursor: pointer;
        }
        .topnav .search-container button:hover {
            background: #ccc;
        }

        @media screen and (max-width: 600px) {
            .topnav .search-container {
                float: none;
            }
            .topnav a, .topnav input[type=text], .topnav .search-container button {
                float: none;
                display: block;
                text-align: left;
                width: 100%;
                margin: 0;
                padding: 14px;
            }
            .topnav input[type=text] {
                border: 1px solid #ccc;
            }
        }

        }
    </style>
</head>
<body>
</style>

</head>
<body>

<div class=\"topnav\">
           <a class=\"active\" href=\"#home\">Home</a>
                                                    <div class=\"search-container\">
                                                               <form action=\"/action_page.php\">
                                                                               <input type=\"text\" placeholder=\"Search..\" name=\"search\">
                                                                                                                                  <button type=\"submit\"><i class=\"fa fa-search\"></i></button>
                                                                                                                                                                                          </form>
                                                                                                                                                                                            </div>
                                                                                                                                                                                              </div>

                                                                                                                                                                                                <br>
                                                                                                                                                                                                <br>
                                                                                                                                                                                                <br>

                                                                                                                                                                                                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">
                                                                                                                                                                                                                                                                     <style>
                                                                                                                                                                                                                                                                     .dropbtn {
                                                                                                                                                                                                                                                                         background-color: #4CAF50;
                                                                                                                                                                                                                                                                         color: white;
                                                                                                                                                                                                                                                                         padding: 16px;
                                                                                                                                                                                                                                                                         font-size: 16px;
                                                                                                                                                                                                                                                                         border: none;
                                                                                                                                                                                                                                                                     }

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f1f1f1;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;}
</style>
</head>
<body>


<div class=\"dropdown\">
    <button class=\"dropbtn\">Select a medicine type</button>
    <div class=\"dropdown-content\">
        <a href=\"#\">Link 1</a>
        <a href=\"#\">Link 2</a>
        <a href=\"#\">Link 3</a>
    </div>
</div>

<div class=\"dropdown\">
    <button class=\"dropbtn\">Select a medicine brand</button>
    <div class=\"dropdown-content\">
        <a href=\"#\">Link 1</a>
        <a href=\"#\">Link 2</a>
        <a href=\"#\">Link 3</a>
    </div>
</div>

<div class=\"dropdown\">
    <button class=\"dropbtn\">Select a quantity</button>
    <div class=\"dropdown-content\">
        <a href=\"#\">Link 1</a>
        <a href=\"#\">Link 2</a>
        <a href=\"#\">Link 3</a>
    </div>
</div>

<br>
<br>
<br>

<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">
<style>
    .block {
        display: block;
        width: 100%;
        border: none;
        background-color: #4CAF50;
        color: white;
        padding: 14px 28px;
        font-size: 16px;
        cursor: pointer;
        text-align: center;
    }

    .block:hover {
        background-color: #ddd;
        color: black;
    }
</style>
</head>
<body>

<button class=\"block\">Checkout</button>

</body>
</html>

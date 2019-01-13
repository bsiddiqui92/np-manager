<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pojo to Json Serialization using Jersey with Jackson for Java REST Services</title>

    <script src="/js/jquery-1.11.2.min.js"></script>
    <script>
        var ctxPath = "<%=request.getContextPath() %>";
        $(function(){
            $("#postPerson, #postMessage, #createUser").on("click", function(){
                var url;
                var data;
                if($(this).attr("id") === "postMessage"){
                    url = ctxPath+"/api/message/post";
                    data = '{"firstName":"Michael", "lastName":"Jordan"}';
                }
                if($(this).attr("id") === "postPerson"){
                    url = ctxPath+"/api/person/post";
                    data = '{"firstName":"Michael", "lastName":"Jordan"}';
                }
                if($(this).attr("id") === "createUser"){
                    url = ctxPath+"/api/users/createUser";
                    data = '{"firstName":"Tahir", "lastName":"Siddiqui", "email":"tssaeed@gmail.com", "password":"secret"}';
                }

                $.ajax({
//                    url: $(this).attr("id") === "postMessage" ? ctxPath+"api/message/post" : ctxPath+"api/person/post",
                    url : url,
                    type: "POST",
                    data: data,
                    contentType: "application/json",
                    cache: false,
                    dataType: "json",
                    success : function(){console.log("Success.")},
                    error : function (err) {
                        console.log(err)
                    }
                });
            });
        });
    </script>

</head>

<body>
<h1>Pojo to Json Serialization using Jersey with Jackson for Java REST Services</h1>
<ul>
    <li><a href="<%=request.getContextPath() %>/api/message">/api/message</a></li>
    <li><a href="<%=request.getContextPath() %>/api/message/ping">/api/message/ping</a></li>
    <li><a href="<%=request.getContextPath() %>/api/person/get">/api/person/get</a></li>
    <li><a href="<%=request.getContextPath() %>/api/users/get">/api/users/get</a></li>
    <li><button id="postPerson">Post Person</button></li>
    <li><button id="postMessage">Post Message</button></li>
    <li><button id="createUser">Create User</button></li>
</ul>


</body>

</html>
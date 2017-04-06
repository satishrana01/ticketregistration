<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>Message</title>
</head>
<body>
        <div class="container">
           <div style="position: absolute; padding-left: 10px; padding-top: 2px; z-index: 999;" id="logo">
           <a target="_blank" title="London Comic Con" href="http://www.mcmcomiccon.com/london/">
            <img src="images/londondatebannerlogo.png"/>
            </a></div>
            <header>
                <h1>Registration Failed </h1>
				<br>
				<br>
				<br>
				<h1><%=request.getAttribute("message")%></h1>
								
            </header>
			<p><a href="/ticketregistration" class="to_register"> Go and log in </a></p>
</div>
</body>
</html>
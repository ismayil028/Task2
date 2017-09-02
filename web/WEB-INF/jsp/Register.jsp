<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
form {
	margin: 0 auto;
	width: 300px
}

input {
	margin-bottom: 3px;
	padding: 10px;
	width: 100%;
	border: 1px solid #CCC
}

button {
	padding: 10px
}

label {
	cursor: pointer
}

#form-switch {
	display: none
}
</style>
</head>
<body>
<h1>${msg}</h1>
<h1>${asd}</h1>
	<form id='register-form' action="/Task2/registersuccess" method='post'>
		<input type="text" name="name" placeholder="Full Name" required/> 
		<input type="email" name="email" placeholder="Email"  required/> 
		<input type="password" name="password" placeholder="Password" required/>
		<button type='submit'>Register</button>

	</form>
</body>
</html>
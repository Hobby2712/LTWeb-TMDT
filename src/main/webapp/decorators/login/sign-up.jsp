<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
    <div id="logreg-forms">
        <form class="form-signin" action="/Web/signup" method="post">
            <p></p>
            <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
                Sign Up</h1>
            <p class="text-danger">${mess}</p>
            <input name="email" type="text" id="user-email" class="form-control"
				placeholder="Email" required="" autofocus="">
			<input name="user" type="text" id="user-name" class="form-control"
				placeholder="User name" required="" autofocus=""> <input
				name="pass" type="password" id="user-pass" class="form-control"
				placeholder="Password" required autofocus=""> <input
				name="repass" type="password" id="user-repeatpass"
				class="form-control" placeholder="Repeat Password" required
				autofocus="">

			<button class="btn btn-primary btn-block" type="submit">
				<i class="fa fa-user-plus"></i> Sign Up
			</button>
			<a href="/Web/loginAccount" id="cancel_signup"><i class=" fa fa-angle-left"></i> Back</a>
        </form>

    </div>
</body>
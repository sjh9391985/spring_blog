<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp" %>


<div class="container">
<h2>로그인</h2>
<form action="#" method="post">
    <div class="form-group">
      <label for="username">Username:</label>
      <input type="text" class="form-control" name="username" id="username" placeholder="Enter username" name="username">
    </div>

    <div class="form-group">
        <label for="pwd">Password:</label>
        <input type="password" class="form-control" name="password" id="pwd" placeholder="Enter password" name="pwd">
    </div>

    <div class="form-group form-check">
      <label class="form-check-label">
        <input name="remember" class="form-check-input" type="checkbox" name="remember"> ID 저장
      </label>
    </div>
    <button id="btn-login" class="btn btn-primary">로그인</button>
  </form>

</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp" %>


<div class="container">
<h2>로그인</h2>
<form>

    <div class="form-group">
      <label for="username">Username:</label>
      <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
    </div>

    <div class="form-group">
        <label for="pwd">Password:</label>
        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
    </div>

    <div class="form-group form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> ID 저장
      </label>
    </div>

  </form>
  <button id="btn-login" class="btn btn-primary">로그인</button>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>
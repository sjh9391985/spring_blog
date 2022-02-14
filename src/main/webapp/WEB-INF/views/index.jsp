<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/blog/">HOME</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/user/join"><span class="glyphicon glyphicon-user"></span>회원가입</a></li>
        <li><a href="/user/login"><span class="glyphicon glyphicon-log-in"></span>로그인</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
    <div class="card m-2" style="width:400px">
        <div class="card-body">
            <h4 class="card-title">title 영역</h4>
            <p class="card-text">content 영역</p>
            <a href="#" class="btn btn-primary">상세보기</a>
        </div>
    </div>

    <div class="card m-2" style="width:400px">
        <div class="card-body">
            <h4 class="card-title">title 영역</h4>
            <p class="card-text">content 영역</p>
            <a href="#" class="btn btn-primary">상세보기</a>
        </div>
    </div>

    <div class="card m-2" style="width:400px">
        <div class="card-body">
            <h4 class="card-title">title 영역</h4>
            <p class="card-text">content 영역</p>
            <a href="#" class="btn btn-primary">상세보기</a>
        </div>
    </div>
</div>

<div class="jumbotron text-center" style="margin-bottm:0">
    <p>Created by Gmta</p>
    <p>📞 010-2527-1985</p>
    <p>📍 부산 북구 만덕동</p>
</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
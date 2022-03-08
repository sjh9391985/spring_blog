<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="container">
    <form>
        <div class="form-group">
          <label for="title">TITLE</label>
          <input type="text" class="form-control" id="title" placeholder="Enter title" >
        </div>

        <div class="form-group">
          <label for="content">Content</label>
          <textarea id="content" rows="5" class="form-control summernote"></textarea>
        </div>

      </form>

      <button id="btn-save" class="btn btn-primary">save</button>
</div>
    <script>
      $('.summernote').summernote({
        tabsize: 2,
        height: 300
      });
    </script>
    <script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>
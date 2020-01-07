<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="https://code.jquery.com/jquery-3.0.0.js"></script>
<script src="https://code.jquery.com/jquery-migrate-3.1.0.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../tableHeader.jsp" %>


<div id="page-wrapper" style="min-height: 474px;">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Użytkownicy</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-table fa-fw"></i> Użytkownicy
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <table width="100%" class="table table-hover" id="dataTables-example">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.name}</td>
                                <td>
                                    <a href="/user/delete/${user.id}">Delete</a>
                                    <span> / </span>
                                    <a href="/user/edit/${user.id}">Editaaaa</a>
                                      <button type="button" class="btn btn-primary" data-id="${user.id}" data-toggle="modal" data-target="#myModal">Modal</button>
                                    
                                </td>
                            </tr>
                            </c:forEach>                     
                        
                        </tbody>
                    </table>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
</div>
<!-- /#page-wrapper -->

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h3 class="modal-title" id="exampleModalLongTitle"><i class="fa fa-edit fa-fw"></i> Zmień nazwę użytkownika </h3>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
			<form id="user">
				<input type="hidden" id="id" name="id">
				<label for="user_name" id="user">Name</label>
				<input type="text" id="user_name" name="name">

			 </form> 
			
			<div id="ajax-errors" class="alert alert-danger" role="alert" style="display: none">Nie działa</div>
			
			
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> 
        <button type="button" class="btn btn-primary" id="btnSaveEdit">Save changes</button>
  
        </div>
      </div>
    </div>
  </div>
</div>

  			<script>
$('#btnSaveEdit').click(function() 
		{
		var a = 11
		var id = $('#id').val();
		var name = $('#user_name').val();
		alert(name)
		})
</script> 

<%@include file="../tableFooter.jsp" %>

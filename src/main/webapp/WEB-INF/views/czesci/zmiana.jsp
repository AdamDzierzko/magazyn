<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../tableHeader.jsp" %>

<div id="page-wrapper" style="min-height: 474px;">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Elementy</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-edit fa-fw"></i> Zmiana ilosci elementu
                </div>
                <div class="panel-body">
                    <div class="row">
                        <form method="post">
                            <div class="col-sm-3">

                                <div class="form-group">
                                    <label>zmiana ilosci elementu ${czesci.nazwa}</label>
                                    <input name="z" type="text" class="form-control"/>
                                    <input name="i" type="hidden" class="form-control" value="${czesci.id}"/>
                                </div>

                                <button type="submit" class="btn btn-default">Submit</button>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /#page-wrapper -->

<%@include file="../tableFooter.jsp" %>

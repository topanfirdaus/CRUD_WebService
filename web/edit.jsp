<%-- 
    Document   : edit
    Created on : Dec 13, 2017, 9:26:15 PM
    Author     : Topan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="">
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
            <c:forEach items="${karyawans}" var="karyawan" varStatus="loop">
            <form action="/topan_mgs/karyawan" method="post" class="form-horizontal" role="form">
                <div class="form-group">
                    <legend>Edit Data Karyawan</legend>
                </div>
                <input name="no" id="no" value="${karyawan.no}" style="display: none"/>
                <div class="form-group">
                    <label for="nama" class="col-sm-2 control-label">Nama Lengkap</label>
                    <div class="col-sm-10">
                        <input value="${karyawan.nama}" type="text" class="form-control" id="Nama" name="nama" placeholder="Nama Lengkap">
                    </div>
                </div>
                <div class="form-group">
                    <label for="jurusan" class="col-sm-2 control-label">Jurusan</label>
                    <div class="col-sm-10">
                        <input value="${karyawan.jurusan}" type="text" class="form-control" id="jurusan" name="jurusan" placeholder="Jurusan">
                    </div>
                </div>
                <div class="form-group">
                    <label for="asal" class="col-sm-2 control-label">Asal</label>
                    <div class="col-sm-10">
                        <input value="${karyawan.asal}" type="text" class="form-control" id="asal" name="asal" placeholder="Asal">
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-10 col-sm-offset-2">
                        <button type="submit" class="btn btn-primary pull-right">Simpan</button>
                    </div>
                </div>
            </form>
            </c:forEach>
        </div>
    </body>
</html>

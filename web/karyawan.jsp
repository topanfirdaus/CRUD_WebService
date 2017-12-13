<%-- 
    Document   : karyawan
    Created on : Dec 13, 2017, 8:04:36 PM
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
            <form action="/topan_mgs/karyawan" method="post" class="form-horizontal" role="form">
                <div class="form-group">
                    <legend>Tambah Karyawan</legend>
                </div>
                <div class="form-group">
                    <label for="nama" class="col-sm-2 control-label">Nama Lengkap</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="Nama" name="nama" placeholder="Nama Lengkap">
                    </div>
                </div>
                <div class="form-group">
                    <label for="jurusan" class="col-sm-2 control-label">Jurusan</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="jurusan" name="jurusan" placeholder="Jurusan">
                    </div>
                </div>
                <div class="form-group">
                    <label for="asal" class="col-sm-2 control-label">Asal</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="asal" name="asal" placeholder="Asal">
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-10 col-sm-offset-2">
                        <button type="submit" class="btn btn-primary pull-right">Simpan</button>
                    </div>
                </div>
            </form>
        </div>
        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th>No</th>
                <th>Nama</th>
                <th>Jurusan</th>
                <th>Asal</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${karyawans}" var="karyawan" varStatus="loop">
                <tr>
                    <td>${loop.index+1}</td>
                    <td>${karyawan.nama}</td>
                    <td>${karyawan.jurusan}</td>
                    <td>${karyawan.asal}</td>
                    <td>
                        <a href="/topan_mgs/edit?no=${karyawan.no}">Edit</a>
                        <a href="/topan_mgs/karyawan?no=${karyawan.no}" class="btn btn-danger btn-sm">Hapus</a>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
       
    </div>
    </body>
</html>

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.karyawan;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.karyawanService;

/**
 *
 * @author Topan
 */
@WebServlet("/edit")
public class editServlet extends HttpServlet {

    private karyawanService service = new karyawanService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        karyawan Karyawan = new karyawan();
        if (req.getParameter("no") != null) {
            Karyawan.setNo(Long.parseLong(req.getParameter("no")));
        }

        Karyawan.setNama(req.getParameter("nama"));
        Karyawan.setJurusan(req.getParameter("jurusan"));
        Karyawan.setAsal(req.getParameter("asal"));

        service.update(Karyawan);
        resp.sendRedirect("/topan_mgs/karyawan");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        String id = req.getParameter("no");
        karyawan karyawan = service.findById(Long.parseLong(id));
        List<karyawan> karyawans = new ArrayList<>();
        karyawans.add(karyawan);
        req.setAttribute("karyawans", karyawans);
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

}

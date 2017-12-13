/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implement;

import dao.karyawanDao;
import entity.karyawan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import koneksi.koneksiDB;

/**
 *
 * @author Topan
 */
public class karyawanDaoImplement implements karyawanDao {

    @Override
    public karyawan Save(karyawan entity) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      String sql = "INSERT INTO karyawan VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement statement = koneksiDB.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, entity.getNo());
            statement.setString(2, entity.getNama());
            statement.setString(3, entity.getJurusan());
            statement.setString(4, entity.getAsal());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                entity.setNo(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public karyawan update(karyawan entity) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   String sql = "UPDATE karyawan SET " +
                "nama = ?, " +
                "jurusan = ?, " +
                "asal = ? " +
                "WHERE no = ? ";
        try {
            PreparedStatement statement = koneksiDB.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, entity.getNama());
            statement.setString(2, entity.getJurusan());
            statement.setString(3, entity.getAsal());
            statement.setLong(4, entity.getNo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public List<karyawan> find(int offset, int limit) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    List<karyawan> karyawans = new ArrayList<>();
        String sql = "SELECT * FROM karyawan " +
                "ORDER BY no DESC ";

        if (offset != 0 && limit != 0) {
            sql += "limit ?, ? ";
        }

        try {
            PreparedStatement statement = koneksiDB.getInstance().getConnection().prepareStatement(sql);
            if (offset != 0 && limit != 0) {
                statement.setInt(1, offset);
                statement.setInt(2, limit);
            }

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                karyawan Karyawan = new karyawan();
                Karyawan.setNo(rs.getInt("no"));
                Karyawan.setNama(rs.getString("nama"));
                Karyawan.setJurusan(rs.getString("jurusan"));
                Karyawan.setAsal(rs.getString("asal"));
                karyawans.add(Karyawan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return karyawans;
    }

    @Override
    public karyawan findByNo(long no) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    karyawan Karyawan = new karyawan();
        String sql = "SELECT * FROM karyawan WHERE no = ? ";

        try {
            PreparedStatement statement = koneksiDB.getInstance().getConnection().prepareStatement(sql);
            statement.setLong(1, no);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Karyawan.setNo(rs.getInt("no"));
                Karyawan.setNama(rs.getString("nama"));
                Karyawan.setJurusan(rs.getString("jurusan"));
                Karyawan.setAsal(rs.getString("asal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Karyawan;
    }

    @Override
    public String delete(long no) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     String sql = "DELETE FROM karyawan WHERE no = ? ";
        String message;
        try {
            PreparedStatement statement = koneksiDB.getInstance().getConnection().prepareStatement(sql);
            statement.setLong(1, no);
            int status = statement.executeUpdate();
            if (status == 0) {
                message = "Delete Failed!";
            } else {
                message = "Record is deleted!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            message = "Delete Failed!";
        }

        return message;
    }
    }
    

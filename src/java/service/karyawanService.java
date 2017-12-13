/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import dao.implement.karyawanDaoImplement;
import dao.karyawanDao;
import entity.karyawan;
import java.util.List;

/**
 *
 * @author Topan
 */
public class karyawanService implements BaseService<karyawan> {
     private karyawanDao karyawanDao = new karyawanDaoImplement();

    @Override
    public karyawan Save(karyawan entity) {
        if (entity.getNo() == 0) {
            entity = karyawanDao.Save(entity);
        } else {
            entity = karyawanDao.update(entity);
        }

        return entity;
    }

    @Override
    public List<karyawan> find(int offset, int limit) {
        return karyawanDao.find(offset, limit);
    }

    @Override
    public karyawan findById(long no) {
        return karyawanDao.findByNo(no);
    }

    @Override
    public String delete(long no) {
        return karyawanDao.delete(no);
    }

    @Override
    public karyawan update(karyawan entity) {
        return karyawanDao.update(entity);
    }
}
    


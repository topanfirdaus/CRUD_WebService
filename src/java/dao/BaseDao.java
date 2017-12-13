/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;

/**
 *
 * @author Topan
 */
public interface BaseDao<T> {
    T Save(T entity);

    T update(T entity);

    List<T> find(int offset, int limit);

    T findByNo(long no);

    String delete(long no);
}
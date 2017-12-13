/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.List;

/**
 *
 * @author Topan
 */
public interface BaseService<T> {

    T Save(T entity);

    List<T> find(int offset, int limit);

    T findById(long no);

    String delete(long no);
    
    T update (T entity);
            
           
}


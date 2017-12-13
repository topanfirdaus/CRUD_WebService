/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

/**
 *
 * @author Topan
 */
public class BaseEntity {
     private long no;

    public BaseEntity() {
    }

    public BaseEntity(long no) {
        this.no = no;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "no=" + no +
                '}';
    }
}

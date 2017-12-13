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
public class karyawan extends BaseEntity{
   
    private String nama;
     private String jurusan;
    private String asal;

    public karyawan() {
    }

    public karyawan(long no){
        super (no);
    }



    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
        public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    @Override
    public String toString() {
        return "karyawan{" +
                "nama='" + nama + '\'' +
                ", jurusan='" + jurusan + '\'' +
                ", asal='" + asal + '\'' +
                '}';
    }
}

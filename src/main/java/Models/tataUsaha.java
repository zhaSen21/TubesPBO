package Models;

import Interface.tataUsahaInterface;
import java.sql.SQLException;
import java.util.List;

public class tataUsaha implements tataUsahaInterface{

    private String idTu;
    private String nama;
    private String usia;
    private String pendidikan;

    public tataUsaha(String idTu, String nama, String usia, String pendidikan) {
        this.idTu = idTu;
        this.nama = nama;
        this.usia = usia;
        this.pendidikan = pendidikan;
    }

    public String getIdTu() {
        return idTu;
    }

    public void setIdTu(String idTu) {
        this.idTu = idTu;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }


    @Override
    public tataUsaha insert(tataUsaha o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(tataUsaha o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String idTu) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<tataUsaha> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

package Controller;

import Interface.siswaInterface;
import Database.ConnectionHelper;
import Models.siswa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class siswaController implements siswaInterface {

    PreparedStatement st;

    @Override
    public siswa insertTra(siswa o) throws SQLException {
        st = ConnectionHelper.getConnection().prepareStatement(
                "Insert into siswa values(?,?,?,?,?,?)");
        st.setString(1, o.getNis());
        st.setString(2, o.getNama());
        st.setString(3, o.getJurusan());
        st.setString(4, o.getKelas());
        st.setString(5, o.getJumlah());
        st.setString(6, o.getStatus());
        st.executeUpdate();
        return o;
    }

    @Override
    public siswa insert(siswa o) throws SQLException {
        st = ConnectionHelper.getConnection().prepareStatement(
                "Insert into siswa values(?,?,?,?,?,?)");
        st.setString(1, o.getNis());
        st.setString(2, o.getNama());
        st.setString(3, o.getJurusan());
        st.setString(4, o.getKelas());
        st.setString(5, o.getJumlah());
        st.setString(6, o.getStatus());
        st.executeUpdate();
        return o;
    }

    @Override
    public void update(siswa o) throws SQLException {
        st = ConnectionHelper.getConnection().prepareStatement(
                "Update siswa set nama=?, jurusan=?, kelas=? where nis=?");
        st.setString(1, o.getNis());
        st.setString(2, o.getNama());
        st.setString(3, o.getJurusan());
        st.setString(4, o.getKelas());
        st.executeUpdate();
    }

    @Override
    public void delete(String nis) throws SQLException {
        st = ConnectionHelper.getConnection().prepareStatement(
                "Delete from siswa where nis=?");
        st.setString(1, nis);
        st.executeUpdate();
    }

    @Override
    public List<siswa> getAll() throws SQLException {
        Statement st = ConnectionHelper.getConnection().createStatement();
        ResultSet rs = st.executeQuery("Select * from siswa");
        List<siswa> list = new ArrayList<siswa>();
        while (rs.next()) {
            siswa mhs = new siswa(null, null, null, null, null, null);
            mhs.setNis(rs.getString("Nis"));
            mhs.setNama(rs.getString("Nama"));
            mhs.setJurusan(rs.getString("Jurusan"));
            mhs.setKelas(rs.getString("Kelas"));
            list.add(mhs);
        }
        return list;
    }

    @Override
    public List<siswa> getAlls() throws SQLException {
        Statement st = ConnectionHelper.getConnection().createStatement();
        ResultSet rs = st.executeQuery("Select * from siswa");
        List<siswa> list = new ArrayList<siswa>();
        while (rs.next()) {
            siswa mhs = new siswa(null, null, null, null, null, null);
            mhs.setNis(rs.getString("Nis"));
            mhs.setNama(rs.getString("Nama"));
            mhs.setJurusan(rs.getString("Jurusan"));
            mhs.setKelas(rs.getString("Kelas"));
            mhs.setJumlah(rs.getString("Jumlah"));
            mhs.setStatus(rs.getString("Status"));
            list.add(mhs);
        }
        return list;
    }

}

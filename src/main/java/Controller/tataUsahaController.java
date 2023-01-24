package Controller;

import Interface.tataUsahaInterface;
import Database.ConnectionHelper;
import Models.tataUsaha;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class tataUsahaController implements tataUsahaInterface{

    PreparedStatement st;

    @Override
    public tataUsaha insert(tataUsaha o) throws SQLException {
        st = ConnectionHelper.getConnection().prepareStatement(
                "Insert into tatausaha values(?,?,?,?)");
        st.setString(1, o.getIdTu());
        st.setString(2, o.getNama());
        st.setString(3, o.getUsia());
        st.setString(4, o.getPendidikan());
        st.executeUpdate();
        return o;
    }

    @Override
    public void update(tataUsaha o) throws SQLException {
        st = ConnectionHelper.getConnection().prepareStatement(
                "UPDATE tatausaha set nama=?, usia=?, pendidikan=? where idTu=?");

        st.setString(1, o.getIdTu());
        st.setString(2, o.getNama());
        st.setString(3, o.getUsia());
        st.setString(4, o.getPendidikan());
        st.executeUpdate();
    }

    @Override
    public void delete(String idTu) throws SQLException {
        st = ConnectionHelper.getConnection().prepareStatement(
                "Delete from tatausaha where idTu=?");
        st.setString(1, idTu);
        st.executeUpdate();
    }

    @Override
    public List<tataUsaha> getAll() throws SQLException {
        Statement st = ConnectionHelper.getConnection().createStatement();
        ResultSet rs = st.executeQuery("Select * from tatausaha");
        List<tataUsaha> list = new ArrayList<tataUsaha>();
        while (rs.next()) {
            tataUsaha tus = new tataUsaha(null, null, null, null);
            tus.setIdTu(rs.getString("idTu"));
            tus.setNama(rs.getString("Nama"));
            tus.setUsia(rs.getString("Usia"));
            tus.setPendidikan(rs.getString("Pendidikan"));
            list.add(tus);
        }
        return list;
    }
    
}

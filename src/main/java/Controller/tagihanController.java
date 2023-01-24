/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Interface.tagihanInterface;
import Database.ConnectionHelper;
import Models.tagihan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class tagihanController implements tagihanInterface{
    PreparedStatement st;

    @Override
    public tagihan insert(tagihan o) throws SQLException {
        st = ConnectionHelper.getConnection().prepareStatement(
                "Insert into tagihan values(?,?)");
        st.setString(1, o.getJumlah());
        st.setString(2, o.getStatus());
        st.executeUpdate();
        return o;
    }

    @Override
    public void update(tagihan o) throws SQLException {
        st = ConnectionHelper.getConnection().prepareStatement(
                "UPDATE tagihan set status=? where jumlah=?");

        st.setString(1, o.getJumlah());
        st.setString(2, o.getStatus());
        st.executeUpdate();
    }

    @Override
    public void delete(String jumlah) throws SQLException {
        st = ConnectionHelper.getConnection().prepareStatement(
                "Delete from tagihan where jumlah=?");
        st.setString(1, jumlah);
        st.executeUpdate();
    }

    @Override
    public List<tagihan> getAll() throws SQLException {
        Statement st = ConnectionHelper.getConnection().createStatement();
        ResultSet rs = st.executeQuery("Select * from tagihan");
        List<tagihan> list = new ArrayList<tagihan>();
        while (rs.next()) {
            tagihan tag = new tagihan(null, null);
            tag.setJumlah(rs.getString("Jumlah"));
            tag.setStatus(rs.getString("Status"));
            list.add(tag);
        }
        return list;
    }
}

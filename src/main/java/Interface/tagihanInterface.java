package Interface;

import Models.tagihan;
import java.sql.SQLException;
import java.util.List;

public interface tagihanInterface {

    tagihan insert(tagihan o) throws SQLException;

    void update(tagihan o) throws SQLException;

    void delete(String jumlah) throws SQLException;

    List<tagihan> getAll() throws SQLException;
}

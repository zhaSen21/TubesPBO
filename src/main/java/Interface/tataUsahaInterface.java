package Interface;

import Models.tataUsaha;
import java.sql.SQLException;
import java.util.List;

public interface tataUsahaInterface {

    tataUsaha insert(tataUsaha o) throws SQLException;

    void update(tataUsaha o) throws SQLException;

    void delete(String idTu) throws SQLException;

    List<tataUsaha> getAll() throws SQLException;

}

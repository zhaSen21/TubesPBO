package Interface;

import Models.siswa;
import java.sql.SQLException;
import java.util.List;

public interface siswaInterface {

    siswa insert(siswa o) throws SQLException;
    
    siswa insertTra(siswa o) throws SQLException;

    void update(siswa o) throws SQLException;

    void delete(String nis) throws SQLException;

    List<siswa> getAll() throws SQLException;
    
    List<siswa> getAlls() throws SQLException;
}

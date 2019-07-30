package fi.academy.ravintolaappback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArvosteluDao {

    private JdbcTemplate jdbc;
    private final RowMapper<Arvostelu> arvosteluRowmapper = (resultSet, rivi) -> {
        Arvostelu a = new Arvostelu(resultSet.getInt("id"),
                resultSet.getInt("ravintola"),
                resultSet.getInt("arvosana"),
                resultSet.getString("arvio")
                );
        return a;
    };

    @Autowired
    public ArvosteluDao(JdbcTemplate jdbc) {this.jdbc = jdbc; }

    public List<Arvostelu> haeRavintolanArvostelut(int id) {
        List<Arvostelu> haettu = jdbc.query("select * from arvostelut where ravintola = ?", new Object[]{id}, arvosteluRowmapper);
        return haettu;
     /*   if (haettu.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(haettu.get(0)); */
    }
}

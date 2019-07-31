package fi.academy.ravintolaappback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;
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
    }

    public List<Arvostelu> haeKaikkiArvostelut() {
        List<Arvostelu> haettu = jdbc.query("select * from arvostelut", arvosteluRowmapper);
        return haettu;
    }

    public int lisaa(Arvostelu a) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("insert into arvostelut (ravintola, arvosana, arvio) " +
                            "values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, a.getRavintola());
            ps.setInt(2, a.getArvosana());
            ps.setString(3, a.getArvio());
            return ps;
        };
        jdbc.update(psc, keyHolder);
        int id = (int)keyHolder.getKeys().get("id");
        return id;
    }
}

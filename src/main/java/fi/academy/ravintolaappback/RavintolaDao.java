package fi.academy.ravintolaappback;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Service
public class RavintolaDao {

    private JdbcTemplate jdbc;
    private final RowMapper<Ravintola> ravintolaRowmapper = (resultSet, rivi) -> {
        Ravintola r = new Ravintola(resultSet.getInt("id"),
                resultSet.getString("nimi"),
                resultSet.getString("paikkakunta"),
                resultSet.getString("osoite"),
                resultSet.getString("tyyppi"));
        return r;
    };

    @Autowired
    public RavintolaDao(JdbcTemplate jdbc) {this.jdbc = jdbc; }

    public List<Ravintola> haeKaikki() {
        return jdbc.query("select * from ravintolat", ravintolaRowmapper);
    }

    public int lisaa(Ravintola r) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("insert into ravintolat (nimi, paikkakunta, osoite, tyyppi) " +
                            "values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, r.getNimi());
            ps.setString(2, r.getPaikkakunta());
            ps.setString(3, r.getOsoite());
            ps.setString(4, r.getTyyppi());
            return ps;
        };
        jdbc.update(psc, keyHolder);
        int id = (int)keyHolder.getKeys().get("id");
        return id;
    }
}

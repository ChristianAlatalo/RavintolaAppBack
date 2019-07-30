package fi.academy.ravintolaappback;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

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
}

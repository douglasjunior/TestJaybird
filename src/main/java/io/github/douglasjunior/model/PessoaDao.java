package io.github.douglasjunior.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class PessoaDao {

    private final Connection conn;

    public PessoaDao(Connection conn) {
        this.conn = conn;
    }

    public List<Pessoa> getPessoas() throws SQLException {
        List<Pessoa> pessoas = new ArrayList<>();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM PESSOA");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ID"); // ID como INTEGER
            String nome = rs.getString("NOME"); // NOME como VARCHAR

            Pessoa p = new Pessoa(id, nome);
            pessoas.add(p);
        }

        return pessoas;
    }
}

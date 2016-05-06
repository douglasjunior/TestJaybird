package io.github.douglasjunior.servlet;

import io.github.douglasjunior.model.Pessoa;
import io.github.douglasjunior.model.PessoaDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douglas
 */
public class PessoaServlet extends HttpServlet implements Serializable {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conexao");
        PessoaDao dao = new PessoaDao(conn);
        try {
            List<Pessoa> pessoas = dao.getPessoas();

            // Gera o Json e escreve no PrintWritter
            PrintWriter pw = resp.getWriter();
            resp.setContentType("application/json");
            
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(pw, pessoas);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}

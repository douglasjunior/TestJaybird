package io.github.douglasjunior.filter;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Douglas
 */
public class ConexaoFilter implements Filter, Serializable {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // chamado quando o filtro é criado, na inicialização do glassfish
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // é chamado a cada requisição que chegar no webservie
        Connection conn = null;
        try {
            // abre a conexão
            conn = abrirConexao(request);
            // encaminha a requisição a diante
            chain.doFilter(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            // re-lançando a exceção para o glassfish
            throw new RuntimeException(ex);
        } finally {
            // fecha a conexão
            fecharConexao(conn);
        }
    }

    @Override
    public void destroy() {
        // chamado quando o filtro é destruido, quando o glassfish for desligado
    }

    private Connection abrirConexao(ServletRequest request) throws ClassNotFoundException, SQLException {
        Class.forName("org.firebirdsql.jdbc.FBDriver");
        Connection connection = DriverManager.getConnection(
                "jdbc:firebirdsql:localhost/3050:C:/firebird/testejaybird.gdb",
                "SYSDBA", "masterkey");
        // adiciona o objeto da conexão na requisição
        request.setAttribute("conexao", connection);
        return connection;
    }

    private void fecharConexao(Connection conn) {
        try {
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

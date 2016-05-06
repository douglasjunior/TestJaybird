package io.github.douglasjunior.rest;

import io.github.douglasjunior.model.Pessoa;
import io.github.douglasjunior.model.PessoaDao;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Douglas
 */
@Path("pessoa")
public class PessoaResource implements Serializable {

    @Context
    private UriInfo context;

    @Context
    private HttpServletRequest req;

    /**
     * Creates a new instance of PessoaResource
     */
    public PessoaResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> getPessoas() throws SQLException {
        Connection conn = (Connection) req.getAttribute("conexao");
        PessoaDao dao = new PessoaDao(conn);

        List<Pessoa> pessoas = dao.getPessoas();

        return pessoas;
    }

}

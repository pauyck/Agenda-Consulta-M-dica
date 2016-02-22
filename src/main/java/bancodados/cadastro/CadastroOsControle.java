package bancodados.cadastro;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cadastrar")
public class CadastroOsControle extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String paramId = req.getParameter("id");
		String id = paramId == null ? "" : paramId;

		String paramData = req.getParameter("data");
		String data = paramData == null ? "" : paramData;

		String paramSolicitante = req.getParameter("solicitante");
		String solicitante = paramSolicitante == null ? "" : paramSolicitante;

		String paramExecutante = req.getParameter("executante");
		String executante = paramExecutante == null ? "" : paramExecutante;

		String paramEvento = req.getParameter("evento");
		String evento = paramEvento == null ? "" : paramEvento;

		OrdemDeServico ordemDeServico = new OrdemDeServico();
		ordemDeServico.setId(id);
		ordemDeServico.setData(data);
		ordemDeServico.setSolicitante(solicitante);
		ordemDeServico.setExecutante(executante);

		if (evento.equals("Incluir")) {
			if (!id.equals("")) {
				ordemDeServico.incluir();
			}
		} else if (evento.equals("Alterar")) {
			if (!id.equals("")) {
				ordemDeServico.alterar(id, data, solicitante, executante);
			}
		} else if (evento.equals("Excluir")) {
			if (!id.equals("")) {
				ordemDeServico.excluir(id);
			}
		}

		req.setAttribute("ordemDeServico", ordemDeServico); // Passando um objeto para o JSP.

		List<OrdemDeServico> ordemDeServicos = OrdemDeServico.listar();
		req.setAttribute("ordemDeServicos", ordemDeServicos); // Passando uma coleção para o
											// JSP.

		// Chamar o JSP apenas para mostrar o resultado.
		req.getRequestDispatcher("cadastrar.jsp").forward(req, resp);
	}

}

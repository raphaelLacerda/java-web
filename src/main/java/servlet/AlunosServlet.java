package servlet;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import dao.AlunoDAO;
import factory.ConnectionFactory;
import modelo.Aluno;

@WebServlet("/alunos")
public class AlunosServlet extends HttpServlet {

	private Map<Integer, Aluno> mapaDeAlunos = new HashMap<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String jsp = req.getParameter("jsp");

		if (jsp != null && !jsp.isEmpty()) {
			req.setAttribute("alunos", mapaDeAlunos.values());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/alunos.jsp");
			requestDispatcher.forward(req, resp);
			return;
		}

		if (id != null && !id.isEmpty()) {
			retornarJson(resp, mapaDeAlunos.get(Integer.parseInt(id)));
		} else {
			retornarJson(resp, mapaDeAlunos.values());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String bodyAsString = recuperarJsonDaRequisicao(req);

		Aluno aluno = new Gson().fromJson(bodyAsString, Aluno.class);

		salvarAlunoNaBaseDeDados(aluno);
//		salvarAlunoEmMemoria(aluno);

		System.out.println("total de alunos!" + mapaDeAlunos.size());
		retornarJson(resp, aluno);
	}

	private void salvarAlunoNaBaseDeDados(Aluno aluno) {

		AlunoDAO alunoDAO = new AlunoDAO(new ConnectionFactory().getConexao());
		
	}

	private void salvarAlunoEmMemoria(Aluno aluno) {
		int idAlunos = mapaDeAlunos.size() + 1;
		aluno.setId(idAlunos);
		mapaDeAlunos.put(aluno.getId(), aluno);
	}

	private String recuperarJsonDaRequisicao(HttpServletRequest req) throws IOException {
		StringWriter writer = new StringWriter();
		IOUtils.copy(req.getInputStream(), writer, Charset.defaultCharset());
		String bodyAsString = writer.toString();
		return bodyAsString;
	}

	private void retornarJson(HttpServletResponse resp, Object retorno) throws IOException {
		resp.setContentType("application/json");
		resp.getWriter().print(new Gson().toJson(retorno));
	}
}

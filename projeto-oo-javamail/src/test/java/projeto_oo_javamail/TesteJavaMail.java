package projeto_oo_javamail;
import org.junit.Test;

public class TesteJavaMail {
	
	
	@Test
	public void testeEmail() {
		
		StringBuilder stringBuilderTextoEmail = new StringBuilder();
		stringBuilderTextoEmail.append("Olá, <br/><br/>");
		stringBuilderTextoEmail.append("Você está recebendo atualizações.<br/><br/>");
		stringBuilderTextoEmail.append("Para ter acesso ao material clique no botão abaixo! <br/><br/>");
		
		stringBuilderTextoEmail.append("<b>Login:</b> seu_email@gmail.com<br/>");
		stringBuilderTextoEmail.append("<b>Senha:</b> sua senha<br/><br/>");
		
		stringBuilderTextoEmail.append("<a target=\"_blank\" "
				+ "href=\"https://github.com/Prof-Rodrigo-Silva/codigosAulasPOOJavaMail\" style=\"color:#2525a7; padding: 14px 25px; text-align:center; text-decoration:none; display:inline-block; border-radius:30px; font-size:20px; font-family:courier;border: 3px solid green; background-color:#99DA39\"> Acessar Material</a>");
		
		stringBuilderTextoEmail.append("<br/><span style=\"font-size:10px\">Ass.: Prof Rodrigo</span>");
		
			ObjetoEnviaEmail enviaEmail = 
					new ObjetoEnviaEmail("profrodrigorosadasilva@gmail.com",
							"Prof Rodrigo",
							"Teste e-mail",
							stringBuilderTextoEmail.toString());
			enviaEmail.enviarEmail(true);
		
		//Caso o email não esteja sendo enviado colocar um tempo de espera
		//Thread.sleep(5000);
		
	}

}

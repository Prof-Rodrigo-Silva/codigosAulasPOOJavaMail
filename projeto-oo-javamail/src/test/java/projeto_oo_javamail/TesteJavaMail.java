package projeto_oo_javamail;
import org.junit.Test;

public class TesteJavaMail {
	
	
	@Test
	public void testeEmail() {
		
		try {
			
			ObjetoEnviaEmail enviaEmail = 
					new ObjetoEnviaEmail("profrodrigorosadasilva@gmail.com",
							"Prof Rodrigo",
							"Teste e-mail",
							"Testando o envio de e-mails através do objeto enviar e-mails!");
			enviaEmail.enviarEmail();
		
		//Caso o email não esteja sendo enviado colocar um tempo de espera
		//Thread.sleep(5000);
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

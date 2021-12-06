package projeto_oo_javamail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

public class TesteJavaMail {
	
	private String userName = "";
	private String password = "";
	
	@Test
	public void testeEmail() {
		
		try {
		
		//Ver configurações smtp do seu email
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");//Autorização
		properties.put("mail.smtp.starttls", "true");//Autenticação
		properties.put("mail.smtp.host", "smtp.gmail.com");//Servidor gmail google
		properties.put("mail.smtp.port","465");//Porta servidor
		properties.put("mail.smtp.socketFactory.port","465");//Expecifica a porta a ser conectada pelo socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//Calsse socket de conexão SMTP
		
		Session session = Session.getInstance(properties, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
			
		});
		
		Address[] toUser = InternetAddress.parse("profrodrigorosadasilva@gmail.com, rodrigo.teste.bg@gmail.com");
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName));
		message.setRecipients(Message.RecipientType.TO, toUser);
		message.setSubject("Chegou e-mail enviado com JAVA");//Assuto do e-mail
		message.setText("Olá, e-mail recebido com JAVA");
		
		Transport.send(message);
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}

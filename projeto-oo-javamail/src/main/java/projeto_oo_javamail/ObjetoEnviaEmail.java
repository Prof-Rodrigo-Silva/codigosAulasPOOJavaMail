package projeto_oo_javamail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ObjetoEnviaEmail {
	
	private String userName = "";//Incluir o e-mail
	private String password = "";//Incluir a senha
	
	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String textoEmail = "";
	
	public ObjetoEnviaEmail(String listaDestinatarios, String nomeRemetente, String assuntoEmail, String textoEmail) {
		this.listaDestinatarios = listaDestinatarios;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
	}

	public void enviarEmail(boolean envioHtml) {
		
		try {
			
			//Ver configurações smtp do seu email
			
			Properties properties = new Properties();
			properties.put("mail.smtp.ssl.trust", "*");
			
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
			
			Address[] toUser = InternetAddress.parse(listaDestinatarios);
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName, nomeRemetente));
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assuntoEmail);//Assuto do e-mail
			
			if(envioHtml) {
				message.setContent(textoEmail, "text/html; charset=utf-8");
				
			}else {
				message.setText(textoEmail);
			}
			
			Transport.send(message);
			
			//Caso o email não esteja sendo enviado colocar um tempo de espera
			//Thread.sleep(5000);
			
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	private FileInputStream simuladorDePDF() throws Exception{
		
		Document document = new Document();
		File file = new File("anexo.pfd");
		file.createNewFile();
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		document.add(new Paragraph("Conteúdo do PDF anexado com JavaMail"));
		document.close();
		
		return new FileInputStream(file);
	}

}

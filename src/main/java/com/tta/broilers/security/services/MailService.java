package com.tta.broilers.security.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tta.broilers.dao.UserSecurityService;
import com.tta.broilers.entities.User;
import com.tta.broilers.entities.UserSecurity;
import com.tta.broilers.entities.rest.ResetPassword;
import com.tta.broilers.repositories.UserSecurityRepository;
import com.tta.broilers.security.jwt.JwtUtils;


@Service
public class MailService {
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
    JwtUtils jwtUtil;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	UserSecurityRepository userRepository;
	
	@Autowired
	UserSecurityService userService;
	
	
	public void EnvoyerEmailAjout(UserSecurity userSecurity , User user) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {

		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

		mimeMessageHelper.setSubject("Welcome to Flellis application");
		mimeMessageHelper.setFrom("TTA");
		mimeMessageHelper.setTo(user.getEmail());
		String url = "http://localhost:4210/forgetpassword/" + jwtUtil.generateTokenBylogin(userSecurity.getUsername());
		String content = "Hi, "+user.getName()+"!"
		+"\n"
		+ "vous etes inscris a notre application BoxDechange, pour acceder a votre espace voici vos coordonnées: \n" 
		
		+ "your login: "+user.getUsername()
		+"\n"
		+ "pour intializez votre mot de passe vous devez acceder a ce lien, "+url
		+"\n"
		+ "Cordialement,";

		mimeMessageHelper.setText(content);
		/*mimeMessageHelper.setText("<html><body><p>" + content
		+ "</p> <img src=\"http://207.180.211.158/photo/assets/images/logo_dsms.png\" width=\"50\" alt=\"Apen\"></body></html>",
		true);*/
		mailSender.send(mimeMessageHelper.getMimeMessage());
		} catch (MessagingException e) {
		e.printStackTrace();
		}
		
		}

	public void resetPassword(ResetPassword resetPassword, String login) {
        UserSecurity userSecurity = userRepository.getByUsername(login);
        String pass = encoder.encode(resetPassword.getPassword());
        userSecurity.setPassword(pass);
        
        userService.updateUser(userSecurity);

    }
	
	public void EnvoyerEmail(UserSecurity userSecurity , User user ) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {

		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

		mimeMessageHelper.setSubject("Did you Forget your password? ");
		mimeMessageHelper.setFrom("TTA");
		mimeMessageHelper.setTo(userSecurity.getEmail());
		String url = "http://localhost:4210/forgetpassword/" + jwtUtil.generateTokenBylogin(userSecurity.getUsername());
		String content = "Hi, "+user.getName() 
		+"\n"
		+ "Pour vous intializez votre mot de passe vous devez acceder a ce lien : \n" + url + "\n"
		+ "Cordialement,";

		mimeMessageHelper.setText(content);
		/*mimeMessageHelper.setText("<html><body><p>" + content
		+ "</p> <img src=\"http://207.180.211.164:8080/Elab/T.D/logo-ELAB-final.png\" width=\"50\" alt=\"Apen\"></body></html>",
		true);*/
		mailSender.send(mimeMessageHelper.getMimeMessage());
		} catch (MessagingException e) {
		e.printStackTrace();
		}

		}
}

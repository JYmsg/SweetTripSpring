package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.User;
import com.ssafy.trip.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	

	@Override
	public User select(String id) throws SQLException {
		return repo.select(id);
	}

	@Override
	public int delete(String id) throws SQLException {
		return repo.delete(id);
	}

	@Override
	public int insert(User user) throws SQLException {
		System.out.println(user);
		return repo.insert(user);
	}

	@Override
	public int update(User user) throws SQLException {
		return repo.update(user);
	}

	@Override
	public List<User> selectAll() throws SQLException {
		return repo.selectAll();
	}

	@Override
	public List<User> selectUsers(String keyword) throws SQLException {
		return repo.selectUsers(keyword);
	}

	@Override
	public String sendMail(String email) throws SQLException, AddressException {
		String code = makeCode(), subject = "SweetTrip 이메일 인증 코드", msg = "";
		
        msg += "<img width=\"120\" height=\"36\" style=\"margin-top: 0; margin-right: 0; margin-bottom: 32px; margin-left: 0px; padding-right: 30px; padding-left: 30px;\" src=\"https://slack.com/x-a1607371436052/img/slack_logo_240.png\" alt=\"\" loading=\"lazy\">";
        msg += "<h1 style=\"font-size: 30px; padding-right: 30px; padding-left: 30px;\">이메일 주소 확인</h1>";
        msg += "<p style=\"font-size: 17px; padding-right: 30px; padding-left: 30px;\">아래 확인 코드를 SweetTrip 회원가입 창에 입력하세요.</p>";
        msg += "<div style=\"padding-right: 30px; padding-left: 30px; margin: 32px 0 40px;\"><table style=\"border-collapse: collapse; border: 0; background-color: #F4F4F4; height: 70px; table-layout: fixed; word-wrap: break-word; border-radius: 6px;\"><tbody><tr><td style=\"text-align: center; vertical-align: middle; font-size: 30px;\">";
        msg += code;
        msg += "</td></tr></tbody></table></div>";
		
        System.out.println("code = "+code);
//		MimeMessage mail = mailSender.createMimeMessage();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(email);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(msg);
		
//			mail.addRecipient(RecipientType.TO, new InternetAddress(email));
//			mail.setSubject(subject,"utf-8");
//			mail.setText(msg,"utf-8","html");
		System.out.println("11");
//			mailSender.send(mail);
		javaMailSender.send(simpleMailMessage);
		System.out.println("22");
		
		return code;
	}

	@Override
	public String makeCode() throws SQLException {
		StringBuffer key = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 6; i++) { // 인증코드 6자리
            key.append((rnd.nextInt(10)));
        }
        return key.toString();
	}
	public List<User> selectInviteAll(int travel_id) throws SQLException {
		return repo.selectInviteAll(travel_id);
	}

}

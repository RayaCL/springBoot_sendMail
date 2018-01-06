package cn.et;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
	@Autowired
	private JavaMailSender jms;
	
	//@GetMapping("/send")
	public String send(String email_to,String email_subject ,String email_content){
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setFrom("lgw_999@126.com");
		mailMessage.setTo(email_to);
		mailMessage.setSubject(email_subject);
		mailMessage.setText(email_content);
		jms.send(mailMessage);
		return "1";
	}
	@PostMapping("/send")
	public String send(@RequestBody Map<String,Object> map){
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setFrom("lgw_999@126.com");
		mailMessage.setTo(map.get("email_to").toString());
		mailMessage.setSubject(map.get("email_subject").toString());
		mailMessage.setText(map.get("email_content").toString());
		jms.send(mailMessage);
		return "1";
	}
	
	@GetMapping("/a")
	public String a(){
		
		return "2";
	}
	
	@GetMapping("/user/{userId}")
	public Map getUser(@PathVariable String userId){
		Map map=new HashMap();
		map.put("id", userId);
		map.put("name", "zs_"+userId);
		return map;
	}
}

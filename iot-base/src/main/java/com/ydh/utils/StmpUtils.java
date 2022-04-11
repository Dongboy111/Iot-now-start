package com.ydh.utils;


import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import org.thymeleaf.context.Context ;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class StmpUtils {

    @Autowired
    private  JavaMailSender mailSender; //自动注入的Bean

    @Resource
    TemplateEngine templateEngine ;




    @Value("${spring.mail.username}")
    private  String Sender; //读取配置文件中的参数

//    private final static SimpleMailMessage message = new SimpleMailMessage();
    public  Boolean sendMessage(String toMail,String theme,String data){
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(Sender);
            message.setTo(toMail);
            message.setSubject(theme);
            message.setText(data);

            mailSender.send(message);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false ;
        }


    }
    public Boolean sendMessageHtml(String toMail,String theme,String date,String code)  {
       try {

//           SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//           // 设置上下文
//           templateResolver.setApplicationContext(context);
//           // 禁用缓存
//           templateResolver.setCacheable(false);
//           // 设置自定义模板目录
//           templateResolver.setPrefix("classpath:/email/");
//           // 设置文件后缀
//           templateResolver.setSuffix(".html");
//           // 设置模板解析
           Context context = new Context() ;
           context.setVariable("code",code);

           String process = templateEngine.process("test",context) ;
           MimeMessage mimeMessage = mailSender.createMimeMessage() ;
           MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true) ;
           helper.setFrom(Sender);
           helper.setTo(toMail);
           helper.setSubject(theme);
           helper.setText(process,true);


           mailSender.send(mimeMessage);
           return true ;
       }catch (Exception e){
           e.printStackTrace();
           return false ;
       }


    }


}

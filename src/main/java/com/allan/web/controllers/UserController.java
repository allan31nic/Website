package com.allan.web.controllers;

import com.allan.web.config.email.SmtpMail;
import com.allan.web.model.Message;
import com.allan.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private SmtpMail smtpMail;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(){
        return "index";
    }

    @RequestMapping(value = "/resume", method = RequestMethod.GET)
    public String emailForm(Model model){
        model.addAttribute("user", new User());
        return "email-form";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String send(@Valid @ModelAttribute User user, BindingResult result,
                       RedirectAttributes redirectAttributes) throws MessagingException, IOException {
        if(result.hasErrors()){
            return "email-form";
        }
        redirectAttributes.addFlashAttribute("message", Message.SENT.getMessage());
        smtpMail.send(user.getUserEmail());
        return "redirect:/home";
    }


}

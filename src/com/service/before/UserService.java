package com.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.po.Buser;

public interface UserService {
	public String login(Buser buser,Model model, HttpSession session);
	public String register(Buser buser,Model model, HttpSession session);
}

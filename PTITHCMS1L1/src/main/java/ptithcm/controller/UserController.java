package ptithcm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.entity.Users;


@Transactional
@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	SessionFactory factory;
	@RequestMapping("index")
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql ="FROM Users";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Users> list = query.list();
		model.addAttribute("users",list);
		return "user/index";
	}
	
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("user", new Users());
		return "user/insert";
	}
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("user") Users user, BindingResult errors) {
		if(user.getUsername().trim().length()==0) {
			errors.rejectValue("username", "user", "Không được bỏ trống");
		}
		if(user.getPassword().trim().length()==0) {
			errors.rejectValue("password", "user", "Không được bỏ trống");
		}
		if(user.getFullname().trim().length()==0) {
			errors.rejectValue("fullname", "user", "Không được bỏ trống");
		}
		
		if(errors.hasErrors()) {
			model.addAttribute("message", "Thêm mới thất bại! ");
		}
		else {
			Session session =factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(user);
				t.commit();
				model.addAttribute("message", "Thêm mới thành công! ");
			}catch(Exception e) {
				t.rollback();
				model.addAttribute("message", "Thêm mới thất bại! ");
			}
			finally {
				session.close();
			}
		}
		return "user/insert";
	}
	
	@RequestMapping(value = "update/{username}", method = RequestMethod.GET)
	public String edit(ModelMap model, @PathVariable("username") String username) {
		Session session = factory.getCurrentSession();
		Users user = (Users) session.get(Users.class, username);
		model.addAttribute("user", user);
		model.addAttribute("users", getUsers());
		return "user/update";
	}

	@RequestMapping(value = "update/{username}", method = RequestMethod.POST)
	public String edit(ModelMap model, HttpServletRequest req) {
		
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				Users user = new Users();
				user.setUsername(req.getParameter("username"));
				user.setPassword(req.getParameter("password"));
				user.setFullname(req.getParameter("fullname"));
				session.update(user);
				t.commit();
				model.addAttribute("message", "Cập nhật thành công!");
				String hql ="FROM Users";
				Query query = session.createQuery(hql);
				@SuppressWarnings("unchecked")
				List<Users> list = query.list();
				model.addAttribute("users",list);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Cập nhật thất bại!");
			} finally {
				session.close();
			}
		return "user/index";
	}
	
	@RequestMapping("index/{username}")
	public String delete(ModelMap model,@PathVariable("username") String username) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			
			Users user = (Users) session.get(Users.class, username);
			session.delete(user);
			t.commit();
			model.addAttribute("message", "Xoá thành công! ");
			String hql ="FROM Users";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Users> list = query.list();
			model.addAttribute("users",list);
		}catch(Exception e) {
			t.rollback();
			model.addAttribute("message", "Xoá thất bại! ");
		}
		finally {
			session.close();
		}
		
		return "user/index";
	}
	
	public List<Users> getUsers() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Users";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Users> list = query.list();
		return list;
	}

}

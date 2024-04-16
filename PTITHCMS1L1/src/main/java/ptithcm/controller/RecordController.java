package ptithcm.controller;



import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.entity.Records;
import ptithcm.entity.Staffs;


@Transactional
@Controller
@RequestMapping("/record/")
public class RecordController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("record", new Records());
		return "record/insert";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST )
	public String insert(ModelMap model,
						@ModelAttribute("record") Records record, BindingResult errors) {
		
		if(record.getReason().trim().length()==0) {
			errors.rejectValue("reason", "record", "Không được bỏ trống");
		}
		
		if(errors.hasErrors()) {
			model.addAttribute("message", "Thêm mới thất bại! ");
		}
		else {
			Session session =factory.openSession();
			Transaction t =session.beginTransaction();
			try {
				record.setDate(new Date());
				session.save(record);
				t.commit();
				model.addAttribute("message", "Thêm mới thành công!");	
			}catch(Exception e) {
				t.rollback();
				model.addAttribute("message", "Thêm mới thất bại!");
			}finally {
				session.close();
			}
		}
		return "record/insert";
		}
	
	
	@ModelAttribute("staffs")
	public List<Staffs> getStaffs(){
		Session session =factory.getCurrentSession();
		String hql = "FROM Staffs";
		Query query =session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Staffs> list = query.list();
		return list;
		
	}
}

package com.setmore.bookingPage;

import java.io.IOException;
import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.setmore.bookingPage.URLFetchClass;
;@Controller
public class SetmoreBookingPageServlet  {
	
	ModelAndView model;


	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView login(){
	    return new ModelAndView("index");
	}
	
	@RequestMapping(value="/bookingPage",method=RequestMethod.GET)
	@ResponseBody
	public String getStaff(@RequestBody String companyKey ) throws Exception{
		System.out.println("company key " + companyKey);
		
		URLFetchClass classObj = new URLFetchClass();
		String accessToken = classObj.getAccessToken();
		String services    = classObj.getService(accessToken);
		
		
		return services;	
	
	}
	
	
}

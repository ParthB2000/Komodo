package com.hlis.exam.handler;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SessionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub	
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		String token = (String) httpServletRequest.getSession().getAttribute("token");
		
		if(!httpServletRequest.getRequestURI().contains("/admin"))
		{
		
		if(!httpServletRequest.getRequestURI().contains(".js") && !httpServletRequest.getRequestURI().contains(".css") && !httpServletRequest.getRequestURI().contains(".png"))
			{
				if(token!=null)
				{
//					System.err.println(httpServletRequest.getRequestURI());
					if( httpServletRequest.getRequestURI().equals("/send/login/otp") 
							|| httpServletRequest.getRequestURI().equals("/signup")
							|| httpServletRequest.getRequestURI().equals("/"))
					{
						httpServletResponse.sendRedirect("/user/dashboard");
					}
				}
				else
				{
					if( !httpServletRequest.getRequestURI().equals("/send/login/otp")
							&& !httpServletRequest.getRequestURI().equals("/signup") 
							&& !httpServletRequest.getRequestURI().equals("/login/verify")
							&& !httpServletRequest.getRequestURI().equals("/register/varify")
							&& !httpServletRequest.getRequestURI().equals("/signup/process")
							&& !httpServletRequest.getRequestURI().equals("/"))
					{
						httpServletResponse.sendRedirect("/send/login/otp");
					}
				}
			}
		}
			chain.doFilter(request, response);
		}
	}



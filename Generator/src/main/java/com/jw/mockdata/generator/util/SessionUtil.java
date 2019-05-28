package com.jw.mockdata.generator.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Slf4j
public class SessionUtil {
	public static HttpServletRequest getRequest() {
		try {
			return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		} catch (Exception e) {
			return null;
		}
	}

	public static HttpSession getSession() {
		try {
			HttpServletRequest request = getRequest();
			if (request != null)
				return request.getSession();
			else
				return null;
		} catch (Exception e) {
			return null;
		}
	}

	public static String getCtx() {
		try {
			HttpServletRequest request = getRequest();
			if (request != null) {
				return getRequest().getContextPath();
			} else {
				return null;
			}
		} catch (Exception e) {
			log.error("",e);
			return null;
		}
	}

}

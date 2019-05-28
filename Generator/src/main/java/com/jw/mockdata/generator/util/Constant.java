package com.jw.mockdata.generator.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Constant {
	public static String UI_TEMPLATE = "custom_frame";//default_tabh_list

	public static int QUERY_LIMIT = 5000;
	
	public static int ORCL_QUERY_LIMIT = 5000;

	public final static int ALLOCATION_SIZE = 0;

	public final static String OUTPRINT_MODE = "OUTPRINT_MODE";

	public final static String USER_SESSION = "USER_SESSION";
	
	public final static String USER_EDIT_STATUS = "USER_EDIT_STATUS";

	public final static int PAGE_SIZE = 2000;

	public final static int PAGE_NEXT = 1;
	
	public final static int PAGE_PREVIOUS = 0;

	public static ObjectMapper mapper = new ObjectMapper();
}

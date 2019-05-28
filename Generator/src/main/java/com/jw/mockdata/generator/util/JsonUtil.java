package com.jw.mockdata.generator.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JsonUtil
{
	private static Log logger = LogFactory.getLog(JsonUtil.class);
	public static ObjectMapper mapper = new ObjectMapper();

	/**
	 * 对象转换成json
	 * 
	 * @param
	 * @return
	 */
	public static String Object2Json(Object obj)
	{
		String r = null;
		try
		{
			if (obj != null)
			{
				r = replaceStr(mapper.writeValueAsString(obj));
			}
		}
		catch (Exception e)
		{
			logger.error(e);
			return null;
		}
		return r;
	}

	/**
	 * json转换成对象
	 * 
	 * @param
	 * @return
	 */
	public static Object Json2Object(String content, JavaType valueType)
	{
		try
		{
			return mapper.readValue(unReplaceStr(content), valueType);
		}
		catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * 获取泛型的Collection Type
	 * 
	 * @param collectionClass
	 *            泛型的Collection
	 * @param elementClasses
	 *            元素类
	 * @return JavaType Java类型
	 * @since 1.0
	 */
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses)
	{
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	/**
	 * 替换字符 #1# ',
	 * 
	 * @param writeValueAsString
	 * @return
	 */
	private static String replaceStr(String writeValueAsString)
	{
		writeValueAsString = writeValueAsString.replace("'", "#1#");
		return writeValueAsString;
	}

	/**
	 * 反替换字符 #1# ',
	 * 
	 * @param writeValueAsString
	 * @return
	 */
	private static String unReplaceStr(String writeValueAsString)
	{
		writeValueAsString = writeValueAsString.replace("#1#", "‘");
		return writeValueAsString;
	}

}

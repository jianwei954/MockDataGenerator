package com.jw.mockdata.generator.util;


import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Util
{
	public static PrintWriter outPrint(String content, HttpServletResponse response, String charset)
	{
		try
		{
			response.setContentType("text/html;charset=" + charset);
			response.setHeader("Pragma", "No-Cache");
			response.addHeader("Cache-Control", "no-cache");
			PrintWriter out = response.getWriter();

			if (!StringUtil.isBlank(content))
				out.print(content);

			return out;
		}
		catch (Exception e)
		{
			return null;
		}
	}
	public static String getUUID()
	{
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}
	public static PrintWriter outPrintXML(String content, HttpServletResponse response, String charset)
	{
		try
		{
			response.setContentType("text/xml;charset=" + charset);
			response.setHeader("Pragma", "No-Cache");
			response.addHeader("Cache-Control", "no-cache");
			PrintWriter out = response.getWriter();

			if (!StringUtil.isBlank(content))
				out.print(content);

			return out;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * 在页面上输出HTML内容
	 * 
	 * @param content
	 * @param response
	 * @throws IOException
	 */
	public static PrintWriter outPrint(String content, HttpServletResponse response)
	{
		try
		{
			response.setContentType("text/html;charset=utf-8");
			response.setHeader("Pragma", "No-Cache");
			response.addHeader("Cache-Control", "no-cache");
			PrintWriter out = response.getWriter();

			if (!StringUtil.isBlank(content))
				out.print(content);

			return out;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * 在页面上输出JSON内容
	 * 
	 * @param content
	 * @param response
	 * @throws IOException
	 */
	public static PrintWriter outPrintJSON(String content, HttpServletResponse response)
	{
		try
		{
			response.setContentType("application/json;charset=utf-8");
			response.setHeader("Pragma", "No-Cache");
			response.addHeader("Cache-Control", "no-cache");
			PrintWriter out = response.getWriter();

			if (!StringUtil.isBlank(content))
				out.print(content);

			return out;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * 将斜杠替换为系统默认斜杠
	 * 
	 * @param path
	 * @return
	 */
	public static String systemFileSeparator(String path)
	{
		return path.replace("/", File.separator).replace("\\", File.separator);
	}

	/**
	 * 是否手机号码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isMobile(String str)
	{
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号 (相应的请修改 jquery.validate.common.js)
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	public static <T> List<T> subList(List<T> list, int fromIdx, int toIdx)
	{
		try
		{
			if (list == null || list.isEmpty())
				return null;
			if (fromIdx > list.size())
			{
				return null;
			}
			if (toIdx > list.size())
			{
				toIdx = list.size();
			}
			return list.subList(fromIdx, toIdx);
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public static String list2Str(List<String> list)
	{
		if (list == null || list.isEmpty())
		{
			return "";
		}
		StringBuffer res = new StringBuffer();
		int i = 0;
		for (String str : list)
		{
			if (i++ != 0)
			{
				res.append("," + str);
			}
			else
			{
				res.append(str);
			}
		}
		return res.toString();
	}

	public static String array2Str(String[] array)
	{
		if (array == null || array.length == 0)
		{
			return "";
		}
		StringBuffer res = new StringBuffer();
		int i = 0;
		for (String str : array)
		{
			if (i++ != 0)
			{
				res.append("," + str);
			}
			else
			{
				res.append(str);
			}
		}
		return res.toString();
	}

	public static String makeToken()
	{
		String token = DateUtil.formatDate(new Date(), "yyyyMMdd") + "8ad0a6980f35";
		return StringUtil.encryptPassword2(token);
	}

	public static String makeToken(String value)
	{
		if (!StringUtil.isBlank(value))
		{
			String token = DateUtil.formatDate(new Date(), "yyyyMMdd") + value;
			return StringUtil.encryptPassword2(token);
		}
		return "";

	}

	public static List<Days4Query> parseDate(Date startDate, Date endDate)
	{
		String ymd1 = DateUtil.formatDate(startDate, "yyyy-MM-dd");
		String ymd2 = DateUtil.formatDate(endDate, "yyyy-MM-dd");
		Date startDatetmp = DateUtil.formatDateStr(ymd1, "yyyy-MM-dd");
		Date stopDatetmp = DateUtil.formatDateStr(ymd2, "yyyy-MM-dd");

		long between = DateUtil.compareDate(startDatetmp, stopDatetmp);

		ArrayList<Days4Query> dateList = new ArrayList<Days4Query>();

		Calendar sd = Calendar.getInstance();
		sd.setTime(startDate);
		for (int i = 0; i <= between; i++)
		{
			Days4Query dq = new Days4Query();
			if (i != 0)
			{
				sd.set(Calendar.HOUR_OF_DAY, 0);
				sd.set(Calendar.MINUTE, 0);
				sd.set(Calendar.SECOND, 0);
			}
			dq.setStartTime(sd.getTime());
			dq.setDay(sd.get(Calendar.YEAR) + "-" + (sd.get(Calendar.MONTH) + 1) + "-"
					+ sd.get(Calendar.DAY_OF_MONTH));

			if (i != between)
			{
				Calendar sd2 = Calendar.getInstance();
				sd2.set(Calendar.YEAR, sd.get(Calendar.YEAR));
				sd2.set(Calendar.MONTH, sd.get(Calendar.MONTH));
				sd2.set(Calendar.DAY_OF_MONTH, sd.get(Calendar.DAY_OF_MONTH));
				sd2.set(Calendar.HOUR_OF_DAY, 23);
				sd2.set(Calendar.MINUTE, 59);
				sd2.set(Calendar.SECOND, 59);
				dq.setEndTime(sd2.getTime());
			}
			else
			{
				dq.setEndTime(endDate);
			}

			dateList.add(0, dq);
			sd.add(Calendar.DAY_OF_MONTH, 1);
		}

		return dateList;
	}

	public static class Days4Query
	{
		private String day;

		private Date startTime;

		private Date endTime;

		public String getDay()
		{
			return day;
		}

		public void setDay(String day)
		{
			this.day = day;
		}

		public Date getStartTime()
		{
			return startTime;
		}

		public void setStartTime(Date startTime)
		{
			this.startTime = startTime;
		}

		public Date getEndTime()
		{
			return endTime;
		}

		public void setEndTime(Date endTime)
		{
			this.endTime = endTime;
		}

	}

	public static void main(String[] args)
	{
		Date d1 = DateUtil.formatDateStr("2014-01-01 10:12:13", "yyyy-MM-dd HH:mm:ss");
		Date d2 = DateUtil.formatDateStr("2014-02-07 14:15:55", "yyyy-MM-dd HH:mm:ss");
		List<Days4Query> dqList = Util.parseDate(d1, d2);
		for (Util.Days4Query dq : dqList)
		{
			System.out.println(dq.getDay() + " " + dq.getStartTime() + " " + dq.getEndTime());
		}
	}
	
	public static String idcard15To18(String perIDSrc)
	{
		if(perIDSrc.length()!=15)
		{
			return perIDSrc;
		}
		
		int iS = 0;

		// 加权因子常数
		int[] iW = new int[] { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8,
				4, 2 };
		// 校验码常数
		String LastCode = "10X98765432";
		// 新身份证号
		String perIDNew;

		perIDNew = perIDSrc.substring(0, 6);
		// 填在第6位及第7位上填上‘1’，‘9’两个数字
		perIDNew += "19";

		perIDNew += perIDSrc.substring(6, 15);

		// 进行加权求和

		for (int i = 0; i < 17; i++) {
			iS += Integer.parseInt(perIDNew.substring(i, i+1)) * iW[i];
		}

		// 取模运算，得到模值
		int iY = iS % 11;
		// 从LastCode中取得以模为索引号的值，加到身份证的最后一位，即为新身份证号。
		perIDNew += LastCode.substring(iY, iY+1);
		return perIDNew;
		
	}

	public static byte[] compress(byte[] data)
			throws IOException
	{
		byte[] zip = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try
		{
			GZIPOutputStream gzip = new GZIPOutputStream(bos);
			try
			{
				gzip.write(data);
				gzip.finish();
				zip = bos.toByteArray();
			}
			finally
			{
				gzip.close();
			}
		}
		finally
		{
			bos.close();
		}
		return zip;
	}
	public static byte[] decompress(byte[] zip)
			throws IOException
	{
		byte[] result = null;
		ByteArrayInputStream bis = new ByteArrayInputStream(zip);
		try
		{
			GZIPInputStream gzip = new GZIPInputStream(bis);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			try
			{

				byte[] buff = new byte[1024];
				int num = -1;
				while ((num = gzip.read(buff, 0, buff.length)) != -1)
				{
					bos.write(buff, 0, num);
				}
				result = bos.toByteArray();
			}
			finally
			{
				bos.close();
				gzip.close();
			}
		}
		finally
		{
			bis.close();
		}
		return result;
	}
}

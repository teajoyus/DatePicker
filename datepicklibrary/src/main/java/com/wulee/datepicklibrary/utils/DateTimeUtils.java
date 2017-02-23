package com.wulee.datepicklibrary.utils;

import android.content.Context;
import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
	/**
	 * @function getMsgShowTime 获取显示的日期，格式有三种：今天 、昨天、月/日
	 * @param timestamp long 毫秒级的时间戳
	 * @return String
	 */
	public static String getShowDate(long timestamp, Context context) {
		if (timestamp <= 0 || null == context) {
			return null;
		}

		SimpleDateFormat defaultDateFormat = new SimpleDateFormat("MM/dd");// 默认的日期格式
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
		// 获取今天的日期
		Calendar calendar = Calendar.getInstance();
		String today = dayFormat.format(calendar.getTime());

		// 获取昨天的日期
		calendar.add(Calendar.DATE, -1);// 日期减一
		String yesterday = dayFormat.format(calendar.getTime());

		// 获取给定时间戳的日期
		calendar.setTimeInMillis(timestamp);
		String day = dayFormat.format(calendar.getTime());

		if (day.equals(today)) {
			return "今天";
		} else if (day.equals(yesterday)) {
			return "昨天";
		} else {
			return defaultDateFormat.format(calendar.getTime());
		}
	}

	/**
	 * @function 将yyyy-MM-dd HH:mm:ss转化为三种：今天 、昨天、月/日
	 * @return String
	 */
	public static String getStringDate(String dateString, Context context) {
		if (null == context) {
			return null;
		}

		SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 默认的日期格式
		Date date;
		try {
			date = defaultDateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return getShowDate(date.getTime(), context);
	}

	/**
	 * @function yyyy-MM-dd HH:mm:ss --> yyyy年MM月dd日 HH:mm
	 * @return String
	 */
	public static String getStringDateLocal(String dateString) {
		if (TextUtils.isEmpty(dateString)) {
			return "";
		}
		SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 默认的日期格式
		SimpleDateFormat defaultDateFormat1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");// 默认的日期格式
		Date date;
		try {
			date = defaultDateFormat.parse(dateString);
		} catch (ParseException e) {
			return "";
		}
		return defaultDateFormat1.format(date);
	}

	/**
	 * @function yyyy-MM-dd HH:mm:ss --> dd日 HH:mm
	 * @return String
	 */
	public static String getStringDayTime(String dateString) {
		if (TextUtils.isEmpty(dateString)) {
			return "";
		}
		SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 默认的日期格式
		SimpleDateFormat defaultDateFormat1 = new SimpleDateFormat("dd日 HH:mm");// 默认的日期格式
		Date date;
		try {
			date = defaultDateFormat.parse(dateString);
		} catch (ParseException e) {
			return "";
		}
		return defaultDateFormat1.format(date);
	}
	/**
	 * @function yyyy-MM-dd HH:mm:ss --> dd日 HH:mm
	 * @return String
	 */
	public static String getStringDay2(String dateString) {
		if (TextUtils.isEmpty(dateString)) {
			return "";
		}
		SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 默认的日期格式
		SimpleDateFormat defaultDateFormat1 = new SimpleDateFormat("dd日 HH:mm");// 默认的日期格式
		Date date;
		try {
			date = defaultDateFormat.parse(dateString);
		} catch (ParseException e) {
			return "";
		}
		return defaultDateFormat1.format(date);
	}

	/**
	 * @function yyyy-MM-dd --> MM-dd
	 * @return String
	 */
	public static String getStringDay(String dateString) {
		if (TextUtils.isEmpty(dateString)) {
			return "";
		}
		SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd");// 默认的日期格式
		SimpleDateFormat defaultDateFormat1 = new SimpleDateFormat("MM-dd");// 默认的日期格式
		Date date;
		try {
			date = defaultDateFormat.parse(dateString);
		} catch (ParseException e) {
			return "";
		}
		return defaultDateFormat1.format(date);
	}

	/**
	 * 将"yyyy-MM-dd HH:mm:ss" --> "yyyy年MM月dd日"
	 * 
	 * @param dateString
	 * @return
	 */
	public static String getStringDateTrans(String dateString) {
		if (TextUtils.isEmpty(dateString)) {
			return "";
		}
		SimpleDateFormat defaultDateFormatSrc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 默认的日期格式
		SimpleDateFormat defaultDateFormatDst = new SimpleDateFormat("yyyy年MM月dd日");// 默认的日期格式
		Date date;
		try {
			date = defaultDateFormatSrc.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
		return defaultDateFormatDst.format(date);
	}

	/**
	 * 将"yyyy-MM-dd HH:mm:ss" --> "yyyy-MM-dd HH:mm"
	 * 
	 * @param dateString
	 * @return
	 */
	public static String getStringDateTrans2(String dateString) {
		if (TextUtils.isEmpty(dateString)) {
			return "";
		}
		SimpleDateFormat defaultDateFormatSrc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 默认的日期格式
		SimpleDateFormat defaultDateFormatDst = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date;
		try {
			date = defaultDateFormatSrc.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
		return defaultDateFormatDst.format(date);
	}

	/**
	 * 将"yyyy-MM-dd HH:mm:ss" --> "yyyy-MM-dd"
	 * 
	 * @param dateString
	 * @return
	 */
	public static String getStringDateTrans3(String dateString) {
		if (TextUtils.isEmpty(dateString)) {
			return "";
		}
		SimpleDateFormat defaultDateFormatSrc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 默认的日期格式
		SimpleDateFormat defaultDateFormatDst = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = defaultDateFormatSrc.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
		return defaultDateFormatDst.format(date);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss --> 时间戳
	 */
	public static long parseDateTime(String dateTime) {
		if (TextUtils.isEmpty(dateTime)) {
			return 0;
		}

		long time = 0;
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime);
			if (null != date) {
				time = date.getTime();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return time;
	}

	/**
	 * 可以处理1970年以前的日期
	 * @return 输出格式为：yyyy-MM-dd
	 */
	public static String getStringDate(long timestamp) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(new Date(timestamp));
	}

	/**
	 * @return 输出格式为：yyyy年MM月dd日
	 */
	public static String getStringDateCh(long timestamp) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
		return sf.format(new Date(timestamp));
	}

	/**
	 * @return 输出格式为：MM月dd日
	 */
	public static String getStringDateSimpleCh(long timestamp) {
		SimpleDateFormat sf = new SimpleDateFormat("MM月dd日");
		return sf.format(new Date(timestamp));
	}

	/**
	 * yyyy年MM月dd日HH时
	 */
	public static String getStringYMDH(long timestamp) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日HH时");
		return sf.format(new Date(timestamp));
	}

	/**
	 * @return 输出格式为：yyyy年MM月dd日 HH:mm
	 */
	public static String getStringDateTime(long timestamp) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sf.format(new Date(timestamp));
	}

	public static String getStringDateTimeNew(long timestamp) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(new Date(timestamp));
	}

	/**
	 * @return 输出格式为：yyyy-MM-dd HH
	 */
	public static String getStringDateTime2(long timestamp) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时");
		return sf.format(new Date(timestamp));
	}

	/**
	 * @function getShowTime 获取显示的时间，格式为：HH:mm
	 */
	public static String getShowTime(long timestamp) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		Date curDate = new Date(timestamp);
		return formatter.format(curDate);
	}

	/**
	 * 可以处理1970年以前的数据
	 * @function getShowTime 获取显示的时间，格式为：yyyy-MM-dd hh:mm:ss
	 */
	public static String getFullTime(long timestamp) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(new Date(timestamp));
	}
	public static String getFullerTime(long timestamp) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		return sf.format(new Date(timestamp));
	}

	/**
	 * xx年xx天xx小时
	 * @return
	 */
	public static String getYearDayHourString(long timestamp) {
		if (timestamp < 0)
			return "";

		long year = timestamp / (365 * 24 * 3600);
		String dayHour = getStringDayHour(timestamp % (365 * 24 * 3600));

		StringBuilder sb = new StringBuilder();

		if (year > 0)
			sb.append(year).append("年");
		if (!TextUtils.isEmpty(dayHour))
			sb.append(dayHour);

		return sb.toString();
	}

	/**
	 * xx天xx小时
	 */
	public static String getStringDayHour(long timestamp) {
		if (timestamp < 0)
			return "";
		long tian = timestamp / (24 * 3600);
		long xiaoshi = (timestamp % (24 * 3600)) / 3600;

		StringBuilder sb = new StringBuilder();
		if (tian > 0)
			sb.append(tian).append("天");
		if (xiaoshi > 0)
			sb.append(xiaoshi).append("小时");

		if (TextUtils.isEmpty(sb.toString())) {
			sb.append("不足一小时");
		}

		return sb.toString();
	}

	/**
	 * xx天xx小时xx分
	 */
	public static String getStringIntervalTime(long timestamp) {
		if (timestamp <= 0)
			return "";
		long tian = timestamp / (24 * 3600);
		long xiaoshi = (timestamp % (24 * 3600)) / 3600;
		long fen = ((timestamp % (24 * 3600)) % 3600) / 60;

		StringBuilder sb = new StringBuilder();
		if (tian > 0)
			sb.append(tian).append("天");
		if (xiaoshi > 0)
			sb.append(xiaoshi).append("小时");
		if (fen > 0)
			sb.append(fen).append("分");

		return sb.toString();
	}

	/**
	 * @function getMsgShowTime 获取显示的日期，格式有：今天： xx点、昨天：月/日
	 * @return String
	 */
	public static String getRecordShowDate(long timestamp) {
		if (timestamp <= 0) {
			return null;
		}
		SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd");// 默认的日期格式
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
		SimpleDateFormat sf = new SimpleDateFormat("MM月dd日");
		// 获取今天的日期
		Calendar calendar = Calendar.getInstance();
		String today = defaultDateFormat.format(calendar.getTime());

		// 获取昨天的日期
		calendar.add(Calendar.DATE, -1);// 日期减一
		String yesterday = sf.format(calendar.getTime());

		// 获取给定的日期
		calendar.setTimeInMillis(timestamp);
		String createDate = getShowTime(timestamp);
		// String createDay = dayFormat.format(calendar.getTime());

		String createDay = getStringDate(timestamp); // 2014-07-11

		if (createDay.equals(today)) {
			return createDate;
		} else {
			return createDay.substring(5, 10);
		}
	}

	/**
	 * @function getMsgShowTime 获取显示的日期，格式有：今天： xx点、昨天：月/日
	 * @return String
	 */
	public static String getZiXunRecordShowDate(long timestamp) {
		if (timestamp <= 0) {
			return null;
		}
		SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd");// 默认的日期格式
		// 获取今天的日期
		Calendar calendar = Calendar.getInstance();
		String today = defaultDateFormat.format(calendar.getTime());

		// 获取昨天的日期
		calendar.add(Calendar.DATE, -1);// 日期减一
		String yesterday = defaultDateFormat.format(calendar.getTime());

		// 获取给定的日期
		calendar.setTimeInMillis(timestamp);
		String createDate = getShowTime(timestamp);
		String createDay = getStringDate(timestamp); // 2014-07-11

		if (createDay.equals(today)) { // 12:20
			String time[] = createDate.split(":");
			if (time != null && time.length == 2) {
				int hour = -1;
				try {
					hour = Integer.parseInt(time[0]);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				if (hour >= 0 && hour < 6) {
					return createDate;
				} else if (hour >= 6 && hour < 12) {
					return createDate;
				} else if (hour >= 12 && hour < 18) {
					return createDate;
				} else if (hour >= 18 && hour < 24) {
					return createDate;
				}
			}
			return createDate;
		} else if (createDay.equals(yesterday)) {
			return "昨天" + createDate;
		} else {
			return createDay;
		}
	}

	/**
	 * 计算两个时间的差值
	 * */
	public static long getDifferenceTime(long t0, long currTime) {
		long diff = currTime - t0; // 微秒级别
		long diffHours = diff / (1000 * 60 * 60);
		return diffHours;
	}

	/**
	 * 获取预约日历界面显示的月份
	 * */
	public static String getCalendarShowMonth(String strDate) {
		String[] date = strDate.split("-");
		String strMonth = "";
		if (null != date && date.length == 3) {
			try {
				int month = Integer.parseInt(date[1]);

				if (month >= 1 && month < 10) {
					strMonth = date[1].substring(1, date[1].length());
				} else if (month >= 10 && month <= 12) {
					strMonth = date[1];
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return strMonth;
	}

	/**
	 * 将时间戳转换成相应的日期
	 */
	public static String formatTime(String unixDate) {
		if (!TextUtils.isEmpty(unixDate)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			try {
				String date = sdf.format(new Date(Long.parseLong(unixDate)));
				return date;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	/**
	 * 将date转换成相应的日期
	 */
	public static String formatTime(Date time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String date = sdf.format(time);
			return date;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解析时间字符串 eg: 2015-04-12
	 * @param time 需要转换的日期
	 * @return 返回相应的 时间
	 */
	public static Date stringToDate(String time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解析时间字符串 eg: 2015-04-12 10
	 * @param time 需要转换的日期
	 * @return 返回相应的 时间
	 */
	public static Date stringToDate2(String time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");
		try {
			return format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将时间转换成时间戳 eg: 2015-04-12 10
	 * @param time 需要转换的时间
	 * @return 返回相应的时间戳
	 */
	public static long timeToUnixDate2(String time) {
		if (!TextUtils.isEmpty(time)) {
			return stringToDate2(time).getTime();
		}
		return 0;
	}

	/**
	 * 解析时间字符串 eg: 2015-04-12 10:20
	 * @param time 需要转换的日期
	 * @return 返回相应的 时间
	 */
	public static Date stringToDate3(String time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			return format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将时间转换成时间戳 eg: 2015-04-12 10:20
	 * @param time 需要转换的时间
	 * @return 返回相应的时间戳
	 */
	public static long timeToUnixDate3(String time) {
		if (!TextUtils.isEmpty(time)) {
			return stringToDate3(time).getTime();
		}
		return 0;
	}

	/**
	 * 将时间转换成时间戳 eg: 2015-04-12
	 * @param time 需要转换的时间
	 * @return 返回相应的时间戳
	 */
	public static long timeToUnixDate(String time) {
		if (!TextUtils.isEmpty(time)) {
			return stringToDate(time).getTime();
		}
		return 0;
	}

	/**
	 * 判断是不是正确的日期格式
	 */
	public static boolean isValidDate(String time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(true);
		try {
			format.parse(time);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	/**
	 * @param format
	 *            想转换成的格式
	 * @param time
	 *            要转换的时间
	 * @return
	 */
	public static String customFormat(String format, String time) {
		String result = "";
		if (TextUtils.isEmpty(time)) {
			return result;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = df.parse(time);
			SimpleDateFormat df1 = new SimpleDateFormat(format);
			result = df1.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String strToDate(String strDate) {
		if (TextUtils.isEmpty(strDate)) {
			return "";
		}
		SimpleDateFormat defaultDateFormatSrc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 默认的日期格式
		SimpleDateFormat defaultDateFormatDst = new SimpleDateFormat("yyyy");
		Date date;
		try {
			date = defaultDateFormatSrc.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
		return defaultDateFormatDst.format(date);
	}

	public static String strToMonthDate(String strDate) {
		if (TextUtils.isEmpty(strDate)) {
			return "";
		}
		SimpleDateFormat defaultDateFormatSrc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 默认的日期格式
		SimpleDateFormat defaultDateFormatDst = new SimpleDateFormat("MM-dd");
		Date date;
		try {
			date = defaultDateFormatSrc.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
		return defaultDateFormatDst.format(date);
	}

	public static String strToHourMinut(String strDate) {
		if (TextUtils.isEmpty(strDate)) {
			return "";
		}
		SimpleDateFormat defaultDateFormatSrc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 默认的日期格式
		SimpleDateFormat defaultDateFormatDst = new SimpleDateFormat("HH:mm");
		Date date;
		try {
			date = defaultDateFormatSrc.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
		return defaultDateFormatDst.format(date);
	}


	
	public static String getDifferenceTime2(String strDate, int days) {
		//获得某日加/减 x天后的日期  
		String result = "";
	    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    try {  
	        Date d = format.parse(strDate);
	        Calendar c = Calendar.getInstance();
	        c.setTime(d);  
	        c.add(c.DATE, days);   //days>0 加; days<0 减  
	        Date temp_date = c.getTime();
	        result = format.format(temp_date);  //结果2015-08-17  
	    } catch (ParseException e) {
	        e.printStackTrace();  
	    }
		return result;  
	}

	/**
	 * 判断给定时间是否在某一时间段内
	 *
	 * @param strDate
	 *            传入时间 yyyy-MM-dd HH:mm
	 * @param strDateBegin
	 *            开始时间 00:00:00
	 * @param strDateEnd
	 *            结束时间 00:05:00
	 * @return
	 */
	public static boolean isBetweenDate(String strDate, String strDateBegin, String strDateEnd) {
		// 截取传入时间的时分
		int strDateH = Integer.parseInt(strDate.substring(11, 13));
		int strDateM = Integer.parseInt(strDate.substring(14, 16));
		// 截取开始时间时分
		int strDateBeginH = Integer.parseInt(strDateBegin.substring(0, 2));
		int strDateBeginM = Integer.parseInt(strDateBegin.substring(3, 5));
		// 截取结束时间时分
		int strDateEndH = Integer.parseInt(strDateEnd.substring(0, 2));
		int strDateEndM = Integer.parseInt(strDateEnd.substring(3, 5));
		if ((strDateH >= strDateBeginH && strDateH <= strDateEndH)) {
			// 当前时间小时数在开始时间和结束时间小时数之间
			if (strDateH > strDateBeginH && strDateH < strDateEndH) {
				return true;
				// 当前时间小时数等于开始时间小时数
			} else if (strDateH == strDateBeginH) {
				return true;
			}
			// 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数小等于结束时间分钟数
			else if (strDateH >= strDateBeginH && strDateH == strDateEndH
					&& strDateM <= strDateEndM) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * 得到几天后的时间
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateAfter(Date d, int day){
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE,now.get(Calendar.DATE)+day);
		return now.getTime();
	}
}

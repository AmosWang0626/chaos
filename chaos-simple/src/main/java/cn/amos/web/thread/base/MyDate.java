package cn.amos.web.thread.base;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * �ַ���ת��Ϊjava.util.Date<br>
 * ֧�ָ�ʽΪ yyyy.MM.dd G 'at' hh:mm:ss z �� '2002-1-1 AD at 22:10:59 PSD'<br>
 * yy/MM/dd HH:mm:ss �� '2002/1/1 17:55:00'<br>
 * yy/MM/dd HH:mm:ss pm �� '2002/1/1 17:55:00 pm'<br>
 * yy-MM-dd HH:mm:ss �� '2002-1-1 17:55:00' <br>
 * yy-MM-dd HH:mm:ss am �� '2002-1-1 17:55:00 am' <br>
 */
public class MyDate {
	public static void main(String[] args) {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String now = date.format(new Date());
		System.out.println("���ڵ�ʱ���ǣ�" + now);

		Date date1;
		try {
			date1 = date.parse("2016-10-14");
			System.out.println("������������ǣ�" + date.format(date1));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}

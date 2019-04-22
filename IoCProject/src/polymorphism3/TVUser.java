package polymorphism3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		// 1. Spring IoC �����̳ʸ� ����(����)�Ѵ�.
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. �����̳ʷκ��� �׽�Ʈ�� ��ü�� �˻�(Lookup)�Ѵ�.
		TV tv = (TV)container.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		container.close();
	}
}

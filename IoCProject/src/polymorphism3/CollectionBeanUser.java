package polymorphism3;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanUser {
	public static void main(String[] args) {
		// 1. Spring IoC �����̳ʸ� ����(����)�Ѵ�.
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. �����̳ʷκ��� �׽�Ʈ�� ��ü�� �˻�(Lookup)�Ѵ�.
		CollectionBean bean = (CollectionBean)container.getBean("collection");
		Properties collection = bean.getNameList();
		Collection<Object> list = collection.values();
		
		System.out.println("[ �ּ� ��� ]");
		for (Object address : list) {
			System.out.println("---> " + address.toString());
		}
		
		container.close();
	}
}

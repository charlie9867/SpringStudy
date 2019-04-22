package polymorphism3;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanUser {
	public static void main(String[] args) {
		// 1. Spring IoC 컨테이너를 생성(구동)한다.
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. 컨테이너로부터 테스트할 객체를 검색(Lookup)한다.
		CollectionBean bean = (CollectionBean)container.getBean("collection");
		Properties collection = bean.getNameList();
		Collection<Object> list = collection.values();
		
		System.out.println("[ 주소 목록 ]");
		for (Object address : list) {
			System.out.println("---> " + address.toString());
		}
		
		container.close();
	}
}

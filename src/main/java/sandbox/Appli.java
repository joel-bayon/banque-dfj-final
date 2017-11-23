package sandbox;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Appli {

	public static void main(String[] args) {
		ConfigurableApplicationContext spring = new ClassPathXmlApplicationContext("/spring/spring.xml");
		
		LeClient nicolas = spring.getBean(LeClient.class);
		nicolas.manger();

	}

}

package cz.tipsport.elastic.apm.jmx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ExamplesApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(cz.tipsport.elastic.apm.jmx.ExamplesApplication.class, args);

		cz.tipsport.elastic.apm.jmx.TestMbean obj = (cz.tipsport.elastic.apm.jmx.TestMbean) applicationContext.getBean("testMbean");
		obj.show();
		try{
		//Sleep for 2 min 
		//Open JConsole and select your process Bean click PD > testBean > Operation > resetMessageViaMBean
		//Click on 	resetMessageViaMBean - if you see testMbean - it is resetting message
	    //Check whats the message after sleep time is over
		Thread.sleep(60000000);
		}catch(Exception e){
			
		}
		
		obj.show();
		
	}

}


package cz.tipsport.elastic.apm.jmx;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource(
        objectName="JD:type=MBeans,name=testBean",
        description="Managed Bean",
        log=true, logFile="jmx-platform.log")
@Component("testMbean")
public class TestMbean {
	
	private String message = "Simple Message";
	private int number = 10;
	
	public TestMbean(){
		System.out.println("......TestMbean........");
	}
	
	@ManagedOperation
	public void resetMessageViaMBean(){
		this.message = "Message RESET";
	}

	@ManagedAttribute(description="Message name")
	public String getMessageName() {
		return message;
	}

	@ManagedAttribute(description="Just a number")
	public int getNumber() {
		return number;
	}

	public void show(){
		System.out.println(message);
	}

}

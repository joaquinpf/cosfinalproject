package wsbusiness.springclient;

import java.util.ArrayList;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BusinessClient {
	private BusinessServiceIF wsbusiness = null;
	
	public void doTest() {
		//Login de 2 usuarios, John y Jane Doe. Se guardan los id de sesion para futuras 
		//operaciones
	}

	public static void main(String[] args) throws Exception {
		System.out.println(System.getProperty("user.dir"));
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/wsbusiness/springclient/BusinessService.xml");
		BusinessClient service = (BusinessClient) ctx.getBean("app");
		service.doTest();
	}

	public void setWsbusiness(BusinessServiceIF wsbusiness) {
		this.wsbusiness = wsbusiness;
	}

	public BusinessServiceIF getWsbusiness() {
		return wsbusiness;
	}

}


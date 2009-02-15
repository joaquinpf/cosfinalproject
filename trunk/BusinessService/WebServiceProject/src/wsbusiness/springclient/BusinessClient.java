package wsbusiness.springclient;

import java.util.ArrayList;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BusinessClient {
	private BusinessServiceIF wsbusiness = null;
	
	public void doTest() {
		//Login de 2 usuarios, John y Jane Doe. Se guardan los id de sesion para futuras 
		//operaciones
	}
	
	public BusinessServiceIF getWschat() {
		return wsbusiness;
	}

	public void setWschat(BusinessServiceIF wschat) {
		this.wsbusiness = wschat;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(System.getProperty("user.dir"));
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/springclient/ChatService.xml");
		BusinessClient service = (BusinessClient) ctx.getBean("app");
		service.doTest();
	}

}


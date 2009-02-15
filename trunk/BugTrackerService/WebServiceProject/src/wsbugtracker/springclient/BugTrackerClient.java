package wsbugtracker.springclient;

import java.util.ArrayList;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BugTrackerClient {
	private BugTrackerIF wsbugtracker = null;
	
	public void doTest() {
		//operaciones
	}
	
	public BugTrackerIF getWschat() {
		return wsbugtracker;
	}

	public void setWschat(BugTrackerIF wschat) {
		this.wsbugtracker = wschat;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(System.getProperty("user.dir"));
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/springclient/ChatService.xml");
		BugTrackerClient service = (BugTrackerClient) ctx.getBean("app");
		service.doTest();
	}

}


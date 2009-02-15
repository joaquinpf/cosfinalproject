package wsbugtracker.springclient;

import java.util.ArrayList;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BugTrackerClient {
	private BugTrackerIF wsbugtracker = null;
	
	public void doTest() {
		//operaciones
	}

	public static void main(String[] args) throws Exception {
		System.out.println(System.getProperty("user.dir"));
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/wsbugtracker/springclient/BugTrackerService.xml");
		BugTrackerClient service = (BugTrackerClient) ctx.getBean("app");
		service.doTest();
	}

	public void setWsbugtracker(BugTrackerIF wsbugtracker) {
		this.wsbugtracker = wsbugtracker;
	}

	public BugTrackerIF getWsbugtracker() {
		return wsbugtracker;
	}

}


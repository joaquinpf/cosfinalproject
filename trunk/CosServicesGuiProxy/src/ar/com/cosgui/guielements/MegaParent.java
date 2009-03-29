package ar.com.cosgui.guielements;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import ar.com.cosgui.datamodel.DataModel;
import ar.com.cosgui.services.IBugTrackerServiceLocalImp;
import ar.com.cosgui.services.IChatServiceLocalImp;
import ar.com.cosgui.services.IMailServiceLocalImp;
import ar.com.cosgui.services.IProjectTeamServiceLocalImp;
import ar.com.cosgui.services.ServicePoint;
import ar.com.cosgui.services.ServicesConstants;
import ar.com.cosgui.services.imp.BugTrackerServiceLocalImp;
import ar.com.cosgui.services.imp.ChatServiceLocalImp;
import ar.com.cosgui.services.imp.MailServiceLocalImp;
import ar.com.cosgui.services.imp.ProjectTeamServiceLocalImp;

public class MegaParent {
	public MegaParent(){
		initMockDatabase();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
            	IChatServiceLocalImp chat = (IChatServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.CHAT_SERVICE);
            	chat.logout(DataModel.INSTANCE.getActiveUser(), DataModel.INSTANCE.getActiveUserPass());
            }
        });
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width,screenSize.height-20);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		frame.setTitle("SSBS - Active user: " + DataModel.INSTANCE.getActiveUser());
		TaskBarDesktopPane tdp = new TaskBarDesktopPane();
		MainBugMailForm main = new MainBugMailForm(tdp);
		GuiUtils.centerOnParent(main, frame);
		tdp.add(main);
		main.setLocation(main.getX() - 250, main.getY());
		MainChat chat = new MainChat(DataModel.INSTANCE.getActiveUser(),DataModel.INSTANCE.getActiveUserPass(),tdp);
		GuiUtils.centerOnParent(chat, frame);
		tdp.add(chat);       
		chat.setLocation(chat.getX() + 250, chat.getY());
		frame.getContentPane().add(tdp);
		frame.setVisible(true);
	}

    /**
     * Genera datos para el testeo de los servicios.
     */
    private void initMockDatabase() {
    	IProjectTeamServiceLocalImp proj = (IProjectTeamServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.PROJECT_TEAM_SERVICE);
    	IBugTrackerServiceLocalImp bug = (IBugTrackerServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.BUG_TRACKING_SERVICE);
    	IChatServiceLocalImp chat = (IChatServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.CHAT_SERVICE);
    	IMailServiceLocalImp mail = (IMailServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.MAIL_SERVICE);
    
    	//Usuarios
    	proj.addUser("Joaquin Perez Fuentes", "pass");
    	proj.addUser("Marcos Steimbach", "pass");
    	proj.addUser("John Doe", "pass");
    	proj.addUser("Jane Doe", "pass");
    	proj.addUser("Admin", "admin");
    	bug.addUser("Joaquin Perez Fuentes", "pass");
    	bug.addUser("Marcos Steimbach", "pass");
    	bug.addUser("John Doe", "pass");
    	bug.addUser("Jane Doe", "pass");
    	bug.addUser("Admin", "admin");
    	chat.addUser("Joaquin Perez Fuentes", "pass");
    	chat.addUser("Marcos Steimbach", "pass");
    	chat.addUser("John Doe", "pass");
    	chat.addUser("Jane Doe", "pass");
    	chat.addUser("Admin", "admin");
    	mail.addUser("Joaquin Perez Fuentes", "pass");
    	mail.addUser("Marcos Steimbach", "pass");
    	mail.addUser("John Doe", "pass");
    	mail.addUser("Jane Doe", "pass");
    	mail.addUser("Admin", "admin");
        
    	//Proyectos y grupos
    	proj.addProject("Proyecto final de COS", "Cos Project");
    	proj.addGroupToProject("Developers", "Cos Project", "Developers");
    	proj.addGroupToProject("Testers", "Cos Project", "Testers");
    	proj.addGroupToProject("Management", "Cos Project", "Management");
    	proj.addProject("Proyecto final de Grid", "Grid Project");
    	proj.addGroupToProject("Developers", "Grid Project", "Developers");
    	proj.addGroupToProject("Testers", "Grid Project", "Testers");
    	proj.addGroupToProject("Management", "Grid Project", "Management");
    	proj.addProject("Proyecto final de HCI", "HCI Project");
    	proj.addGroupToProject("Developers", "HCI Project", "Developers");
    	proj.addGroupToProject("Testers", "HCI Project", "Testers");
    	proj.addGroupToProject("Management", "HCI Project", "Management");
    
    	//Carga de usuarios en proyectos
    	proj.addMemberToProject("Developers", "Cos Project", "Joaquin Perez Fuentes", "pass", "desarrollador");
    	proj.addMemberToProject("Developers", "Cos Project", "Marcos Steimbach", "pass", "desarrollador");
    	proj.addMemberToProject("Management", "Cos Project", "John Doe", "pass", "manager");
    	proj.addMemberToProject("Developers", "Grid Project", "Joaquin Perez Fuentes", "pass", "desarrollador");
    	proj.addMemberToProject("Developers", "Grid Project", "Marcos Steimbach", "pass", "desarrollador");
    	proj.addMemberToProject("Developers", "HCI Project", "Joaquin Perez Fuentes", "pass", "desarrollador");
    	proj.addMemberToProject("Developers", "HCI Project", "Marcos Steimbach", "pass", "desarrollador");
    	proj.addMemberToProject("Management", "HCI Project", "John Doe", "pass", "manager");
    	proj.addMemberToProject("Testers", "HCI Project", "Jane Doe", "pass", "tester");
    	
    	//Bugs de prueba
    	bug.submitBug("Spring type mapping error in Chat service", "", "Cos Project", "Marcos Steimbach");
    	bug.submitBug("TaskBarDesktopPane can't handle more than 5 windows", "", "Cos Project", "Joaquin Perez Fuentes");
    	bug.submitBug("Firewall blocks incoming connections", "", "Grid Project", "Joaquin Perez Fuentes");
    	bug.submitBug("Condor crashes on windows for exe files", "", "Grid Project", "Joaquin Perez Fuentes");
    	bug.submitBug("Un bug Grid de prueba", "", "Grid Project", "Marcos Steimbach");
    	bug.submitBug("Malformed CSS for IE6", "", "HCI Project", "Marcos Steimbach");
    }
}

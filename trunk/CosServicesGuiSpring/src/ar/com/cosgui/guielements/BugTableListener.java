package ar.com.cosgui.guielements;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import ar.com.cosgui.services.ServicePoint;
import ar.com.cosgui.services.ServicesConstants;
import ar.com.cosgui.services.imp.BugTrackerServiceLocalImp;

/**
 * Listener de cambios para BugTable. 
 * Implementa la notificacion de cambios a ServicePoint para el status.
 * @author Joaquin Alejandro Perez Fuentes
 */
public class BugTableListener implements TableModelListener {

	public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        DefaultTableModel model = (DefaultTableModel)e.getSource();
		if(column == 2) {
            BugTrackerServiceLocalImp bug = (BugTrackerServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.BUG_TRACKING_SERVICE);
            bug.changeBugStatus(Integer.parseInt((String) model.getValueAt(row, 0)), (String) model.getValueAt(row, column) );
		}
	}
}


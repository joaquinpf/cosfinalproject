

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * @author Joaqu�n Alejandro P�rez Fuentes
 */
public class BugTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -293303729609358987L;
	
	private boolean filled = false;	
	private boolean profileable = false;
	
	public BugTable() {
		super();		
		DefaultTableModel model = (DefaultTableModel) this.getModel();
		model.addColumn("ID");
		model.addColumn("Description");
		model.addColumn("Status");
		model.addColumn("Owner");
		
		setCombobox();
 
		TableColumn column = getColumnModel().getColumn(0); 
		column.setPreferredWidth(20); 
		column = getColumnModel().getColumn(1); 
		column.setPreferredWidth(350); 
		column = getColumnModel().getColumn(2); 
		column.setPreferredWidth(4);
		column = getColumnModel().getColumn(3);
		column.setPreferredWidth(4);
		
		setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		getTableHeader().setResizingAllowed(false);
	}
	
	private void setCombobox(){
        String[] statuses = {"Open", "In-Progress", "Closed", "Dismissed"};
	    
	    // Set the combobox editor on the 1st visible column
	    int vColIndex = 2;
	    TableColumn col = this.getColumnModel().getColumn(vColIndex);
	    col.setCellEditor(new MyComboBoxEditor(statuses));
	    
	    // If the cell should appear like a combobox in its
	    // non-editing state, also set the combobox renderer
	    col.setCellRenderer(new MyComboBoxRenderer(statuses));
	}
	
	@SuppressWarnings("unchecked")
	public Class getColumnClass (int columna) { 
		try{ 
			return Object.class;
		} catch (Exception e) { 
			return Object.class; 
		} 
	}
	
    public boolean isCellEditable(int rowIndex, int vColIndex) {
    	if(vColIndex == 2){
    		return true;
    	} else {
    		return false;
    	}
    }
}

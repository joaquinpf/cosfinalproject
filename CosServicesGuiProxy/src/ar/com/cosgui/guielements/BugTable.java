package ar.com.cosgui.guielements;





import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * Tabla de bugs.
 * @author Joaquin Alejandro Perez Fuentes
 */
public class BugTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -293303729609358987L;
	
	/**
	 * Inicializacion. Crea las columnas y genera las opciones del Combobox
	 */
	public BugTable() {
		super();		
		DefaultTableModel model = (DefaultTableModel) this.getModel();
		model.addColumn("ID");
		model.addColumn("Description");
		model.addColumn("Status");
		model.addColumn("Owner");
		model.addColumn("Type");
		model.addColumn("Project");

		setCombobox();
 
		TableColumn column = getColumnModel().getColumn(0); 
		column.setPreferredWidth(1); 
		column = getColumnModel().getColumn(1); 
		column.setPreferredWidth(300); 
		column = getColumnModel().getColumn(2); 
		column.setPreferredWidth(70);
		column = getColumnModel().getColumn(3);
		column.setPreferredWidth(54);
		column = getColumnModel().getColumn(4); 
		column.setPreferredWidth(54);
		column = getColumnModel().getColumn(5);
		column.setPreferredWidth(54);
		
		setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		getTableHeader().setResizingAllowed(false);

		model.addTableModelListener(new BugTableListener());
	}

	/**
	 * Seteo de opciones en el combobox
	 */
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
		return Object.class; 
	}
	
	/**
	 * Devuelve verdadero si la celda puede editarse. Override.
	 */
    public boolean isCellEditable(int rowIndex, int vColIndex) {
    	if(vColIndex == 2){
    		return true;
    	} else {
    		return false;
    	}
    }
}

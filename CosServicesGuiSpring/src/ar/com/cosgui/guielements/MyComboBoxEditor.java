package ar.com.cosgui.guielements;




import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

/**
 * @author Joaquin Alejandro Perez Fuentes
 */
public class MyComboBoxEditor extends DefaultCellEditor {

	private static final long serialVersionUID = -3055572583579131308L;

	public MyComboBoxEditor(String[] items) {
        super(new JComboBox(items));
    }
}
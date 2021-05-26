import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class SearchDataFrame extends JFrame {
   public JTable table;
   public JButton add, delete, cancel, create;
   public DefaultTableModel model;
   private int row = 0;
   private JScrollPane scrollPane;
   private JComboBox<String> tables;
   private JButton update;
   private JTextField textField;

   
   public SearchDataFrame() {
	   
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      
      JPanel panel_1 = new JPanel();
      getContentPane().add(panel_1, BorderLayout.SOUTH);
      panel_1.setLayout(new GridLayout(2, 2));
      
      add = new JButton("Add Constraint");
      panel_1.add(add);
      
      delete = new JButton("Delete Constraint");
      panel_1.add(delete);
      delete.addActionListener(new deleteButtonClickListener());
      
      cancel = new JButton("Cancel");
      panel_1.add(cancel);
      cancel.addActionListener(new cancelButtonClickListener());
      
      create = new JButton("Create");
      panel_1.add(create);
      create.addActionListener(new createButtonClickListener());
      
      
      
      String[] columns = {"Column Name", "Constraint"};
      table = new JTable(new DefaultTableModel(columns, 0));
      model = (DefaultTableModel) table.getModel();
      
      scrollPane = new JScrollPane();
      getContentPane().add(scrollPane, BorderLayout.WEST);
      scrollPane.setViewportView(table);
      
      JPanel panel_2 = new JPanel();
      getContentPane().add(panel_2, BorderLayout.NORTH);
      
      tables = new JComboBox<String>();
//      for(String name : t) tables.addItem(name);
      panel_2.add(tables);
      
      update = new JButton("Refresh tables");
      panel_2.add(update);
      
      

   }
   
   class createButtonClickListener implements ActionListener {
       public void actionPerformed (ActionEvent e) {
    	   setVisible(false);
       }
       
    }
   
   class cancelButtonClickListener implements ActionListener {
       public void actionPerformed (ActionEvent e) {
    	   DefaultTableModel tm = (DefaultTableModel)table.getModel();
    	   tm.setNumRows(0);
    	   setVisible(false);
       }
       
    }
   
   class deleteButtonClickListener implements ActionListener {
       public void actionPerformed (ActionEvent e) {
    	   row = table.getSelectedRow();
    	   DefaultTableModel tm = (DefaultTableModel)table.getModel();
    	   if(row>=0 && row < table.getRowCount()) {
    		   tm.removeRow(row);
    	   }
       }
       
    }
   
		   

   
   
   

}

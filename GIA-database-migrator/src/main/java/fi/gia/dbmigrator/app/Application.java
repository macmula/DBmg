package fi.gia.dbmigrator.app;



import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.lang.reflect.Method;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;







public class Application extends JFrame{
	
	private static final long serialVersionUID = 4860567595501878197L;
	private Action refreshAction;
	private JTextArea alertInfoArea;
	private DefaultListModel<Alert> alertListModel;	
	private JList<Alert> alertList;	
	
	
	
	public Application() {
		initActions();
		initComponents();		
		refreshData();
	}
	
	
	private void refreshData() {
		
				
			
		
		
	}


	private void initComponents() {
		restConnector.init();
		add(createListPane(), BorderLayout.WEST);
		add(createEditor(), BorderLayout.CENTER);
		add(createToolBar(), BorderLayout.PAGE_START);
		
	}


	private JComponent createEditor() {
		final JPanel panel = new JPanel( new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		// Contacts
		constraints = new GridBagConstraints();
		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.insets = new Insets(2, 2, 2, 2);
		panel.add(new JLabel("Alert Info"), constraints);
		
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.insets = new Insets(2, 2, 2, 2);
		constraints.fill = GridBagConstraints.BOTH; 
		alertInfoArea = new JTextArea();
		panel.add(alertInfoArea, constraints);
		
		return panel;
	}


	private JComponent createListPane() {
		alertListModel = new DefaultListModel<Alert>();
		alertList = new JList<Alert>(alertListModel);
		alertList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					Alert selected = alertList.getSelectedValue();
					//setSelectedAlert(selected);
				}
				
			}
		});
		return new JScrollPane(alertList);
	}


	//Application button actions
	private void initActions() {
		refreshAction = new AbstractAction("Refresh") {
			
			public void actionPerformed(final ActionEvent arg0) {
				refreshData();
				
			}
		};
		
	}
	
	
	
	private JToolBar createToolBar() {
		final JToolBar toolBar = new JToolBar();
		toolBar.add(refreshAction);
		toolBar.addSeparator();		
		toolBar.addSeparator();
		
		
		return toolBar;
		
	}
	

}

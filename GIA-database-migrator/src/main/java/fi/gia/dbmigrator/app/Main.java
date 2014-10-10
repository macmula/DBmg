package fi.gia.dbmigrator.app;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;










public class Main {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) throws SQLException {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				Main.LOGGER.info("Starting application");
				Application app = new Application();
				app.setTitle("GIA Database Migrator");
				app.setSize(800, 600);
				app.setLocationRelativeTo(null);
				app.setDefaultCloseOperation(Application.EXIT_ON_CLOSE);
				app.setVisible(true);
				
				
				app.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e){
						Main.LOGGER.debug("Done");
						restConnector.getInstance().close();
					}
					
				});
					
				
				
			}
		});
	}

}

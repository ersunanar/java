package homework1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ErsunAnarHomeWork1 extends JFrame {

	private JPanel contentPane;
	private JPanel pnlHeader;
	private JPanel pnlFooter;
	private JSplitPane splitPane;
	private JLabel lblServer;
	private JTextField txtServer;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lbsPassword;
	private JPasswordField txtPassword;
	private JButton btnConnect;
	private JComboBox cmbDatabases;
	private JButton btnTables;
	private JButton btnRun;
	private JScrollPane scrlQuery;
	private JTextArea txtQueryArea;
	private JScrollPane scrlResultTable;
	private JTable tblResults;
	private JTextField txtFilter;
	private JButton btnFilter;
	private Map<String, TreeSet<String>> schemaTableList = new TreeMap<String, TreeSet<String>>();
	private String sqlQueryStatement;
	private boolean isConnected;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErsunAnarHomeWork1 frame = new ErsunAnarHomeWork1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ErsunAnarHomeWork1() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1128, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pnlHeader = new JPanel();
		contentPane.add(pnlHeader, BorderLayout.NORTH);
		
		lblServer = new JLabel("Server:");
		lblServer.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnlHeader.add(lblServer);
		
		txtServer = new JTextField();
		pnlHeader.add(txtServer);
		txtServer.setColumns(10);
		
		lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnlHeader.add(lblUser);
		
		txtUser = new JTextField();
		pnlHeader.add(txtUser);
		txtUser.setColumns(10);
		
		lbsPassword = new JLabel("Password:");
		lbsPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnlHeader.add(lbsPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		pnlHeader.add(txtPassword);
		
		btnConnect = new JButton("Connect");
		btnConnect.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnlHeader.add(btnConnect);
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					btnConnectClicked();
				}
			});
		
		cmbDatabases = new JComboBox();
		cmbDatabases.setEnabled(false);
		pnlHeader.add(cmbDatabases);
		
		btnTables = new JButton("Tables");
		btnTables.setEnabled(false);
		btnTables.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnlHeader.add(btnTables);
		
		btnRun = new JButton("Run");
		btnRun.setEnabled(false);
		btnRun.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnlHeader.add(btnRun);
		
		pnlFooter = new JPanel();
		contentPane.add(pnlFooter, BorderLayout.SOUTH);
		
		txtFilter = new JTextField();
		pnlFooter.add(txtFilter);
		txtFilter.setColumns(20);
		
		btnFilter = new JButton("Filter");
		btnFilter.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnlFooter.add(btnFilter);
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnFilterClicked();
			}
		});
		
		splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerLocation(150);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		scrlQuery = new JScrollPane();
		splitPane.setLeftComponent(scrlQuery);
		
		txtQueryArea = new JTextArea();
		scrlQuery.setViewportView(txtQueryArea);
		
		scrlResultTable = new JScrollPane();
		splitPane.setRightComponent(scrlResultTable);
		
		tblResults = new JTable();
		scrlResultTable.setViewportView(tblResults);
		tblResults.setAutoCreateRowSorter(true);
	}



	protected void btnConnectClicked() {

		String server = txtServer.getText();
		String user = txtUser.getText();
		String pass = txtPassword.getText();
		
		if (isConnected == false) {
			
			try (
					Connection conn = DriverManager.getConnection("jdbc:mysql://"+server+"/", user, pass);
				)
			{
				
				ArrayList<String> defaultDatabases = new ArrayList<String>();
				defaultDatabases.add("information_schema");
				defaultDatabases.add("mysql");
				defaultDatabases.add("performance_schema");
				
				JOptionPane.showMessageDialog(this, "Connected");
				isConnected = true;
				btnConnect.setText("Disconnect");
				cmbDatabases.setEnabled(true);
				btnRun.setEnabled(true);
				
				
				
				btnRun.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							
							btnRunClicked();
						}
					});
				
				
				btnTables.setEnabled(true);
				btnTables.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							
							btnTablesClicked();
						}
					});
				
				DatabaseMetaData metadata = conn.getMetaData();
			    
			    String[] types = {"TABLE"};
			    ResultSet result = metadata.getTables(null, null, "%", types);
			    while (result.next()) {
			    	String schemaName = result.getString(1);
			        String tableName = result.getString(3);
			        
			        if (!defaultDatabases.contains(schemaName)) {
			        	
						if(schemaTableList.get(schemaName)!=null) {
							
							schemaTableList.get(schemaName).add(tableName);
							
					}else {
						TreeSet<String> newTreeSet = new TreeSet<String>();
						newTreeSet.add(tableName);
						schemaTableList.put(schemaName,newTreeSet);
						
					}	
			        	
			       }
			   
			    }
			    
			    String[] keyArray = schemaTableList.keySet().toArray(new String[schemaTableList.keySet().size()]);
				DefaultComboBoxModel<String> cmbDatabaseList = new DefaultComboBoxModel<>(keyArray);
				cmbDatabases.setModel(cmbDatabaseList);
				
				txtServer.setEnabled(false);
				txtUser.setEnabled(false);
				txtPassword.setEnabled(false);
				
			
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Credentials are wrong");
			}
			
		} else {
			
				JOptionPane.showMessageDialog(this, "Disconnected");
				btnConnect.setText("Connect");
				txtQueryArea.setText("");
				isConnected = false;
				cmbDatabases.removeAllItems();
				schemaTableList.clear();
				cmbDatabases.setEnabled(false);
				btnTables.setEnabled(false);
				btnRun.setEnabled(false);
				tblResults.setModel(new DefaultTableModel());
				txtFilter.setText("");
				txtServer.setEnabled(true);
				txtUser.setEnabled(true);
				txtPassword.setEnabled(true);
				
				
			
		}
		
	}

	protected void btnRunClicked() {
		String server = txtServer.getText();
		String user = txtUser.getText();
		String pass = txtPassword.getText();
		
		
		try (
				Connection conn = DriverManager.getConnection("jdbc:mysql://"+server+"/"+cmbDatabases.getSelectedItem(), user, pass);
			) {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			String query;
			
			if (txtQueryArea.getSelectedText() != null) {
				query = txtQueryArea.getSelectedText();	
				
			} else {
				query = txtQueryArea.getText();
			}
			
			
			String firstWord = query.trim().split("\s+")[0].replaceAll("\n\r", "").toLowerCase();
			if (firstWord.equals("select")) {
				
				ResultSet rs = stmt.executeQuery(query);
				ResultSetMetaData rsMeta = rs.getMetaData();
				int colCount = rsMeta.getColumnCount();
				
				String [] headers = new String[colCount];
			      for (int i = 0 ; i < colCount; i++) {
			        headers[i] = rsMeta.getColumnName(i+1);
			      }
			      
			      
			      rs.last();	      		      
			      int rowNumber = rs.getRow();
			      rs.beforeFirst();
			     
			      Object[][] data = new Object[rowNumber][colCount];
			      
			      for (int i = 0; i < rowNumber; i++) {
			    	  rs.next();
			    	  for (int j = 0; j < colCount; j++) {
			    		  data[i][j]=rs.getObject(j+1);
						
					}
			    	 
				}
				
			      DefaultTableModel tblModel = new DefaultTableModel(data, headers);
			      tblResults.setModel(tblModel);
				
			} else if (firstWord.equals("delete")||firstWord.equals("update")||firstWord.equals("insert")) {
				
				
				int numRows =  stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(this, numRows + " rows are effected....");
				
			}
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(this, "There is a problem with your query");
		}
	}

	protected void btnTablesClicked() {
		txtQueryArea.setText("");
		
		String defaultQueris = "";
		for (String str : schemaTableList.get(cmbDatabases.getSelectedItem())) {
			
			defaultQueris += "SELECT * FROM "+str+";\n";
		}
		txtQueryArea.append("\n"+defaultQueris);
		
	}
	
	
	
	protected void btnFilterClicked() {

		TableRowSorter<DefaultTableModel> filteredResult = new TableRowSorter<DefaultTableModel>((DefaultTableModel) tblResults.getModel());
		
		tblResults.setRowSorter(filteredResult);
		filteredResult.setRowFilter(RowFilter.regexFilter(txtFilter.getText()));	
		
	}
	
	

}

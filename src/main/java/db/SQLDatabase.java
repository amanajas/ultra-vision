package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
public class SQLDatabase {
	
	private String path;
	private String dir;
	
	public SQLDatabase(String path) {
		this.dir = "sqlite/" + path;
		this.path = "jdbc:sqlite:" + this.dir;
	}
	
	private void openSQLSchema(Connection conn) {
		String file = "sqlite/sql/schema.sql";
		String schema = "";
		BufferedReader reader = null;

		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;

		    while ((text = reader.readLine()) != null) {
		        schema += text;
		        if (schema.indexOf(";") > -1) {
		        	this.createTable(conn, schema);
		        	schema = "";
		        }
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}
	}
	
	private void createTable(Connection conn, String sql) {
        // Get schema
        try (Statement stmt = conn.createStatement()) {
            // create a new table
        	System.out.println(sql);
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public Boolean create() {
		File f = new File(this.dir);
		if (f.exists()) {
			System.out.println("Database already exists!");
			return true;		
		}
		Connection conn = null;
        try {
        	Class.forName("org.sqlite.JDBC");
        	conn = DriverManager.getConnection(this.path);
            if (conn != null) {
            	
            	// Create tables
            	this.openSQLSchema(conn);
            	
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                return true;
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
	}
	
	
	public ResultSet query(String sql) {
		ResultSet response = null;
		Connection conn = null;
        try {
        	Class.forName("org.sqlite.JDBC");
        	conn = DriverManager.getConnection(this.path);
            if (conn != null) {
            	
            	Statement stmt = conn.createStatement(
            			ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
            	System.out.println(sql);
            	response = stmt.executeQuery(sql);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return response;
	}
	
}

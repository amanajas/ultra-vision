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
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		        if (schema.contains(";")) {
                            this.createTable(conn, schema);
                            schema = "";
		        }
		    }
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
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
        	conn = DriverManager.getConnection(this.path);
            if (conn != null) {
            	
            	// Create tables
            	this.openSQLSchema(conn);
            	
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                return true;
            }

        } catch (SQLException e) {
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
        
        public List<Map<String, Object>> insertOrUpdate(String sql, Object... values) {
            return this.query(sql, true, values);
        }
	
        public List<Map<String, Object>> query(String sql) {
            return this.query(sql, false);
        }
	
	private List<Map<String, Object>> query(String sql, 
                boolean insertOrUpdate, Object... values) {
            int valueCount = 1;
            for (Object value : values) {
                sql = sql.replace("#" + valueCount, String.valueOf(value));
                valueCount++;
            }
            Connection conn = null;
            List<Map<String, Object>> records = new ArrayList<>();
            try {
                conn = DriverManager.getConnection(this.path);
                if (conn != null) {
                    System.out.println(sql.trim());
                    PreparedStatement stmt = conn.prepareStatement(sql.trim());
                    if (insertOrUpdate) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("result", stmt.execute());
                        records.add(map);
                    } else {
                        ResultSet response = stmt.executeQuery();
                        while(response.next()){
                            int cols = response.getMetaData().getColumnCount();
                            Map<String, Object> map = new HashMap<>();
                            for(int i = 0; i < cols; i++){
                              map.put(response.getMetaData().getColumnName(i + 1), 
                                      response.getObject(i + 1));
                            }
                            records.add(map);
                        }
                    }
                }

            } catch (SQLException e) {
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
            return records;
	}
	
}

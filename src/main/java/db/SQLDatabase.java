package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class SQLDatabase {
	
	private final String path;
	private final String dir;
	private final String schema;
        
	public SQLDatabase() {
		this.dir = "sqlite/db/";
		this.path = this.dir + "ultra-vision.db";
                this.schema = "sqlite/sql/schema.sql";
	}
	
	private void openSQLSchema(SQLiteConnection conn) {
		String schema = "";
		BufferedReader reader = null;

		try {
		    reader = new BufferedReader(new FileReader(this.schema));
		    String text;
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
	
	private void createTable(SQLiteConnection conn, String sql) {
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
            File f = new File(this.path);
            if (f.exists()) {
                    System.out.println("Database already exists!");
                    return true;		
            }
            SQLiteConnection conn = null;
            try {
                conn = new SQLiteConnection(this.dir, this.path);
                // Create tables
                this.openSQLSchema(conn);

                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                return true;

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
        
        public int insert(String sql, Object... values) {
            return (int) this.query(sql, true, values).get(0).get("last_insert_rowid()");
        }
        
        public boolean update(String sql, Object... values) {
            return (int) this.query(sql, true, values).get(0).get("last_insert_rowid()") == 0;
        }
	
        public List<Map<String, Object>> query(String sql, Object... values) {
            return this.query(sql, false, values);
        }
        
        private List<Map<String, Object>> query(String sql, boolean insertUpdate, Object... values) {
            int valueCount = 1;
            for (Object value : values) {
                sql = sql.replace("#" + valueCount, String.valueOf(value));
                valueCount++;
            }
            SQLiteConnection conn = null;
            List<Map<String, Object>> records = new ArrayList<>();
            try {
                ResultSet response;
                conn = new SQLiteConnection(this.dir, this.path);
                System.out.println(sql.trim());
                PreparedStatement stmt = conn.prepareStatement(sql.trim(),
                        Statement.RETURN_GENERATED_KEYS);
                if (insertUpdate) {
                    stmt.executeUpdate();
                    response = stmt.getGeneratedKeys();
                } else {
                    response = stmt.executeQuery();
                }
                while(response.next()){
                    int cols = response.getMetaData().getColumnCount();
                    Map<String, Object> map = new HashMap<>();
                    for(int i = 0; i < cols; i++){
                      map.put(response.getMetaData().getColumnName(i + 1), 
                              response.getObject(i + 1));
                    }
                    records.add(map);
                }
                System.out.println(records.toString());
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

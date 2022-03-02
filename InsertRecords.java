    import java.sql.Connection;  
    import java.sql.DriverManager;  
    import java.sql.PreparedStatement;  
    import java.sql.SQLException;  
       
    public class InsertRecords {  
       
        private Connection connect() {  
            // SQLite connection string  
            String url = "jdbc:sqlite:C://sqlite/SSSIT.db";  
            Connection conn = null;  
            try {  
                conn = DriverManager.getConnection(url);  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
            return conn;  
        }  
       
      
        public void insert(String name, double year) {  
            String sql = "INSERT INTO movies(name, year) VALUES(?,?)";  
       
            try{  
                Connection conn = this.connect();  
                PreparedStatement pstmt = conn.prepareStatement(sql);  
                pstmt.setString(1, name);  
                pstmt.setDouble(2, year);  
                pstmt.executeUpdate();  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
       
        public static void main(String[] args) {  
       
            InsertRecords app = new InsertRecords();  
            // insert three new rows  
            app.insert("First_movie", 2001);  
            app.insert("Robert Movie", 2002);  
            app.insert("Tom Jerry", 2204);  
        }  
       
    }  

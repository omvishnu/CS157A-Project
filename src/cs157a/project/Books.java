
package cs157a.project;

import java.sql.*;
import java.util.*;
import java.sql.SQLException;
public class Books{
    public static void main(String[] args) throws SQLException {
        Connection conn;
        conn= MOC.getconnection();
        try {
            Statement stmt = conn.createStatement();
            Tables createTable = new Tables(stmt, conn);
            createTable.createtable();
            
            Insert insert = new Insert(stmt,conn);
            insert.fillTable();
            
            System.out.println("Table populated with random values");
            //================================================================================
            // Select all authors from the authorstable. Order the information alphabetically by the author’s last name and first name.
            
            String query1= "select * from authors";
            ResultSet resultset= stmt.executeQuery(query1);
            while(resultset.next()){
                int authorId= resultset.getInt(1);
                String firstname= resultset.getString(2);
                System.out.println("AuthorId:" + authorId + " " + "FirstName:"+ firstname);
            }
            System.out.println("==========================================================================================");
            //==================================================================================
            //Select all publishers from the publisherstable.
            
            String query2= "select * from publishers";
            ResultSet resultset2= stmt.executeQuery(query2);
            while(resultset2.next()){
                int publisherId= resultset2.getInt(1);
                String publisherName= resultset2.getString(2);
                System.out.println("Publisher Id:" + " " + publisherId + "PublisherName:"+ publisherName);
            }
             System.out.println("==========================================================================================");
            //=================================================================================
            // Select a specific publisher and list all books published by that publisher. Include the title, yearand ISBN number. Order the information alphabetically by title
            for(int i= 1; i<19; i++){
            String query3 = "Select title, isbn, year from titles where publisherId= "+i+" ";
            ResultSet resultset3= stmt.executeQuery(query3);
            while(resultset3.next()){
                String title= resultset3.getString(1);
                String isbn= resultset3.getString(2);
                String year = resultset3.getString(3);
                System.out.println("Title:"+ title + "ISBN:"+  title + "Year:"+ year); 
            }
            }
              System.out.println("==========================================================================================");
            
           //==========================================================================================
           // Add new author
           String query4= "insert into authors(authorId, firstname, lastname) values (21, 'Pulkit', 'Agarwal') ";
            stmt.executeQuery(query4);
           String sub= "Select firstname, lastname from authors where authorid= 21";
           ResultSet rs= stmt.executeQuery(sub);
           while(rs.next()){
              String lastName = rs.getString(2);
               String name= rs.getString(1);
              
               System.out.println("Name:" + name+ " " + "LastName:" + lastName);
           }
           System.out.println("==========================================================================================");
            //===========================================================================================
            //Edit/Update the existing information about an author
            
        
            
            
            //==================================================================================================
            //Add a new title for an author
            String query6= "";            
            
          
            
    }catch (SQLException ex) {
            ex.printStackTrace();
        }catch(Exception e){
        }
}
}

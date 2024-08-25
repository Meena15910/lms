package jdbc;
import java.sql.*;
import java.util.Scanner;
public class LMS {
	public static void main(String[] args) throws Exception  {
		Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Library Management System Menu:");
            System.out.println("1. Read Login Records");
            System.out.println("2. Insert Login Record");
            System.out.println("3. Delete Login Record");
            System.out.println("4. Read Book Records");
            System.out.println("5. Insert Book Record");
            System.out.println("6. Update Book Record");
            System.out.println("7. Delete Book Record");
            System.out.println("8. Read Member Records");
            System.out.println("9. Insert Member Record");
            System.out.println("10. Delete Member Record");
            System.out.println("11. Update Member Record");
            System.out.println("12. Read Transaction Records");
            System.out.println("13. Insert Transaction Record");
            System.out.println("14. Delete Transaction Record");
            System.out.println("15. Update Transaction Record");
            System.out.println("16. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (choice) {
                    case 1:
                        readRec();
                        break;
                    case 2:
                        insertRec();
                        break;
                    case 3:
                        deleteRec();
                        break;
                    case 4:
                        readRecords();
                        break;
                    case 5:
                        insertRecords();
                        break;
                    case 6:
                        deleteRecords();
                        break;
                    case 7:
                        updateRecords();
                        break;    
                    case 8:
                        readData();
                        break;
                    case 9:
                        insertData();
                        break;
                    case 10:
                        deleteData();
                        break;
                    case 11:
                        updateData();
                        break;
                    case 12:
                        read();
                        break;
                    case 13:
                        insert();
                        break;
                    case 14:
                        delete();
                        break;
                    case 15:
                        update();
                        break;    
                    case 16:
                        System.out.println("Exiting program...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 16.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
	public static void readRec() throws Exception{
    	String url = "jdbc:mysql://localhost:3306/data1";
    	String userName = "root";
    	String password = "";
    	String query = "select * from user_login";
    	Connection con = DriverManager.getConnection(url,userName,password);
    	Statement st = con.createStatement();
    	ResultSet rs = st.executeQuery(query);
    	while(rs.next()) {
    		System.out.println("username" + rs.getString(1));
    		System.out.println("user_password" + rs.getString(2));
    		System.out.println("role" + rs.getString(3));
    	}
    	con.close();
    }
	public static void insertRec() throws Exception{
    	String url = "jdbc:mysql://localhost:3306/data1";
    	String userName = "root";
    	String password = "";
    	Scanner scanner = new Scanner(System.in);
        System.out.println("Enter login details:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("user_password: ");
        String user_password = scanner.nextLine();
        System.out.print("Role: ");
        String role = scanner.nextLine();
        String query = "INSERT INTO user_login (username, user_password, role) VALUES (?, ?, ?)";
        try (Connection con = DriverManager.getConnection(url, userName, password);
               PreparedStatement st = con.prepareStatement(query)) {
               st.setString(1, username);
               st.setString(2, user_password);
               st.setString(3, role);
               int rows = st.executeUpdate();
               System.out.println("No of rows affected : " + rows);
	        }
	    }
	public static void deleteRec() throws Exception {
        String url = "jdbc:mysql://localhost:3306/data1";
        String userName = "root";
        String password = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the user ID to delete: ");
        int user_id = scanner.nextInt();
        scanner.close();
        String query = "DELETE FROM user_login WHERE user_id= ?";
        try (Connection con = DriverManager.getConnection(url, userName, password);
             PreparedStatement st = con.prepareStatement(query)) {
            st.setInt(1, user_id);
            int rows = st.executeUpdate();
            System.out.println("No of rows affected : " + rows);
        }
    }
    public static void readRecords() throws Exception{
    	String url = "jdbc:mysql://localhost:3306/data1";
    	String userName = "root";
    	String password = "";
    	String query = "select *from Books";
    	Connection con = DriverManager.getConnection(url,userName,password);
    	Statement st = con.createStatement();
    	ResultSet rs = st.executeQuery(query);
    	while(rs.next()) {
    		System.out.println("book_id" + rs.getInt(1));
    		System.out.println("title" + rs.getString(2));
    		System.out.println("author" + rs.getString(3));
    		System.out.println("genre" + rs.getString(4));
    		System.out.println("publication_year" + rs.getInt(5));
    		System.out.println("isbnr" + rs.getString(6));
    		System.out.println("available_copies" + rs.getInt(7));
    		System.out.println("total_copies" + rs.getInt(8));
    		System.out.println("shelf_location" + rs.getString(9));
        }
    	con.close();
    }
	public static void insertRecords() throws Exception {
        String url = "jdbc:mysql://localhost:3306/data1";
        String userName = "root";
        String password = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book details:");
        System.out.print("Book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Publication Year: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Available Copies: ");
        int availableCopies = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Total Copies: ");
        int totalCopies = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Shelf Location: ");
        String shelfLocation = scanner.nextLine();
        scanner.close();
        String query = "INSERT INTO Books VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(url, userName, password);
             PreparedStatement st = con.prepareStatement(query)) {
            st.setInt(1, bookId);
            st.setString(2, title);
            st.setString(3, author);
            st.setString(4, genre);
            st.setInt(5, publicationYear);
            st.setString(6, isbn);
            st.setInt(7, availableCopies);
            st.setInt(8, totalCopies);
            st.setString(9, shelfLocation);
            int rows = st.executeUpdate();
            System.out.println("No of rows affected : " + rows);
        }
    }
	public static void deleteRecords() throws Exception {
        String url = "jdbc:mysql://localhost:3306/data1";
        String userName = "root";
        String password = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Book ID to delete: ");
        int bookId = scanner.nextInt();
        scanner.close();
        String query = "DELETE FROM Books WHERE book_id = ?";
        try (Connection con = DriverManager.getConnection(url, userName, password);
             PreparedStatement st = con.prepareStatement(query)) {
            st.setInt(1, bookId);
            int rows = st.executeUpdate();
            System.out.println("No of rows affected : " + rows);
        }
    }
	public static void updateRecords() throws Exception{
		    String url = "jdbc:mysql://localhost:3306/data1";
	    	String userName = "root";
	    	String password = "";
	    	Scanner sc=new Scanner(System.in);
	    	System.out.print("Enter book id to update:");
	    	int a=sc.nextInt();
	    	String query = "update Books set title='suspense' where book_id = " +a;
	        Connection con = DriverManager.getConnection(url,userName,password);
	    	Statement st = con.createStatement();
	    	int rows = st.executeUpdate(query);
	    	System.out.println("No of rows affected : " + rows);
	    	con.close();
	}
	public static void readData() throws Exception{
	    	String url = "jdbc:mysql://localhost:3306/data1";
	    	String userName = "root";
	    	String password = "";
	    	String query = "select *from Members";
	    	Connection con = DriverManager.getConnection(url,userName,password);
	    	Statement st = con.createStatement();
	    	ResultSet rs = st.executeQuery(query);
	    	while(rs.next()) {
	    		System.out.println("member_id" + rs.getInt(1));
	    		System.out.println("name" + rs.getString(2));
	    		System.out.println("email" + rs.getString(3));
	    		System.out.println("phone_number" + rs.getString(4));
	    		System.out.println("address" + rs.getString(5));
	    		System.out.println("membership_type" + rs.getString(6));
	    		System.out.println("join_date" + rs.getInt(7));
	    	}
	    	con.close();
}
	public static void insertData() throws Exception {
	        String url = "jdbc:mysql://localhost:3306/data1";
	        String userName = "root";
	        String password = "";
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter member details:");
	        System.out.print("member_id: ");
	        int member_id = scanner.nextInt();
	        scanner.nextLine();
	        System.out.print("name: ");
	        String name = scanner.nextLine();
	        System.out.print("email: ");
	        String email = scanner.nextLine();
	        System.out.print("phone_number: ");
	        String phone_number = scanner.nextLine();
	        System.out.print("address: ");
	        String address = scanner.nextLine();
	        System.out.print("membership_type: ");
	        String membership_type = scanner.nextLine();
	        System.out.print("join_date(YYYY-MM-DD): ");
	        String join_date = scanner.nextLine();
	        scanner.close();
	        String query = "INSERT INTO Members (member_id, name, email, phone_number, address, membership_type, join_date) " +
	                "VALUES (?, ?, ?, ?, ?, ?, ?)";
	        try (Connection con = DriverManager.getConnection(url, userName, password);
	             PreparedStatement st = con.prepareStatement(query)) {
	            st.setInt(1, member_id);
	            st.setString(2, name);
	            st.setString(3, email);
	            st.setString(4, phone_number);
	            st.setString(5, address);
	            st.setString(6, membership_type);
	            st.setString(7, join_date);
	            int rows = st.executeUpdate();
	            System.out.println("No of rows affected : " + rows);
	        }
	    }
	 public static void deleteData() throws Exception {
	        String url = "jdbc:mysql://localhost:3306/data1";
	        String userName = "root";
	        String password = "";
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the Member ID to delete: ");
	        int memberid = scanner.nextInt();
	        scanner.close();
	        String query = "DELETE FROM Members WHERE member_id = ?";
	        try (Connection con = DriverManager.getConnection(url, userName, password);
	             PreparedStatement st = con.prepareStatement(query)) {
	           st.setInt(1, memberid);
	           int rows = st.executeUpdate();
	           System.out.println("No of rows affected : " + rows);
	        }
	 }
	 public static void updateData() throws Exception{
	    	String url = "jdbc:mysql://localhost:3306/data1";
	    	String userName = "root";
	    	String password = "";
	    	Scanner sc=new Scanner(System.in);
	    	System.out.print("Enter member id to update:");
	        int a=sc.nextInt();
	    	String query = "update Members set name='meena' where member_id =" +a;
	        Connection con = DriverManager.getConnection(url,userName,password);
	    	Statement st = con.createStatement();
	    	int rows = st.executeUpdate(query);
	    	System.out.println("No of rows affected : " + rows);
	    	con.close();
	}
	 public static void read() throws Exception{
	    	String url = "jdbc:mysql://localhost:3306/data1";
	    	String userName = "root";
	    	String password = "";
	    	String query = "select *from Transactions";
	    	Connection con = DriverManager.getConnection(url,userName,password);
	    	Statement st = con.createStatement();
	    	ResultSet rs = st.executeQuery(query);
	    	while(rs.next()) {
	    		System.out.println("transaction_id" + rs.getInt(1));
	    		System.out.println("book_id" + rs.getInt(2));
	    		System.out.println("member_id" + rs.getInt(3));
	    		System.out.println("transaction_type" + rs.getString(4));
	    		System.out.println("transaction_date" + rs.getString(5));
	    		System.out.println("due_date" + rs.getString(6));
	    		System.out.println("return_date" + rs.getString(7));
	    		System.out.println("fine_amount" + rs.getFloat(8));
	    	}
	    	con.close();
}
	public static void insert() throws Exception {
	        String url = "jdbc:mysql://localhost:3306/data1";
	        String userName = "root";
	        String password = "";
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter transaction details:");
	        System.out.print("transaction_id: ");
	        int transaction_id = scanner.nextInt();
	        System.out.print("book_id: ");
	        int book_id = scanner.nextInt();
	        System.out.print("member_id: ");
	        int member_id = scanner.nextInt();
	        scanner.nextLine();
	        System.out.print("transaction_type: ");
	        String transaction_type = scanner.nextLine();
	        System.out.print("transaction_date: ");
	        String transaction_date = scanner.nextLine();
	        System.out.print("due_date: ");
	        String due_date = scanner.nextLine();
	        System.out.print("return_date (YYYY-MM-DD, or leave empty if not available): ");
	        String return_date = scanner.nextLine();
	        System.out.print("fine_amount(or leave empty if not available): ");
	        String fine_amount = scanner.nextLine();
	        scanner.close();
	        String query = "INSERT INTO Transactions (transaction_id, book_id, member_id, transaction_type, transaction_date, due_date, return_date, fine_amount) " +
	                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        try (Connection con = DriverManager.getConnection(url, userName, password);
	             PreparedStatement st = con.prepareStatement(query)) {
	            st.setInt(1, transaction_id);
	            st.setInt(2, book_id);
	            st.setInt(3, member_id);
	            st.setString(4, transaction_type);
	            st.setString(5, transaction_date);
	            st.setString(6, due_date);
	            st.setString(7, return_date);
	            st.setString(8, fine_amount);
	            if (return_date.isEmpty()) {
		            st.setNull(7, Types.DATE);
		        } else {
		            st.setString(7, return_date);
		        }
	            if (fine_amount.isEmpty()) {
	                st.setNull(8, Types.FLOAT); 
	            } else {
	                st.setString(8, fine_amount); 
	            }
	            int rows = st.executeUpdate();

	            System.out.println("No of rows affected : " + rows);
	        }
}
	 public static void delete() throws Exception {
	        String url = "jdbc:mysql://localhost:3306/data1";
	        String userName = "root";
	        String password = "";
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the Transaction ID to delete: ");
	        int transactionid = scanner.nextInt();
	        scanner.close();
	        String query = "DELETE FROM Transactions WHERE transaction_id = ?";
	        try (Connection con = DriverManager.getConnection(url, userName, password);
	             PreparedStatement st = con.prepareStatement(query)) {
	            st.setInt(1,transactionid);
	            int rows = st.executeUpdate();
	            System.out.println("No of rows affected : " + rows);
	        }
	 }
	 public static void update() throws Exception{
	    	String url = "jdbc:mysql://localhost:3306/data1";
	    	String userName = "root";
	    	String password = "";
	    	Scanner sc=new Scanner(System.in);
	    	int a=sc.nextInt();
	    	String query = "update Transactions set transaction_date ='2022-02-16'  where transaction_id = "+a;
	        Connection con = DriverManager.getConnection(url,userName,password);
	    	Statement st = con.createStatement();
	    	int rows = st.executeUpdate(query);
	    	System.out.println("No of rows affected : " + rows);
	    	con.close();
	}
}	

 
	
	
		        
		    
		



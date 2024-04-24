package sportsrental;
/*
@author Alex & Anna
*/
import java.sql.Date;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class sportsRentalDB {

    private final String msAccDB = "C:\\Users\\-D3MON-\\OneDrive - Technological University Dublin\\TU819\\Sem 2\\COMP 4604 GUI Design & DB Connectivity\\GUI java Project\\SEMS Database.accdb"; // path to the DB file
    private final String dbURL = "jdbc:ucanaccess://" + msAccDB;

    public sportsRentalDB() {
        // Step 1: Loading or registering JDBC driver class
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException cnfex) {
            System.out.println("Problem in loading or registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
    }

public void addEmployee(String fName, String lName, String address, String username, String nPassword) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        // Step 2: Opening database connection
        connection = DriverManager.getConnection(dbURL);

        // Step 3: Creating and preparing SQL statement with parameters
        String sql = "INSERT INTO Employee (fName, lName, Address, username, password) VALUES (?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);

        // Step 4: Setting values for parameters
        preparedStatement.setString(1, fName);
        preparedStatement.setString(2, lName);
        preparedStatement.setString(3, address);
        preparedStatement.setString(4, username);
        preparedStatement.setString(5, nPassword);

        // Step 5: Executing the prepared statement
        int rowsAffected = preparedStatement.executeUpdate();

        // Step 6: Checking if insertion was successful
        if (rowsAffected > 0) {
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Failed to add employee.");
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        // Step 7: Closing database connection and prepared statement
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
}
    //Add Stock
   public void addEquipment(String equipmentName, int equipmentAge, String equipmentQuality, double equipmentPrice, double rentPricePerDay) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 2: Opening database connection
            connection = DriverManager.getConnection(dbURL);

            // Step 3: Creating JDBC Statement
            statement = connection.createStatement();

            // Step 4: Creating and executing SQL statement to add equipment
            String sql = "INSERT INTO Stock (equipmentName, equipmentAge, equipmentQuality, equipmentPrice, rentPricePerDay) VALUES ('" + equipmentName + "', " + equipmentAge + ", '" + equipmentQuality + "', " + equipmentPrice + ", " + rentPricePerDay + ")";
            int rowsAffected = statement.executeUpdate(sql);

            // Step 5: Checking if insertion was successful
            if (rowsAffected > 0) {
                System.out.println("Equipment added successfully.");
            } else {
                System.out.println("Failed to add equipment.");
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        } finally {
            // Step 6: Closing database connection
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlex) {
                System.err.println(sqlex.getMessage());
            }
        }
    }
   
public Map<Integer, Map<String, Object>> getAllStock() {
        Map<Integer, Map<String, Object>> stockDictionary = new HashMap<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 2: Opening database connection
            connection = DriverManager.getConnection(dbURL);

            // Step 3: Creating JDBC Statement
            statement = connection.createStatement();

            // Step 4: Executing SQL statement to select all records from Stock table
            String sql = "SELECT * FROM Stock";
            resultSet = statement.executeQuery(sql);

            // Step 5: Iterating through the result set and storing data in the dictionary
            while (resultSet.next()) {
                int stockID = resultSet.getInt("stockID");
                String equipmentName = resultSet.getString("equipmentName");
                int equipmentAge = resultSet.getInt("equipmentAge");
                String equipmentQuality = resultSet.getString("equipmentQuality");
                double equipmentPrice = resultSet.getDouble("equipmentPrice");
                double rentPricePerDay = resultSet.getDouble("rentPricePerDay"); // Retrieve rentPricePerDay

                Map<String, Object> stockInfo = new HashMap<>();
                stockInfo.put("equipmentName", equipmentName);
                stockInfo.put("equipmentAge", equipmentAge);
                stockInfo.put("equipmentQuality", equipmentQuality);
                stockInfo.put("equipmentPrice", equipmentPrice);
                stockInfo.put("rentPricePerDay", rentPricePerDay); // Add rentPricePerDay to the stockInfo

                stockDictionary.put(stockID, stockInfo);
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        } finally {
            // Step 6: Closing database connection
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlex) {
                System.err.println(sqlex.getMessage());
            }
        }
        return stockDictionary;
    }

    public void removeEquipment(int stockID) {
    Connection connection = null;
    Statement statement = null;

    try {
        // Step 2: Opening database connection
        connection = DriverManager.getConnection(dbURL);

        // Step 3: Creating JDBC Statement
        statement = connection.createStatement();

        // Step 4: Creating and executing SQL statement to remove equipment
        String sql = "DELETE FROM Stock WHERE stockID = " + stockID;
        int rowsAffected = statement.executeUpdate(sql);

        // Step 5: Checking if deletion was successful
        if (rowsAffected > 0) {
            System.out.println("Equipment removed successfully.");
        } else {
            System.out.println("Failed to remove equipment. Stock ID not found.");
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        // Step 6: Closing database connection
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
}
    
public Map<Integer, Map<String, Object>> getAllEmployees() {
    Map<Integer, Map<String, Object>> employeeDictionary = new HashMap<>();
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    try {
        // Step 2: Opening database connection
        connection = DriverManager.getConnection(dbURL);

        // Step 3: Creating JDBC Statement
        statement = connection.createStatement();

        // Step 4: Executing SQL statement to select all records from Employee table
        String sql = "SELECT * FROM Employee";
        resultSet = statement.executeQuery(sql);

        // Step 5: Iterating through the result set and storing data in the dictionary
        while (resultSet.next()) {
            int employeeID = resultSet.getInt("employeeID");
            String fName = resultSet.getString("fName");
            String lName = resultSet.getString("lName");
            String address = resultSet.getString("Address");

            Map<String, Object> employeeInfo = new HashMap<>();
            employeeInfo.put("fName", fName);
            employeeInfo.put("lName", lName);
            employeeInfo.put("Address", address);

            employeeDictionary.put(employeeID, employeeInfo);
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        // Step 6: Closing database connection
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
    return employeeDictionary;
}    
public void removeEmployee(int employeeID) {
    Connection connection = null;
    Statement statement = null;

    try {
        // Step 2: Opening database connection
        connection = DriverManager.getConnection(dbURL);

        // Step 3: Creating JDBC Statement
        statement = connection.createStatement();

        // Step 4: Creating and executing SQL statement to remove employee
        String sql = "DELETE FROM Employee WHERE employeeID = " + employeeID;
        int rowsAffected = statement.executeUpdate(sql);

        // Step 5: Checking if deletion was successful
        if (rowsAffected > 0) {
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Failed to remove employee. Employee ID not found.");
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        // Step 6: Closing database connection
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
}
public void addCustomer(String fName, String lName, int age, String sex, String address) {
    Connection connection = null;
    Statement statement = null;

    try {
        // Step 2: Opening database connection
        connection = DriverManager.getConnection(dbURL);

        // Step 3: Creating JDBC Statement
        statement = connection.createStatement();

        // Step 4: Creating and executing SQL statement to add customer
        String sql = "INSERT INTO Customer (fName, lName, Age, Sex, Address) VALUES ('" + fName + "', '" + lName + "', " + age + ", '" + sex + "', '" + address + "')";
        int rowsAffected = statement.executeUpdate(sql);

        // Step 5: Checking if insertion was successful
        if (rowsAffected > 0) {
            System.out.println("Customer added successfully.");
        } else {
            System.out.println("Failed to add customer.");
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        // Step 6: Closing database connection
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
}
public Map<Integer, Map<String, Object>> getAllCustomers() {
    Map<Integer, Map<String, Object>> customerDictionary = new HashMap<>();
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    try {
        // Step 2: Opening database connection
        connection = DriverManager.getConnection(dbURL);

        // Step 3: Creating JDBC Statement
        statement = connection.createStatement();

        // Step 4: Executing SQL statement to select all records from Customer table
        String sql = "SELECT * FROM Customer";
        resultSet = statement.executeQuery(sql);

        // Step 5: Iterating through the result set and storing data in the dictionary
        while (resultSet.next()) {
            int customerID = resultSet.getInt("CustomerID");
            String fName = resultSet.getString("fName");
            String lName = resultSet.getString("lName");
            int age = resultSet.getInt("Age");
            String sex = resultSet.getString("Sex");
            String address = resultSet.getString("Address");

            Map<String, Object> customerInfo = new HashMap<>();
            customerInfo.put("fName", fName);
            customerInfo.put("lName", lName);
            customerInfo.put("Age", age);
            customerInfo.put("Sex", sex);
            customerInfo.put("Address", address);

            customerDictionary.put(customerID, customerInfo);
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        // Step 6: Closing database connection
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
    return customerDictionary;
}
public void removeCustomer(int customerID) {
    Connection connection = null;
    Statement statement = null;

    try {
        // Step 2: Opening database connection
        connection = DriverManager.getConnection(dbURL);

        // Step 3: Creating JDBC Statement
        statement = connection.createStatement();

        // Step 4: Creating and executing SQL statement to remove customer
        String sql = "DELETE FROM Customer WHERE CustomerID = " + customerID;
        int rowsAffected = statement.executeUpdate(sql);

        // Step 5: Checking if deletion was successful
        if (rowsAffected > 0) {
            System.out.println("Customer removed successfully.");
        } else {
            System.out.println("Failed to remove customer. Customer ID not found.");
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        // Step 6: Closing database connection
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
}

public List<Map<String, String>> checkAvailability(int stockID) {
    List<Map<String, String>> availabilityInfoList = new ArrayList<>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
        connection = DriverManager.getConnection(dbURL);
        String sql = "SELECT RentalDate, ReturnDate FROM Rentals WHERE stockID = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, stockID);
        resultSet = preparedStatement.executeQuery();

        // Define a formatter that matches the datetime format from your SQL results
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");

        while (resultSet.next()) {
            String rentalDateString = resultSet.getString("RentalDate");
            String returnDateString = resultSet.getString("ReturnDate");

            // Parse the datetime strings using the new formatter
            LocalDateTime rentalDateTime = LocalDateTime.parse(rentalDateString, formatter);
            LocalDateTime returnDateTime = LocalDateTime.parse(returnDateString, formatter);

            // Format to "dd/MM/yyyy" if needed
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedRentalDate = rentalDateTime.toLocalDate().format(outputFormatter);
            String formattedReturnDate = returnDateTime.toLocalDate().format(outputFormatter);

            Map<String, String> availabilityInfo = new HashMap<>();
            availabilityInfo.put("Rental Date", formattedRentalDate);
            availabilityInfo.put("Return Date", formattedReturnDate);

            availabilityInfoList.add(availabilityInfo);
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
    return availabilityInfoList;
}
public double getRentPricePerDay(int stockID) {
    double rentPricePerDay = 0.0;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
        connection = DriverManager.getConnection(dbURL);
        String sql = "SELECT rentPricePerDay FROM Stock WHERE stockID = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, stockID);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            rentPricePerDay = resultSet.getDouble("rentPricePerDay");
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
    return rentPricePerDay;
}
public void addRental(int customerID, int stockID, LocalDate rentalDate, LocalDate returnDate, double rentalPrice) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        // Step 1: Open database connection
        connection = DriverManager.getConnection(dbURL);

        // Step 2: Create and execute SQL statement to add rental
        String sql = "INSERT INTO Rentals (customerID, stockID, RentalDate, ReturnDate, RentalPrice, Status) VALUES (?, ?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, customerID);
        preparedStatement.setInt(2, stockID);
        preparedStatement.setTimestamp(3, Timestamp.valueOf(rentalDate.atStartOfDay()));
        preparedStatement.setTimestamp(4, Timestamp.valueOf(returnDate.atStartOfDay()));
        preparedStatement.setDouble(5, rentalPrice);
        preparedStatement.setString(6, "On Lease");

        int rowsAffected = preparedStatement.executeUpdate();

        // Step 3: Check if insertion was successful
        if (rowsAffected > 0) {
            System.out.println("Rental added successfully.");
        } else {
            System.out.println("Failed to add rental.");
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        // Step 4: Close resources
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
}
public String getCustomerFirstName(int customerID) {
    String firstName = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
        connection = DriverManager.getConnection(dbURL);
        String sql = "SELECT fName FROM Customer WHERE CustomerID = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, customerID);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            firstName = resultSet.getString("fName");
        } else {
            // If no records found for the given customerID, return null
            firstName = null;
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
    return firstName;
}
public boolean checkStockExists(int stockID) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    boolean exists = false;

    try {
        // Open database connection
        connection = DriverManager.getConnection(dbURL);
        
        // Prepare SQL statement
        String sql = "SELECT * FROM Stock WHERE stockID = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, stockID);
        
        // Execute query
        resultSet = preparedStatement.executeQuery();
        
        // Check if result set has any rows
        exists = resultSet.next();
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        // Close resources
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
    return exists;
}
public double getEquipmentPrice(int stockID) {
    double equipmentPrice = 0.0;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
        connection = DriverManager.getConnection(dbURL);
        String sql = "SELECT equipmentPrice FROM Stock WHERE stockID = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, stockID);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            equipmentPrice = resultSet.getDouble("equipmentPrice");
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
    return equipmentPrice;
}
public void addPurchase(int customerID, int stockID, double totalPrice) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        // Step 2: Opening database connection
        connection = DriverManager.getConnection(dbURL);

        // Step 3: Creating and executing SQL statement to add purchase
        String sql = "INSERT INTO Purchases (customerID, stockID, PurchaseDate, TotalPrice) VALUES (?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, customerID);
        preparedStatement.setInt(2, stockID);
        preparedStatement.setDate(3, Date.valueOf(LocalDate.now())); // Use today's date for purchase date
        preparedStatement.setDouble(4, totalPrice);

        int rowsAffected = preparedStatement.executeUpdate();

        // Step 4: Checking if insertion was successful
        if (rowsAffected > 0) {
            System.out.println("Purchase added successfully.");
        } else {
            System.out.println("Failed to add purchase.");
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        // Step 5: Closing database connection
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
}
public void removePurchaseItem(int purchaseID) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        // Step 2: Opening database connection
        connection = DriverManager.getConnection(dbURL);

        // Step 3: Creating and executing SQL statement to remove stock item
        String sql = "DELETE FROM Purchases WHERE purchaseID = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, purchaseID);

        int rowsAffected = preparedStatement.executeUpdate();

        // Step 4: Checking if deletion was successful
        if (rowsAffected > 0) {
            System.out.println("purchaseID item removed successfully.");
        } else {
            System.out.println("Failed to return purchased item. PurchaseID not found.");
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        // Step 5: Closing database connection
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
}
public void updateReturnDate(int rentalID) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        // Step 1: Open database connection
        connection = DriverManager.getConnection(dbURL);

        // Step 2: Create and execute SQL statement to update ReturnDate
        String sql = "UPDATE Rentals SET ReturnDate = ? WHERE rentalID = ?";
        preparedStatement = connection.prepareStatement(sql);
        
        // Get today's date
        LocalDate today = LocalDate.now();
        Date currentDate = Date.valueOf(today);
        
        // Set the parameters
        preparedStatement.setDate(1, currentDate);
        preparedStatement.setInt(2, rentalID);
        
        // Execute the update
        int rowsAffected = preparedStatement.executeUpdate();

        // Step 3: Check if the update was successful
        if (rowsAffected > 0) {
            System.out.println("ReturnDate updated successfully for rentalID: " + rentalID);
        } else {
            System.out.println("Failed to update ReturnDate. RentalID not found.");
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        // Step 4: Close resources
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
}
public void updateReturnDateAndStatus(int rentalID) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        // Step 1: Open database connection
        connection = DriverManager.getConnection(dbURL);

        // Step 2: Create and execute SQL statement to update ReturnDate and Status
        String sql = "UPDATE Rentals SET ReturnDate = ?, Status = ? WHERE rentalID = ?";
        preparedStatement = connection.prepareStatement(sql);
        
        // Get today's date
        LocalDate today = LocalDate.now();
        Date currentDate = Date.valueOf(today);
        
        // Set the parameters
        preparedStatement.setDate(1, currentDate);
        preparedStatement.setString(2, "Returned");
        preparedStatement.setInt(3, rentalID);
        
        // Execute the update
        int rowsAffected = preparedStatement.executeUpdate();

        // Step 3: Check if the update was successful
        if (rowsAffected > 0) {
            System.out.println("ReturnDate and Status updated successfully for rentalID: " + rentalID);
        } else {
            System.out.println("Failed to update ReturnDate and Status. RentalID not found.");
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        // Step 4: Close resources
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
}
public Map<Integer, Map<String, Object>> getAllPurchases() {
    Map<Integer, Map<String, Object>> purchasesDictionary = new HashMap<>();
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    try {
        // Step 1: Opening database connection
        connection = DriverManager.getConnection(dbURL);

        // Step 2: Creating JDBC Statement
        statement = connection.createStatement();

        // Step 3: Executing SQL statement to select all records from Purchases table
        String sql = "SELECT * FROM Purchases";
        resultSet = statement.executeQuery(sql);

        // Step 4: Iterating through the result set and storing data in the dictionary
        while (resultSet.next()) {
            int purchaseID = resultSet.getInt("purchaseID");
            int customerID = resultSet.getInt("customerID");
            int stockID = resultSet.getInt("stockID");
            Date purchaseDate = resultSet.getDate("PurchaseDate");
            double totalPrice = resultSet.getDouble("TotalPrice");

            // Create a map to store the purchase details
            Map<String, Object> purchaseInfo = new HashMap<>();
            purchaseInfo.put("customerID", customerID);
            purchaseInfo.put("stockID", stockID);
            purchaseInfo.put("PurchaseDate", purchaseDate);
            purchaseInfo.put("TotalPrice", totalPrice);

            // Add the purchase details to the dictionary
            purchasesDictionary.put(purchaseID, purchaseInfo);
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        // Step 5: Closing database connection
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
    return purchasesDictionary;
}
public Map<Integer, Map<String, Object>> getAllRentals() {
    Map<Integer, Map<String, Object>> rentalsDictionary = new HashMap<>();
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    try {
        // Step 1: Opening database connection
        connection = DriverManager.getConnection(dbURL);

        // Step 2: Creating JDBC Statement
        statement = connection.createStatement();

        // Step 3: Executing SQL statement to select all records from Rentals table
        String sql = "SELECT * FROM Rentals";
        resultSet = statement.executeQuery(sql);

        // Step 4: Iterating through the result set and storing data in the dictionary
        while (resultSet.next()) {
            int rentalID = resultSet.getInt("rentalID");
            int customerID = resultSet.getInt("customerID");
            int stockID = resultSet.getInt("stockID");
            Date rentalDate = resultSet.getDate("RentalDate");
            Date returnDate = resultSet.getDate("ReturnDate");
            double rentalPrice = resultSet.getDouble("RentalPrice");
            String status = resultSet.getString("Status");

            // Create a map to store the rental details
            Map<String, Object> rentalInfo = new HashMap<>();
            rentalInfo.put("customerID", customerID);
            rentalInfo.put("stockID", stockID);
            rentalInfo.put("RentalDate", rentalDate);
            rentalInfo.put("ReturnDate", returnDate);
            rentalInfo.put("RentalPrice", rentalPrice);
            rentalInfo.put("Status", status);

            // Add the rental details to the dictionary
            rentalsDictionary.put(rentalID, rentalInfo);
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        // Step 5: Closing database connection
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
    return rentalsDictionary;
}
public String getPasswordByUsername(String username) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String password = null;

    try {
        // Step 2: Opening database connection
        connection = DriverManager.getConnection(dbURL);

        // Step 3: Creating and preparing SQL statement with parameter
        String sql = "SELECT password FROM Employee WHERE username = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);

        // Step 4: Executing the prepared statement
        resultSet = preparedStatement.executeQuery();

        // Step 5: Checking if username exists and retrieving password
        if (resultSet.next()) {
            password = resultSet.getString("password");
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    } finally {
        // Step 6: Closing database connection and prepared statement
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
    return password;
}
}
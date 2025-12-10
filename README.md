# 🏦 Java Banking Application

A desktop banking application built with Java Swing and MySQL, featuring user authentication, account management, and transaction processing.

![Java](https://img.shields.io/badge/Java-25-orange)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Maven](https://img.shields.io/badge/Maven-3.x-red)
![License](https://img.shields.io/badge/License-MIT-green)

## 📋 Features

- ✅ **User Authentication**
  - Secure login and registration
  - Password-protected accounts
  
- ✅ **Account Management**
  - View account balance
  - Real-time balance updates
  
- ✅ **Transactions**
  - Deposit money
  - Withdraw money
  - Transfer funds between accounts
  - Transaction history tracking
  
- ✅ **Security**
  - SQL injection prevention with PreparedStatements
  - Input validation
  - Error handling

## 🛠️ Technologies Used

- **Language:** Java 25
- **GUI Framework:** Java Swing
- **Database:** MySQL 8.0
- **Build Tool:** Maven
- **JDBC Driver:** MySQL Connector/J 9.1.0

## 📁 Project Structure

```
mavenproject3/
├── src/
│   └── main/
│       └── java/
│           └── com/mycompany/mavenproject3/
│               ├── Account.java              # Login/Signup GUI
│               ├── Mainmenu.java             # Main navigation
│               ├── DepositWithdraw.java      # Deposit/Withdraw GUI
│               ├── TransactionsTransfer.java # Transfer GUI
│               ├── UserDAO.java              # Database operations
│               ├── DatabaseConnection.java   # DB connection
│               └── DatabaseSetup.java        # Table creation
├── pom.xml                                   # Maven configuration
└── README.md
```

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- MySQL Server 8.0 or higher
- Maven 3.x
- NetBeans IDE (optional)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/java-banking-app.git
   cd java-banking-app
   ```

2. **Set up MySQL Database**
   ```sql
   CREATE DATABASE javaproject;
   USE javaproject;
   
   CREATE TABLE users (
       id INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(50) UNIQUE NOT NULL,
       password VARCHAR(255) NOT NULL,
       balance DECIMAL(10, 2) DEFAULT 0.00,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
   );
   
   CREATE TABLE transactions (
       id INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(50) NOT NULL,
       type VARCHAR(20) NOT NULL,
       amount DECIMAL(10, 2) NOT NULL,
       description VARCHAR(255),
       transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       FOREIGN KEY (username) REFERENCES users(username)
   );
   ```

3. **Configure Database Connection**
   
   Edit `src/main/java/com/mycompany/mavenproject3/DatabaseConnection.java`:
   ```java
   private static final String DB_URL = "jdbc:mysql://localhost:3306/javaproject";
   private static final String USER = "root";
   private static final String PASSWORD = "your_password"; // Change this
   ```

4. **Build the project**
   ```bash
   mvn clean package
   ```

5. **Run the application**
   ```bash
   java -jar target/mavenproject3-1.0-SNAPSHOT-jar-with-dependencies.jar
   ```

## 💻 Usage

### 1. Register a New Account
- Launch the application
- Click "Sign Up"
- Enter username and password
- Click "Create Account"

### 2. Login
- Enter your username and password
- Click "Login"

### 3. Perform Transactions
- **Deposit:** Enter amount and click "Deposit"
- **Withdraw:** Enter amount and click "Withdraw"
- **Transfer:** Enter recipient username and amount, click "Process Transfer"

## 🔒 Security Features

- **SQL Injection Prevention:** All queries use PreparedStatements
- **Input Validation:** Validates all user inputs
- **Error Handling:** Comprehensive try-catch blocks
- **Balance Verification:** Checks sufficient funds before transactions

## 📸 Screenshots

### Login Screen
![Login Screen](login.png)

### Main Menu
![Main Menu](mainmenu.png)

### Transfer Screen
![Transfer](transfer.png)

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**QwertyTheCoder**
- GitHub: [@qwertythecoder](https://github.com/qwertythecoder)

## 🙏 Acknowledgments

- Java Swing documentation
- MySQL documentation
- Maven documentation

## 📞 Support

For support, email or open an issue in the repository.

## 🔮 Future Enhancements

- [ ] Password hashing (BCrypt)
- [ ] Email notifications
- [ ] Transaction receipts (PDF)
- [ ] Account statements
- [ ] Multi-currency support
- [ ] Admin dashboard
- [ ] REST API integration
- [ ] Mobile app version

---

**⭐ If you found this project helpful, please give it a star!**




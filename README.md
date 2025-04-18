# 💼 Employee CRUD App with Thymeleaf and Spring Boot

A simple and intuitive **Employee Management System** built using **Spring Boot**, **Spring MVC**, **Spring Data JPA**, **Thymeleaf**, and **H2 Database**. This project allows you to perform basic **CRUD** (Create, Read, Update, Delete) operations on employee records via a beautiful UI.

---

## 🛠 Technologies Used

- 🌱 Spring Boot
- 🌐 Spring Web
- 📦 Spring Data JPA
- 🎨 Thymeleaf (HTML Templating Engine)
- 🛢 H2 In-Memory Database
- 💡 Spring Tool Suite (STS)

---

## 📸 Features

- ✅ Add new employee
- 📋 View list of employees
- ✏️ Update existing employee
- 🗑️ Delete employee from the list
- 🔔 Flash messages for successful actions
- 💻 Clean and responsive UI

---

## 📂 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.example.demo/
│   │       ├── controllers/
│   │       ├── entity/
│   │       ├── repository/
│   │       └── services/
│   └── resources/
│       ├── templates/
│       │   ├── employee.html
│       │   ├── register.html
│       │   └── update-form.html
│       └── application.properties
```

---

## 🚀 How to Run the Project

> Follow these steps to run the project in **Spring Tool Suite (STS)**:

1. 📥 **Clone the Repository**

   ```bash
   git clone https://github.com/SanketChopade777/Employee-CRUD-App-with-Thymeleaf-and-Spring-Boot
   ```

2. 🧩 **Open in STS**

   - Open Spring Tool Suite.
   - Click on `File > Import > Existing Maven Projects`.
   - Navigate to the cloned project folder and click `Finish`.

3. 🧱 **Build & Run**

   - Right-click the project and select `Run As > Spring Boot App`.

4. 🌐 **Access the App**
   - Open your browser and visit:  
     `http://localhost:8080/employees`

---

## ⚙️ H2 Database Configuration

> No manual DB setup required! H2 is used as an in-memory database.

To view the database in-browser:

- Navigate to: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:tcp://localhost/~/testdb`
- Username: `sa`
- Password: _(leave it blank)_

Make sure the console is enabled in `application.properties`:

```properties
# H2 Database configuration
spring.datasource.url=jdbc:h2:tcp://localhost/~/testdb;AUTO_SERVER=TRUE;IFEXISTS=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Enable H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.web-allow-others=true

# JPA settings
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

```

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

## 🙌 Contributing

Contributions are welcome! Feel free to fork the repository and submit a pull request. For major changes, please open an issue first to discuss what you would like to change.

---

## 💬 Feedback

If you have any suggestions or feedback, feel free to reach out or open an issue. 😊

---

> Made with ❤️ by Sanket Nivas Chopade

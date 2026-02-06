# Developer Onboarding Guide

<cite>
**Referenced Files in This Document**   
- [pom.xml](file://pom.xml)
- [run-legacy.bat](file://run-legacy.bat)
- [stop-legacy.bat](file://stop-legacy.bat)
- [application.properties](file://src/main/resources/application.properties)
- [hibernate.cfg.xml](file://src/main/resources/hibernate.cfg.xml)
- [context.xml](file://META-INF/context.xml)
- [web.xml](file://src/main/webapp/WEB-INF/web.xml)
- [ActionAction.java](file://src/main/java/net/sam/dcl/action/ActionAction.java)
- [ActionForm.java](file://src/main/java/net/sam/dcl/form/ActionForm.java)
- [App.java](file://src/main/java/net/sam/dcl/App.java)
- [MIGRATION_PLAN.md](file://MIGRATION_PLAN.md)
- [MIGRATION_STEPS.md](file://MIGRATION_STEPS.md)
</cite>

## Table of Contents
1. [Introduction](#introduction)
2. [Prerequisites and Environment Setup](#prerequisites-and-environment-setup)
3. [Project Structure Overview](#project-structure-overview)
4. [Building and Running the Application](#building-and-running-the-application)
5. [Configuration and Database Setup](#configuration-and-database-setup)
6. [Making Your First Code Change](#making-your-first-code-change)
7. [Debugging Common Startup Issues](#debugging-common-startup-issues)
8. [Understanding the Legacy Codebase](#understanding-the-legacy-codebase)
9. [Key Learning Resources](#key-learning-resources)
10. [Conclusion](#conclusion)

## Introduction

Welcome to the dcl_v3 project! This guide provides comprehensive onboarding instructions for new developers joining the team. The dcl_v3 application is a legacy enterprise resource management system built on Java 8, Struts 1.x, Hibernate, and Firebird database. This document covers everything you need to know to set up your development environment, build and run the application, understand the codebase, and make your first contribution.

The project has been structured with modernization in mind, as evidenced by the migration documentation and Maven-based build system. While the core technology stack is legacy, the team is actively working on a modernization path that includes transitioning to Spring MVC and updating the persistence layer. This guide will help you navigate both the current state of the application and the planned migration efforts.

**Section sources**
- [MIGRATION_PLAN.md](file://MIGRATION_PLAN.md#L1-L102)
- [MIGRATION_STEPS.md](file://MIGRATION_STEPS.md#L1-L206)

## Prerequisites and Environment Setup

Before you can begin working with the dcl_v3 project, you'll need to install several prerequisites and configure your development environment properly.

### Java Development Kit (JDK)
The application requires **Java 8 (JDK 1.8)** to run. While the migration plan indicates a future move to Java 17, the current codebase is built and tested with Java 8. Download and install JDK 8 from the Oracle website or use an OpenJDK distribution. After installation, verify your setup by running:
```
java -version
javac -version
```

### Apache Maven
The project uses Maven for dependency management and building. Install **Maven 3.x** or higher. The project includes a Maven wrapper (`mvnw`), but having Maven installed globally is recommended for development work. Verify your installation with:
```
mvn -version
```

### Firebird Database
The application uses **Firebird 2.1.3** as its primary database. Download and install Firebird from the official website. During installation, make sure to:
- Set the SYSDBA password to "masterkey" (this is the default expected by the application)
- Note the installation directory as you'll need it for database configuration
- Ensure the Firebird server is running as a service

### Development Tools
While not strictly required, the following tools are recommended:
- **IDE**: IntelliJ IDEA or Eclipse with Java EE support
- **Database Manager**: FlameRobin or IBExpert for Firebird database management
- **Text Editor**: VS Code or similar for configuration files

After installing these prerequisites, set up your environment variables:
- `JAVA_HOME` should point to your JDK installation directory
- Add `%JAVA_HOME%\bin` and your Maven `bin` directory to your `PATH`

**Section sources**
- [MIGRATION_PLAN.md](file://MIGRATION_PLAN.md#L1-L102)
- [pom.xml](file://pom.xml#L1-L283)

## Project Structure Overview

Understanding the project structure is essential for navigating the codebase effectively. The dcl_v3 project follows a standard Maven web application structure with some legacy elements.

The main directories are:
- **src/main/java**: Contains all Java source code, organized in packages by functionality
- **src/main/resources**: Configuration files including `application.properties`, `hibernate.cfg.xml`, and logging configuration
- **src/main/webapp**: Web application resources including JSP files, JavaScript, CSS, and the `WEB-INF` directory
- **db**: Database scripts for schema creation and migrations
- **conf**: Additional configuration files

The Java package structure follows a layered architecture:
- `net.sam.dcl.action`: Struts action classes that handle HTTP requests
- `net.sam.dcl.beans`: Data transfer objects and business entities
- `net.sam.dcl.dao`: Data access objects for database operations
- `net.sam.dcl.form`: Form beans that capture user input
- `net.sam.dcl.service`: Business logic services
- `net.sam.dcl.util`: Utility classes and helpers

The web interface is built with JSP pages that use Struts tag libraries for dynamic content. The `webapp/jsp` directory contains the main user interface components, while `webapp/ajax` contains partial views used for AJAX requests.

**Section sources**
- [pom.xml](file://pom.xml#L1-L283)
- [web.xml](file://src/main/webapp/WEB-INF/web.xml#L1-L176)

## Building and Running the Application

The dcl_v3 application can be built and run using Maven and the provided batch scripts.

### Building with Maven
The project uses a Maven `pom.xml` file for dependency management and building. To build the application, navigate to the project root directory and run:
```
mvn clean package
```

This command will:
- Compile all Java source files
- Process resources
- Run any configured tests (though the current configuration may skip tests)
- Package the application as a WAR file in the `target` directory

The `pom.xml` file includes several profiles for different purposes:
- **legacy-run**: Used to run the application with Jetty (default)
- **db-migrate**: For database migration tasks
- **orm-smoke**: For ORM smoke tests

### Running the Application
The application can be started using the `run-legacy.bat` script, which uses the Jetty Maven plugin to run the application. Simply execute:
```
run-legacy.bat
```

This will start the application on port 8082. You can specify a different port by providing it as an argument:
```
run-legacy.bat 8085
```

The script configures the necessary JVM arguments for the legacy libraries, including the required module opens for Java 17+ compatibility.

To stop the application, use the `stop-legacy.bat` script:
```
stop-legacy.bat
```

### Application Startup Process
When the application starts, the following occurs:
1. The `InitApp` servlet is loaded (configured in `web.xml` with `load-on-startup=1`)
2. Hibernate is initialized using the configuration in `hibernate.cfg.xml`
3. The Struts action servlet is initialized
4. Various filters are loaded, including the Hibernate session filter and security defender filter
5. The application is ready to serve requests at `http://localhost:8082`

**Section sources**
- [pom.xml](file://pom.xml#L1-L283)
- [run-legacy.bat](file://run-legacy.bat#L1-L35)
- [stop-legacy.bat](file://stop-legacy.bat#L1-L25)
- [web.xml](file://src/main/webapp/WEB-INF/web.xml#L1-L176)

## Configuration and Database Setup

Proper configuration is essential for the application to connect to the database and function correctly.

### Application Configuration
The main configuration file is `src/main/resources/application.properties`. This file contains placeholder settings for database connection and Hibernate configuration. For development, you'll need to configure the Firebird database connection.

Uncomment and modify the Firebird configuration section:
```properties
# For Firebird example:
jdbc.driver=org.firebirdsql.jdbc.FBDriver
jdbc.url=jdbc:firebirdsql://localhost:3050/C:/path/to/dcl.fdb?charSet=UTF-8
jdbc.user=sysdba
jdbc.password=masterkey
```

Replace `C:/path/to/dcl.fdb` with the actual path where you want the database file to be created.

### Database Initialization
The database schema is defined in `db/migration/V0__initial_schema.sql`, which was generated from the legacy `create_db.sql` script. This SQL script contains the complete database schema including:
- Generators (sequences) for primary keys
- Domains (data types)
- Tables and relationships
- Stored procedures
- Triggers

To create the database:
1. Ensure the Firebird server is running
2. Use a database management tool like FlameRobin to connect to the Firebird server
3. Execute the SQL script `db/migration/V0__initial_schema.sql`
4. The script will create the database file at the specified location

Alternatively, you can use the Flyway Maven profile to apply migrations:
```
mvn -P db-migrate -Djdbc.url=jdbc:firebirdsql://localhost:3050/C:/path/to/dcl.fdb -Djdbc.user=sysdba -Djdbc.password=masterkey flyway:migrate
```

### Hibernate Configuration
The `hibernate.cfg.xml` file contains the Hibernate configuration used by the application. Key settings include:
- **dialect**: `org.hibernate.dialect.FirebirdDialect` - specifies the Firebird SQL dialect
- **show_sql**: `true` - enables SQL statement logging
- **connection.pool_size**: `10` - connection pool size
- **current_session_context_class**: `org.hibernate.context.ManagedSessionContext` - session context management

The file also lists all the entity classes that Hibernate should manage through `<mapping class>` elements.

### JNDI Configuration
For deployment in a servlet container like Tomcat, the application can use JNDI for database connection pooling. The `META-INF/context.xml` file contains example configurations for different databases, including Firebird. For development, you can use the direct JDBC connection, but for production, configure the JNDI resource in your application server.

**Section sources**
- [application.properties](file://src/main/resources/application.properties#L1-L60)
- [hibernate.cfg.xml](file://src/main/resources/hibernate.cfg.xml#L1-L66)
- [context.xml](file://META-INF/context.xml#L1-L80)
- [V0__initial_schema.sql](file://db/migration/V0__initial_schema.sql#L1-L799)

## Making Your First Code Change

Now that your environment is set up, let's walk through making your first code change to the application.

### Understanding the Code Flow
The application follows the Struts 1.x MVC pattern. When a user interacts with the interface, the following flow occurs:
1. A JSP page contains a form that submits to an action URL (e.g., `Action.do`)
2. The Struts action servlet (configured in `web.xml`) receives the request
3. The appropriate action class processes the request
4. The action forwards to a JSP page to render the response

For example, the `ActionAction.java` class handles requests related to system actions. It extends `DBAction` and implements `IDispatchable`, allowing it to handle multiple operations through the dispatch mechanism.

### Making a Simple Change
Let's modify the version display in the application. The version is defined in `App.java`:

1. Open `src/main/java/net/sam/dcl/App.java`
2. You'll see the version is defined as a static string:
```java
public static String VERSION = "2.4.5";
```
3. Change this to include your name for testing:
```java
public static String VERSION = "2.4.5-dev-[YourName]";
```
4. Save the file

### Building and Testing Your Change
1. Build the application: `mvn clean package`
2. Run the application: `run-legacy.bat`
3. Open a browser and navigate to `http://localhost:8082`
4. The version should now display your modified version string

### Understanding the Components
Let's examine the key components involved in this change:

#### Action Classes
Action classes like `ActionAction.java` handle user requests. They typically:
- Extend a base action class (e.g., `DBAction`)
- Implement methods for different operations (input, edit, process)
- Use form beans to capture and validate user input
- Interact with DAO classes for data access

#### Form Beans
Form beans like `ActionForm.java` capture user input from HTML forms. They contain properties that correspond to form fields and are automatically populated by Struts.

#### JSP Pages
JSP pages use Struts tag libraries to create dynamic content. For example, `Action.jsp` uses tags like `<html:form>`, `<html:text>`, and `<html:checkbox>` to create form elements that are bound to the action form.

### Testing Your Changes
The application includes various testing mechanisms:
- **Manual testing**: Navigate through the UI to verify your changes
- **Visual regression testing**: The migration plan mentions Playwright for visual testing
- **Unit tests**: Located in the `test` directories throughout the codebase

For your version change, manual testing is sufficient. For more complex changes, you should run the existing test suite and potentially add new tests.

**Section sources**
- [App.java](file://src/main/java/net/sam/dcl/App.java#L1-L8)
- [ActionAction.java](file://src/main/java/net/sam/dcl/action/ActionAction.java#L1-L85)
- [ActionForm.java](file://src/main/java/net/sam/dcl/form/ActionForm.java#L1-L61)
- [Action.jsp](file://src/main/webapp/jsp/Action.jsp#L1-L35)

## Debugging Common Startup Issues

When setting up and running the dcl_v3 application, you may encounter various startup issues. Here are the most common problems and their solutions.

### Java Version Compatibility Issues
**Problem**: The application fails to start with module system errors like "Unable to open stack guard page" or "Class not found" for core Java classes.

**Solution**: The application uses legacy libraries that require specific JVM arguments. The `run-legacy.bat` script already includes these arguments:
```
--add-opens=java.base/java.lang=ALL-UNNAMED
--add-opens=java.base/java.lang.reflect=ALL-UNNAMED
--add-opens=java.base/java.io=ALL-UNNAMED
--add-opens=java.base/java.util=ALL-UNNAMED
--add-opens=java.desktop/java.beans=ALL-UNNAMED
```

If you're running Maven directly, include these arguments:
```
mvn jetty:run -Djetty.http.port=8082 --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.lang.reflect=ALL-UNNAMED --add-opens=java.base/java.io=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED --add-opens=java.desktop/java.beans=ALL-UNNAMED
```

### Database Connection Problems
**Problem**: Hibernate fails to initialize with errors like "Cannot create PoolableConnection" or "FirmDatabase not found".

**Solution**: Verify your database configuration:
1. Check that the Firebird server is running
2. Verify the database path in `application.properties` is correct and writable
3. Ensure the SYSDBA user and password are correct
4. Test the connection using a database management tool

### Port Conflicts
**Problem**: The application fails to start with "Address already in use" errors.

**Solution**: The default port is 8082. Either:
- Stop the process currently using port 8082
- Start the application on a different port: `run-legacy.bat 8085`

### Missing Dependencies
**Problem**: Maven build fails with "Cannot resolve dependencies" errors.

**Solution**: The project relies on some legacy JARs that may not be in Maven Central. Check the `legacy-libs/WEB-INF-lib` directory for these JARs. You may need to install them manually in your local Maven repository or configure system-scoped dependencies.

### Classpath Issues
**Problem**: `ClassNotFoundException` or `NoClassDefFoundError` for Struts or Hibernate classes.

**Solution**: Verify that all required dependencies are included in `pom.xml`. The current configuration should include:
- `javax.servlet-api` (provided)
- `jstl`
- `slf4j-api` and `logback-classic`
- `hibernate-core`
- `struts` dependencies

### JSP Compilation Errors
**Problem**: JSP pages fail to compile with tag library errors.

**Solution**: Ensure all required TLD files are present in `WEB-INF/tld/` and that the taglib declarations in JSP files are correct. The `web.xml` file should include the taglib configurations.

### Hibernate Mapping Issues
**Problem**: Hibernate fails to start with "Could not instantiate id generator" or mapping errors.

**Solution**: Verify that `hibernate.cfg.xml` includes all required entity mappings and that the database schema matches the expected structure. The generators in the database should be properly initialized.

**Section sources**
- [run-legacy.bat](file://run-legacy.bat#L1-L35)
- [pom.xml](file://pom.xml#L1-L283)
- [application.properties](file://src/main/resources/application.properties#L1-L60)
- [hibernate.cfg.xml](file://src/main/resources/hibernate.cfg.xml#L1-L66)
- [web.xml](file://src/main/webapp/WEB-INF/web.xml#L1-L176)

## Understanding the Legacy Codebase

The dcl_v3 codebase has several characteristics that are typical of legacy enterprise applications. Understanding these will help you navigate and work with the code more effectively.

### Struts 1.x Architecture
The application uses Struts 1.x, which follows a classic MVC pattern with the following components:

#### Action Classes
Action classes extend `org.apache.struts.action.Action` and handle HTTP requests. They typically:
- Receive an `ActionMapping`, `ActionForm`, `HttpServletRequest`, and `HttpServletResponse`
- Perform business logic and data access
- Return an `ActionForward` to determine the next view

The dcl_v3 application uses a custom base class `DBAction` that extends the Struts `Action` class and adds database functionality.

#### Form Beans
Form beans extend `ActionForm` and represent the data from HTML forms. They contain properties with getters and setters that correspond to form fields. Validation can be performed in the form bean's `validate()` method.

#### Action Mappings
Action mappings are configured in `struts-config.xml` (located at `/WEB-INF/classes/resources/struts/struts-config.xml`). They define:
- Which action class handles each URL pattern
- The form bean associated with each action
- The forward mappings for success, failure, and other outcomes

### Hibernate Integration
The application uses Hibernate 5.6.15.Final for object-relational mapping. Key aspects include:

#### Session Management
The `HibernateSessionFilter` (configured in `web.xml`) manages Hibernate sessions for each request. This ensures that a session is available throughout the request lifecycle and is properly closed afterward.

#### Entity Mapping
Entities are mapped using a combination of:
- XML mapping files referenced in `hibernate.cfg.xml`
- Annotations (though the legacy code appears to use primarily XML mapping)

The `hibernate.cfg.xml` file lists all entity classes that should be managed by Hibernate.

#### DAO Pattern
Data access is handled through DAO classes that encapsulate database operations. These classes use Hibernate sessions to perform CRUD operations and queries.

### Custom Framework Components
The application includes several custom framework components:

#### IActionContext Interface
The `IActionContext` interface (in `net.sam.dcl.controller`) provides a wrapper around the Struts action context, making it easier to work with request, response, form, and other objects.

#### Custom Tag Libraries
The application uses several custom tag libraries:
- `html-controls`: Custom form controls
- `dcl-html-controls`: DCL-specific form controls
- `html-grid`: Grid/table components

These are declared in `web.xml` and used in JSP pages to create consistent UI components.

### Security Model
The application implements security through:
- **DefenderFilter**: A custom filter that checks user authentication and authorization
- **Role-based access control**: Users are assigned roles that determine their permissions
- **Session management**: User sessions are tracked and managed

### Logging and Error Handling
The application uses SLF4J with Logback for logging, with bridges for legacy logging frameworks (commons-logging, log4j). Error handling is implemented through:
- Struts `ActionMessages` and `ActionErrors`
- Custom error pages configured in `web.xml`
- Exception handling in action classes

### Migration Context
The presence of `MIGRATION_PLAN.md` and `MIGRATION_STEPS.md` indicates that the team is actively working on modernizing the application. Key aspects of the migration plan include:
- Moving from Struts 1.x to Spring MVC
- Updating from Java 8 to Java 17
- Modernizing the build system with Maven
- Improving testing with Playwright for visual regression testing

Understanding this migration context is important as it affects how you should approach changes to the codebase. The team is likely looking for changes that support the migration goals rather than deep modifications to the legacy architecture.

**Section sources**
- [ActionAction.java](file://src/main/java/net/sam/dcl/action/ActionAction.java#L1-L85)
- [IActionContext.java](file://src/main/java/net/sam/dcl/controller/IActionContext.java#L1-L59)
- [web.xml](file://src/main/webapp/WEB-INF/web.xml#L1-L176)
- [hibernate.cfg.xml](file://src/main/resources/hibernate.cfg.xml#L1-L66)
- [MIGRATION_PLAN.md](file://MIGRATION_PLAN.md#L1-L102)
- [MIGRATION_STEPS.md](file://MIGRATION_STEPS.md#L1-L206)

## Key Learning Resources

To effectively work with the dcl_v3 application, you should familiarize yourself with several key technologies and resources.

### Official Documentation
- **Struts 1.x Documentation**: The official Apache Struts 1 documentation is essential for understanding the framework's architecture and components. Focus on the user guide and API documentation.
- **Hibernate Documentation**: The Hibernate 5.6 documentation covers configuration, mapping, and query APIs. Pay special attention to the sections on legacy XML mapping and session management.
- **Firebird Documentation**: The Firebird SQL documentation will help you understand the database features and syntax used in the application.

### Project-Specific Resources
- **MIGRATION_PLAN.md**: This document outlines the team's strategy for modernizing the application. Understanding the migration goals will help you make decisions that align with the long-term vision.
- **MIGRATION_STEPS.md**: This step-by-step plan provides detailed instructions for the migration process and includes valuable context about the current state and future direction of the project.
- **pom.xml**: Studying the Maven configuration will help you understand the project's dependencies and build process.

### Internal Code Examples
- **Action Classes**: Study `ActionAction.java` as a representative example of how Struts actions are implemented in the application.
- **Form Beans**: Examine `ActionForm.java` to understand how form data is captured and validated.
- **Configuration Files**: Review `application.properties`, `hibernate.cfg.xml`, and `web.xml` to understand how the application is configured.

### Development Tools
- **Firebird Database Manager**: Tools like FlameRobin or IBExpert will help you manage the database, execute queries, and troubleshoot issues.
- **IDE Debugger**: Learn to use your IDE's debugger to step through code, inspect variables, and understand the application flow.
- **Maven**: Become proficient with Maven commands for building, testing, and managing dependencies.

### Best Practices for Legacy Code
- **Work in Small Increments**: Make small, focused changes and test frequently.
- **Write Tests**: Even if the existing code lacks tests, try to add tests for your changes.
- **Document Your Changes**: Add comments and update documentation to help future developers.
- **Communicate with the Team**: When in doubt, ask questions. The team likely has valuable institutional knowledge about the application.

### Recommended Learning Path
1. Start with the migration documents to understand the project context
2. Set up your development environment and run the application
3. Study the Struts 1.x framework basics
4. Explore the codebase, starting with the action classes and form beans
5. Make a small, non-critical change to get familiar with the development workflow
6. Gradually take on more complex tasks as you become comfortable with the codebase

**Section sources**
- [MIGRATION_PLAN.md](file://MIGRATION_PLAN.md#L1-L102)
- [MIGRATION_STEPS.md](file://MIGRATION_STEPS.md#L1-L206)
- [pom.xml](file://pom.xml#L1-L283)
- [ActionAction.java](file://src/main/java/net/sam/dcl/action/ActionAction.java#L1-L85)
- [ActionForm.java](file://src/main/java/net/sam/dcl/form/ActionForm.java#L1-L61)

## Conclusion

The dcl_v3 project represents a complex legacy enterprise application that is in the process of modernization. This onboarding guide has provided you with the essential knowledge to set up your development environment, understand the codebase, and make your first contributions.

Key takeaways:
- The application is built on Java 8, Struts 1.x, Hibernate, and Firebird database
- A modernization plan is in place to migrate to Spring MVC and update the technology stack
- The Maven build system and migration documentation provide a foundation for incremental improvements
- Understanding the Struts 1.x MVC pattern and Hibernate integration is crucial for working with the codebase

As you begin working on the project, remember to:
- Start with small, manageable tasks to build your understanding
- Refer to the migration documents to align your work with the team's long-term goals
- Don't hesitate to ask questions when you encounter unfamiliar code or patterns
- Contribute to the documentation as you learn, helping future developers

The path to modernizing a legacy application is challenging but rewarding. Your contributions will help improve the maintainability, performance, and reliability of the system while preserving its business value.

Welcome to the team, and happy coding!

**Section sources**
- [MIGRATION_PLAN.md](file://MIGRATION_PLAN.md#L1-L102)
- [MIGRATION_STEPS.md](file://MIGRATION_STEPS.md#L1-L206)
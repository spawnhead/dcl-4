# Directory Structure Breakdown

<cite>
**Referenced Files in This Document**   
- [context.xml](file://META-INF/context.xml)
- [slogans.txt](file://conf/slogans.txt)
- [V0__initial_schema.sql](file://db/migration/V0__initial_schema.sql)
- [application.properties](file://src/main/resources/application.properties)
- [index.jsp](file://src/main/webapp/index.jsp)
- [main.jsp](file://src/main/webapp/layout/main.jsp)
- [web.xml](file://src/main/webapp/WEB-INF/web.xml)
- [App.java](file://src/main/java/net/sam/dcl/App.java)
</cite>

## Table of Contents
1. [Project Structure Overview](#project-structure-overview)
2. [Core Directories](#core-directories)
3. [Configuration and Deployment](#configuration-and-deployment)
4. [Database Assets](#database-assets)
5. [Documentation Assets](#documentation-assets)
6. [Source Code Organization](#source-code-organization)
7. [Web Application Structure](#web-application-structure)
8. [Development Guidance](#development-guidance)

## Project Structure Overview

The dcl_v3 project follows a standard Java web application structure with clear separation of concerns. The directory layout is organized to separate deployment descriptors, configuration files, database assets, documentation, and source code. This structure supports a legacy Java web application built with Struts framework, using Firebird as the primary database with Flyway for migration management. The application appears to be a business management system with modules for contracts, specifications, shipping, and financial tracking.

**Section sources**
- [context.xml](file://META-INF/context.xml)
- [slogans.txt](file://conf/slogans.txt)
- [V0__initial_schema.sql](file://db/migration/V0__initial_schema.sql)

## Core Directories

The project contains several key directories that serve distinct purposes:

- **META-INF**: Contains deployment descriptors for the application container
- **conf**: Stores configuration files and application resources
- **db**: Houses all database-related assets including migration scripts and Firebird UDFs
- **doc**: Contains HTML documentation for the application
- **src/main**: Contains the main source code, resources, and web application files

These directories follow conventional patterns for Java web applications, with the src/main directory following Maven standard directory layout for web applications.

**Section sources**
- [context.xml](file://META-INF/context.xml)
- [slogans.txt](file://conf/slogans.txt)
- [V0__initial_schema.sql](file://db/migration/V0__initial_schema.sql)

## Configuration and Deployment

The configuration and deployment directory structure is organized to separate container-specific configuration from application configuration:

### META-INF Directory
The META-INF directory contains context.xml which defines JNDI resources for database connections. The file includes commented examples for different database vendors (PostgreSQL, Oracle, Firebird), indicating the application supports multiple database backends. The configuration uses Tomcat's JDBC connection pool with standard settings for connection management.

### conf Directory
The conf directory contains application-specific configuration files. Currently, it includes slogans.txt which appears to contain user interface text and help content in Russian, suggesting the application's primary user base is Russian-speaking. This file contains HTML-formatted text with CSS styling and JavaScript functionality, indicating it's used directly in the user interface.

**Section sources**
- [context.xml](file://META-INF/context.xml)
- [slogans.txt](file://conf/slogans.txt)

## Database Assets

The db directory contains comprehensive database assets for the application, organized into subdirectories for different types of database components:

### Migration Scripts
The db/migration directory contains Flyway migration scripts that follow the standard Flyway naming convention (V[version]__[description].sql). The migrations are versioned sequentially from V0__initial_schema.sql through multiple versions (V1_*, V2_*), indicating a well-maintained database evolution process. The initial schema script creates a Firebird database with numerous generators (sequences), domains, tables, stored procedures, and triggers.

### Firebird UDFs
The db/firebird/UDF directory contains SQL scripts (fbudf.sql, ib_udf.sql, ib_udf2.sql) that define User Defined Functions for Firebird. These UDFs provide additional functionality such as date arithmetic (ADDDAY, ADDHOUR, ADDMONTH) and null value handling (INVL, DNVL). The presence of these UDFs indicates the application leverages Firebird-specific extensions for enhanced database functionality.

### Flyway Configuration
The pom.xml file configures the Flyway Maven plugin with the migration location set to filesystem:${project.basedir}/db/migration, confirming the migration directory structure. The configuration includes validateOnMigrate and baselineOnMigrate settings, indicating a robust database migration strategy.

**Section sources**
- [V0__initial_schema.sql](file://db/migration/V0__initial_schema.sql)
- [fbudf.sql](file://db/firebird/UDF/fbudf.sql)
- [pom.xml](file://pom.xml)

## Documentation Assets

The doc directory contains HTML documentation for the application, organized as standalone HTML files with associated resources:

### HTML Documentation
The documentation consists of HTML files with Russian names (e.g., "DCL v1_4_8 - Отгрузки.htm", "КП - интерфейс.htm") that appear to be user guides or interface documentation. Each HTML file has a corresponding files directory containing supporting assets like CSS and JavaScript files. This structure suggests the documentation was generated from a WYSIWYG HTML editor or content management system.

### Documentation Organization
The documentation is organized by functional areas of the application, with files covering specific modules like shipping ("Отгрузки" meaning "Shipments") and commercial proposals ("КП" likely meaning "Commercial Proposal"). This indicates a comprehensive documentation approach that covers key business processes supported by the application.

**Section sources**
- [DCL v1_4_8 - Отгрузки.htm](file://doc/DCL v1_4_8 - Отгрузки.htm)
- [КП - интерфейс.htm](file://doc/КП - интерфейс.htm)

## Source Code Organization

The src/main directory follows the standard Maven directory structure for Java web applications, with clear separation between Java source code, resources, and web application files:

### Java Source Code
The src/main/java directory contains the Java source code organized under the net.sam.dcl package hierarchy. The code follows a typical MVC pattern with separate packages for actions (controllers), beans (models), DAOs (data access), and services. The action package contains numerous Action classes that handle user requests, while the beans package contains data transfer objects and business entities.

### Resource Files
The src/main/resources directory contains configuration files including:
- application.properties: Application configuration with commented database connection settings
- hibernate.cfg.xml: Hibernate ORM configuration
- log4j.properties and logback.xml: Logging configuration
- persistence.xml: JPA persistence configuration

These resources provide the necessary configuration for the application's data access, logging, and persistence layers.

**Section sources**
- [App.java](file://src/main/java/net/sam/dcl/App.java)
- [application.properties](file://src/main/resources/application.properties)
- [hibernate.cfg.xml](file://src/main/resources/hibernate.cfg.xml)

## Web Application Structure

The web application structure is organized according to Java web application standards, with JSPs, static assets, and configuration files properly separated:

### Web Configuration
The src/main/webapp/WEB-INF directory contains web.xml which configures the Struts ActionServlet to handle requests with the *.do extension. The configuration includes filter mappings for session management, request/response encoding (UTF-8), and security. The web application uses Struts tag libraries for UI components and form handling.

### JSP Organization
The JSP files are organized into several directories:
- **ajax**: Contains JSPs for AJAX responses and partial page updates
- **dialogs**: Contains modal dialog JSPs
- **jsp**: Contains main page JSPs for various application functions
- **layout**: Contains template JSPs that define the overall page structure
- **layout-items**: Contains reusable UI components like headers, footers, and menus

### Static Assets
The web application includes numerous static assets organized under the includes directory:
- **cerny**: Contains JavaScript libraries and utilities (console, JSON tools)
- **plupload-2.1.2**: Contains the Plupload file upload library
- Various JavaScript files for UI functionality (calendar.js, prototype.js, tabs.js)
- CSS files for styling (dcl.css, tabs.css)

The index.jsp file serves as the application entry point, forwarding to the OfficeAction.do controller, which suggests the main application interface is accessed through this action.

**Section sources**
- [index.jsp](file://src/main/webapp/index.jsp)
- [main.jsp](file://src/main/webapp/layout/main.jsp)
- [web.xml](file://src/main/webapp/WEB-INF/web.xml)

## Development Guidance

For developers working on the dcl_v3 project, the following guidance applies for locating specific types of files:

### Configuration Files
- **Application configuration**: src/main/resources/application.properties
- **Database configuration**: META-INF/context.xml (container) and application.properties (application)
- **Logging configuration**: src/main/resources/log4j.properties and logback.xml
- **Persistence configuration**: src/main/resources/hibernate.cfg.xml and persistence.xml

### Database Assets
- **Migration scripts**: db/migration/ (Flyway scripts named V[version]__[description].sql)
- **Initial schema**: db/migration/V0__initial_schema.sql
- **Firebird UDFs**: db/firebird/UDF/
- **Stored procedures and triggers**: Defined in migration scripts

### Source Code
- **Controllers**: src/main/java/net/sam/dcl/action/
- **Models/Beans**: src/main/java/net/sam/dcl/beans/
- **Data Access**: src/main/java/net/sam/dcl/dao/
- **Services**: src/main/java/net/sam/dcl/service/
- **Utilities**: src/main/java/net/sam/dcl/util/

### Web Resources
- **Main pages**: src/main/webapp/jsp/
- **AJAX components**: src/main/webapp/ajax/
- **Templates**: src/main/webapp/layout/
- **Static assets**: src/main/webapp/includes/
- **JavaScript libraries**: src/main/webapp/includes/plupload-2.1.2/ and cerny/
- **CSS files**: src/main/webapp/includes/*.css

### Documentation
- **User documentation**: doc/ directory (HTML files)
- **Configuration documentation**: conf/slogans.txt (UI text and help content)
- **Build configuration**: pom.xml

This structure provides a clear organization that facilitates development, maintenance, and extension of the application.

**Section sources**
- [pom.xml](file://pom.xml)
- [slogans.txt](file://conf/slogans.txt)
- [V0__initial_schema.sql](file://db/migration/V0__initial_schema.sql)
- [application.properties](file://src/main/resources/application.properties)
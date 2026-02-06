# JavaScript Components

<cite>
**Referenced Files in This Document**   
- [plupload.full.min.js](file://includes/plupload-2.1.2/js/plupload.full.min.js)
- [cerny.js](file://includes/cerny/js/cerny.js)
- [tabs.js](file://includes/tabs.js)
- [list.js](file://includes/list.js)
- [prototype.js](file://includes/prototype.js)
- [calendar.js](file://includes/calendar.js)
- [dFilter.js](file://includes/dFilter.js)
- [MultipleFileUpload.jsp](file://jsp/MultipleFileUpload.jsp)
- [MultipleFileUploadHelperAction.java](file://java/net/sam/dcl/action/MultipleFileUploadHelperAction.java)
</cite>

## Table of Contents
1. [File Upload with Plupload](#file-upload-with-plupload)
2. [Cerny.js UI Utility Library](#cernyjs-ui-utility-library)
3. [Custom JavaScript Components](#custom-javascript-components)
4. [Integration with Backend Services](#integration-with-backend-services)
5. [Browser Compatibility and Performance](#browser-compatibility-and-performance)

## File Upload with Plupload

The dcl_v3 application utilizes Plupload for file upload functionality, providing multi-runtime support that ensures compatibility across different browsers and environments. Plupload supports various runtimes including HTML5, Flash, Silverlight, and legacy HTML4, allowing the application to adapt to the user's browser capabilities.

Plupload is configured to use the Silverlight runtime as specified in the MultipleFileUpload.jsp file, with the browse_button set to 'pickfiles' and the upload URL pointing to a servlet endpoint. The configuration includes the silverlight_xap_url parameter pointing to Moxie.xap, which is required for the Silverlight runtime to function properly.

The file upload process follows a standard workflow: users click the "Select Files" button to open the file dialog, select one or more files which are then added to the upload queue, and finally click "Upload Files" to initiate the upload process. During upload, progress is displayed for each file, showing the percentage completed. The implementation handles various events including PostInit, FilesAdded, UploadProgress, and Error, providing feedback to users throughout the upload process.

Plupload's event system enables comprehensive monitoring of the upload process. The FilesAdded event triggers when files are selected, updating the UI to display the selected files and their sizes. The UploadProgress event updates the progress indicator for each file as it uploads. Error handling is implemented to catch and display any issues that occur during the upload process, with error details logged to the browser console.

**Section sources**
- [plupload.full.min.js](file://includes/plupload-2.1.2/js/plupload.full.min.js)
- [MultipleFileUpload.jsp](file://jsp/MultipleFileUpload.jsp)

## Cerny.js UI Utility Library

Cerny.js serves as the core UI utility library in the dcl_v3 application, providing essential functionality for DOM manipulation, popup windows, and console utilities. The library follows a modular design with various components that can be used independently based on the application's needs.

The console functionality in Cerny.js offers multiple output options including a popup window console and a DOM element console. The popup window console opens a separate browser window for logging messages, while the DOM element console writes messages to a designated element in the page. Both consoles support different log levels (FATAL, ERROR, WARN, INFO, DEBUG, TRACE) with corresponding CSS classes for visual differentiation.

Cerny.js implements an interception pattern that allows for aspect-oriented programming, enabling features like logging, profiling, and type checking to be added to functions without modifying their core implementation. The library includes a ContractViolation exception for enforcing preconditions and postconditions, helping to ensure code correctness. Type checking functionality verifies parameter types and return values according to specified signatures, enhancing code reliability.

The library also provides utility functions for object manipulation, including methods for creating objects with prototypal inheritance, attaching methods with interceptors, and checking object types. These utilities simplify common JavaScript operations and promote consistent coding patterns throughout the application.

**Section sources**
- [cerny.js](file://includes/cerny/js/cerny.js)
- [console.js](file://includes/cerny/js/console/console.js)
- [PopupWindow.js](file://includes/cerny/js/console/PopupWindow.js)
- [DomElement.js](file://includes/cerny/js/console/DomElement.js)

## Custom JavaScript Components

The dcl_v3 application includes several custom JavaScript components that enhance user interface functionality and improve the user experience. These components address specific UI requirements and provide consistent behavior across the application.

### Tabs Component

The tabs.js component implements tabbed interfaces that allow users to navigate between different content sections without page reloads. The component uses CSS classes to identify tab containers, tab headers, and tab panes, enabling the system to dynamically show and hide content based on user selection. When a tab is clicked, the switchTab function identifies the selected tab, updates the visibility of tab panes, and stores the selection in a cookie to maintain state across sessions.

The tabs component supports multiple interaction methods including direct tab clicks, tab links, and navigation buttons for moving between tabs. It uses event delegation to handle clicks on tab elements, preventing default browser behavior and ensuring consistent navigation. The component also provides keyboard navigation support, allowing users to move between tabs using arrow keys.

### List Component

The list.js component implements grid controls and dropdown lists that enhance data entry and selection processes. The component manages keyboard navigation within lists, allowing users to move between rows using arrow keys and select items with the Enter key. It implements a filtering mechanism that automatically triggers searches when input values change, providing real-time feedback as users type.

The list component uses an overlay approach to display dropdown lists, positioning them relative to the associated input field. It handles document clicks to close the list when users click elsewhere on the page, maintaining a clean interface. The component also manages focus states, highlighting selected rows and updating input values when items are selected.

### Other Custom Components

The application includes several other specialized components:

- **Prototype.js**: Provides AJAX operations and DOM manipulation utilities, extending native JavaScript objects with additional methods for arrays, strings, and functions. It includes functionality for asynchronous requests, element effects, and event handling.

- **Calendar.js**: Implements date picker functionality with support for multiple date formats and localization. The component displays a monthly calendar view with navigation controls for moving between months and years. It supports both date selection and month range selection, with callback functions that execute when dates are selected.

- **dFilter.js**: Provides input validation for numerical fields, enforcing formatting rules and preventing invalid characters from being entered. The component processes keyboard events to filter input according to a specified mask, automatically formatting numbers as users type.

**Section sources**
- [tabs.js](file://includes/tabs.js)
- [list.js](file://includes/list.js)
- [prototype.js](file://includes/prototype.js)
- [calendar.js](file://includes/calendar.js)
- [dFilter.js](file://includes/dFilter.js)

## Integration with Backend Services

The JavaScript components in dcl_v3 are tightly integrated with backend services to provide a seamless user experience. The file upload functionality demonstrates this integration, with Plupload sending files to a servlet endpoint that processes the uploads and manages attachments.

The MultipleFileUploadHelperAction Java class handles the server-side processing of file uploads. It uses Apache Commons FileUpload to parse multipart requests and extract uploaded files. The action checks for duplicate filenames before saving files to prevent conflicts. The integration between the client-side Plupload component and the server-side action is facilitated through a specific URL pattern that includes the user's session ID for security.

Error handling is implemented on both client and server sides. Client-side JavaScript captures upload errors and displays them to users, while server-side code validates uploads and returns appropriate error responses. The communication follows a request-response pattern, with the client sending files and receiving status updates and completion notifications.

The tabs component maintains state through cookies, allowing the application to remember user preferences across sessions. When users navigate between tabs, the selection is stored in a cookie named according to the tab container's ID, enabling the interface to restore the last active tab when the page is reloaded.

**Section sources**
- [MultipleFileUpload.jsp](file://jsp/MultipleFileUpload.jsp)
- [MultipleFileUploadHelperAction.java](file://java/net/sam/dcl/action/MultipleFileUploadHelperAction.java)

## Browser Compatibility and Performance

The dcl_v3 application addresses browser compatibility issues through the use of polyfills and feature detection in its JavaScript components. Plupload's multi-runtime architecture ensures file upload functionality works across different browsers, automatically selecting the most appropriate technology based on browser capabilities.

The application includes legacy JavaScript support for older browsers, with polyfills for modern JavaScript features and conditional code paths for browser-specific quirks. The tabs and list components include workarounds for Internet Explorer's event model, using both standard DOM event methods and IE-specific properties to ensure compatibility.

Performance optimization techniques are applied to the monolithic scripts through careful event handling and DOM manipulation. The components minimize reflows and repaints by batching DOM updates and using document fragments when appropriate. Event delegation is used extensively to reduce the number of event listeners and improve memory efficiency.

The application also implements lazy loading for certain components, initializing them only when needed rather than at page load. This approach reduces initial page load time and improves perceived performance. The file upload component specifically optimizes bandwidth usage by supporting chunked uploads, allowing large files to be transferred in smaller pieces with the ability to resume interrupted uploads.

**Section sources**
- [plupload.full.min.js](file://includes/plupload-2.1.2/js/plupload.full.min.js)
- [tabs.js](file://includes/tabs.js)
- [list.js](file://includes/list.js)
- [prototype.js](file://includes/prototype.js)
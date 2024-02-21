src/ : Contient le code source de l'application.

model/ : Contient les classes représentant les entités Prof et Matiere.

view/ : Contient les interfaces utilisateur pour afficher les données.

controller/ : Contient les classes contrôleur qui orchestrent l'accès aux données et leur affichage.

dao/ : Contient les classes d'accès aux données pour interagir avec la base de données.

# Model-View-Controller (MVC)

## Description
The MVC pattern is a design pattern used to structure software applications. It divides an application into three main components: the model, the view, and the controller. Each component has a specific responsibility within the system, making it easier to manage, maintain, and scale the application.

## Components

### 1. Model
The model represents the data and business logic of the application. It manages data access, performs CRUD operations (create, read, update, delete), and contains data processing logic. The model is typically independent of the user interface.

### 2. View
The view is responsible for the user interface and displaying data to the client. It presents the model data in a user-friendly manner for the end user. The view has no business logic; it simply displays the data provided by the controller or directly by the model.

### 3. Controller
The controller acts as an intermediary between the model and the view. It receives user input via the view, processes this input, performs necessary operations on the model, and returns the results to the view for display. The controller typically contains event handling and user action logic.

## Advantages of the MVC Pattern

- **Separation of Concerns**: The MVC pattern separates the responsibilities of the application into three distinct components, making the code more modular, maintainable, and scalable.
  
- **Code Reusability**: By separating business logic from the user interface, code can be reused in different parts of the application or in other projects.

- **Facilitated Collaboration**: The MVC pattern allows different developers to work simultaneously on different components of the application without interfering with each other.


## License
This pattern is made available under the MIT License. See the LICENSE file for more details.

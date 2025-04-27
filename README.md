# Activity6-3: Weather Forecast Application

This is a Spring MVC web application that retrieves and displays weather forecasts using the National Weather Service API. Users can input latitude and longitude to get the weather forecast for a specific location.

## Features
- Input latitude and longitude to fetch weather data.
- Displays weather forecast in a styled table format.
- Uses the National Weather Service API for accurate weather data.

## Prerequisites
- Java 17 or higher installed.
- Maven installed (or use the Maven wrapper provided).
- Internet connection to access the National Weather Service API.

## How to Run

### On Windows
1. Open a terminal or command prompt.
2. Navigate to the project directory:
   ```
   cd c:\Users\Daren\IdeaProjects\Activity6-3
   ```
3. Use the Maven wrapper to run the application:
   ```
   .\mvnw spring-boot:run
   ```
4. Open your browser and go to `http://localhost:8080`.

### On Mac/Linux
1. Open a terminal.
2. Navigate to the project directory:
   ```
   cd /path/to/Activity6-3
   ```
3. Use the Maven wrapper to run the application:
   ```
   ./mvnw spring-boot:run
   ```
4. Open your browser and go to `http://localhost:8080`.

## How to Use
1. Enter the latitude and longitude of the location you want to check.
2. Click the "Get Weather" button.
3. View the weather forecast displayed in a table format.

## Project Structure
- `src/main/java`: Contains the Java source code.
  - `Activity63Application.java`: Main application entry point.
  - `WeatherController.java`: Handles user input and API calls.
- `src/main/resources`: Contains static resources and templates.
  - `static/styles.css`: CSS for styling the application.
  - `templates/weatherForm.html`: HTML form for user input.
  - `templates/weatherResult.html`: Displays the weather forecast.

## Notes
- Ensure you have an active internet connection to fetch data from the National Weather Service API.
- If you encounter any issues, check the logs in the terminal for error messages.

## License
This project is for educational purposes and does not include a specific license.
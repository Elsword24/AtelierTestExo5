Feature: Task CRUD operations

  Background:
    * url 'http://localhost:8080'

  Scenario: Create a new task
    Given path 'tasks'
    And request { "title": "Test Task", "description": "Description of Test Task", "completed": false }
    When method post
    Then status 200
    And match response.title == 'Test Task'
    And match response.description == 'Description of Test Task'
    And match response.completed == false
    And def taskId = response.id

  Scenario: Read the created task
    Given path 'tasks', taskId
    When method get
    Then status 200
    And match response.id == taskId
    And match response.title == 'Test Task'
    And match response.description == 'Description of Test Task'
    And match response.completed == false

  Scenario: Update the created task
    Given path 'tasks', taskId
    And request { "title": "Updated Task", "description": "Updated Description", "completed": true }
    When method put
    Then status 200
    And match response.id == taskId
    And match response.title == 'Updated Task'
    And match response.description == 'Updated Description'
    And match response.completed == true

  Scenario: Delete the created task
    Given path 'tasks', taskId
    When method delete
    Then status 204

  Scenario: Verify the task is deleted
    Given path 'tasks', taskId
    When method get
    Then status 404

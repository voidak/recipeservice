
# Recipe Service

This project is a web service for a website that collects and publishes recipes. 

Technologies used in this project:

 - Jersey 2.28/ JAX-RS 2.1
 - Json/Jackson 2.28 
 - Java 8
 - Tomcat 9
 - Maven 3
 - JUnit 4.8.2


# Running
   
## Prerequisites
  
 - Maven is installed 
 - Web server, such as Tomcat 
  
## Steps
 
 1 Navigate to the location where you want to have the project
 2 Run the following commant to download the project
	git clone https://github.com/voidak/recipeservice.git
 3 Now navigate inside the project folder
 4 Run the following command to generate the *.war file
	mvn install
 5 The project is building and the Unit Test status can be monitored in the command line output
 6 Inside the project folder ther will be a /target folder and a *.war file inside it
 7 Use a web server (for example Tomcat) to run the *.war file.
 8 The web service is now running, by default, on http://localhost:8080/ 

 
# API
   
## Get all recipes

Returns JSON data with the list of all recipes.

* **URL**

  /recipeservice/rest/recipe/all

* **Method:**

  `GET`

* **Success Response:**

  * **Code:** 200
    **Content:**
  ```javascript
	{
		"head": {
			"title": "Title 1",
			"categories": {
				"cat": [
					"Cat 1",
					"Cat 2"
				]
			},
			"yield": 1
		},
		"ingredients": {
			"ing": [{
					"amt": {
						"qty": "1",
						"unit": "unit"
					},
					"item": "Some item"
				},
				{
					"amt": {
						"qty": "1",
						"unit": "unit"
					},
					"item": "Some item"
				}
			]
		},
		"directions": {
			"step": "Description"
		}
	},
	{
		"head": {
			"title": "Title 2",
			"categories": {
				"cat": [
					"Cat 3",
					"Cat 4"
				]
			},
			"yield": 2
		},
		"ingredients": {
			"ing": [{
					"amt": {
						"qty": "1",
						"unit": "unit"
					},
					"item": "Some item"
				},
				{
					"amt": {
						"qty": "1",
						"unit": "unit"
					},
					"item": "Some item"
				}
			]
		},
		"directions": {
			"step": "Description"
		}
	}
	```
* **Error Response:**
  * **Code:** 500 Server error
  
## Get a recipe from a specific category

Returns JSON data with the list of all recipes frm a specific category

* **URL**

  /recipeservice/rest/recipe/all?category=:category

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `category=[String]`

* **Success Response:**

  * **Code:** 200
    **Content:**
  ```javascript
	{
		"head": {
			"title": "Title 1",
			"categories": {
				"cat": [
					"Cat 1",
					"Cat 2"
				]
			},
			"yield": 1
		},
		"ingredients": {
			"ing": [{
					"amt": {
						"qty": "1",
						"unit": "unit"
					},
					"item": "Some item"
				},
				{
					"amt": {
						"qty": "1",
						"unit": "unit"
					},
					"item": "Some item"
				}
			]
		},
		"directions": {
			"step": "Description"
		}
	},
	{
		"head": {
			"title": "Title 2",
			"categories": {
				"cat": [
					"Cat 3",
					"Cat 4"
				]
			},
			"yield": 2
		},
		"ingredients": {
			"ing": [{
					"amt": {
						"qty": "1",
						"unit": "unit"
					},
					"item": "Some item"
				},
				{
					"amt": {
						"qty": "1",
						"unit": "unit"
					},
					"item": "Some item"
				}
			]
		},
		"directions": {
			"step": "Description"
		}
	}
	```
* **Error Response:**

  * **Code:** 500 Server error

## Get all cateogries
Returns JSON data with the list of distinct categories.

* **URL**

  /recipeservice/rest/recipe/categories

* **Method:**

  `GET`

* **Success Response:**

  * **Code:** 200
    **Content:**
  ```javascript
   [
    "Cat 1",
    "Cat 2"
   ]
  ```
* **Error Response:**

  * **Code:** 500 Server error
 
## Save a recipe

  Enables saving a recipe

* **URL**

  /recipeservice/rest/recipe/save

* **Method:**

  `POST`

* **Request**

  * **Content-Type: application/json**
  ```javascript
	{
		"head": {
			"title": "Title 1",
			"categories": {
				"cat": [
					"Cat 1",
					"Cat 2"
				]
			},
			"yield": 1
		},
		"ingredients": {
			"ing": [{
					"amt": {
						"qty": "1",
						"unit": "unit"
					},
					"item": "Some item"
				},
				{
					"amt": {
						"qty": "1",
						"unit": "unit"
					},
					"item": "Some item"
				}
			]
		},
		"directions": {
			"step": "Description"
		}
	}
	```

* **Success Response:**

  * **Code:** 200
 
* **Error Response:**

  * **Code:** 500 Server error
   * **Code:** 400 Bad request

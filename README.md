
# Recipe Service

This project is a web service for a website that collects and publishes recipes. 

Technologies used in this project:

 - Jersey 2.28/ JAX-RS 2.1
 - Json/Jackson 2.28 
 - Java SDK 8
 - Tomcat 9
 - Maven 3
 - JUnit 4.8.2

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

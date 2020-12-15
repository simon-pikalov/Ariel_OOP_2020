"""
JSON:
    stands for JavaScript Object Notation.
    is a lightweight format for storing and transporting data.
    is often used when data is sent from a server to a web page.
    is "self-describing" and easy to understand
"""

#Import the json module:
import json

#Parse JSON (i.e.: Convert from JSON to Python) with json.loads()
x =  '{ "name":"John", "age":30, "city":"New York"}'
y = json.loads(x)# the result is a Python dictionary:
print(y["age"]) 

#from Python to JSON with json.dumps()
x =  { "name":"John", "age":30, "city":"New York"}
# convert into JSON:
y = json.dumps(x)
print(y) #output is sring: {"name": "John", "age": 30, "city": "New York"}

"""
You can convert Python objects of the following types, into JSON strings:

    dict
    list
    tuple
    string
    int
    float
    True
    False
    None
    
When you convert from Python to JSON, Python objects are converted into the JSON (JavaScript) equivalent:
Python 	JSON

dict 	Object
list 	Array
tuple 	Array
str 	String
int 	Number
float 	Number
True 	true
False 	false
None 	null



"""
#Convert a Python object containing all the legal data types:
import json

x = {
  "name": "John",
  "age": 30,
  "married": True,
  "divorced": False,
  "children": ("Ann","Billy"),
  "pets": None,
  "cars": [
    {"model": "BMW 230", "mpg": 27.5},
    {"model": "Ford Edge", "mpg": 24.1}
  ]
}

print(json.dumps(x)) #tryit to understand the next

#Use the indent parameter to define the numbers of indents:
json.dumps(x, indent=4)

"""
output:
{
    "name": "John",
    "age": 30,
    "married": true,
    "divorced": false,
    "children": [
        "Ann",
        "Billy"
    ],
    "pets": null,
    "cars": [
        {
            "model": "BMW 230",
            "mpg": 27.5
        },
        {
            "model": "Ford Edge",
            "mpg": 24.1
        }
    ]
} 
"""
# use . and a space to separate objects, and a space, a = and a space to separate keys from their values:
print(json.dumps(x, indent=4, separators=(". ", " = ")))
"""
output:
{
    "name" = "John".
    "age" = 30.
    "married" = true.
    "divorced" = false.
    "children" = [
        "Ann".
        "Billy"
    ],
    "pets" = null.
    "cars" = [
        {
            "model" = "BMW 230".
            "mpg" = 27.5
        }.
        {
            "model" = "Ford Edge".
            "mpg" = 24.1
        }
    ]
} 
"""

#Use the sort_keys parameter to specify if the result should be sorted or not:
json.dumps(x, indent=4, sort_keys=True)

"""
{
    "age": 30,
    "cars": [
        {
            "model": "BMW 230",
            "mpg": 27.5
        },
        {
            "model": "Ford Edge",
            "mpg": 24.1
        }
    ],
    "children": [
        "Ann",
        "Billy"
    ],
    "divorced": false,
    "married": true,
    "name": "John",
    "pets": null
}
"""

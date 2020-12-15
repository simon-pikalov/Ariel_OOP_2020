#regex or regular expression: Regular expressions are extremely useful in extracting information from text such as code, log files, spreadsheets, or even documents.
"""
it's better to take tutorial if you're new to it
https://regexone.com/
"""

import re #regex module

#Search the string to see if it starts with "The" and ends with "Spain":

txt = "The rain in Spain"
x = re.search("^The.*Spain$", txt) 
"""
Function 	Description

findall 	Returns a list containing all matches
search 	  Returns a Match object if there is a match anywhere in the string
split 	  Returns a list where the string has been split at each match
sub 	    Replaces one or many matches with a string
"""
>>>>>>>learn regex

#"a" - Append - will append to the end of the file

f = open("demofile2.txt", "a")
f.write("Now the file has more content!")
f.close()

#open and read the file after the appending:
f = open("demofile2.txt", "r")
print(f.read())

#"w" - Write - will overwrite (delete) any existing content

f = open("demofile3.txt", "w")
f.write("Woops! I have deleted the content!")
f.close()

#open and read the file after the appending:
f = open("demofile3.txt", "r")
print(f.read()) 

#"x" - Create - will create a file, returns an error if the file exist
#"w" - Write - will create a file if the specified file does not exist

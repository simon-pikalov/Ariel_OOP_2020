#to delete file
import os
os.remove("demofile.txt") 

#Check if file exists, then delete it:
import os
if os.path.exists("demofile.txt"):
  os.remove("demofile.txt")
else:
  print("The file does not exist") 

#Remove the folder "myfolder":
import os
os.rmdir("myfolder") 

# With while loop we can execute a set of statements as long as a condition is true.

# Print i as long as i is less than 6:
i = 1
while i < 6:
    print(i)
    i += 1

# break statement we can stop the loop even if condition is true:

# Exit the loop when i is 3:
i = 1
while i < 6:
    print(i)
    if i == 3:
        break
    i += 1

# continue statement can stop the current iteration, and continue with the next:

# Continue to the next iteration if i is 3:
i = 0
while i < 6:
    i += 1
    if i == 3:
        continue
    print(i)

# else:

i = 1
while i < 6:
    print(i)
    i += 1
    if i == 3:
        break
else:  # this is relevant mainly for cases of break
    print("i is no longer less than 6")  # run the block of code once when the condition no longer is true.

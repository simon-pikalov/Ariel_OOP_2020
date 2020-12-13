# OOP: Intro to Python_101, for java programmers: Dictionaries (like maps in Java)
d = {"user":"my name", "password":1234} # aka Hash table.
print(d)
print(d.get("user"))
print(d["password"])
v = d.get("none")
print(v)
d["new"] = 41 # 'new' ~ "new"
d['new'] = 42
l = len(d)
print(l)
print(d)
print(d.values())
print(d.keys())
l = d.items()
print(l)
print(d)

del d["new"]
print(d)
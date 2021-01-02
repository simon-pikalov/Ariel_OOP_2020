import random

import matplotlib.pyplot as plt
import numpy as np
#https://colab.research.google.com/github/makeabilitylab/signals/blob/master/Tutorials/IntroToMatplotlib.ipynb#scrollTo=DZBaqyORpHIS

import random
import matplotlib.pyplot as plt
import numpy as np

x_vals = [1,2,3,4]
y_vals = [1,4,9,16]
plt.plot(x_vals,y_vals,label = "My firs plot :)")
plt.xlabel("x axis ")
plt.ylabel("y axis ")
plt.title("The title of the graph")
plt.legend()
plt.show()

x = np.arange(0,10,0.1)
plt.figure(figsize=(20, 10))
y = np.sin(x)
plt.plot(x,y,"D-")
plt.plot(x_vals,y_vals,"ro-")
plt.show()


x = [0.15, 0.3, 0.45, 0.6, 0.75]
y = [2.56422, 3.77284, 3.52623, 3.51468, 3.02199]
n = [58, 651, 393, 203, 123]

fig, ax = plt.subplots()
ax.scatter(x, y)

for i, txt in enumerate(n):
    ax.annotate(n[i], (x[i]+0.005, y[i]+0.005)) # arrowprops=dict(arrowstyle="simple")

plt.plot(x, y)
plt.show()

fig = plt.figure()
ax = plt.axes(projection="3d")


z_line = np.linspace(0, 15, 1000)
x_line = np.cos(z_line)
y_line = np.sin(z_line)
ax.plot3D(x_line, y_line, z_line, 'gray')

z_points = 15 * np.random.random(100)
x_points = np.cos(z_points) + 0.1 * np.random.randn(100)
y_points = np.sin(z_points) + 0.1 * np.random.randn(100)
ax.scatter3D(x_points, y_points, z_points, c=z_points, cmap='hsv');

plt.show()
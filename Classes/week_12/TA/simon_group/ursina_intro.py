from ursina import *


# Test Cube
class Test_cube(Entity):
	def __init__(self):
		super().__init__(
			parent = scene,
			model = 'cube',
			texture = 'white_cube',
			rotation = Vec3(45,45,45))

# Test button
class Test_button(Button):
	def __init__(self,scale = 0.1):
		super().__init__(
			parent = scene,
			model = 'cube',
			texture = 'brick',
			color = color.white,
			highlight_color = color.red,
			pressed_color = color.lime)

# update is run every frame
def update():
	#print('test')
	if held_keys['a']:
		cube.x -= 1 * time.dt
	if held_keys['d']:
		cube.x += 1 * time.dt
if __name__ == '__main__':


	app = Ursina()

	cube = Entity(model='quad', color=color.orange, scale = (2,5), position = (5,1))

	test = Test_cube()

	btn = Test_button()


	app.run()


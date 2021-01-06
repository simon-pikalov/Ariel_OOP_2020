from ursina import *
from ursina import camera
from ursina.prefabs.first_person_controller import FirstPersonController

from mincraft.block_type import Block
from mincraft.texture import Textures


class Hand(Entity):
    def __init__(self):
        super().__init__(
            parent=camera.ui,
            model='assets/arm',
            texture=Textures.creat_texture('arm'),
            scale=0.2,
            rotation=Vec3(150, -10, 0),
            position=Vec2(0.4, -0.6))

    def active(self):
        self.position = Vec2(0.3, -0.5)

    def passive(self):
        self.position = Vec2(0.4, -0.6)



class Player(FirstPersonController):
    def __init__(self):
        super().__init__()
        self.hand = Hand()






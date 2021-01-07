from ursina import *
from mincraft.texture import Textures


class Sky(Entity):
    def __init__(self, scale=150):
        super().__init__(
            parent=scene,
            model='sphere',
            texture=Textures.creat_texture('sky'),
            scale=scale,
            double_sided=True)

from ursina import Ursina

from mincraft.block_type import Block
from mincraft.player import Player
from mincraft.sky import Sky
from mincraft.world import World
from ursina import *
from ursina import camera, mouse
from ursina.prefabs.first_person_controller import FirstPersonController


class Game():

    def __init__(self):
        self.app = Ursina()
        window.fullscreen = True
        self.word = World()
        self.player = Player()
        self.sky = Sky()
        self.app.run()



if __name__ == '__main__':
    game = Game()

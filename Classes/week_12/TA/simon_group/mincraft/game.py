from ursina import Ursina

from mincraft.block_type import Block
from mincraft.player import Player
from mincraft.sky import Sky
from mincraft.world import World
from ursina import *
from ursina import camera, mouse
from ursina.prefabs.first_person_controller import FirstPersonController


class Game(Entity):

    def __init__(self):

        super().__init__()

        self.app = Ursina()
        window.fullscreen = True
        self.word = World()
        self.player = Player()
        self.sky = Sky()
        self.app.run()

    def update(self):
        if held_keys['left mouse'] or held_keys['right mouse']:
            self.player.hand.active()
        else:
            self.player.hand.passive()


if __name__ == '__main__':
    game = Game()

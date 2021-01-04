import numpy as np
import pygame

from src.utils import Rotatable

SPEED_DECAY = 0.9
ACCELERATE_SPEED = 10
DECELERATE_SPEED = 5
TURN_ANGLE = 5
MAX_SPEED = 1000
MIN_SHOOT_TIME = .5


class Astroid(pygame.sprite.Sprite, Rotatable):
    def __init__(self, screen_size):
        super(Astroid, self).__init__()

        self.polygon = np.array([
            [20, 0],
            [0, 20],
            [20, 40],
            [40, 20],

        ])
        ship_size = (40, 40)
        self.surf = pygame.Surface(ship_size, pygame.SRCALPHA)
        self.surf.fill((0, 0, 0, 0))  # Make it transparent
        pygame.draw.polygon(self.surf, (255, 255, 255), self.polygon, 0)
        self.image_org = self.surf.copy()
        self.rect = self.surf.get_rect()
        self.rect.center = np.random.random() * screen_size[0], np.random.random() * screen_size[1]
        self.rot_angle = 0
        self.speed = (np.random.random(2)-.5) * 300

    def move(self, fps):
        self.rect.x += self.speed[0] / fps
        self.rect.y += self.speed[1] / fps

        self._rotateObject(3)

import time

import numpy as np
import pygame

from src.Fire import Fire
from src.utils import Rotatable

SPEED_DECAY = 0.9
ACCELERATE_SPEED = 10
DECELERATE_SPEED = 5
TURN_ANGLE = 5
MAX_SPEED = 1000
MIN_SHOOT_TIME = .5


class StarShip(pygame.sprite.Sprite, Rotatable):
    def __init__(self, ):
        super(StarShip, self).__init__()

        self.polygon = np.array([
            [0, 5],
            [10, 20],
            [20, 5],
            [15, 0],
            [5, 0],

        ])
        ship_size = (20, 20)
        self.surf = pygame.Surface(ship_size, pygame.SRCALPHA)
        self.surf.fill((0, 0, 0, 0))  # Make it transparent
        pygame.draw.polygon(self.surf, (0, 255, 0), self.polygon, 0)
        self.image_org = self.surf.copy()
        self.rect = self.surf.get_rect()
        self.rect.center = (400, 400)
        self.rot_angle = 0
        self.ship_speed = np.array([0, 0], dtype=np.float32)

        self.last_shoot_ts = 0

    def move(self, fps):
        self.rect.x += self.ship_speed[0] / fps
        self.rect.y += self.ship_speed[1] / fps

    def accelerate(self):
        self.ship_speed += ACCELERATE_SPEED * np.array([np.sin(np.radians(self.rot_angle)),
                                                        np.cos(np.radians(self.rot_angle))])
        mag = np.sqrt(np.power(self.ship_speed, 2).sum())
        norm_speed = self.ship_speed / (mag + np.finfo('float').eps)
        mag = np.min((MAX_SPEED, mag))
        self.ship_speed = norm_speed * mag

    def decelerate(self):
        self.ship_speed += -DECELERATE_SPEED * np.array([np.sin(np.radians(self.rot_angle)),
                                                         np.cos(np.radians(self.rot_angle))])
        mag = np.sqrt(np.power(self.ship_speed, 2).sum())
        norm_speed = self.ship_speed / (mag + np.finfo('float').eps)
        mag = np.min((MAX_SPEED, mag))
        self.ship_speed = norm_speed * mag if mag > 1 else np.zeros_like(self.ship_speed)

    def rotateRight(self):
        self._rotateObject(-TURN_ANGLE)

    def rotateLeft(self):
        self._rotateObject(TURN_ANGLE)

    def fire(self):
        if time.time() - self.last_shoot_ts <= MIN_SHOOT_TIME:
            return None

        self.last_shoot_ts = time.time()
        return Fire(
            self.rect.center[0],
            self.rect.center[1],
            self.rot_angle,
            self.ship_speed
        )

import pygame

from src.utils import Rotatable
import numpy as np

FIRE_SPEED = 500
MAX_DIST = 400
FIRE_RED = (255, 255, 130)


class Fire(pygame.sprite.Sprite, Rotatable):
    def __init__(self, x, y, ori, speed):
        super(Fire, self).__init__()
        # Making the shape
        self.size = (7, 15)
        self.surf = pygame.Surface(self.size, pygame.SRCALPHA)
        self.surf.fill((0, 0, 0, 0))
        pygame.draw.ellipse(self.surf, FIRE_RED, self.surf.get_rect())
        self.image_org = self.surf.copy()
        self.rect = self.surf.get_rect(center=(x, y))

        self.rot_angle = ori
        self._rotateObject(0)

        self.speed = np.array([FIRE_SPEED * np.sin(np.radians(self.rot_angle)),
                               FIRE_SPEED * np.cos(np.radians(self.rot_angle))]) + speed
        self.dist_traveled = 0

    def move(self, fps):
        self.rect.x += self.speed[0] / fps
        self.rect.y += self.speed[1] / fps

        self.dist_traveled += np.sqrt(np.power(self.speed / fps, 2).sum())
        if self.dist_traveled > MAX_DIST:
            self.kill()

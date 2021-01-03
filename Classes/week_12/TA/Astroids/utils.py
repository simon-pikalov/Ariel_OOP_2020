import pygame


class Rotatable:
    def __init__(self):
        self.image_org = None
        self.rot_able = 0

    def _rotateObject(self, angle):
        self.rot_angle += angle % 360
        center = self.rect.center
        self.surf = pygame.transform.rotate(self.image_org, self.rot_angle)
        self.rect = self.surf.get_rect()
        self.rect.center = center

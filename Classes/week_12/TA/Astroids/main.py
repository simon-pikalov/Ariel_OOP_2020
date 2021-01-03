import pygame
from pygame.time import Clock

from Astroids import Astroid
from SimpleShip import StarShip

screen_w, screen_h = 1000, 800
FPS = 60


def correct(rect):
    rect.x = rect.x % screen_w
    rect.y = rect.y % screen_w


def move(sprite_lst):
    for s in sprite_lst:
        s.move(FPS)
        correct(s.rect)


def draw(sprite_lst, screen):
    for s in sprite_lst:
        screen.blit(s.surf, s.rect)


def handle_keys(star_ship: StarShip):
    global fire_grp, all_sprites
    """ Handles Keys """
    key = pygame.key.get_pressed()
    if key[pygame.K_SPACE]:  # Shoot
        fire = star_ship.fire()
        if fire:
            all_sprites.add(fire)
            fire_grp.add(fire)
    if key[pygame.K_DOWN]:  # Decelerate
        star_ship.decelerate()
    elif key[pygame.K_UP]:  # Accelerate
        star_ship.accelerate()

    if key[pygame.K_RIGHT]:  # Turn right
        star_ship.rotateRight()
    elif key[pygame.K_LEFT]:  # Turn left
        star_ship.rotateLeft()


def checkCollid(player_ship, asteroids_grp, fire_grp):
    if pygame.sprite.spritecollideany(player_ship, asteroids_grp):
        player_ship.kill()
        return True

    for ast in asteroids_grp:
        shot = pygame.sprite.spritecollideany(ast, fire_grp)
        if shot:
            shot.kill()
            ast.kill()

    return False


def main():
    global fire_grp, all_sprites
    pygame.init()

    screen = pygame.display.set_mode([screen_w, screen_h])

    all_sprites = pygame.sprite.Group()
    asteroids_grp = pygame.sprite.Group()
    fire_grp = pygame.sprite.Group()

    player_ship = StarShip()
    all_sprites.add(player_ship)
    all_sprites.add(fire_grp)
    all_sprites.add(asteroids_grp)

    all_sprites.add(player_ship)

    for i in range(5):
        ast = Astroid([screen_w, screen_h])
        asteroids_grp.add(ast)
        all_sprites.add(ast)

    running = True
    while running:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_q:
                    running = False
        if len(asteroids_grp) < 1:
            running = False

        screen.fill((0, 0, 0))
        move(all_sprites)
        draw(all_sprites, screen)

        if checkCollid(player_ship, asteroids_grp, fire_grp):
            running = False

        handle_keys(player_ship)
        pygame.display.update()

        Clock().tick(FPS)

    pygame.quit()


if __name__ == '__main__':
    main()

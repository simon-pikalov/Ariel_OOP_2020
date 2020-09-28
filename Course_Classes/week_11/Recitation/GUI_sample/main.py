import pygame
import Pytton
from Pybar import Toolbar, TBOption

white = (255, 255, 255)
green = (0, 200, 0)
red = (200, 0, 0)

black = (0, 0, 0)

bright_red = (255, 0, 0)
bright_green = (0, 255, 0)


def main():
    game_intro()


def game_intro():
    pygame.init()
    display_width = 800
    display_height = 600
    gameDisplay = pygame.display.set_mode((display_width, display_height))
    pygame.display.set_caption('GUI Demo')
    clock = pygame.time.Clock()

    intro = True

    toolbar = Toolbar(gameDisplay)
    opt1 = TBOption('File')
    opt2 = TBOption('Exit')
    opt2.action = Pytton.quit_game

    toolbar.addOption(opt1)
    toolbar.addOption(opt2)

    btn_eng = Pytton.ButtonEngine()
    green_btn = Pytton.Button(gameDisplay, (150, 450, 100, 50), green, 'Start')
    red_btn = Pytton.Button(gameDisplay, (550, 450, 100, 50), red, 'Exit')
    btn_eng.addButton(green_btn)
    btn_eng.addButton(red_btn)

    red_btn.action = Pytton.quit_game

    while intro:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
        gameDisplay.fill(white)
        largeText = pygame.font.Font('freesansbold.ttf', 115)
        TextSurf = largeText.render('GUI Demo', True, black)
        TextRect = TextSurf.get_rect()
        TextRect.center = ((display_width / 2), (display_height / 2))
        gameDisplay.blit(TextSurf, TextRect)

        toolbar.update()
        toolbar.draw()

        btn_eng.draw()
        btn_eng.hover()

        pygame.display.update()
        clock.tick(15)


if __name__ == '__main__':
    main()

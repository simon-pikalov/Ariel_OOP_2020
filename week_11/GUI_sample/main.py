import pygame
from PUBG import Pytton
from PUBG.Pybar import *
from PUBG.utils.colors import *


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
    scrl = TBScroll('File')
    opt1 = TBOption('Exit')
    opt1.action = Pytton.quit_game
    scrl.addOption(TBOption('Save'))
    scrl.addOption(TBOption('Load somthing long'))
    scrl.addOption(opt1)

    toolbar.addOption(scrl)

    btn_eng = Pytton.ButtonEngine()
    green_btn = Pytton.Button(gameDisplay, (150, 450, 100, 50), kGREEN_COLOR, 'Start')
    red_btn = Pytton.Button(gameDisplay, (550, 450, 100, 50), kRED_COLOR, 'Exit')
    try_exit_btn = Pytton.Button(gameDisplay, (10, 40, 100, 50), kRED_COLOR, 'TryExit')

    btn_eng.addButton(green_btn)
    btn_eng.addButton(red_btn)
    btn_eng.addButton(try_exit_btn)

    red_btn.action = Pytton.quit_game
    try_exit_btn.action = Pytton.quit_game

    while intro:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
        gameDisplay.fill(kWIHTE_COLOR)
        largeText = pygame.font.Font('freesansbold.ttf', 115)
        TextSurf = largeText.render('GUI Demo', True, kBLACK_COLOR)
        TextRect = TextSurf.get_rect()
        TextRect.center = ((display_width / 2), (display_height / 2))
        gameDisplay.blit(TextSurf, TextRect)

        if not toolbar.update():
            btn_eng.hover()  # Prevents from catching clicks that where meant for the toolbar
        btn_eng.draw()
        toolbar.draw()

        pygame.display.update()
        clock.tick(15)


if __name__ == '__main__':
    main()

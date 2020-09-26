import pygame

kGRAY_COLOR = (150, 150, 150)
kGRAY_BTN = (120, 120, 120)
kGRAY_BTN_HOVER = (200, 200, 200)

kBLACK_COLOR = (0, 0, 0)
kTB_HEIGHT = 30
kPADDING = 5
kHEIGHT_PADDING = 2


def getWidth(name):
    small_text = pygame.font.Font("freesansbold.ttf", 20)
    text_surf = small_text.render(name, True, kBLACK_COLOR)
    text_rect = text_surf.get_rect()
    return text_rect.width + 2 * kPADDING


class TBOption:
    def __init__(self, name):
        self.game_disp = None
        self.name = name
        self.width = getWidth(name)
        self.color = kGRAY_BTN
        self.pos = 0
        self.dims = self.pos, kHEIGHT_PADDING, self.width, kTB_HEIGHT - 2 * kHEIGHT_PADDING
        self.action = None

    def setPos(self, pos):
        self.pos = pos
        self.dims = self.pos, kHEIGHT_PADDING, self.width, kTB_HEIGHT - 2 * kHEIGHT_PADDING

    def draw(self):
        (x, y, w, h) = self.dims
        x += kPADDING
        w -= 2 * kHEIGHT_PADDING
        pygame.draw.rect(self.game_disp, self.color, (x, y, w, h))

        small_text = pygame.font.Font("freesansbold.ttf", 20)
        text_surf = small_text.render(self.name, True, kBLACK_COLOR)
        text_rect = text_surf.get_rect()
        text_rect.center = ((self.pos + (self.width + kPADDING) / 2), kTB_HEIGHT // 2)
        self.game_disp.blit(text_surf, text_rect)

    def doAction(self):
        if self.action is None:
            return
        self.action()

    def hover(self):
        x, y, w, h = self.dims
        mx, my = pygame.mouse.get_pos()
        if x <= mx <= x + w and y <= my <= y + h:
            self.color = kGRAY_BTN_HOVER
            return True

        self.color = kGRAY_BTN
        return False


class Toolbar:
    def __init__(self, game_disp):  # And other customisation options
        self.game_disp = game_disp
        self.image = pygame.Surface((self.game_disp.get_rect().width, kTB_HEIGHT))
        self.image.fill(kGRAY_COLOR)
        self.rect = self.image.get_rect()
        self.rect.topleft = (0, 0)
        self.btns = []
        self.last_pos = kPADDING

    def addOption(self, opt):
        pos = self.last_pos
        opt.game_disp = self.game_disp
        opt.setPos(pos)
        self.btns.append(opt)
        self.last_pos += opt.width

        return opt

    def update(self):
        mouse_click = pygame.mouse.get_pressed()
        for op in self.btns:
            if op.hover():
                if mouse_click[0] == 1:
                    op.doAction()

    def draw(self):
        self.game_disp.blit(self.image, self.rect)
        for op in self.btns:
            op.draw()

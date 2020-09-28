import pygame

from PUBG.utils.colors import *

kTB_HEIGHT = 30
kPADDING = 5
kHEIGHT_PADDING = 2


def getWidth(name: str) -> int:
    """
    Returns the width of the text
    :param name:
    :return:
    """
    small_text = pygame.font.Font("freesansbold.ttf", 20)
    text_surf = small_text.render(name, True, kBLACK_COLOR)
    text_rect = text_surf.get_rect()
    return text_rect.width + 2 * kPADDING


class TBObject:

    def __init__(self, name: str):
        self.name = name
        self.game_disp = None
        self.width = None
        self.pos = 0
        self.color = kGRAY_BTN
        self.dims = None
        self.action = None

    def setGameDisp(self, game_display: pygame.display) -> None:
        pass

    def setPos(self, pos: int) -> None:
        pass


class TBOption(TBObject):
    """
    An option the the toolbar
    """

    def __init__(self, name: str):
        super().__init__(name)
        self.width = getWidth(name)
        self.color = kGRAY_BTN
        self.dims = self.pos, kHEIGHT_PADDING, self.width, kTB_HEIGHT - 2 * kHEIGHT_PADDING

    def setGameDisp(self, game_disp: pygame.display) -> None:
        """
        Sets the game display
        :param game_disp: PyGame display
        :return:
        """
        self.game_disp = game_disp

    def setPos(self, pos: int) -> None:
        """
        Sets the X position of the TBOption
        :param pos: Position (X)
        :return:
        """
        self.pos = pos
        self.dims = self.pos, kHEIGHT_PADDING, self.width, kTB_HEIGHT - 2 * kHEIGHT_PADDING

    def draw(self) -> None:
        """
        Draws the TBOption on the toolbar
        :return:
        """
        (x, y, w, h) = self.dims
        x += kPADDING
        w -= 2 * kHEIGHT_PADDING
        pygame.draw.rect(self.game_disp, self.color, (x, y, w, h))

        small_text = pygame.font.Font("freesansbold.ttf", 20)
        text_surf = small_text.render(self.name, True, kBLACK_COLOR)
        text_rect = text_surf.get_rect()
        text_rect.center = ((self.pos + (self.width + kPADDING) / 2), y + kTB_HEIGHT // 2)
        self.game_disp.blit(text_surf, text_rect)

    def doAction(self) -> None:
        """
        Performs the action of the TBOption
        :return:
        """
        if self.action is None:
            return
        self.action()

    def hover(self) -> bool:
        """
        Performs the hover of the TBOption
        :return True if the mouse is over the button O.W. False
        """
        x, y, w, h = self.dims
        mx, my = pygame.mouse.get_pos()
        if x <= mx <= x + w and y <= my <= y + h:
            self.color = kGRAY_BTN_HOVER
            return True

        self.color = kGRAY_BTN
        return False


class TBScroll(TBObject):
    """
    Scroll down menu
    """

    def __init__(self, name: str):
        super().__init__(name)
        self.name = name
        self.width = getWidth(name)
        self.color = kGRAY_BTN
        self.dims = self.pos, kHEIGHT_PADDING, self.width, kTB_HEIGHT - 2 * kHEIGHT_PADDING
        self.scrl_lst = []
        self.scrl_dims = None
        self.is_open = False

    def setGameDisp(self, game_disp: pygame.display) -> None:
        """
        Sets the game display
        :param game_disp: PyGame display
        :return
        """
        self.game_disp = game_disp
        for op in self.scrl_lst:
            op.setGameDisp(game_disp)

    def setPos(self, pos: int) -> None:
        """
        Sets the X position of the scroll menu
        :param pos: The X position of the scroll menue
        :return:
        """
        self.pos = pos
        self.dims = self.pos, kHEIGHT_PADDING, self.width, kTB_HEIGHT - 2 * kHEIGHT_PADDING

        max_width = 0
        for idx, op in enumerate(self.scrl_lst):
            op.pos = pos
            height_offset = kTB_HEIGHT * (1 + idx)
            x, y, w, h = op.dims
            op.dims = self.pos, \
                      height_offset + kHEIGHT_PADDING, \
                      w, \
                      h
            max_width = max(max_width, op.dims[2]) + kHEIGHT_PADDING

        self.scrl_dims = self.pos, kTB_HEIGHT - kHEIGHT_PADDING, max_width, kTB_HEIGHT * len(self.scrl_lst)

    def addOption(self, option: TBOption) -> None:
        """
        Adds an option the the scroll menue
        :param option: a new TBOption
        :return:
        """
        self.scrl_lst.append(option)

    def draw(self) -> None:
        """
        Draws the Scroll down menu
        :return:
        """
        (x, y, w, h) = self.dims
        x += kPADDING
        w -= 2 * kHEIGHT_PADDING
        pygame.draw.rect(self.game_disp, self.color, (x, y, w, h))

        small_text = pygame.font.Font("freesansbold.ttf", 20)
        text_surf = small_text.render(self.name, True, kBLACK_COLOR)
        text_rect = text_surf.get_rect()
        text_rect.center = ((self.pos + (self.width + kPADDING) / 2), kTB_HEIGHT // 2)
        self.game_disp.blit(text_surf, text_rect)

        if self.is_open:
            pygame.draw.rect(self.game_disp, kGRAY_DARK_COLOR, self.scrl_dims)
            for op in self.scrl_lst:
                op.draw()

    def doAction(self) -> None:
        """
        Opens the scroll menu
        :return:
        """
        self.is_open = True

    def hover(self) -> True:
        """
        Handles the hover function of the scroll menu
        :return: True if the mouse is hovering over the menu O.W. False
        """
        x, y, w, h = self.dims
        mx, my = pygame.mouse.get_pos()
        mouse_clicked = pygame.mouse.get_pressed()

        hover_over_option = False
        hover_over_title = x <= mx <= x + w and y <= my <= y + h

        if not self.is_open:
            if hover_over_title:
                self.color = kGRAY_BTN_HOVER
                return True
            self.color = kGRAY_BTN
            return False

        if self.is_open:
            for op in self.scrl_lst:
                hover_over_option = op.hover()
                if hover_over_option:
                    if mouse_clicked[0] == 1:
                        op.doAction()
                        self.is_open = False
                        return True

        if not (hover_over_title or hover_over_option) and max(mouse_clicked) == 1:
            self.is_open = False
        return False


class Toolbar:
    """
    Toobar object
    """

    def __init__(self, game_disp: pygame.display):
        self.game_disp = game_disp
        self.image = pygame.Surface((self.game_disp.get_rect().width, kTB_HEIGHT))
        self.image.fill(kGRAY_COLOR)
        self.rect = self.image.get_rect()
        self.rect.topleft = (0, 0)
        self.btns = []
        self.last_pos = kPADDING

    def addOption(self, opt: TBObject) -> TBObject:
        """
        Adds a TBObject to the toolbar
        :param opt: The new object
        :return: The TBObject that was added
        """
        pos = self.last_pos
        opt.setGameDisp(self.game_disp)
        opt.setPos(pos)
        self.btns.append(opt)
        self.last_pos += opt.width

        return opt

    def update(self) -> bool:
        """
        Updated the clickes/hovers on the toolbar
        :return: True if the mouse hovered over the toolbar O.W. False
        """
        mouse_click = pygame.mouse.get_pressed()
        for op in self.btns:
            if op.hover():
                if mouse_click[0] == 1:
                    op.doAction()
                return True
        return False

    def draw(self) -> None:
        """
        Draws the Toolbar
        :return:
        """
        self.game_disp.blit(self.image, self.rect)
        for op in self.btns:
            op.draw()

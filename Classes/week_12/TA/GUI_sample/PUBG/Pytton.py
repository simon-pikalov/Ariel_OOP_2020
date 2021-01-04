import pygame

from PUBG.utils.colors import kBLACK_COLOR


class Button:
    """
    This class handles the buttons on the screen
    """

    def __init__(self, game_display: pygame.display, dims: tuple, color: tuple, text: str = '', hover_color=None):
        self.gameDisp = game_display
        self.dims = dims
        self.color = color
        self.hover_color = tuple(min(int(x) * 1.5, 255) for x in color) if hover_color is None else hover_color
        self.org_color = color
        self.text = text
        self.action = None

    def do_action(self) -> None:
        """
        Preforms the buttons action
        :return:
        """
        if self.action is not None:
            self.action()

    def hover(self) -> bool:
        """
        Handles what hapenns if the mouse hovers over the button
        :param mouse_pos:
        :return:
        """
        x, y, w, h = self.dims
        mx, my = pygame.mouse.get_pos()
        if x <= mx <= x + w and y <= my <= y + h:
            self.color = self.hover_color
            return True

        self.color = self.org_color
        return False

    def draw(self) -> None:
        """
        Draws the button
        :return:
        """
        pygame.draw.rect(self.gameDisp, self.color, self.dims)
        self._drawText()

    def _drawText(self) -> None:
        """
        Handles the test drawing on the button
        :return:
        """
        if len(self.text) < 1:
            return

        x, y, w, h = self.dims
        small_text = pygame.font.Font("freesansbold.ttf", 20)
        text_surf = small_text.render(self.text, True, kBLACK_COLOR)
        text_rect = text_surf.get_rect()
        text_rect.center = ((x + (w / 2)), (y + (h / 2)))
        self.gameDisp.blit(text_surf, text_rect)


def quit_game() -> None:
    """
    Exits the game
    :return:
    """
    pygame.quit()
    quit()


class ButtonEngine:
    """
    Handles all the buttons on the screen
    """

    class __ButtonEngine:
        """
        This Creates a Singleton
        """

        def __init__(self):
            self.btns = []

        def addButton(self, new_btn: Button) -> None:
            """
            Adds a button to the Button engine
            :param new_btn:
            :return:
            """
            self.btns.append(new_btn)

        def hover(self) -> None:
            """
            Performs the 'Hover' functions on the button under the mouse pointer
            :return:
            """
            mouse_click = pygame.mouse.get_pressed()
            for b in self.btns:
                if b.hover():
                    if mouse_click[0] == 1:
                        b.do_action()
                    return

        def draw(self) -> None:
            """
            Draws the buttons
            :return:
            """
            for b in self.btns:
                b.draw()

    instance = None

    def __init__(self):
        """
        Singleton init
        """
        if not ButtonEngine.instance:
            ButtonEngine.instance = ButtonEngine.__ButtonEngine()
        else:
            pass

    def __getattr__(self, name):
        """
        Refers to the singleton instance
        :param name:
        :return:
        """
        return getattr(self.instance, name)

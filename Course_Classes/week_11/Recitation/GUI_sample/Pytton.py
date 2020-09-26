import pygame

kBLACK_COLOR = (0, 0, 0)


class Button:
    def __init__(self, game_display: pygame.display, dims: tuple, color: tuple, text: str = ''):
        self.gameDisp = game_display
        self.dims = dims
        self.color = color
        self.hover_color = tuple(min(int(x) * 1.5, 255) for x in color)
        self.org_color = color
        self.text = text
        self.action = None

    def do_action(self):
        if self.action is not None:
            self.action()

    def hover(self, mouse_pos: tuple) -> bool:
        x, y, w, h = self.dims
        mx, my = mouse_pos
        if x <= mx <= x + w and y <= my <= y + h:
            self.color = self.hover_color
            return True

        self.color = self.org_color
        return False

    def draw(self):
        pygame.draw.rect(self.gameDisp, self.color, self.dims)
        self._drawText()

    def _drawText(self):
        if len(self.text) < 1:
            return

        x, y, w, h = self.dims
        small_text = pygame.font.Font("freesansbold.ttf", 20)
        text_surf = small_text.render(self.text, True, kBLACK_COLOR)
        text_rect = text_surf.get_rect()
        text_rect.center = ((x + (w / 2)), (y + (h / 2)))
        self.gameDisp.blit(text_surf, text_rect)


def quit_game():
    pygame.quit()
    quit()


class ButtonEngine:
    def __init__(self):
        self.btns = []

    def addButton(self, new_btn: Button):
        self.btns.append(new_btn)

    def hover(self):
        mouse_pos = pygame.mouse.get_pos()
        mouse_click = pygame.mouse.get_pressed()
        for b in self.btns:
            if b.hover(mouse_pos):
                if mouse_click[0] == 1:
                    b.do_action()
                return

    def draw(self):
        for b in self.btns:
            b.draw()

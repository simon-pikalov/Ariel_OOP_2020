from ursina import Audio


class Sound:

    def __init__(self):
        self.punch_sound = Audio('assets/punch_sound', loop=False, autoplay=False)

    def play_punch_sound(self):
        self.punch_sound.play()
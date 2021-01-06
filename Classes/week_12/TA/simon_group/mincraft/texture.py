from ursina import load_texture


class Textures:

    @staticmethod
    def creat_texture(texture):

        if texture == "grass":
            return load_texture('assets/grass_block.png')

        elif texture == "stone":
            return load_texture('assets/stone_block.png')

        elif texture == "brick":
            return load_texture('assets/brick_block.png')

        elif texture == "dirt":
            return load_texture('assets/dirt_block.png')

        elif texture == "sky":
            return load_texture('assets/skybox.png')

        elif texture == "arm":
            return load_texture('assets/arm_texture.png')

        else:
            raise ValueError(texture)

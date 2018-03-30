class EffectPrefab(object):
    pass


class TintEffectPrefab(EffectPrefab):
    def __init__(self, color_prefab):
        self.color_prefab = color_prefab

    def get_color_prefab(self):
        return self.color_prefab

    def __str__(self):
        return "TintEffectPrefab(color_prefab={})".format(str(self.color_prefab))


class AlphaEffectPrefab(EffectPrefab):
    def __init__(self, alpha_value):
        self.alpha_value = int(alpha_value)

    def get_alpha_value(self):
        return self.alpha_value

    def __str__(self):
        return "AlphaEffectPrefab(alpha_value={})".format(self.alpha_value)


class ShaderEffectPrefab(EffectPrefab):
    def __init__(self, shader_program_prefab):
        self.shader_program_prefab = shader_program_prefab

    def get_shader_program_prefab(self):
        return self.shader_program_prefab

    def __str__(self):
        return "ShaderEffectPrefab(shader_program_prefab={})".format(str(self.shader_program_prefab))

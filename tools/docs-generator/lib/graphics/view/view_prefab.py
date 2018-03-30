class ViewPrefab(object):
    def __init__(self, prefab_id, position_prefab):
        self.id = str(prefab_id)
        self.position_prefab = position_prefab

    def get_id(self):
        return self.id

    def get_position_prefab(self):
        return self.position_prefab


class SpriteViewPrefab(ViewPrefab):
    def __init__(self, prefab_id, position_prefab, sprite_prefab):
        super().__init__(prefab_id, position_prefab)
        self.sprite_prefab = sprite_prefab

    def get_sprite_prefab(self):
        return self.sprite_prefab

    def __str__(self):
        return "SpriteViewPrefab(id={}, position_prefab={}, sprite_prefab={})" \
            .format(self.id, str(self.position_prefab), str(self.sprite_prefab))


class AnimationViewPrefab(ViewPrefab):
    def __init__(self, prefab_id, position_prefab, animation_prefab):
        super().__init__(prefab_id, position_prefab)
        self.animation_prefab = animation_prefab

    def get_animation_prefab(self):
        return self.animation_prefab

    def __str__(self):
        return "AnimationViewPrefab(id={}, position_prefab={}, animation_prefab={})" \
            .format(self.id, str(self.position_prefab), str(self.animation_prefab))


class ParticleEffectViewPrefab(ViewPrefab):
    def __init__(self, prefab_id, position_prefab, particle_effect_prefab):
        super().__init__(prefab_id, position_prefab)
        self.particle_effect_prefab = particle_effect_prefab

    def get_particle_effect_prefab(self):
        return self.particle_effect_prefab

    def __str__(self):
        return "ParticleEffectViewPrefab(id={}, position_prefab={}, particle_effect_prefab={})" \
            .format(self.id, self.position_prefab, str(self.particle_effect_prefab))

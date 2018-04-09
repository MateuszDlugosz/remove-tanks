from lib.graphics.view.view_prefab import SpriteViewPrefab, AnimationViewPrefab, ParticleEffectViewPrefab
from lib.html.html import HtmlElement

VIEW_HTML_CLASS_ATTRIBUTE = "doc-view"


class ViewPrefabHtmlGenerator(object):
    def __init__(self, sub_generators):
        self.sub_generators = {}
        for sub_generator in sub_generators:
            self.sub_generators[sub_generator.get_type()] = sub_generator

    def generate_html(self, view_prefab):
        try:
            if view_prefab.__class__.__name__ not in self.sub_generators:
                raise ViewPrefabHtmlGeneratorNotFoundException(view_prefab)

            return self.sub_generators[view_prefab.__class__.__name__].generate_html(view_prefab)
        except Exception as e:
            raise ViewPrefabHtmlGenerationException(view_prefab, e)


class SubViewPrefabHtmlGenerator(object):
    def generate_html(self, view_prefab):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class SubSpriteViewPrefabHtmlGenerator(SubViewPrefabHtmlGenerator):
    def __init__(self, position_prefab_html_generator, sprite_prefab_html_generator):
        self.position_prefab_html_generator = position_prefab_html_generator
        self.sprite_prefab_html_generator = sprite_prefab_html_generator

    def generate_html(self, view_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": VIEW_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Sprite view"),
                HtmlElement("div", children=[
                    self.position_prefab_html_generator.generate_html(view_prefab.get_position_prefab()),
                    self.sprite_prefab_html_generator.generate_html(view_prefab.get_sprite_prefab())
                ])
            ])
        except Exception as e:
            raise ViewPrefabHtmlGenerationException(view_prefab, e)

    def get_type(self):
        return SpriteViewPrefab.__name__


class SubAnimationViewPrefabHtmlGenerator(SubViewPrefabHtmlGenerator):
    def __init__(self, position_prefab_html_generator, animation_prefab_html_generator):
        self.position_prefab_html_generator = position_prefab_html_generator
        self.animation_prefab_html_generator = animation_prefab_html_generator

    def generate_html(self, view_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": VIEW_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Animation view"),
                HtmlElement("div", children=[
                    self.position_prefab_html_generator.generate_html(view_prefab.get_position_prefab()),
                    self.animation_prefab_html_generator.generate_html(view_prefab.get_animation_prefab())
                ])
            ])
        except Exception as e:
            raise ViewPrefabHtmlGenerationException(view_prefab, e)

    def get_type(self):
        return AnimationViewPrefab.__name__


class SubParticleEffectViewPrefabHtmlGenerator(SubViewPrefabHtmlGenerator):
    def __init__(self, position_prefab_html_generator, particle_effect_prefab_html_generator):
        self.position_prefab_html_generator = position_prefab_html_generator
        self.particle_effect_prefab_html_generator = particle_effect_prefab_html_generator

    def generate_html(self, view_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": VIEW_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Particle effect view"),
                HtmlElement("div", children=[
                    self.position_prefab_html_generator.generate_html(view_prefab.get_position_prefab()),
                    self.particle_effect_prefab_html_generator.generate_html(view_prefab.get_particle_effect_prefab())
                ])
            ])
        except Exception as e:
            raise ViewPrefabHtmlGenerationException(view_prefab, e)

    def get_type(self):
        return ParticleEffectViewPrefab.__name__


class ViewPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from view prefab {}. Cause: {}."

    def __init__(self, view_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(view_prefab, cause))


class ViewPrefabHtmlGeneratorNotFoundException(Exception):
    MESSAGE_TEMPLATE = "View prefab html generator of type {} not found."

    def __init__(self, view_prefab):
        super().__init__(self.MESSAGE_TEMPLATE.format(view_prefab.__class__.__name__))

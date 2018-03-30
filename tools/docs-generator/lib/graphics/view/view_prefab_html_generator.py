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
            html = HtmlElement("div")
            html.set_attribute("class", VIEW_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Sprite view"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Position"))
            dd_position = HtmlElement("dd")
            dd_position.add_child(self.position_prefab_html_generator.generate_html(
                view_prefab.get_position_prefab()
            ))
            dl.add_child(dd_position)

            dl.add_child(HtmlElement("dt", "Sprite"))
            dd_sprite = HtmlElement("dd")
            dd_sprite.add_child(self.sprite_prefab_html_generator.generate_html(
                view_prefab.get_sprite_prefab()
            ))
            dl.add_child(dd_sprite)

            html.add_child(dl)

            return html
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
            html = HtmlElement("div")
            html.set_attribute("class", VIEW_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Animation view"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Position"))
            dd_position = HtmlElement("dd")
            dd_position.add_child(self.position_prefab_html_generator.generate_html(
                view_prefab.get_position_prefab()
            ))
            dl.add_child(dd_position)

            dl.add_child(HtmlElement("dt", "Animation"))
            dd_animation = HtmlElement("dd")
            dd_animation.add_child(self.animation_prefab_html_generator.generate_html(
                view_prefab.get_animation_prefab()
            ))
            dl.add_child(dd_animation)

            html.add_child(dl)

            return html
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
            html = HtmlElement("div")
            html.set_attribute("class", VIEW_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Atlas view"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Position"))
            dd_position = HtmlElement("dd")
            dd_position.add_child(self.position_prefab_html_generator.generate_html(
                view_prefab.get_position_prefab()
            ))
            dl.add_child(dd_position)

            dl.add_child(HtmlElement("dt", "Particle effect"))
            dd_pe = HtmlElement("dd")
            dd_pe.add_child(self.particle_effect_prefab_html_generator.generate_html(
                view_prefab.get_particle_effect_prefab()
            ))
            dl.add_child(dd_pe)

            html.add_child(dl)

            return html
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

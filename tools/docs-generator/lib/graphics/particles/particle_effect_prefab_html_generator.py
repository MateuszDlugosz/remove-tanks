from lib.graphics.particles.particle_effect_prefab import FileParticleEffectPrefab, AtlasParticleEffectPrefab
from lib.html.html import HtmlElement

PARTICLE_EFFECT_HTML_CLASS_ATTRIBUTE = "doc-particle-effect"


class ParticleEffectPrefabHtmlGenerator(object):
    def __init__(self, sub_generators):
        self.sub_generators = {}
        for sub_generator in sub_generators:
            self.sub_generators[sub_generator.get_type()] = sub_generator

    def generate_html(self, particle_effect_prefab):
        try:
            if particle_effect_prefab.__class__.__name__ not in self.sub_generators:
                raise ParticleEffectPrefabHtmlGeneratorNotFoundException(particle_effect_prefab)

            return self.sub_generators[particle_effect_prefab.__class__.__name__].generate_html(particle_effect_prefab)
        except Exception as e:
            raise ParticleEffectPrefabHtmlGenerationException(particle_effect_prefab, e)


class SubParticleEffectPrefabHtmlGenerator(object):
    def generate_html(self, particle_effect_prefab):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class SubFileParticleEffectPrefabHtmlGenerator(SubParticleEffectPrefabHtmlGenerator):
    def generate_html(self, particle_effect_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", PARTICLE_EFFECT_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "File particle effect"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Flip x"))
            dl.add_child(HtmlElement("dd", particle_effect_prefab.get_flip_x()))
            dl.add_child(HtmlElement("dt", "Flip y"))
            dl.add_child(HtmlElement("dd", particle_effect_prefab.get_flip_y()))
            dl.add_child(HtmlElement("dt", "Filename"))
            dl.add_child(HtmlElement("dd", particle_effect_prefab.get_filename()))
            dl.add_child(HtmlElement("dt", "Images directory"))
            dl.add_child(HtmlElement("dd", particle_effect_prefab.get_images_dir()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise ParticleEffectPrefabHtmlGenerationException(particle_effect_prefab, e)

    def get_type(self):
        return FileParticleEffectPrefab.__name__


class SubAtlasParticleEffectPrefabHtmlGenerator(SubParticleEffectPrefabHtmlGenerator):
    def generate_html(self, particle_effect_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", PARTICLE_EFFECT_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Atlas particle effect"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Flip x"))
            dl.add_child(HtmlElement("dd", particle_effect_prefab.get_flip_x()))
            dl.add_child(HtmlElement("dt", "Flip y"))
            dl.add_child(HtmlElement("dd", particle_effect_prefab.get_flip_y()))
            dl.add_child(HtmlElement("dt", "Filename"))
            dl.add_child(HtmlElement("dd", particle_effect_prefab.get_filename()))
            dl.add_child(HtmlElement("dt", "Atlas filename"))
            dl.add_child(HtmlElement("dd", particle_effect_prefab.get_atlas_filename()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise ParticleEffectPrefabHtmlGenerationException(particle_effect_prefab, e)

    def get_type(self):
        return AtlasParticleEffectPrefab.__name__


class ParticleEffectPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from particle effect prefab {}. Cause: {}."

    def __init__(self, particle_effect_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(particle_effect_prefab, cause))


class ParticleEffectPrefabHtmlGeneratorNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Particle effect prefab html generator of type {} not found."

    def __init__(self, particle_effect_prefab):
        super().__init__(self.MESSAGE_TEMPLATE.format(particle_effect_prefab.__class__.__name__))

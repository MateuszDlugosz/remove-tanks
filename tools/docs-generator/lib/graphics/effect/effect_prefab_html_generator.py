from lib.graphics.effect.effect_prefab import TintEffectPrefab, ShaderEffectPrefab, AlphaEffectPrefab
from lib.html.html import HtmlElement

EFFECT_HTML_CLASS_ATTRIBUTE = "doc-effect"


class EffectPrefabHtmlGenerator(Exception):
    def __init__(self, sub_generators):
        self.sub_generators = {}
        for sub_generator in sub_generators:
            self.sub_generators[sub_generator.get_type()] = sub_generator

    def generate_html(self, effect_prefab):
        try:
            if effect_prefab.__class__.__name__ not in self.sub_generators:
                raise EffectPrefabHtmlGeneratorNotFoundException(effect_prefab)

            return self.sub_generators[effect_prefab.__class__.__name__].generate_html(effect_prefab)
        except Exception as e:
            raise EffectPrefabHtmlGenerationException(effect_prefab, e)


class SubEffectPrefabHtmlGenerator(object):
    def generate_html(self, effect_prefab):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class SubAlphaEffectPrefabHtmlGenerator(SubEffectPrefabHtmlGenerator):
    def generate_html(self, effect_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", EFFECT_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Alpha effect"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Alpha value"))
            dd = HtmlElement("dd", effect_prefab.get_alpha_value())
            dl.add_child(dd)
            html.add_child(dl)

            return html
        except Exception as e:
            raise EffectPrefabHtmlGenerationException(effect_prefab, e)

    def get_type(self):
        return AlphaEffectPrefab.__name__


class SubShaderEffectPrefabHtmlGenerator(SubEffectPrefabHtmlGenerator):
    def __init__(self, shader_program_prefab_html_generator):
        self.shader_program_prefab_html_generator = shader_program_prefab_html_generator

    def generate_html(self, effect_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", EFFECT_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Shader effect"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Shader program"))
            dd = HtmlElement("dd")
            dd.add_child(self.shader_program_prefab_html_generator.generate_html(
                effect_prefab.get_shader_program_prefab()))
            dl.add_child(dd)
            html.add_child(dl)

            return html
        except Exception as e:
            raise EffectPrefabHtmlGenerationException(effect_prefab, e)

    def get_type(self):
        return ShaderEffectPrefab.__name__


class SubTintEffectPrefabHtmlGenerator(SubEffectPrefabHtmlGenerator):
    def __init__(self, color_prefab_html_generator):
        self.color_prefab_html_generator = color_prefab_html_generator

    def generate_html(self, effect_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", EFFECT_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Tint effect"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Color"))
            dd = HtmlElement("dd")
            dd.add_child(self.color_prefab_html_generator.generate_html(
                effect_prefab.get_color_prefab()))
            dl.add_child(dd)
            html.add_child(dl)

            return html
        except Exception as e:
            raise EffectPrefabHtmlGenerationException(effect_prefab, e)

    def get_type(self):
        return TintEffectPrefab.__name__


class EffectPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from effect prefab %s. Cause: {}."

    def __init__(self, effect_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(effect_prefab, cause))


class EffectPrefabHtmlGeneratorNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Effect prefab html generator of prefab type {} not found."

    def __init__(self, effect_prefab):
        super().__init__(self.MESSAGE_TEMPLATE.format(effect_prefab.__class__.__name__))

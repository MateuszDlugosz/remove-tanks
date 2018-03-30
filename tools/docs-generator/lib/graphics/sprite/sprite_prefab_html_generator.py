from lib.graphics.sprite.sprite_prefab import FileSpritePrefab, AtlasSpritePrefab
from lib.html.html import HtmlElement

SPRITE_HTML_CLASS_ATTRIBUTE = "doc-sprite"


class SpritePrefabHtmlGenerator(object):
    def __init__(self, sub_generators):
        self.sub_generators = {}
        for sub_generator in sub_generators:
            self.sub_generators[sub_generator.get_type()] = sub_generator

    def generate_html(self, sprite_prefab):
        try:
            if sprite_prefab.__class__.__name__ not in self.sub_generators:
                raise SpritePrefabHtmlGeneratorNotFoundException(sprite_prefab)

            return self.sub_generators[sprite_prefab.__class__.__name__].generate_html(sprite_prefab)
        except Exception as e:
            raise SpritePrefabHtmlGenerationException(sprite_prefab, e)


class SubSpritePrefabHtmlGenerator(object):
    def generate_html(self, sprite_prefab):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class SubFileSpritePrefabHtmlGenerator(SubSpritePrefabHtmlGenerator):
    def generate_html(self, sprite_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", SPRITE_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "File sprite"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Flip x"))
            dl.add_child(HtmlElement("dd", sprite_prefab.get_flip_x()))
            dl.add_child(HtmlElement("dt", "Flip y"))
            dl.add_child(HtmlElement("dd", sprite_prefab.get_flip_y()))
            dl.add_child(HtmlElement("dt", "Filename"))
            dl.add_child(HtmlElement("dd", sprite_prefab.get_filename()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise SpritePrefabHtmlGenerationException(sprite_prefab, e)

    def get_type(self):
        return FileSpritePrefab.__name__


class SubAtlasSpritePrefabHtmlGenerator(SubSpritePrefabHtmlGenerator):
    def generate_html(self, sprite_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", SPRITE_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Atlas sprite"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Flip x"))
            dl.add_child(HtmlElement("dd", sprite_prefab.get_flip_x()))
            dl.add_child(HtmlElement("dt", "Flip y"))
            dl.add_child(HtmlElement("dd", sprite_prefab.get_flip_y()))
            dl.add_child(HtmlElement("dt", "Atlas filename"))
            dl.add_child(HtmlElement("dd", sprite_prefab.get_atlas_filename()))
            dl.add_child(HtmlElement("dt", "Region name"))
            dl.add_child(HtmlElement("dd", ", ".join(sprite_prefab.get_region_name())))

            html.add_child(dl)

            return html
        except Exception as e:
            raise SpritePrefabHtmlGenerationException(sprite_prefab, e)

    def get_type(self):
        return AtlasSpritePrefab.__name__


class SpritePrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from sprite prefab {}. Cause: {}."

    def __init__(self, sprite_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(sprite_prefab, cause))


class SpritePrefabHtmlGeneratorNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Sprite prefab html generator of type {} not found."

    def __init__(self, sprite_prefab):
        super().__init__(self.MESSAGE_TEMPLATE.format(sprite_prefab.__class__.__name__))

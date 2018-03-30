from lib.graphics.animation.animation_prefab import FileAnimationPrefab, AtlasAnimationPrefab
from lib.html.html import HtmlElement

ANIMATION_HTML_CLASS_ATTRIBUTE = "doc-animation"


class AnimationPrefabHtmlGenerator(object):
    def __init__(self, sub_generators):
        self.sub_generators = {}
        for sub_generator in sub_generators:
            self.sub_generators[sub_generator.get_type()] = sub_generator

    def generate_html(self, animation_prefab):
        try:
            if animation_prefab.__class__.__name__ not in self.sub_generators:
                raise AnimationPrefabHtmlGeneratorNotFoundException(animation_prefab)

            return self.sub_generators[animation_prefab.__class__.__name__].generate_html(animation_prefab)
        except Exception as e:
            raise AnimationPrefabHtmlGenerationException(animation_prefab, e)


class SubAnimationPrefabHtmlGenerator(object):
    def generate_html(self, animation_prefab):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class SubFileAnimationPrefabHtmlGenerator(SubAnimationPrefabHtmlGenerator):
    def generate_html(self, animation_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ANIMATION_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "File animation"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Flip x"))
            dl.add_child(HtmlElement("dd", animation_prefab.get_flip_x()))
            dl.add_child(HtmlElement("dt", "Flip y"))
            dl.add_child(HtmlElement("dd", animation_prefab.get_flip_y()))
            dl.add_child(HtmlElement("dt", "Play mode"))
            dl.add_child(HtmlElement("dd", animation_prefab.get_play_mode()))
            dl.add_child(HtmlElement("dt", "Frame duration"))
            dl.add_child(HtmlElement("dd", animation_prefab.get_frame_duration()))
            dl.add_child(HtmlElement("dt", "Filenames"))
            dl.add_child(HtmlElement("dd", ", ".join(animation_prefab.get_filenames())))

            html.add_child(dl)

            return html
        except Exception as e:
            raise AnimationPrefabHtmlGenerationException(animation_prefab, e)

    def get_type(self):
        return FileAnimationPrefab.__name__


class SubAtlasAnimationPrefabHtmlGenerator(SubAnimationPrefabHtmlGenerator):
    def generate_html(self, animation_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ANIMATION_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Atlas animation"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Flip x"))
            dl.add_child(HtmlElement("dd", animation_prefab.get_flip_x()))
            dl.add_child(HtmlElement("dt", "Flip y"))
            dl.add_child(HtmlElement("dd", animation_prefab.get_flip_y()))
            dl.add_child(HtmlElement("dt", "Play mode"))
            dl.add_child(HtmlElement("dd", animation_prefab.get_play_mode()))
            dl.add_child(HtmlElement("dt", "Frame duration"))
            dl.add_child(HtmlElement("dd", animation_prefab.get_frame_duration()))
            dl.add_child(HtmlElement("dt", "Atlas filename"))
            dl.add_child(HtmlElement("dd", animation_prefab.get_atlas_filename()))
            dl.add_child(HtmlElement("dt", "Region names"))
            dl.add_child(HtmlElement("dd", ", ".join(animation_prefab.get_region_names())))

            html.add_child(dl)

            return html
        except Exception as e:
            raise AnimationPrefabHtmlGenerationException(animation_prefab, e)

    def get_type(self):
        return AtlasAnimationPrefab.__name__


class AnimationPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from animation prefab {}. Cause: {}."

    def __init__(self, animation_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(animation_prefab, cause))


class AnimationPrefabHtmlGeneratorNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Animation prefab html generator of type {} not found."

    def __init__(self, animation_prefab):
        super().__init__(self.MESSAGE_TEMPLATE.format(animation_prefab.__class__.__name__))

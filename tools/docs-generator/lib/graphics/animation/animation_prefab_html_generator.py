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
            return HtmlElement("div", attributes={
                "class": ANIMATION_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "File animation"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Flip x"),
                            HtmlElement("td", animation_prefab.get_flip_x())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Flip y"),
                            HtmlElement("td", animation_prefab.get_flip_y())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Play mode"),
                            HtmlElement("td", animation_prefab.get_play_mode())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Frame duration"),
                            HtmlElement("td", animation_prefab.get_frame_duration())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Filenames"),
                            HtmlElement("td", ", ".join(animation_prefab.get_filenames()))
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise AnimationPrefabHtmlGenerationException(animation_prefab, e)

    def get_type(self):
        return FileAnimationPrefab.__name__


class SubAtlasAnimationPrefabHtmlGenerator(SubAnimationPrefabHtmlGenerator):
    def generate_html(self, animation_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ANIMATION_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "File animation"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Flip x"),
                            HtmlElement("td", animation_prefab.get_flip_x())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Flip y"),
                            HtmlElement("td", animation_prefab.get_flip_y())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Play mode"),
                            HtmlElement("td", animation_prefab.get_play_mode())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Frame duration"),
                            HtmlElement("td", animation_prefab.get_frame_duration())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Atlas filename"),
                            HtmlElement("td", animation_prefab.get_atlas_filename())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Region names"),
                            HtmlElement("td", ", ".join(animation_prefab.get_region_names()))
                        ])
                    ])
                ])
            ])
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

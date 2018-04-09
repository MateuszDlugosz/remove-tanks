from lib.html.html import HtmlElement

SOUND_HTML_CLASS_ATTRIBUTE = "doc-sound"


class SoundPrefabHtmlGenerator(object):
    def generate_html(self, soud_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": SOUND_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Sound"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Filename"),
                            HtmlElement("td", soud_prefab.get_filename())
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise SoundPrefabHtmlGenerationException(soud_prefab, e)


class SoundPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from sound prefab {}. Cause: {}."

    def __init__(self, soud_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(soud_prefab), cause))

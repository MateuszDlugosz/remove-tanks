from lib.html.html import HtmlElement

SOUND_HTML_CLASS_ATTRIBUTE = "doc-sound"


class SoundPrefabHtmlGenerator(object):
    def generate_html(self, soud_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", SOUND_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Sound"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Filename"))
            dl.add_child(HtmlElement("dd", soud_prefab.get_filename()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise SoundPrefabHtmlGenerationException(soud_prefab, e)


class SoundPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from sound prefab {}. Cause: {}."

    def __init__(self, soud_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(soud_prefab), cause))

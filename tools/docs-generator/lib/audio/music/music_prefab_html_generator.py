from lib.html.html import HtmlElement

MUSIC_HTML_CLASS_ATTRIBUTE = "doc-music"


class MusicPrefabHtmlGenerator(object):
    def generate_html(self, music_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", MUSIC_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Music"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Filename"))
            dl.add_child(HtmlElement("dd", music_prefab.get_filename()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise MusicPrefabHtmlGenerationException(music_prefab, e)


class MusicPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from music prefab {}. Cause: {}."

    def __init__(self, music_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(music_prefab), cause))

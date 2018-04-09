from lib.html.html import HtmlElement

MUSIC_HTML_CLASS_ATTRIBUTE = "doc-music"


class MusicPrefabHtmlGenerator(object):
    def generate_html(self, music_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": MUSIC_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Music"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Filename"),
                            HtmlElement("td", music_prefab.get_filename())
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise MusicPrefabHtmlGenerationException(music_prefab, e)


class MusicPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from music prefab {}. Cause: {}."

    def __init__(self, music_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(music_prefab), cause))

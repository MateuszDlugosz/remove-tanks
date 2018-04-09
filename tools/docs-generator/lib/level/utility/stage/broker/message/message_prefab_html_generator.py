from lib.html.html import HtmlElement

MESSAGE_CLASS_HTML_ATTRIBUTE = "doc-message"


class MessagePrefabHtmlGenerator(object):
    def generate_html(self, message_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": MESSAGE_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Message"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Time"),
                            HtmlElement("td", message_prefab.get_time())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Entry key"),
                            HtmlElement("td", message_prefab.get_translation_entry_key())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Face id"),
                            HtmlElement("td", message_prefab.get_face_id())
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise MessagePrefabHtmlGenerationException(message_prefab, e)


class MessagePrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from message prefab {}. Cause: {}."

    def __init__(self, message_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(message_prefab), cause))

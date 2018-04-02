from lib.html.html import HtmlElement

MESSAGE_CLASS_HTML_ATTRIBUTE = "doc-message"


class MessagePrefabHtmlGenerator(object):
    def generate_html(self, message_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", MESSAGE_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Message"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Time"))
            dl.add_child(HtmlElement("dd", message_prefab.get_time()))
            dl.add_child(HtmlElement("dt", "Translation entry key"))
            dl.add_child(HtmlElement("dd", message_prefab.get_translation_entry_key()))
            dl.add_child(HtmlElement("dt", "Face id"))
            dl.add_child(HtmlElement("dd", message_prefab.get_face_id()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise MessagePrefabHtmlGenerationException(message_prefab, e)


class MessagePrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from message prefab {}. Cause: {}."

    def __init__(self, message_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(message_prefab), cause))

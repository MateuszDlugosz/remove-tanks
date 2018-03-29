from lib.html.html import HtmlElement

BODY_HTML_ID_ATTRIBUTE = "doc-body"


class BodyPrefabHtmlGenerator(object):
    def generate_html(self, body_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("id", BODY_HTML_ID_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Body"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Body type"))
            dl.add_child(HtmlElement("dd", body_prefab.get_body_type()))
            dl.add_child(HtmlElement("dt", "Active"))
            dl.add_child(HtmlElement("dd", body_prefab.get_active()))
            dl.add_child(HtmlElement("dt", "Awake"))
            dl.add_child(HtmlElement("dd", body_prefab.get_awake()))
            dl.add_child(HtmlElement("dt", "Allow sleep"))
            dl.add_child(HtmlElement("dd", body_prefab.get_allow_sleep()))
            dl.add_child(HtmlElement("dt", "Fixed rotation"))
            dl.add_child(HtmlElement("dd", body_prefab.get_fixed_rotation()))
            dl.add_child(HtmlElement("dt", "Bullet"))
            dl.add_child(HtmlElement("dd", body_prefab.get_bullet()))
            dl.add_child(HtmlElement("dt", "Gravity scale"))
            dl.add_child(HtmlElement("dd", body_prefab.get_gravity_scale()))
            dl.add_child(HtmlElement("dt", "Angle"))
            dl.add_child(HtmlElement("dd", body_prefab.get_angle()))
            dl.add_child(HtmlElement("dt", "Linear damping"))
            dl.add_child(HtmlElement("dd", body_prefab.get_linear_damping()))
            dl.add_child(HtmlElement("dt", "Angular damping"))
            dl.add_child(HtmlElement("dd", body_prefab.get_angular_damping()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise BodyPrefabHtmlGenerationException(body_prefab, e)


class BodyPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from body prefab {}. Cause: {}."

    def __init__(self, body_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(body_prefab), cause))

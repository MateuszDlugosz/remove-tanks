from lib.html.html import HtmlElement

BODY_HTML_CLASS_ATTRIBUTE = "doc-body"


class BodyPrefabHtmlGenerator(object):
    def generate_html(self, body_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": BODY_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Body"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Body type"),
                            HtmlElement("td", body_prefab.get_body_type())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Active"),
                            HtmlElement("td", body_prefab.get_active())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Awake"),
                            HtmlElement("td", body_prefab.get_awake())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Allow sleep"),
                            HtmlElement("td", body_prefab.get_allow_sleep())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Fixed rotation"),
                            HtmlElement("td", body_prefab.get_fixed_rotation())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Bullet"),
                            HtmlElement("td", body_prefab.get_bullet())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Gravity scale"),
                            HtmlElement("td", body_prefab.get_gravity_scale())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Angle"),
                            HtmlElement("td", body_prefab.get_linear_damping())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Linear damping"),
                            HtmlElement("td", body_prefab.get_linear_damping())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Angular damping"),
                            HtmlElement("td", body_prefab.get_angular_damping())
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise BodyPrefabHtmlGenerationException(body_prefab, e)


class BodyPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from body prefab {}. Cause: {}."

    def __init__(self, body_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(body_prefab), cause))

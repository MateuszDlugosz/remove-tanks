from lib.html.html import HtmlElement

SHADER_PROGRAM_HTML_CLASS_ATTRIBUTE = "doc-shader-program"


class ShaderProgramPrefabHtmlGenerator(object):
    def generate_html(self, shader_program_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": SHADER_PROGRAM_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Shader program"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Fragment shader filename"),
                            HtmlElement("td", shader_program_prefab.get_fragment_shader_filename())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Vertex shader filename"),
                            HtmlElement("td", shader_program_prefab.get_vertex_shader_filename())
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise ShaderProgramPrefabHtmlGenerationException(shader_program_prefab, e)


class ShaderProgramPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from shader program prefab {}. Cause: {}."

    def __init__(self, shader_program_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(shader_program_prefab), cause))

from lib.html.html import HtmlElement

SHADER_PROGRAM_HTML_CLASS_ATTRIBUTE = "doc-shader-program"


class ShaderProgramPrefabHtmlGenerator(object):
    def generate_html(self, shader_program_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", SHADER_PROGRAM_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Shader program"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dt0 = HtmlElement("dt", "Fragment shader filename")
            dd0 = HtmlElement("dd", shader_program_prefab.get_fragment_shader_filename())
            dt1 = HtmlElement("dt", "Vertex shader filename")
            dd1 = HtmlElement("dd", shader_program_prefab.get_vertex_shader_filename())
            dl.add_child(dt0)
            dl.add_child(dd0)
            dl.add_child(dt1)
            dl.add_child(dd1)
            html.add_child(dl)

            return html
        except Exception as e:
            raise ShaderProgramPrefabHtmlGenerationException(shader_program_prefab, e)


class ShaderProgramPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from shader program prefab {}. Cause: {}."

    def __init__(self, shader_program_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(shader_program_prefab), cause))

import xml.etree.ElementTree as EXml

from lib.html.html import HtmlElement


class ShaderProgramPrefab(object):
    def __init__(self, vertex_shader_filename, fragment_shader_filename):
        self.vertex_shader_filename = str(vertex_shader_filename)
        self.fragment_shader_filename = str(fragment_shader_filename)

    def get_vertex_shader_filename(self):
        return self.vertex_shader_filename

    def get_fragment_shader_filename(self):
        return self.fragment_shader_filename

    def __str__(self):
        return "ShaderProgramPrefab(vertex_shader_filename={}, fragment_shader_filename={})" \
                    .format(self.vertex_shader_filename, self.fragment_shader_filename)


class ShaderProgramPrefabXmlReader(object):
    SHADER_PROGRAM_ELEMENT = "shaderProgram"
    VERTEX_SHADER_FILENAME_ELEMENT = "vertexShaderFilename"
    FRAGMENT_SHADER_FILENAME_ELEMENT = "fragmentShaderFilename"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            vertex_shader_filename = element.find(self.VERTEX_SHADER_FILENAME_ELEMENT).text.strip()
            fragment_shader_filename = element.find(self.FRAGMENT_SHADER_FILENAME_ELEMENT).text.strip()
            return ShaderProgramPrefab(vertex_shader_filename, fragment_shader_filename)
        except Exception as e:
            raise ShaderProgramPrefabXmlReadException(xml_string, e)


class ShaderProgramPrefabHtmlGenerator(object):
    def generate_html(self, shader_program_prefab):
        try:
            html = HtmlElement("div")
            dl = HtmlElement("dl")
            dl.set_attribute("class", "row")
            dt0 = HtmlElement("dt", "Fragment shader filename")
            dt0.set_attribute("class", "col-sm-3")
            dd0 = HtmlElement("dd", shader_program_prefab.get_fragment_shader_filename())
            dd0.set_attribute("class", "col-sm-9")
            dt1 = HtmlElement("dt", "Vertex shader filename")
            dt1.set_attribute("class", "col-sm-3")
            dd1 = HtmlElement("dd", shader_program_prefab.get_vertex_shader_filename())
            dd1.set_attribute("class", "col-sm-9")
            dl.add_child(dt0)
            dl.add_child(dd0)
            dl.add_child(dt1)
            dl.add_child(dd1)
            html.add_child(dl)

            return html
        except Exception as e:
            raise ShaderProgramPrefabHtmlGenerationException(shader_program_prefab, e)


class ShaderProgramPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read shader program prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))


class ShaderProgramPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from shader program prefab {}. Cause: {}."

    def __init__(self, shader_program_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(shader_program_prefab), cause))

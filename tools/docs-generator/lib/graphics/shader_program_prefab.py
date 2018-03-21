import xml.etree.ElementTree as EXml


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


class ShaderProgramPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read shader program prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))

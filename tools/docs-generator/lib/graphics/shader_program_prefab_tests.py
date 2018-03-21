import unittest

from lib.graphics.shader_program_prefab import *


class TestShaderProgramPrefab(unittest.TestCase):
    def test_shader_program_prefab_to_string(self):
        self.assertEqual(
            str(ShaderProgramPrefab("VERTEX_TEST", "FRAGMENT_TEST")),
            "ShaderProgramPrefab(vertex_shader_filename=VERTEX_TEST, fragment_shader_filename=FRAGMENT_TEST)"
        )


class TestShaderProgramPrefabXmlReader(unittest.TestCase):
    def test_shader_program_prefab_xml_reader_valid(self):
        xml = """
            <shaderProgram>
                <vertexShaderFilename>VERTEX_TEST</vertexShaderFilename>
                <fragmentShaderFilename>FRAGMENT_TEST</fragmentShaderFilename>
            </shaderProgram>
        """
        reader = ShaderProgramPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_vertex_shader_filename(), "VERTEX_TEST")
        self.assertEqual(prefab.get_fragment_shader_filename(), "FRAGMENT_TEST")

    def test_shader_program_prefab_xml_reader_invalid(self):
        xml = """
            <shaderProgram />
        """
        reader = ShaderProgramPrefabXmlReader()

        with self.assertRaises(ShaderProgramPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


if __name__ == "__main__":
    unittest.main()

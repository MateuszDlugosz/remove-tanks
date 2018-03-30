import unittest

from lib.graphics.color.color_prefab_xml_reader import ColorPrefabXmlReader, SubHexColorPrefabXmlReader
from lib.graphics.effect.effect_prefab_xml_reader import SubAlphaEffectPrefabXmlReader, EffectPrefabXmlReadException, \
    SubTintEffectPrefabXmlReader, SubShaderEffectPrefabXmlReader, EffectPrefabXmlReader
from lib.graphics.shader.shader_program_prefab_xml_reader import ShaderProgramPrefabXmlReader


class TestSubAlphaEffectPrefabXmlReader(unittest.TestCase):
    def test_alpha_effect_prefab_xml_reader_valid(self):
        xml = """
            <effect type="AlphaEffect">
                <alphaValue>1</alphaValue>
            </effect>
        """
        reader = SubAlphaEffectPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_alpha_value(), 1)

    def test_alpha_effect_prefab_xml_reader_invalid(self):
        xml = """
            <effect type="AlphaEffect"></effect>
        """
        reader = SubAlphaEffectPrefabXmlReader()

        with self.assertRaises(EffectPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubTintEffectPrefabXmlReader(unittest.TestCase):
    def test_tint_effect_prefab_xml_reader_valid(self):
        xml = """
            <effect type="TintEffect">
                <color type="HexColor">
                    <hexValue>CCAAFFEE</hexValue>
                </color>
            </effect>
        """
        reader = SubTintEffectPrefabXmlReader(ColorPrefabXmlReader([SubHexColorPrefabXmlReader()]))
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_color_prefab().get_hex_value(), "CCAAFFEE")

    def test_tint_effect_prefab_xml_reader_invalid(self):
        xml = """
            <effect type="TintEffect">
            </effect>
        """
        reader = SubTintEffectPrefabXmlReader(ColorPrefabXmlReader([SubHexColorPrefabXmlReader()]))

        with self.assertRaises(EffectPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubShaderEffectPrefabXmlReader(unittest.TestCase):
    def test_shader_effect_prefab_xml_reader_valid(self):
        xml = """
            <effect type="ShaderEffect">
                <shaderProgram>
                    <vertexShaderFilename>test_vertex</vertexShaderFilename>
                    <fragmentShaderFilename>test_fragment</fragmentShaderFilename>
                </shaderProgram>
            </effect>
        """
        reader = SubShaderEffectPrefabXmlReader(ShaderProgramPrefabXmlReader())
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_shader_program_prefab().get_vertex_shader_filename(), "test_vertex")
        self.assertEqual(prefab.get_shader_program_prefab().get_fragment_shader_filename(), "test_fragment")

    def test_shader_effect_prefab_xml_reader_invalid(self):
        xml = """
            <effect type="ShaderEffect">
            </effect>
        """
        reader = SubShaderEffectPrefabXmlReader(ShaderProgramPrefabXmlReader())

        with self.assertRaises(EffectPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestEffectPrefabXmlReader(unittest.TestCase):
    def test_effect_prefab_xml_reader_valid(self):
        xml = """
            <effect type="AlphaEffect">
                <alphaValue>1</alphaValue>
            </effect>
        """
        reader = EffectPrefabXmlReader([SubAlphaEffectPrefabXmlReader()])
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_alpha_value(), 1)

    def test_effect_prefab_xml_reader_invalid(self):
        xml = """
            <effect type="UnknownEffect"></effect>
        """
        reader = EffectPrefabXmlReader([SubAlphaEffectPrefabXmlReader()])

        with self.assertRaises(EffectPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


if __name__ == "__main__":
    unittest.main()

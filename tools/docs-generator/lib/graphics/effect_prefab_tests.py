import unittest

from lib.graphics.color_prefab import HexColorPrefab, SubHexColorPrefabXmlReader
from lib.graphics.effect_prefab import *
from lib.graphics.shader_program_prefab import ShaderProgramPrefab


class TestEffectPrefab(unittest.TestCase):
    def test_alpha_effect_prefab_to_string(self):
        self.assertEqual(
            str(AlphaEffectPrefab(1)),
            "AlphaEffectPrefab(alpha_value=1)"
        )

    def test_tint_effect_prefab_to_string(self):
        self.assertEqual(
            str(TintEffectPrefab(HexColorPrefab("CCAAFFEE"))),
            "TintEffectPrefab(color_prefab={})".format(str(HexColorPrefab("CCAAFFEE")))
        )

    def test_shader_effect_prefab_to_string(self):
        self.assertEqual(
            str(ShaderEffectPrefab(ShaderProgramPrefab("test_vertex", "test_fragment"))),
            "ShaderEffectPrefab(shader_program_prefab={})"
                .format(str(ShaderProgramPrefab("test_vertex", "test_fragment")))
        )


class EffectPrefabXmlReaderTest(unittest.TestCase):
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

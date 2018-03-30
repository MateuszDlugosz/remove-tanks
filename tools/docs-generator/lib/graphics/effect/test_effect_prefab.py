import unittest

from lib.graphics.color.color_prefab import HexColorPrefab
from lib.graphics.effect.effect_prefab import AlphaEffectPrefab, TintEffectPrefab, ShaderEffectPrefab
from lib.graphics.shader.shader_program_prefab import ShaderProgramPrefab


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


if __name__ == "__main__":
    unittest.main()

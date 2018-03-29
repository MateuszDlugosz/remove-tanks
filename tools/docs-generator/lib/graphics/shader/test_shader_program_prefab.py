import unittest

from lib.graphics.shader.shader_program_prefab import *


class TestShaderProgramPrefab(unittest.TestCase):
    def test_shader_program_prefab_to_string(self):
        self.assertEqual(
            str(ShaderProgramPrefab("VERTEX_TEST", "FRAGMENT_TEST")),
            "ShaderProgramPrefab(vertex_shader_filename=VERTEX_TEST, fragment_shader_filename=FRAGMENT_TEST)"
        )


if __name__ == "__main__":
    unittest.main()

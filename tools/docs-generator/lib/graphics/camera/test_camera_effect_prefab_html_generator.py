import unittest

from lib.graphics.camera.camera_effect_prefab import ShakeCameraEffectPrefab
from lib.graphics.camera.camera_effect_prefab_html_generator import SubShakeCameraEffectPrefabHtmlGenerator, \
    CameraEffectPrefabHtmlGenerator
from lib.html.html import HtmlGenerator


class TestSubShakeCameraEffectPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ShakeCameraEffectPrefab(10, 20)
        html_generator = HtmlGenerator()
        scm_html_generator = SubShakeCameraEffectPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-camera-effect"><p>Shakecameraeffect</p><div><table><tr><th>Time</th><td>10.0</td></tr><tr>'
            '<th>Power</th><td>20.0</td></tr></table></div></div>',
            html_generator.generate_html(scm_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestCameraEffectPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ShakeCameraEffectPrefab(10, 20)
        html_generator = HtmlGenerator()
        cep_html_generator = CameraEffectPrefabHtmlGenerator([SubShakeCameraEffectPrefabHtmlGenerator()])

        self.assertEqual(
            '<divclass="doc-camera-effect"><p>Shakecameraeffect</p><div><table><tr><th>Time</th><td>10.0</td></tr><tr>'
            '<th>Power</th><td>20.0</td></tr></table></div></div>',
            html_generator.generate_html(cep_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()

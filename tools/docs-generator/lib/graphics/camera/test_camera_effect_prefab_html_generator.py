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
            '<divclass="doc-camera-effect"><h6>Shakecameraeffect</h6><hr/><dl><dt>Time</dt><dd>10.0</dd><dt>Power'
            '</dt><dd>20.0</dd></dl></div>',
            html_generator.generate_html(scm_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestCameraEffectPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ShakeCameraEffectPrefab(10, 20)
        html_generator = HtmlGenerator()
        cep_html_generator = CameraEffectPrefabHtmlGenerator([SubShakeCameraEffectPrefabHtmlGenerator()])

        self.assertEqual(
            '<divclass="doc-camera-effect"><h6>Shakecameraeffect</h6><hr/><dl><dt>Time</dt><dd>10.0</dd><dt>Power'
            '</dt><dd>20.0</dd></dl></div>',
            html_generator.generate_html(cep_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()

import unittest

from lib.html.html import HtmlGenerator
from lib.level.engine.entity.component.component_prefab_html_generator import *
from lib.utility.surface.position.position_prefab import PositionPrefab
from lib.utility.surface.position.position_prefab_html_generator import PositionPrefabHtmlGenerator


class TestSubSpeedComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = SpeedComponentPrefab(10)
        html_generator = HtmlGenerator()
        sub_generator = SubSpeedComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Speedcomponent</h5><hr/><dl><dt>Speed</dt><dd>10.0</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubSpeedModifierComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = SpeedModifierComponentPrefab(10)
        html_generator = HtmlGenerator()
        sub_generator = SubSpeedModifierComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Speedmodifiercomponent</h5><hr/><dl><dt>Speedmodifier</dt>'
            '<dd>10.0</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubCameraTrackComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = CameraTrackComponentPrefab(1, PositionPrefab(1, 2))
        html_generator = HtmlGenerator()
        sub_generator = SubCameraTrackComponentPrefabHtmlGenerator(PositionPrefabHtmlGenerator())

        self.assertEqual(
            '<divclass="doc-component"><h5>Cameratrackcomponent</h5><hr/><dl><dt>Priority</dt><dd>1</dd><dt>'
            'Position</dt><dd><divclass="doc-position"><h6>Position</h6><hr/><dl><dt>X</dt><dd>1.0</dd><dt>Y'
            '</dt><dd>2.0</dd></dl></div></dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        pass


if __name__ == "__main__":
    unittest.main()

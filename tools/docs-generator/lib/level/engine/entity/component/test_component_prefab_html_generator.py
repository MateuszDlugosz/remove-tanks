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


class TestSubLeaveBonusComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = LeaveBonusComponentPrefab(1)
        html_generator = HtmlGenerator()
        sub_generator = SubLeaveBonusComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Leavebonuscomponent</h5><hr/><dl><dt>Chancemodifier<'
            '/dt><dd>1.0</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAmmoComponentComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AmmoComponentPrefab(1, 2, {1: {"Left": "LeftBullet0", "Right": "RightBullet0"},
                                            2: {"Left": "LeftBullet1", "Right": "RightBullet1"}})
        html_generator = HtmlGenerator()
        sub_generator = SubAmmoComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Ammocomponent</h5><hr/><dt>Ammotable</dt><dd><table><tr><th>Level</th><th>'
            'EntityPrefabCodes</th></tr><tr><td>1</td><td><table><tr><th>Direction</th><th>Entityprefabcode</th></tr>'
            '<tr><td>Left</td><td>LeftBullet0</td></tr><tr><td>Right</td><td>RightBullet0</td></tr></table></td></tr>'
            '<tr><td>2</td><td><table><tr><th>Direction</th><th>Entityprefabcode</th></tr><tr><td>Left</td><td>'
            'LeftBullet1</td></tr><tr><td>Right</td><td>RightBullet1</td></tr></table></td></tr></table></dd><dl><dt>'
            'Currentlevel</dt><dd>1</dd><dt>Maxlevel</dt><dd>2</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAutoShootComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AutoShootComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubAutoShootComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Autoshootcomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDamageComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DamageComponentPrefab(2)
        html_generator = HtmlGenerator()
        sub_generator = SubDamageComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Damagecomponent</h5><hr/><dl><dt>Damage</dt><dd>2</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubHealthComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = HealthComponentPrefab(2, 6)
        html_generator = HtmlGenerator()
        sub_generator = SubHealthComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Healthcomponent</h5><hr/><dl><dt>Health</dt><dd>2</dd><dt>Maxhealth</dt>'
            '<dd>6</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        pass


if __name__ == "__main__":
    unittest.main()

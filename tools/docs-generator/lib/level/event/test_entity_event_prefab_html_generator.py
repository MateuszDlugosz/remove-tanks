import unittest

from lib.graphics.camera.camera_effect_prefab import ShakeCameraEffectPrefab
from lib.graphics.camera.camera_effect_prefab_html_generator import CameraEffectPrefabHtmlGenerator, \
    SubShakeCameraEffectPrefabHtmlGenerator
from lib.html.html import HtmlGenerator
from lib.level.event.entity_event_prefab import SpawnAirplaneEntityEventPrefab, AmmoLevelUpEntityEventPrefab, \
    AddCameraEffectEntityEventPrefab, CreateEntityEventPrefab, DestroyEntityEventPrefab, \
    DestroyEntityByIdEntityEventPrefab
from lib.level.event.entity_event_prefab_html_generator import SubSpawnAirplaneEntityEventPrefabHtmlGenerator, \
    SubAmmoLevelUpEntityEventPrefabHtmlGenerator, SubAddCameraEffectEntityEventPrefabHtmlGenerator, \
    SubCreateEntityEventPrefabHtmlGenerator, SubDestroyEntityEventPrefabHtmlGenerator, \
    SubDestroyEntityByIdEntityEventPrefabHtmlGenerator
from lib.level.utility.create.create_entry_prefab import CreateEntryPrefab
from lib.level.utility.create.create_entry_prefab_html_generator import CreateEntryPrefabHtmlGenerator
from lib.utility.surface.position.position_prefab import PositionPrefab
from lib.utility.surface.position.position_prefab_html_generator import PositionPrefabHtmlGenerator


class TestSubSpawnAirplaneEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = SpawnAirplaneEntityEventPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubSpawnAirplaneEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Spawnairplaneentityevent</h6><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAmmoLevelUpEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AmmoLevelUpEntityEventPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubAmmoLevelUpEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Ammolevelupentityevent</h6><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAddCameraEffectEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AddCameraEffectEntityEventPrefab(ShakeCameraEffectPrefab(10, 20))
        html_generator = HtmlGenerator()
        sub_generator = SubAddCameraEffectEntityEventPrefabHtmlGenerator(
            CameraEffectPrefabHtmlGenerator([SubShakeCameraEffectPrefabHtmlGenerator()])
        )

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Addcameraeffectentityevent</h6><hr/><dl><dt>Cameraeffect'
            '</dt><dd><divclass="doc-camera-effect"><h6>Shakecameraeffect</h6><hr/><dl><dt>Time</dt><dd>'
            '10.0</dd><dt>Power</dt><dd>20.0</dd></dl></div></dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubCreateEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = CreateEntityEventPrefab([CreateEntryPrefab("PREFAB_CODE", PositionPrefab(10, 20))])
        html_generator = HtmlGenerator()
        sub_generator = SubCreateEntityEventPrefabHtmlGenerator(
            CreateEntryPrefabHtmlGenerator(PositionPrefabHtmlGenerator())
        )

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Createentityevent</h6><hr/><dl><dt>Createentries</dt><dd>'
            '<divclass="doc-create-entry"><h6>Createentry</h6><hr/><dl><dt>Position</dt><dd><divclass="doc-position">'
            '<h6>Position</h6><hr/><dl><dt>X</dt><dd>10.0</dd><dt>Y</dt><dd>20.0</dd></dl></div></dd><dt>'
            'Entityprefabcode</dt><dd>PREFAB_CODE</dd></dl></div></dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDestroyEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DestroyEntityEventPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubDestroyEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Destroyentityevent</h6><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDestroyEntityByIdEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DestroyEntityByIdEntityEventPrefab("ID")
        html_generator = HtmlGenerator()
        sub_generator = SubDestroyEntityByIdEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Destroyentitybyidentityevent</h6><hr/><dl><dt>Id</dt>'
            '<dd>ID</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        pass


if __name__ == "__main__":
    unittest.main()

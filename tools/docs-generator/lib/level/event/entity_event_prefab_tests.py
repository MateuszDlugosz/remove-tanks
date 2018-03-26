import unittest

from lib.level.event.entity_event_prefab import SpawnAirplaneEntityEventPrefab, AmmoLevelUpEntityEventPrefab, \
    SubSpawnAirplaneEntityEventPrefabXmlReader, SubAmmoLevelUpEntityEventPrefabXmlReader, EntityEventPrefabXmlReader


class TestSpawnAirplaneEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        self.assertEqual(
            str(SpawnAirplaneEntityEventPrefab()),
            "SpawnAirplaneEntityEventPrefab()"
        )


class TestAmmoLevelUpEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        self.assertEqual(
            str(AmmoLevelUpEntityEventPrefab()),
            "AmmoLevelUpEntityEventPrefab()"
        )


class TestSubSpawnAirplaneEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """<entityEvent type="SpawnAirplaneEntityEvent" />"""
        reader = SubSpawnAirplaneEntityEventPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubAmmoLevelUpEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """<entityEvent type="AmmoLevelUpEntityEvent" />"""
        reader = SubAmmoLevelUpEntityEventPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestEntityEventPrefabXmlReader(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """<entityEvent type="AmmoLevelUpEntityEvent" />"""
        reader = EntityEventPrefabXmlReader([SubAmmoLevelUpEntityEventPrefabXmlReader()])
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)

    def test_read_prefabs_from_string_valid(self):
        xml = """
            <entityEvents>
                <entityEvent type="AmmoLevelUpEntityEvent" />
                <entityEvent type="AmmoLevelUpEntityEvent" />
            </entityEvents>
        """
        reader = EntityEventPrefabXmlReader([SubAmmoLevelUpEntityEventPrefabXmlReader()])
        prefabs = reader.read_prefabs_from_string(xml)

        self.assertEqual(2, len(prefabs))

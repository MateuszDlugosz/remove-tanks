import unittest

from lib.graphics.camera.camera_effect_prefab import ShakeCameraEffectPrefab, SubShakeCameraEffectPrefabXmlReader, \
    CameraEffectPrefabXmlReadException, CameraEffectPrefabXmlReader


class TestShakeCameraEffectPrefab(unittest.TestCase):
    def test_camera_effect_prefab_to_string(self):
        self.assertEqual(
            str(ShakeCameraEffectPrefab(10, 20)),
            "ShakeCameraEffectPrefab(time=10.0, power=20.0)"
        )


class TestSubShakeCameraEffectPrefabXmlReader(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """
            <cameraEffect type="ShakeCameraEffect">
                <time>2.2</time>
                <power>2.3</power>
            </cameraEffect>
        """
        reader = SubShakeCameraEffectPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_power(), 2.3)
        self.assertEqual(prefab.get_time(), 2.2)

    def test_read_prefab_from_string_invalid(self):
        xml = """
            <cameraEffect type="ShakeCameraEffect" />
        """
        reader = SubShakeCameraEffectPrefabXmlReader()

        with self.assertRaises(CameraEffectPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestCameraEffectPrefabXmlReader(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """
            <cameraEffect type="ShakeCameraEffect">
                <time>2.2</time>
                <power>2.3</power>
            </cameraEffect>
        """
        reader = CameraEffectPrefabXmlReader([SubShakeCameraEffectPrefabXmlReader()])
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_power(), 2.3)
        self.assertEqual(prefab.get_time(), 2.2)

    def test_read_prefab_from_string_invalid(self):
        xml = """
            <cameraEffect type="ShakeCameraEffect" />
        """
        reader = CameraEffectPrefabXmlReader([SubShakeCameraEffectPrefabXmlReader()])

        with self.assertRaises(CameraEffectPrefabXmlReadException):
            reader.read_prefab_from_string(xml)

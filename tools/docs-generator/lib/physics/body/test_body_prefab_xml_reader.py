import unittest

from lib.physics.body.body_prefab_xml_reader import BodyPrefabXmlReader, BodyPrefabXmlReadException


class TestBodyPrefabXmlReader(unittest.TestCase):
    def test_body_prefab_xml_reader_valid(self):
        xml = """
            <body>
                <type>KinematicBody</type>
                <active>true</active>
                <allowSleep>false</allowSleep>
                <awake>false</awake>
                <bullet>true</bullet>
                <fixedRotation>false</fixedRotation>
                <gravityScale>1</gravityScale>
                <angle>10</angle>
                <angularDamping>2</angularDamping>
                <linearDamping>8</linearDamping>
            </body>
        """
        reader = BodyPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_body_type(), "KinematicBody")
        self.assertTrue(prefab.get_active())
        self.assertFalse(prefab.get_allow_sleep())
        self.assertFalse(prefab.get_awake())
        self.assertTrue(prefab.get_bullet())
        self.assertFalse(prefab.get_fixed_rotation())
        self.assertEqual(prefab.get_gravity_scale(), 1)
        self.assertEqual(prefab.get_angle(), 10)
        self.assertEqual(prefab.get_angular_damping(), 2)
        self.assertEqual(prefab.get_linear_damping(), 8)

    def test_body_prefab_xml_reader_invalid(self):
        xml = """
            <body>
                <angle>invalid</angle>
            </body>
        """

        reader = BodyPrefabXmlReader()

        with self.assertRaises(BodyPrefabXmlReadException):
            reader.read_prefab_from_string(xml)

    def test_body_prefab_xml_reader_defaults(self):
        xml = "<body></body>"
        reader = BodyPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_body_type(), BodyPrefabXmlReader.DEFAULT_BODY_TYPE)
        self.assertEqual(prefab.get_active(), BodyPrefabXmlReader.DEFAULT_ACTIVE)
        self.assertEqual(prefab.get_allow_sleep(), BodyPrefabXmlReader.DEFAULT_ALLOW_SLEEP)
        self.assertEqual(prefab.get_awake(), BodyPrefabXmlReader.DEFAULT_AWAKE)
        self.assertEqual(prefab.get_bullet(), BodyPrefabXmlReader.DEFAULT_BULLET)
        self.assertEqual(prefab.get_fixed_rotation(), BodyPrefabXmlReader.DEFAULT_FIXED_ROTATION)
        self.assertEqual(prefab.get_gravity_scale(), BodyPrefabXmlReader.DEFAULT_GRAVITY_SCALE)
        self.assertEqual(prefab.get_angle(), BodyPrefabXmlReader.DEFAULT_ANGLE)
        self.assertEqual(prefab.get_angular_damping(), BodyPrefabXmlReader.DEFAULT_ANGULAR_DAMPING)
        self.assertEqual(prefab.get_linear_damping(), BodyPrefabXmlReader.DEFAULT_LINEAR_DAMPING)


if __name__ == '__main__':
    unittest.main()

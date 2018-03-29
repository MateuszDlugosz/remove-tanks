import xml.etree.ElementTree as EXml

from lib.physics.body.body_prefab import BodyPrefab
from lib.utility.string_functions import string_to_boolean


class BodyPrefabXmlReader(object):
    BODY_ELEMENT = "body"

    BODY_TYPE_ELEMENT = "type"
    ACTIVE_ELEMENT = "active"
    AWAKE_ELEMENT = "awake"
    ALLOW_SLEEP_ELEMENT = "allowSleep"
    FIXED_ROTATION_ELEMENT = "fixedRotation"
    BULLET_ELEMENT = "bullet"
    GRAVITY_SCALE_ELEMENT = "gravityScale"
    ANGLE_ELEMENT = "angle"
    LINEAR_DAMPING_ELEMENT = "linearDamping"
    ANGULAR_DAMPING_ELEMENT = "angularDamping"

    DEFAULT_BODY_TYPE = "StaticBody"
    DEFAULT_ACTIVE = True
    DEFAULT_AWAKE = True
    DEFAULT_ALLOW_SLEEP = True
    DEFAULT_FIXED_ROTATION = True
    DEFAULT_BULLET = False
    DEFAULT_GRAVITY_SCALE = 1.0
    DEFAULT_ANGLE = 0.0
    DEFAULT_LINEAR_DAMPING = 0.0
    DEFAULT_ANGULAR_DAMPING = 0.0

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)

            body_type = self.DEFAULT_BODY_TYPE
            active = self.DEFAULT_ACTIVE
            awake = self.DEFAULT_AWAKE
            allow_sleep = self.DEFAULT_ALLOW_SLEEP
            fixed_rotation = self.DEFAULT_FIXED_ROTATION
            bullet = self.DEFAULT_BULLET
            gravity_scale = self.DEFAULT_GRAVITY_SCALE
            angle = self.DEFAULT_ANGLE
            angular_damping = self.DEFAULT_ANGULAR_DAMPING
            linear_damping = self.DEFAULT_LINEAR_DAMPING

            if element.find(self.BODY_TYPE_ELEMENT) is not None:
                body_type = element.find(self.BODY_TYPE_ELEMENT).text.strip()

            if element.find(self.ACTIVE_ELEMENT) is not None:
                active = string_to_boolean(element.find(self.ACTIVE_ELEMENT).text.strip())

            if element.find(self.AWAKE_ELEMENT) is not None:
                awake = string_to_boolean(element.find(self.AWAKE_ELEMENT).text.strip())

            if element.find(self.ALLOW_SLEEP_ELEMENT) is not None:
                allow_sleep = string_to_boolean(element.find(self.ALLOW_SLEEP_ELEMENT).text.strip())

            if element.find(self.FIXED_ROTATION_ELEMENT) is not None:
                fixed_rotation = string_to_boolean(element.find(self.FIXED_ROTATION_ELEMENT).text.strip())

            if element.find(self.BULLET_ELEMENT) is not None:
                bullet = string_to_boolean(element.find(self.BULLET_ELEMENT).text.strip())

            if element.find(self.GRAVITY_SCALE_ELEMENT) is not None:
                gravity_scale = float(element.find(self.GRAVITY_SCALE_ELEMENT).text.strip())

            if element.find(self.ANGLE_ELEMENT) is not None:
                angle = float(element.find(self.ANGLE_ELEMENT).text.strip())

            if element.find(self.ANGULAR_DAMPING_ELEMENT) is not None:
                angular_damping = float(element.find(self.ANGULAR_DAMPING_ELEMENT).text.strip())

            if element.find(self.LINEAR_DAMPING_ELEMENT) is not None:
                linear_damping = float(element.find(self.LINEAR_DAMPING_ELEMENT).text.strip())

            return BodyPrefab(body_type, active, allow_sleep, awake, bullet,
                              fixed_rotation, gravity_scale, angle, angular_damping, linear_damping)
        except Exception as e:
            raise BodyPrefabXmlReadException(xml_string, e)


class BodyPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read body prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(xml_string, cause)

import xml.etree.ElementTree as EXml
from lib.utility.string_functions import string_to_boolean


class BodyPrefab(object):
    def __init__(self, body_type, active, allow_sleep, awake, bullet,
                 fixed_rotation, gravity_scale, angle, angular_damping, linear_damping):
        self.body_type = str(body_type)
        self.active = bool(active)
        self.allow_sleep = bool(allow_sleep)
        self.awake = bool(awake)
        self.bullet = bool(bullet)
        self.fixed_rotation = bool(fixed_rotation)
        self.gravity_scale = float(gravity_scale)
        self.angle = float(angle)
        self.angular_damping = float(angular_damping)
        self.linear_damping = float(linear_damping)

    def get_body_type(self):
        return self.body_type

    def get_active(self):
        return self.active

    def get_allow_sleep(self):
        return self.allow_sleep

    def get_awake(self):
        return self.awake

    def get_bullet(self):
        return self.bullet

    def get_fixed_rotation(self):
        return self.fixed_rotation

    def get_gravity_scale(self):
        return self.gravity_scale

    def get_angle(self):
        return self.angle

    def get_angular_damping(self):
        return self.angular_damping

    def get_linear_damping(self):
        return self.linear_damping

    def __str__(self):
        return "BodyPrefab(body_type={}, active={}, allow_sleep={}, awake={}, bullet={}, fixed_rotation={}, " \
               "gravity_scale={}, angle={}, angular_damping={}, linear_damping={})"\
            .format(self.body_type, self.active, self.allow_sleep, self.awake, self.bullet, self.fixed_rotation,
                    self.gravity_scale, self.angle, self.angular_damping, self.linear_damping)


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

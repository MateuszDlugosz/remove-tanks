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

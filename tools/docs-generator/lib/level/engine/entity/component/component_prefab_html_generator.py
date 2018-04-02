from lib.html.html import HtmlElement
from lib.level.engine.entity.component.component_prefab import SpeedComponentPrefab, SpeedModifierComponentPrefab, \
    CameraTrackComponentPrefab, LeaveBonusComponentPrefab, AmmoComponentPrefab, AutoShootComponentPrefab, \
    DamageComponentPrefab, HealthComponentPrefab, HitComponentPrefab, ProtectionComponentPrefab, \
    RandomShootComponentPrefab, DirectionComponentPrefab, ChangeBehaviorComponentPrefab, RandomDirectionComponentPrefab, \
    PlayerComponentPrefab, EnemyComponentPrefab, IdentityComponentPrefab, InputComponentPrefab, CreateComponentPrefab, \
    DestroyComponentPrefab, DestroyOnContactComponentPrefab, DestroyOnContactLostComponentPrefab, \
    LifetimeComponentPrefab, RandomCreateComponentPrefab, AutoMoveComponentPrefab, PhysicsComponentPrefab, \
    AirplaneRenderLayerComponentPrefab, BombRenderLayerComponentPrefab, BonusRenderLayerComponentPrefab, \
    BulletRenderLayerComponentPrefab, CloudRenderLayerComponentPrefab, ExplosionRenderLayerComponentPrefab, \
    GroundRenderLayerComponentPrefab, ObstacleRenderLayerComponentPrefab, VehicleRenderLayerComponentPrefab, \
    ViewComponentPrefab, AirplaneSpawnerComponentPrefab, RespawnComponentPrefab, AutoSpawnerComponentPrefab, \
    StateComponentPrefab, CreateTriggerComponentPrefab, HitTriggerComponentPrefab, DestroyTriggerComponentPrefab

COMPONENT_CLASS_HTML_ATTRIBUTE = "doc-component"


class ComponentPrefabHtmlGenerator(object):
    def __init__(self, sub_generators):
        self.sub_generators = {}
        for sub_generator in sub_generators:
            self.sub_generators[sub_generator.get_type()] = sub_generator

    def generate_html(self, component_prefab):
        try:
            if component_prefab.__class__.__name__ not in self.sub_generators:
                raise ComponentPrefabHtmlGeneratorNotFoundException(component_prefab)

            return self.sub_generators[component_prefab.__class__.__name__].generate_html(component_prefab)
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)


class SubComponentPrefabHtmlGenerator(object):
    def generate_html(self, component_prefab):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class SubSpeedComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Speed component"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Speed"))
            dl.add_child(HtmlElement("dd", component_prefab.get_speed()))
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return SpeedComponentPrefab.__name__


class SubSpeedModifierComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Speed modifier component"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Speed modifier"))
            dl.add_child(HtmlElement("dd", component_prefab.get_speed_modifier()))
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return SpeedModifierComponentPrefab.__name__


class SubCameraTrackComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def __init__(self, position_prefab_html_generator):
        self.position_prefab_html_generator = position_prefab_html_generator

    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Camera track component"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Priority"))
            dl.add_child(HtmlElement("dd", component_prefab.get_priority()))
            dl.add_child(HtmlElement("dt", "Position"))
            dd1 = HtmlElement("dd")
            dd1.add_child(self.position_prefab_html_generator.generate_html(
                component_prefab.get_position_prefab()
            ))
            dl.add_child(dd1)
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return CameraTrackComponentPrefab.__name__


class SubLeaveBonusComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Leave bonus component"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Chance modifier"))
            dl.add_child(HtmlElement("dd", component_prefab.get_chance_modifier()))
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return LeaveBonusComponentPrefab.__name__


class SubAmmoComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Ammo component"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Current level"))
            dl.add_child(HtmlElement("dd", component_prefab.get_current_level()))
            dl.add_child(HtmlElement("dt", "Max level"))
            dl.add_child(HtmlElement("dd", component_prefab.get_max_level()))

            dl.add_child(HtmlElement("dt", "Ammo table"))
            dd_ammo_table = HtmlElement("dd")

            table = HtmlElement("table")
            title_row = HtmlElement("tr")
            title_row.add_child(HtmlElement("th", "Level"))
            title_row.add_child(HtmlElement("th", "EntityPrefabCodes"))
            table.add_child(title_row)

            for key, value in component_prefab.get_prefab_codes().items():
                row = HtmlElement("tr")
                row.add_child(HtmlElement("td", key))
                row_table = HtmlElement("table")
                row_table_row = HtmlElement("tr")
                row_table_row.add_child(HtmlElement("th", "Direction"))
                row_table_row.add_child(HtmlElement("th", "Entity prefab code"))
                row_table.add_child(row_table_row)
                td_direction = HtmlElement("td")

                for k, v in value.items():
                    direction_row = HtmlElement("tr")
                    direction_row.add_child(HtmlElement("td", k))
                    direction_row.add_child(HtmlElement("td", v))
                    row_table.add_child(direction_row)

                td_direction.add_child(row_table)
                row.add_child(td_direction)

                table.add_child(row)

            dd_ammo_table.add_child(table)
            dl.add_child(dd_ammo_table)
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return AmmoComponentPrefab.__name__


class SubAutoShootComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Auto shoot component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return AutoShootComponentPrefab.__name__


class SubDamageComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Damage component"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Damage"))
            dl.add_child(HtmlElement("dd", component_prefab.get_damage()))
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return DamageComponentPrefab.__name__


class SubHealthComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Health component"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Health"))
            dl.add_child(HtmlElement("dd", component_prefab.get_health()))
            dl.add_child(HtmlElement("dt", "Max health"))
            dl.add_child(HtmlElement("dd", component_prefab.get_max_health()))
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return HealthComponentPrefab.__name__


class SubHitComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def __init__(self, effect_prefab_html_generator):
        self.effect_prefab_html_generator = effect_prefab_html_generator

    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Hit component"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Time"))
            dl.add_child(HtmlElement("dd", component_prefab.get_hit_time()))
            dl.add_child(HtmlElement("dt", "Effect"))
            dd = HtmlElement("dd")
            dd.add_child(self.effect_prefab_html_generator.generate_html(
                component_prefab.get_effect_prefab()
            ))
            dl.add_child(dd)
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return HitComponentPrefab.__name__


class SubProtectionComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Protection component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return ProtectionComponentPrefab.__name__


class SubRandomShootComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Random shoot component"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Min shoot frequency"))
            dl.add_child(HtmlElement("dd", component_prefab.get_min_shoot_frequency()))
            dl.add_child(HtmlElement("dt", "Max shoot frequency"))
            dl.add_child(HtmlElement("dd", component_prefab.get_max_shoot_frequency()))
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return RandomShootComponentPrefab.__name__


class SubDirectionComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Direction component"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Direction"))
            dl.add_child(HtmlElement("dd", component_prefab.get_direction()))
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return DirectionComponentPrefab.__name__


class SubChangeBehaviorComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def __init__(self, component_prefab_html_generator):
        self.component_prefab_html_generator = component_prefab_html_generator

    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Change behavior component"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Components"))
            dd = HtmlElement("dd")
            for c_prefab in component_prefab.get_component_prefabs():
                dd.add_child(self.component_prefab_html_generator.generate_html(c_prefab))
            dl.add_child(dd)
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return ChangeBehaviorComponentPrefab.__name__


class SubRandomDirectionComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Random direction component"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Min direction frequency"))
            dl.add_child(HtmlElement("dd", component_prefab.get_min_change_direction_frequency()))
            dl.add_child(HtmlElement("dt", "Max direction frequency"))
            dl.add_child(HtmlElement("dd", component_prefab.get_max_change_direction_frequency()))
            dl.add_child(HtmlElement("dt", "Directions"))
            dl.add_child(HtmlElement("dd", ", ".join(component_prefab.get_directions())))
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return RandomDirectionComponentPrefab.__name__


class SubPlayerComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Player component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return PlayerComponentPrefab.__name__


class SubEnemyComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Enemy component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return EnemyComponentPrefab.__name__


class SubIdentityComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Identity component"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Id"))
            dl.add_child(HtmlElement("dd", component_prefab.get_id()))
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return IdentityComponentPrefab.__name__


class SubInputComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Input component"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Shoot delay"))
            dl.add_child(HtmlElement("dd", component_prefab.get_shoot_delay()))
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return InputComponentPrefab.__name__


class SubCreateComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Create component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return CreateComponentPrefab.__name__


class SubDestroyComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Destroy component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return DestroyComponentPrefab.__name__


class SubDestroyOnContactComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Destroy on contact component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return DestroyOnContactComponentPrefab.__name__


class SubDestroyOnContactLostComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Destroy on contact lost component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return DestroyOnContactLostComponentPrefab.__name__


class SubLifetimeComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Lifetime component"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Lifetime"))
            dl.add_child(HtmlElement("dd", component_prefab.get_lifetime()))
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return LifetimeComponentPrefab.__name__


class SubRandomCreateComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def __init__(self, create_entry_prefab_html_generator):
        self.create_entry_prefab_html_generator = create_entry_prefab_html_generator

    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Random create component"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Min create frequency"))
            dl.add_child(HtmlElement("dd", component_prefab.get_min_create_frequency()))
            dl.add_child(HtmlElement("dt", "Max create frequency"))
            dl.add_child(HtmlElement("dd", component_prefab.get_max_create_frequency()))
            dl.add_child(HtmlElement("dt", "Create entries"))
            ce_dd = HtmlElement("dd")
            for ce in component_prefab.get_create_entry_prefabs():
                ce_dd.add_child(self.create_entry_prefab_html_generator.generate_html(ce))
            dl.add_child(ce_dd)
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return RandomCreateComponentPrefab.__name__


class SubAutoMoveComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Auto move component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return AutoMoveComponentPrefab.__name__


class SubPhysicsComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def __init__(self, body_prefab_html_generator, hit_box_prefab_html_generator,
                 sensor_prefab_html_generator, light_handler_prefab_html_generator):
        self.body_prefab_html_generator = body_prefab_html_generator
        self.hit_box_prefab_html_generator = hit_box_prefab_html_generator
        self.sensor_prefab_html_generator = sensor_prefab_html_generator
        self.light_handler_prefab_html_generator = light_handler_prefab_html_generator

    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Physics component"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")

            dl.add_child(HtmlElement("dt", "Body"))
            dd_body = HtmlElement("dd")
            dd_body.add_child(self.body_prefab_html_generator.generate_html(
                component_prefab.get_body_prefab()
            ))
            dl.add_child(dd_body)

            dl.add_child(HtmlElement("dt", "Hit boxes"))
            dd_hit_boxes = HtmlElement("dd")
            for hb_prefab in component_prefab.get_hit_box_prefabs():
                dd_hit_boxes.add_child(self.hit_box_prefab_html_generator.generate_html(hb_prefab))
            dl.add_child(dd_hit_boxes)

            dl.add_child(HtmlElement("dt", "Sensors"))
            dd_sensors = HtmlElement("dd")
            for s_prefab in component_prefab.get_sensor_prefabs():
                dd_sensors.add_child(self.sensor_prefab_html_generator.generate_html(s_prefab))
            dl.add_child(dd_sensors)

            dl.add_child(HtmlElement("dt", "Light handlers"))
            dd_light_handlers = HtmlElement("dd")
            for l_prefab in component_prefab.get_light_handler_prefabs():
                dd_light_handlers.add_child(self.light_handler_prefab_html_generator.generate_html(l_prefab))
            dl.add_child(dd_light_handlers)

            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return PhysicsComponentPrefab.__name__


class SubAirplaneRenderLayerComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Airplane render layer component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return AirplaneRenderLayerComponentPrefab.__name__


class SubBombRenderLayerComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Bomb render layer component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return BombRenderLayerComponentPrefab.__name__


class SubBonusRenderLayerComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Bonus render layer component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return BonusRenderLayerComponentPrefab.__name__


class SubBulletRenderLayerComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Bullet render layer component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return BulletRenderLayerComponentPrefab.__name__


class SubCloudRenderLayerComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Cloud render layer component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return CloudRenderLayerComponentPrefab.__name__


class SubExplosionRenderLayerComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Explosion render layer component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return ExplosionRenderLayerComponentPrefab.__name__


class SubGroundRenderLayerComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Ground render layer component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return GroundRenderLayerComponentPrefab.__name__


class SubObstacleRenderLayerComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Obstacle render layer component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return ObstacleRenderLayerComponentPrefab.__name__


class SubVehicleRenderLayerComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Vehicle render layer component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return VehicleRenderLayerComponentPrefab.__name__


class SubViewComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def __init__(self, view_prefab_html_generator):
        self.view_prefab_html_generator = view_prefab_html_generator

    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "View component"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Views"))
            dd_views = HtmlElement("dd")
            for v_prefab in component_prefab.get_view_prefabs():
                dd_views.add_child(self.view_prefab_html_generator.generate_html(v_prefab))
            dl.add_child(dd_views)
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return ViewComponentPrefab.__name__


class SubAirplaneSpawnerComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Airplane spawner component"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Entity prefab code"))
            dl.add_child(HtmlElement("dd", component_prefab.get_entity_prefab_code()))
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return AirplaneSpawnerComponentPrefab.__name__


class SubRespawnComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Respawn component"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return RespawnComponentPrefab.__name__


class SubAutoSpawnerComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Auto spawner component"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Id"))
            dl.add_child(HtmlElement("dd", component_prefab.get_id()))
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return AutoSpawnerComponentPrefab.__name__


class SubStateComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "State component"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "State"))
            dl.add_child(HtmlElement("dd", component_prefab.get_state()))
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return StateComponentPrefab.__name__


class SubCreateTriggerComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def __init__(self, entity_event_prefab_html_generator):
        self.entity_event_prefab_html_generator = entity_event_prefab_html_generator

    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Create trigger component"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Entity events"))
            ee_dd = HtmlElement("dd")
            for entity_event_prefab in component_prefab.get_entity_event_prefabs():
                ee_dd.add_child(self.entity_event_prefab_html_generator.generate_html(entity_event_prefab))
            dl.add_child(ee_dd)
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return CreateTriggerComponentPrefab.__name__


class SubHitTriggerComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def __init__(self, entity_event_prefab_html_generator):
        self.entity_event_prefab_html_generator = entity_event_prefab_html_generator

    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Hit trigger component"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Entity events"))
            ee_dd = HtmlElement("dd")
            for entity_event_prefab in component_prefab.get_entity_event_prefabs():
                ee_dd.add_child(self.entity_event_prefab_html_generator.generate_html(entity_event_prefab))
            dl.add_child(ee_dd)
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return HitTriggerComponentPrefab.__name__


class SubDestroyTriggerComponentPrefabHtmlGenerator(SubComponentPrefabHtmlGenerator):
    def __init__(self, entity_event_prefab_html_generator):
        self.entity_event_prefab_html_generator = entity_event_prefab_html_generator

    def generate_html(self, component_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COMPONENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h5", "Destroy trigger component"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Entity events"))
            ee_dd = HtmlElement("dd")
            for entity_event_prefab in component_prefab.get_entity_event_prefabs():
                ee_dd.add_child(self.entity_event_prefab_html_generator.generate_html(entity_event_prefab))
            dl.add_child(ee_dd)
            html.add_child(dl)

            return html
        except Exception as e:
            raise ComponentPrefabHtmlGenerationException(component_prefab, e)

    def get_type(self):
        return DestroyTriggerComponentPrefab.__name__


class ComponentPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from component prefab {}. Cause: {}."

    def __init__(self, component_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(component_prefab), cause))


class ComponentPrefabHtmlGeneratorNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Component prefab html generator of {} component type not found."

    def __init__(self, component_prefab):
        super().__init__(self.MESSAGE_TEMPLATE.format(component_prefab.__class__.__name__))

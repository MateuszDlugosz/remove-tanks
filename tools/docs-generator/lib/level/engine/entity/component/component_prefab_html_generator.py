from lib.html.html import HtmlElement
from lib.level.engine.entity.component.component_prefab import SpeedComponentPrefab, SpeedModifierComponentPrefab, \
    CameraTrackComponentPrefab, LeaveBonusComponentPrefab, AmmoComponentPrefab, AutoShootComponentPrefab, \
    DamageComponentPrefab, HealthComponentPrefab

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

            html.add_child(HtmlElement("dt", "Ammo table"))
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
            html.add_child(dd_ammo_table)
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


class ComponentPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from component prefab {}. Cause: {}."

    def __init__(self, component_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(component_prefab), cause))


class ComponentPrefabHtmlGeneratorNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Component prefab html generator of {} component type not found."

    def __init__(self, component_prefab):
        super().__init__(self.MESSAGE_TEMPLATE.format(component_prefab.__class__.__name__))

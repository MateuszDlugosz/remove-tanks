from lib.html.html import HtmlElement
from lib.level.event.entity_event_prefab import SpawnAirplaneEntityEventPrefab, AmmoLevelUpEntityEventPrefab, \
    AddCameraEffectEntityEventPrefab, CreateEntityEventPrefab, DestroyEntityEventPrefab, \
    DestroyEntityByIdEntityEventPrefab, DestroyFamilyEntityEventPrefab, AddLifeEntityEventPrefab, \
    AddMessageEntityEventPrefab, PlayMusicEntityEventPrefab, AddPointsEntityEventPrefab, \
    IncreasePointsMultiplierEntityEventPrefab, PlaySoundEntityEventPrefab, ActivateSpawnerEntityEventPrefab, \
    ChangeLevelStateEntityEventPrefab

ENTITY_EVENT_CLASS_HTML_ATTRIBUTE = "doc-entity-event"


class EntityEventPrefabHtmlGenerator(object):
    def __init__(self, sub_generators):
        self.sub_generators = {}
        for sub_generator in sub_generators:
            self.sub_generators[sub_generator.get_type()] = sub_generator

    def generate_html(self, entity_event_prefab):
        try:
            if entity_event_prefab.__class__.__name__ not in self.sub_generators:
                raise EntityEventPrefabHtmlGeneratorNotFoundException(entity_event_prefab)

            return self.sub_generators[entity_event_prefab.__class__.__name__].generate_html(entity_event_prefab)
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)


class SubEntityEventPrefabHtmlGenerator(object):
    def generate_html(self, entity_event_prefab):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class SubSpawnAirplaneEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ENTITY_EVENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Spawn airplane entity event"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return SpawnAirplaneEntityEventPrefab.__name__


class SubAmmoLevelUpEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ENTITY_EVENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Ammo level up entity event"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return AmmoLevelUpEntityEventPrefab.__name__


class SubAddCameraEffectEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def __init__(self, camera_effect_prefab_html_generator):
        self.camera_effect_prefab_html_generator = camera_effect_prefab_html_generator

    def generate_html(self, entity_event_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ENTITY_EVENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Add camera effect entity event"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Camera effect"))
            ce_dd = HtmlElement("dd")
            ce_dd.add_child(self.camera_effect_prefab_html_generator.generate_html(
                entity_event_prefab.get_camera_effect_prefab()
            ))
            dl.add_child(ce_dd)

            html.add_child(dl)

            return html
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return AddCameraEffectEntityEventPrefab.__name__


class SubCreateEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def __init__(self, create_entry_prefab_html_generator):
        self.create_entry_prefab_html_generator = create_entry_prefab_html_generator

    def generate_html(self, entity_event_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ENTITY_EVENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Create entity event"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Create entries"))
            dd_ce = HtmlElement("dd")
            for create_entry_prefab in entity_event_prefab.get_create_entry_prefabs():
                dd_ce.add_child(self.create_entry_prefab_html_generator.generate_html(
                    create_entry_prefab
                ))

            dl.add_child(dd_ce)
            html.add_child(dl)

            return html
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return CreateEntityEventPrefab.__name__


class SubDestroyEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ENTITY_EVENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Destroy entity event"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return DestroyEntityEventPrefab.__name__


class SubDestroyEntityByIdEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ENTITY_EVENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Destroy entity by id entity event"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Id"))
            dl.add_child(HtmlElement("dd", entity_event_prefab.get_id()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return DestroyEntityByIdEntityEventPrefab.__name__


class SubDestroyFamilyEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ENTITY_EVENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Destroy family entity event"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Entity family"))
            dl.add_child(HtmlElement("dd", entity_event_prefab.get_entity_family()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return DestroyFamilyEntityEventPrefab.__name__


class SubAddLifeEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ENTITY_EVENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Add life entity event"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return AddLifeEntityEventPrefab.__name__


class SubAddMessageEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def __init__(self, message_prefab_html_generator):
        self.message_prefab_html_generator = message_prefab_html_generator

    def generate_html(self, entity_event_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ENTITY_EVENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Add message entity event"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Message"))
            message_dd = HtmlElement("dd")
            message_dd.add_child(self.message_prefab_html_generator.generate_html(
                entity_event_prefab.get_message_prefab()
            ))
            dl.add_child(message_dd)

            html.add_child(dl)

            return html
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return AddMessageEntityEventPrefab.__name__


class SubPlayMusicEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def __init__(self, music_prefab_html_generator):
        self.music_prefab_html_generator = music_prefab_html_generator

    def generate_html(self, entity_event_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ENTITY_EVENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Play music entity event"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Music"))
            music_dd = HtmlElement("dd")
            music_dd.add_child(self.music_prefab_html_generator.generate_html(
                entity_event_prefab.get_music_prefab()
            ))
            dl.add_child(music_dd)
            dl.add_child(HtmlElement("dt", "Music channel name"))
            dl.add_child(HtmlElement("dd", entity_event_prefab.get_music_channel_name()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return PlayMusicEntityEventPrefab.__name__


class SubAddPointsEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ENTITY_EVENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Add points entity event"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Points"))
            dl.add_child(HtmlElement("dd", entity_event_prefab.get_points()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return AddPointsEntityEventPrefab.__name__


class SubIncreasePointsMultiplierEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ENTITY_EVENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Increase points multiplier entity event"))
            html.add_child(HtmlElement("hr"))

            return html
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return IncreasePointsMultiplierEntityEventPrefab.__name__


class SubPlaySoundEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def __init__(self, sound_prefab_html_generator):
        self.sound_prefab_html_generator = sound_prefab_html_generator

    def generate_html(self, entity_event_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ENTITY_EVENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Play sound entity event"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Sound"))
            sound_dd = HtmlElement("dd")
            sound_dd.add_child(self.sound_prefab_html_generator.generate_html(
                entity_event_prefab.get_sound_prefab()
            ))
            dl.add_child(sound_dd)
            dl.add_child(HtmlElement("dt", "Sound channel name"))
            dl.add_child(HtmlElement("dd", entity_event_prefab.get_sound_channel_name()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return PlaySoundEntityEventPrefab.__name__


class SubActivateSpawnerEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ENTITY_EVENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Activate spawner entity event"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Id"))
            dl.add_child(HtmlElement("dd", entity_event_prefab.get_id()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return ActivateSpawnerEntityEventPrefab.__name__


class SubChangeLevelStateEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ENTITY_EVENT_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Change level state entity event"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Level state"))
            dl.add_child(HtmlElement("dd", entity_event_prefab.get_level_state()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return ChangeLevelStateEntityEventPrefab.__name__


class EntityEventPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from entity event prefab {}. Cause: {}."

    def __init__(self, entity_event_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(entity_event_prefab), cause))


class EntityEventPrefabHtmlGeneratorNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Entity event prefab html generator of type {} not found."

    def __init__(self, entity_event_prefab):
        super().__init__(self.MESSAGE_TEMPLATE.format(entity_event_prefab.__class__.__name__))

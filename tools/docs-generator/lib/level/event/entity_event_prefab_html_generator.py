from lib.html.html import HtmlElement
from lib.level.event.entity_event_prefab import SpawnAirplaneEntityEventPrefab, AmmoLevelUpEntityEventPrefab, \
    AddCameraEffectEntityEventPrefab, CreateEntityEventPrefab, DestroyEntityEventPrefab, \
    DestroyEntityByIdEntityEventPrefab, DestroyFamilyEntityEventPrefab, AddLifeEntityEventPrefab, \
    AddMessageEntityEventPrefab, PlayMusicEntityEventPrefab, AddPointsEntityEventPrefab, \
    IncreasePointsMultiplierEntityEventPrefab, PlaySoundEntityEventPrefab, ActivateSpawnerEntityEventPrefab, \
    ChangeLevelStateEntityEventPrefab, RandomCreateEntityEventPrefab, RemoveLifeEntityEventPrefab, \
    ClearMessagesEntityEventPrefab, ResetPointsMultiplierEntityEventPrefab, ActivateSystemEntityEventPrefab, \
    DeactivateSystemEntityEventPrefab

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
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Spawn airplane entity event")
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return SpawnAirplaneEntityEventPrefab.__name__


class SubAmmoLevelUpEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Ammo level up entity event")
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return AmmoLevelUpEntityEventPrefab.__name__


class SubAddCameraEffectEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def __init__(self, camera_effect_prefab_html_generator):
        self.camera_effect_prefab_html_generator = camera_effect_prefab_html_generator

    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Add camera effect entity event"),
                self.camera_effect_prefab_html_generator.generate_html(entity_event_prefab.get_camera_effect_prefab())
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return AddCameraEffectEntityEventPrefab.__name__


class SubCreateEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def __init__(self, create_entry_prefab_html_generator):
        self.create_entry_prefab_html_generator = create_entry_prefab_html_generator

    def generate_html(self, entity_event_prefab):
        try:
            create_entry_elements = [HtmlElement("p", "Create entries")]
            for create_entry_prefab in entity_event_prefab.get_create_entry_prefabs():
                create_entry_elements.append(self.create_entry_prefab_html_generator.generate_html(create_entry_prefab))

            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Create entity event"),
                HtmlElement("div", children=create_entry_elements)
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return CreateEntityEventPrefab.__name__


class SubDestroyEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Destroy entity event")
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return DestroyEntityEventPrefab.__name__


class SubDestroyEntityByIdEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Destroy entity by id entity event"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Id"),
                            HtmlElement("td", entity_event_prefab.get_id())
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return DestroyEntityByIdEntityEventPrefab.__name__


class SubDestroyFamilyEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Destroy family entity event"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Family"),
                            HtmlElement("td", entity_event_prefab.get_entity_family())
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return DestroyFamilyEntityEventPrefab.__name__


class SubAddLifeEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Add life entity event")
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return AddLifeEntityEventPrefab.__name__


class SubAddMessageEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def __init__(self, message_prefab_html_generator):
        self.message_prefab_html_generator = message_prefab_html_generator

    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Add message entity event"),
                self.message_prefab_html_generator.generate_html(
                    entity_event_prefab.get_message_prefab())
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return AddMessageEntityEventPrefab.__name__


class SubPlayMusicEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def __init__(self, music_prefab_html_generator):
        self.music_prefab_html_generator = music_prefab_html_generator

    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Play music entity event"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Music channel name"),
                            HtmlElement("td", entity_event_prefab.get_music_channel_name())
                        ])
                    ])
                ]),
                self.music_prefab_html_generator.generate_html(entity_event_prefab.get_music_prefab())
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return PlayMusicEntityEventPrefab.__name__


class SubAddPointsEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Add points entity event"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Points"),
                            HtmlElement("td", entity_event_prefab.get_points())
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return AddPointsEntityEventPrefab.__name__


class SubIncreasePointsMultiplierEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Increase points multiplier entity event")
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return IncreasePointsMultiplierEntityEventPrefab.__name__


class SubPlaySoundEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def __init__(self, sound_prefab_html_generator):
        self.sound_prefab_html_generator = sound_prefab_html_generator

    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Play sound entity event"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Sound channel name"),
                            HtmlElement("td", entity_event_prefab.get_sound_channel_name())
                        ])
                    ])
                ]),
                self.sound_prefab_html_generator.generate_html(entity_event_prefab.get_sound_prefab())
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return PlaySoundEntityEventPrefab.__name__


class SubActivateSpawnerEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Activate spawner entity event"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Id"),
                            HtmlElement("td", entity_event_prefab.get_id())
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return ActivateSpawnerEntityEventPrefab.__name__


class SubChangeLevelStateEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Change level state entity event"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Level state"),
                            HtmlElement("td", entity_event_prefab.get_level_state())
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return ChangeLevelStateEntityEventPrefab.__name__


class SubRandomCreateEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def __init__(self, create_entry_prefab_html_generator):
        self.create_entry_prefab_html_generator = create_entry_prefab_html_generator

    def generate_html(self, entity_event_prefab):
        try:
            create_entry_elements = [HtmlElement("p", "Create entries")]
            for create_entry_prefab in entity_event_prefab.get_create_entry_prefabs():
                create_entry_elements.append(self.create_entry_prefab_html_generator.generate_html(create_entry_prefab))

            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Random create entity event"),
                HtmlElement("div", children=create_entry_elements)
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return RandomCreateEntityEventPrefab.__name__


class SubRemoveLifeEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Remove life entity event")
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return RemoveLifeEntityEventPrefab.__name__


class SubClearMessagesEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Clear messages entity event")
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return ClearMessagesEntityEventPrefab.__name__


class SubResetPointsMultiplierEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Reset points multiplier entity event")
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return ResetPointsMultiplierEntityEventPrefab.__name__


class SubActivateSystemEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Activate system entity event"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Class name"),
                            HtmlElement("td", entity_event_prefab.get_class_name())
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return ActivateSystemEntityEventPrefab.__name__


class SubDeactivateSystemEntityEventPrefabHtmlGenerator(SubEntityEventPrefabHtmlGenerator):
    def generate_html(self, entity_event_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_EVENT_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Deactivate system entity event"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Class name"),
                            HtmlElement("td", entity_event_prefab.get_class_name())
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise EntityEventPrefabHtmlGenerationException(entity_event_prefab, e)

    def get_type(self):
        return DeactivateSystemEntityEventPrefab.__name__


class EntityEventPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from entity event prefab {}. Cause: {}."

    def __init__(self, entity_event_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(entity_event_prefab), cause))


class EntityEventPrefabHtmlGeneratorNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Entity event prefab html generator of type {} not found."

    def __init__(self, entity_event_prefab):
        super().__init__(self.MESSAGE_TEMPLATE.format(entity_event_prefab.__class__.__name__))

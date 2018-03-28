from lib.audio.music.music_prefab import MusicPrefabXmlReader
from lib.audio.sound.sound_prefab import SoundPrefabXmlReader
from lib.graphics.animation.animation_prefab import AnimationPrefabXmlReader, SubFileAnimationPrefabXmlReader, \
    SubAtlasAnimationPrefabXmlReader
from lib.graphics.camera.camera_effect_prefab import CameraEffectPrefabXmlReader, SubShakeCameraEffectPrefabXmlReader
from lib.graphics.color.color_prefab import ColorPrefabXmlReader, SubRgbColorPrefabXmlReader, \
    SubRgbaColorPrefabXmlReader, SubHexColorPrefabXmlReader
from lib.graphics.effect.effect_prefab import EffectPrefabXmlReader, SubAlphaEffectPrefabXmlReader, \
    SubTintEffectPrefabXmlReader, SubShaderEffectPrefabXmlReader
from lib.graphics.particles.particle_effect_prefab import ParticleEffectPrefabXmlReader, \
    SubFileParticleEffectPrefabXmlReader, SubAtlasParticleEffectPrefabXmlReader
from lib.graphics.shader.shader_program_prefab import ShaderProgramPrefabXmlReader
from lib.graphics.sprite.sprite_prefab import SpritePrefabXmlReader, SubFileSpritePrefabXmlReader, \
    SubAtlasSpritePrefabXmlReader
from lib.graphics.view.view_prefab import ViewPrefabXmlReader, SubSpriteViewPrefabXmlReader, \
    SubAnimationViewPrefabXmlReader, SubParticleEffectViewPrefabXmlReader
from lib.level.engine.entity.component.component_prefab import ComponentPrefabXmlReader, \
    SubCameraTrackComponentPrefabXmlReader, SubLeaveBonusComponentPrefabXmlReader, SubAmmoComponentPrefabXmlReader, \
    SubAutoShootComponentPrefabXmlReader, SubDamageComponentPrefabXmlReader, SubHealthComponentPrefabXmlReader, \
    SubHitComponentPrefabXmlReader, SubChangeBehaviorComponentPrefabXmlReader, SubDirectionComponentPrefabXmlReader, \
    SubRandomShootComponentPrefabXmlReader, SubProtectionComponentPrefabXmlReader, \
    SubRandomDirectionComponentPrefabXmlReader, SubEnemyComponentPrefabXmlReader, SubPlayerComponentPrefabXmlReader, \
    SubIdentityComponentPrefabXmlReader, SubInputComponentPrefabXmlReader, SubCreateComponentPrefabXmlReader, \
    SubDestroyComponentPrefabXmlReader, SubDestroyOnContactComponentPrefabXmlReader, \
    SubDestroyOnContactLostComponentPrefabXmlReader, SubLifetimeComponentPrefabXmlReader, \
    SubRandomCreateComponentPrefabXmlReader, SubAutoMoveComponentPrefabXmlReader, SubPhysicsComponentPrefabXmlReader, \
    SubAirplaneRenderLayerComponentPrefabXmlReader, SubBombRenderLayerComponentPrefabXmlReader, \
    SubBonusRenderLayerComponentPrefabXmlReader, SubBulletRenderLayerComponentPrefabXmlReader, \
    SubCloudRenderLayerComponentPrefabXmlReader, SubExplosionRenderLayerComponentPrefabXmlReader, \
    SubGroundRenderLayerComponentPrefabXmlReader, SubObstacleRenderLayerComponentPrefabXmlReader, \
    SubVehicleRenderLayerComponentPrefabXmlReader, SubViewComponentPrefabXmlReader, \
    SubAirplaneSpawnerComponentPrefabXmlReader, SubRespawnComponentPrefabXmlReader, \
    SubAutoSpawnerComponentPrefabXmlReader, SubStateComponentPrefabXmlReader, SubCreateTriggerComponentPrefabXmlReader, \
    SubDestroyTriggerComponentPrefabXmlReader, SubHitTriggerComponentPrefabXmlReader, SubSpeedComponentPrefabXmlReader, \
    SubSpeedModifierComponentPrefabXmlReader
from lib.level.engine.entity.entity_prefab import EntityPrefabXmlReader
from lib.level.engine.entity.entity_prefab_repository import EntityPrefabRepositoryXmlReader
from lib.level.engine.entity.entity_prefab_storage import EntityPrefabStorageFactory
from lib.level.event.entity_event_prefab import EntityEventPrefabXmlReader, SubAmmoLevelUpEntityEventPrefabXmlReader, \
    SubSpawnAirplaneEntityEventPrefabXmlReader, SubAddCameraEffectEntityEventPrefabXmlReader, \
    SubCreateEntityEventPrefabXmlReader, SubDestroyEntityEventPrefabXmlReader, \
    SubDestroyEntityByIdEntityEventPrefabXmlReader, SubDestroyFamilyEntityEventPrefabXmlReader, \
    SubAddLifeEntityEventPrefabXmlReader, SubAddMessageEntityEventPrefabXmlReader, \
    SubPlayMusicEntityEventPrefabXmlReader, SubChangeLevelStateEntityEventPrefabXmlReader, \
    SubActivateSpawnerEntityEventPrefabXmlReader, SubPlaySoundEntityEventPrefabXmlReader, \
    SubIncreasePointsMultiplierEntityEventPrefabXmlReader, SubAddPointsEntityEventPrefabXmlReader
from lib.level.preload.preload_data import PreloadDataXmlReader
from lib.level.utility.create.create_entry_prefab import CreateEntryPrefabXmlReader
from lib.level.utility.direction.direction import DirectionXmlReader
from lib.level.utility.stage.broker.message.message_prefab import MessagePrefabXmlReader
from lib.level.utility.state.state import StateXmlReader
from lib.physics.body.body_prefab import BodyPrefabXmlReader
from lib.physics.filter.filter_prefab import FilterPrefabXmlReader
from lib.physics.fixture.fixture_prefab import FixturePrefabXmlReader, HitBoxPrefabXmlReader, SensorPrefabXmlReader
from lib.physics.light.light_prefab import LightPrefabXmlReader, SubDirectionalLightPrefabXmlReader, \
    SubPointLightPrefabXmlReader, SubConeLightPrefabXmlReader, LightHandlerPrefabXmlReader
from lib.physics.shape.shape_prefab import ShapePrefabXmlReader, SubRectangleShapePrefabXmlReader, \
    SubCircleShapePrefabXmlReader, SubPolygonShapePrefabXmlReader, VertexPrefabXmlReader, SubChainShapePrefabXmlReader
from lib.utility.surface.position.position_prefab import PositionPrefabXmlReader


class ContextComponents(object):
    @staticmethod
    def init_position_prefab_xml_reader(components):
        return "PositionPrefabXmlReader", PositionPrefabXmlReader()

    @staticmethod
    def init_sound_prefab_xml_reader(components):
        return "SoundPrefabXmlReader", SoundPrefabXmlReader()

    @staticmethod
    def init_music_prefab_xml_reader(components):
        return "MusicPrefabXmlReader", MusicPrefabXmlReader()

    @staticmethod
    def init_shader_program_xml_reader(components):
        return "ShaderProgramXmlReader", ShaderProgramPrefabXmlReader()

    @staticmethod
    def init_animation_prefab_xml_reader(components):
        return "AnimationPrefabXmlReader", AnimationPrefabXmlReader([
            SubFileAnimationPrefabXmlReader(),
            SubAtlasAnimationPrefabXmlReader()
        ])

    @staticmethod
    def init_camera_effect_prefab_xml_reader(components):
        return "CameraEffectPrefabXmlReader", CameraEffectPrefabXmlReader([
            SubShakeCameraEffectPrefabXmlReader()
        ])

    @staticmethod
    def init_color_prefab_xml_reader(components):
        return "ColorPrefabXmlReader", ColorPrefabXmlReader([
            SubRgbColorPrefabXmlReader(),
            SubRgbaColorPrefabXmlReader(),
            SubHexColorPrefabXmlReader()
        ])

    @staticmethod
    def init_effect_prefab_xml_reader(components):
        return "EffectPrefabXmlReader", EffectPrefabXmlReader([
            SubAlphaEffectPrefabXmlReader(),
            SubTintEffectPrefabXmlReader(components["ColorPrefabXmlReader"]),
            SubShaderEffectPrefabXmlReader(components["ShaderProgramXmlReader"])
        ])

    @staticmethod
    def init_particle_effect_prefab_xml_reader(components):
        return "ParticleEffectPrefabXmlReader", ParticleEffectPrefabXmlReader([
            SubFileParticleEffectPrefabXmlReader(),
            SubAtlasParticleEffectPrefabXmlReader()
        ])

    @staticmethod
    def init_sprite_prefab_xml_reader(components):
        return "SpritePrefabXmlReader", SpritePrefabXmlReader([
            SubFileSpritePrefabXmlReader(),
            SubAtlasSpritePrefabXmlReader()
        ])

    @staticmethod
    def init_view_prefab_xml_reader(components):
        return "ViewPrefabXmlReader", ViewPrefabXmlReader([
            SubSpriteViewPrefabXmlReader(components["PositionPrefabXmlReader"],
                                         components["SpritePrefabXmlReader"]),
            SubAnimationViewPrefabXmlReader(components["PositionPrefabXmlReader"],
                                            components["AnimationPrefabXmlReader"]),
            SubParticleEffectViewPrefabXmlReader(components["PositionPrefabXmlReader"],
                                                 components["ParticleEffectPrefabXmlReader"])
        ])

    @staticmethod
    def init_body_prefab_xml_reader(components):
        return "BodyPrefabXmlReader", BodyPrefabXmlReader()

    @staticmethod
    def init_vertex_prefab_xml_reader(components):
        return "VertexPrefabXmlReader", VertexPrefabXmlReader()

    @staticmethod
    def init_shape_prefab_xml_reader(components):
        return "ShapePrefabXmlReader", ShapePrefabXmlReader([
            SubRectangleShapePrefabXmlReader(components["PositionPrefabXmlReader"]),
            SubCircleShapePrefabXmlReader(components["PositionPrefabXmlReader"]),
            SubPolygonShapePrefabXmlReader(components["PositionPrefabXmlReader"], components["VertexPrefabXmlReader"]),
            SubChainShapePrefabXmlReader(components["PositionPrefabXmlReader"], components["VertexPrefabXmlReader"])
        ])

    @staticmethod
    def init_filter_prefab_xml_reader(components):
        return "FilterPrefabXmlReader", FilterPrefabXmlReader()

    @staticmethod
    def init_fixture_prefab_xml_reader(components):
        return "FixturePrefabXmlReader", FixturePrefabXmlReader(
            components["FilterPrefabXmlReader"], components["ShapePrefabXmlReader"])

    @staticmethod
    def init_hit_box_prefab_xml_reader(components):
        return "HitBoxPrefabXmlReader", HitBoxPrefabXmlReader(components["FixturePrefabXmlReader"])

    @staticmethod
    def init_sensor_prefab_xml_reader(components):
        return "SensorPrefabXmlReader", SensorPrefabXmlReader(components["FixturePrefabXmlReader"])

    @staticmethod
    def init_light_prefab_xml_reader(components):
        return "LightPrefabXmlReader", LightPrefabXmlReader([
            SubDirectionalLightPrefabXmlReader(components["ColorPrefabXmlReader"]),
            SubPointLightPrefabXmlReader(components["ColorPrefabXmlReader"],
                                         components["PositionPrefabXmlReader"]),
            SubConeLightPrefabXmlReader(components["ColorPrefabXmlReader"],
                                        components["PositionPrefabXmlReader"])
        ])

    @staticmethod
    def init_light_handler_prefab_xml_reader(components):
        return "LightHandlerPrefabXmlReader", LightHandlerPrefabXmlReader(components["LightPrefabXmlReader"])

    @staticmethod
    def init_create_entry_prefab_xml_reader(components):
        return "CreateEntryPrefabXmlReader", CreateEntryPrefabXmlReader(components["PositionPrefabXmlReader"])

    @staticmethod
    def init_direction_xml_reader(components):
        return "DirectionXmlReader", DirectionXmlReader()

    @staticmethod
    def init_state_xml_reader(components):
        return "StateXmlReader", StateXmlReader()

    @staticmethod
    def init_message_prefab_xml_reader(components):
        return "MessagePrefabXmlReader", MessagePrefabXmlReader()

    @staticmethod
    def init_entity_event_prefab_xml_reader(components):
        return "EntityEventPrefabXmlReader", EntityEventPrefabXmlReader([
            SubAmmoLevelUpEntityEventPrefabXmlReader(),
            SubSpawnAirplaneEntityEventPrefabXmlReader(),
            SubAddCameraEffectEntityEventPrefabXmlReader(components["CameraEffectPrefabXmlReader"]),
            SubCreateEntityEventPrefabXmlReader(components["CreateEntryPrefabXmlReader"]),
            SubDestroyEntityEventPrefabXmlReader(),
            SubDestroyEntityByIdEntityEventPrefabXmlReader(),
            SubDestroyFamilyEntityEventPrefabXmlReader(),
            SubAddLifeEntityEventPrefabXmlReader(),
            SubAddMessageEntityEventPrefabXmlReader(components["MessagePrefabXmlReader"]),
            SubPlayMusicEntityEventPrefabXmlReader(components["MusicPrefabXmlReader"]),
            SubAddPointsEntityEventPrefabXmlReader(),
            SubIncreasePointsMultiplierEntityEventPrefabXmlReader(),
            SubPlaySoundEntityEventPrefabXmlReader(components["SoundPrefabXmlReader"]),
            SubActivateSpawnerEntityEventPrefabXmlReader(),
            SubChangeLevelStateEntityEventPrefabXmlReader()
        ])

    @staticmethod
    def init_component_prefab_xml_reader(components):
        return "ComponentPrefabXmlReader", ComponentPrefabXmlReader([
            SubCameraTrackComponentPrefabXmlReader(components["PositionPrefabXmlReader"]),
            SubLeaveBonusComponentPrefabXmlReader(),
            SubAmmoComponentPrefabXmlReader(),
            SubAutoShootComponentPrefabXmlReader(),
            SubDamageComponentPrefabXmlReader(),
            SubHealthComponentPrefabXmlReader(),
            SubHitComponentPrefabXmlReader(components["EffectPrefabXmlReader"]),
            SubProtectionComponentPrefabXmlReader(),
            SubRandomShootComponentPrefabXmlReader(),
            SubDirectionComponentPrefabXmlReader(components["DirectionXmlReader"]),
            SubChangeBehaviorComponentPrefabXmlReader(
                ComponentPrefabXmlReader([
                    SubSpeedModifierComponentPrefabXmlReader(),
                    SubDirectionComponentPrefabXmlReader(components["DirectionXmlReader"])
                ])
            ),
            SubRandomDirectionComponentPrefabXmlReader(components["DirectionXmlReader"]),
            SubEnemyComponentPrefabXmlReader(),
            SubPlayerComponentPrefabXmlReader(),
            SubIdentityComponentPrefabXmlReader(),
            SubInputComponentPrefabXmlReader(),
            SubCreateComponentPrefabXmlReader(),
            SubDestroyComponentPrefabXmlReader(),
            SubDestroyOnContactComponentPrefabXmlReader(),
            SubDestroyOnContactLostComponentPrefabXmlReader(),
            SubLifetimeComponentPrefabXmlReader(),
            SubRandomCreateComponentPrefabXmlReader(components["CreateEntryPrefabXmlReader"]),
            SubAutoMoveComponentPrefabXmlReader(),
            SubPhysicsComponentPrefabXmlReader(components["BodyPrefabXmlReader"],
                                               components["HitBoxPrefabXmlReader"],
                                               components["SensorPrefabXmlReader"],
                                               components["LightHandlerPrefabXmlReader"]),
            SubAirplaneRenderLayerComponentPrefabXmlReader(),
            SubBombRenderLayerComponentPrefabXmlReader(),
            SubBonusRenderLayerComponentPrefabXmlReader(),
            SubBulletRenderLayerComponentPrefabXmlReader(),
            SubCloudRenderLayerComponentPrefabXmlReader(),
            SubExplosionRenderLayerComponentPrefabXmlReader(),
            SubGroundRenderLayerComponentPrefabXmlReader(),
            SubObstacleRenderLayerComponentPrefabXmlReader(),
            SubVehicleRenderLayerComponentPrefabXmlReader(),
            SubViewComponentPrefabXmlReader(components["ViewPrefabXmlReader"]),
            SubAirplaneSpawnerComponentPrefabXmlReader(),
            SubRespawnComponentPrefabXmlReader(),
            SubAutoSpawnerComponentPrefabXmlReader(),
            SubStateComponentPrefabXmlReader(components["StateXmlReader"]),
            SubCreateTriggerComponentPrefabXmlReader(components["EntityEventPrefabXmlReader"]),
            SubDestroyTriggerComponentPrefabXmlReader(components["EntityEventPrefabXmlReader"]),
            SubHitTriggerComponentPrefabXmlReader(components["EntityEventPrefabXmlReader"]),
            SubSpeedComponentPrefabXmlReader(),
            SubSpeedModifierComponentPrefabXmlReader()
        ])

    @staticmethod
    def init_preload_data_xml_reader(components):
        return "PreloadDataXmlReader", PreloadDataXmlReader()

    @staticmethod
    def init_entity_prefab_repository_xml_reader(components):
        return "EntityPrefabRepositoryXmlReader", EntityPrefabRepositoryXmlReader()

    @staticmethod
    def init_entity_prefab_xml_reader(components):
        return "EntityPrefabXmlReader", EntityPrefabXmlReader(components["PreloadDataXmlReader"],
                                                              components["ComponentPrefabXmlReader"])

    @staticmethod
    def init_entity_prefab_storage_factory(components):
        return "EntityPrefabStorageFactory", EntityPrefabStorageFactory(components["EntityPrefabXmlReader"])

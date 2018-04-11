from lib.application.generator.layout.layout_html_generator import LayoutHtmlGenerator
from lib.application.generator.pages.parts.footer_html_generator import FooterHtmlGenerator
from lib.application.generator.pages.parts.header_html_generator import HeaderHtmlGenerator
from lib.application.generator.pages.parts.menu_entity_prefabs_html_generator import MenuEntityPrefabsHtmlGenerator
from lib.application.generator.pages.parts.menu_html_generator import MenuHtmlGenerator
from lib.audio.music.music_prefab_html_generator import MusicPrefabHtmlGenerator
from lib.audio.music.music_prefab_xml_reader import MusicPrefabXmlReader
from lib.audio.sound.sound_prefab_html_generator import SoundPrefabHtmlGenerator
from lib.audio.sound.sound_prefab_xml_reader import SoundPrefabXmlReader
from lib.graphics.animation.animation_prefab_html_generator import AnimationPrefabHtmlGenerator, \
    SubFileAnimationPrefabHtmlGenerator, SubAtlasAnimationPrefabHtmlGenerator
from lib.graphics.animation.animation_prefab_xml_reader import AnimationPrefabXmlReader, \
    SubFileAnimationPrefabXmlReader, SubAtlasAnimationPrefabXmlReader
from lib.graphics.camera.camera_effect_prefab_html_generator import CameraEffectPrefabHtmlGenerator, \
    SubShakeCameraEffectPrefabHtmlGenerator
from lib.graphics.camera.camera_effect_prefab_xml_reader import CameraEffectPrefabXmlReader, \
    SubShakeCameraEffectPrefabXmlReader
from lib.graphics.color.color_prefab_html_generator import ColorPrefabHtmlGenerator, SubRgbColorPrefabHtmlGenerator, \
    SubRgbaColorPrefabHtmlGenerator, SubHexColorPrefabHtmlGenerator
from lib.graphics.color.color_prefab_xml_reader import ColorPrefabXmlReader, SubRgbColorPrefabXmlReader, \
    SubRgbaColorPrefabXmlReader, SubHexColorPrefabXmlReader
from lib.graphics.effect.effect_prefab_html_generator import EffectPrefabHtmlGenerator, \
    SubTintEffectPrefabHtmlGenerator, SubShaderEffectPrefabHtmlGenerator, SubAlphaEffectPrefabHtmlGenerator
from lib.graphics.effect.effect_prefab_xml_reader import EffectPrefabXmlReader, SubAlphaEffectPrefabXmlReader, \
    SubTintEffectPrefabXmlReader, SubShaderEffectPrefabXmlReader
from lib.graphics.image.image_html_generator import ImageHtmlGenerator
from lib.graphics.particles.particle_effect_prefab_html_generator import ParticleEffectPrefabHtmlGenerator, \
    SubFileParticleEffectPrefabHtmlGenerator, SubAtlasParticleEffectPrefabHtmlGenerator
from lib.graphics.particles.particle_effect_prefab_xml_reader import ParticleEffectPrefabXmlReader, \
    SubFileParticleEffectPrefabXmlReader, SubAtlasParticleEffectPrefabXmlReader
from lib.graphics.shader.shader_program_prefab_html_generator import ShaderProgramPrefabHtmlGenerator
from lib.graphics.shader.shader_program_prefab_xml_reader import ShaderProgramPrefabXmlReader
from lib.graphics.sprite.sprite_prefab_html_generator import SpritePrefabHtmlGenerator, \
    SubFileSpritePrefabHtmlGenerator, SubAtlasSpritePrefabHtmlGenerator
from lib.graphics.sprite.sprite_prefab_xml_reader import SpritePrefabXmlReader, SubFileSpritePrefabXmlReader, \
    SubAtlasSpritePrefabXmlReader
from lib.graphics.texture.texture_atlas_reader import TextureAtlasReader
from lib.graphics.texture.texture_atlas_unpacker import TextureAtlasUnpacker
from lib.graphics.view.view_prefab_html_generator import ViewPrefabHtmlGenerator, SubSpriteViewPrefabHtmlGenerator, \
    SubAnimationViewPrefabHtmlGenerator, SubParticleEffectViewPrefabHtmlGenerator
from lib.graphics.view.view_prefab_xml_reader import ViewPrefabXmlReader, SubSpriteViewPrefabXmlReader, \
    SubAnimationViewPrefabXmlReader, SubParticleEffectViewPrefabXmlReader
from lib.html.html import HtmlGenerator
from lib.level.engine.entity.component.component_prefab_html_generator import ComponentPrefabHtmlGenerator, \
    SubSpeedComponentPrefabHtmlGenerator, SubSpeedModifierComponentPrefabHtmlGenerator, \
    SubCameraTrackComponentPrefabHtmlGenerator, SubLeaveBonusComponentPrefabHtmlGenerator, \
    SubAmmoComponentPrefabHtmlGenerator, SubAutoShootComponentPrefabHtmlGenerator, \
    SubDamageComponentPrefabHtmlGenerator, SubHealthComponentPrefabHtmlGenerator, SubHitComponentPrefabHtmlGenerator, \
    SubProtectionComponentPrefabHtmlGenerator, SubRandomShootComponentPrefabHtmlGenerator, \
    SubDirectionComponentPrefabHtmlGenerator, SubChangeBehaviorComponentPrefabHtmlGenerator, \
    SubRandomDirectionComponentPrefabHtmlGenerator, SubEnemyComponentPrefabHtmlGenerator, \
    SubPlayerComponentPrefabHtmlGenerator, SubIdentityComponentPrefabHtmlGenerator, \
    SubInputComponentPrefabHtmlGenerator, SubCreateComponentPrefabHtmlGenerator, SubDestroyComponentPrefabHtmlGenerator, \
    SubDestroyOnContactComponentPrefabHtmlGenerator, SubDestroyOnContactLostComponentPrefabHtmlGenerator, \
    SubLifetimeComponentPrefabHtmlGenerator, SubRandomCreateComponentPrefabHtmlGenerator, \
    SubAutoMoveComponentPrefabHtmlGenerator, SubPhysicsComponentPrefabHtmlGenerator, \
    SubAirplaneRenderLayerComponentPrefabHtmlGenerator, SubBombRenderLayerComponentPrefabHtmlGenerator, \
    SubBonusRenderLayerComponentPrefabHtmlGenerator, SubBulletRenderLayerComponentPrefabHtmlGenerator, \
    SubCloudRenderLayerComponentPrefabHtmlGenerator, SubExplosionRenderLayerComponentPrefabHtmlGenerator, \
    SubGroundRenderLayerComponentPrefabHtmlGenerator, SubObstacleRenderLayerComponentPrefabHtmlGenerator, \
    SubVehicleRenderLayerComponentPrefabHtmlGenerator, SubViewComponentPrefabHtmlGenerator, \
    SubAirplaneSpawnerComponentPrefabHtmlGenerator, SubRespawnComponentPrefabHtmlGenerator, \
    SubAutoSpawnerComponentPrefabHtmlGenerator, SubStateComponentPrefabHtmlGenerator, \
    SubCreateTriggerComponentPrefabHtmlGenerator, SubDestroyTriggerComponentPrefabHtmlGenerator, \
    SubHitTriggerComponentPrefabHtmlGenerator
from lib.level.engine.entity.component.component_prefab_xml_reader import ComponentPrefabXmlReader, \
    SubSpeedComponentPrefabXmlReader, SubSpeedModifierComponentPrefabXmlReader, SubCameraTrackComponentPrefabXmlReader, \
    SubLeaveBonusComponentPrefabXmlReader, SubAmmoComponentPrefabXmlReader, SubAutoShootComponentPrefabXmlReader, \
    SubDamageComponentPrefabXmlReader, SubHealthComponentPrefabXmlReader, SubHitComponentPrefabXmlReader, \
    SubProtectionComponentPrefabXmlReader, SubRandomShootComponentPrefabXmlReader, SubDirectionComponentPrefabXmlReader, \
    SubChangeBehaviorComponentPrefabXmlReader, SubRandomDirectionComponentPrefabXmlReader, \
    SubEnemyComponentPrefabXmlReader, SubPlayerComponentPrefabXmlReader, SubIdentityComponentPrefabXmlReader, \
    SubInputComponentPrefabXmlReader, SubCreateComponentPrefabXmlReader, SubDestroyComponentPrefabXmlReader, \
    SubDestroyOnContactComponentPrefabXmlReader, SubDestroyOnContactLostComponentPrefabXmlReader, \
    SubLifetimeComponentPrefabXmlReader, SubRandomCreateComponentPrefabXmlReader, SubAutoMoveComponentPrefabXmlReader, \
    SubPhysicsComponentPrefabXmlReader, SubAirplaneRenderLayerComponentPrefabXmlReader, \
    SubBombRenderLayerComponentPrefabXmlReader, SubBonusRenderLayerComponentPrefabXmlReader, \
    SubBulletRenderLayerComponentPrefabXmlReader, SubCloudRenderLayerComponentPrefabXmlReader, \
    SubExplosionRenderLayerComponentPrefabXmlReader, SubGroundRenderLayerComponentPrefabXmlReader, \
    SubObstacleRenderLayerComponentPrefabXmlReader, SubVehicleRenderLayerComponentPrefabXmlReader, \
    SubViewComponentPrefabXmlReader, SubAirplaneSpawnerComponentPrefabXmlReader, SubRespawnComponentPrefabXmlReader, \
    SubAutoSpawnerComponentPrefabXmlReader, SubStateComponentPrefabXmlReader, SubCreateTriggerComponentPrefabXmlReader, \
    SubDestroyTriggerComponentPrefabXmlReader, SubHitTriggerComponentPrefabXmlReader
from lib.level.engine.entity.entity_prefab_html_generator import EntityPrefabHtmlGenerator
from lib.level.engine.entity.entity_prefab_repository import EntityPrefabRepositoryXmlReader
from lib.level.engine.entity.entity_prefab_storage import EntityPrefabStorageFactory
from lib.level.engine.entity.entity_prefab_xml_reader import EntityPrefabXmlReader
from lib.level.event.entity_event_prefab_html_generator import EntityEventPrefabHtmlGenerator, \
    SubAmmoLevelUpEntityEventPrefabHtmlGenerator, SubSpawnAirplaneEntityEventPrefabHtmlGenerator, \
    SubAddCameraEffectEntityEventPrefabHtmlGenerator, SubCreateEntityEventPrefabHtmlGenerator, \
    SubDestroyEntityEventPrefabHtmlGenerator, SubDestroyEntityByIdEntityEventPrefabHtmlGenerator, \
    SubDestroyFamilyEntityEventPrefabHtmlGenerator, SubAddLifeEntityEventPrefabHtmlGenerator, \
    SubAddMessageEntityEventPrefabHtmlGenerator, SubPlayMusicEntityEventPrefabHtmlGenerator, \
    SubAddPointsEntityEventPrefabHtmlGenerator, SubIncreasePointsMultiplierEntityEventPrefabHtmlGenerator, \
    SubPlaySoundEntityEventPrefabHtmlGenerator, SubActivateSpawnerEntityEventPrefabHtmlGenerator, \
    SubChangeLevelStateEntityEventPrefabHtmlGenerator, SubRandomCreateEntityEventPrefabHtmlGenerator
from lib.level.event.entity_event_prefab_xml_reader import EntityEventPrefabXmlReader, \
    SubAmmoLevelUpEntityEventPrefabXmlReader, SubSpawnAirplaneEntityEventPrefabXmlReader, \
    SubAddCameraEffectEntityEventPrefabXmlReader, SubCreateEntityEventPrefabXmlReader, \
    SubDestroyEntityEventPrefabXmlReader, SubDestroyEntityByIdEntityEventPrefabXmlReader, \
    SubDestroyFamilyEntityEventPrefabXmlReader, SubAddLifeEntityEventPrefabXmlReader, \
    SubAddMessageEntityEventPrefabXmlReader, SubPlayMusicEntityEventPrefabXmlReader, \
    SubAddPointsEntityEventPrefabXmlReader, SubIncreasePointsMultiplierEntityEventPrefabXmlReader, \
    SubPlaySoundEntityEventPrefabXmlReader, SubActivateSpawnerEntityEventPrefabXmlReader, \
    SubChangeLevelStateEntityEventPrefabXmlReader, SubRandomCreateEntityEventPrefabXmlReader
from lib.level.preload.preload_data_html_generator import PreloadDataHtmlGenerator
from lib.level.preload.preload_data_xml_reader import PreloadDataXmlReader
from lib.level.utility.create.create_entry_prefab_html_generator import CreateEntryPrefabHtmlGenerator
from lib.level.utility.create.create_entry_prefab_xml_reader import CreateEntryPrefabXmlReader
from lib.level.utility.direction.direction_xml_reader import DirectionXmlReader
from lib.level.utility.stage.broker.message.message_prefab_html_generator import MessagePrefabHtmlGenerator
from lib.level.utility.stage.broker.message.message_prefab_xml_reader import MessagePrefabXmlReader
from lib.level.utility.state.state_xml_reader import StateXmlReader
from lib.physics.body.body_prefab_html_generator import BodyPrefabHtmlGenerator
from lib.physics.body.body_prefab_xml_reader import BodyPrefabXmlReader
from lib.physics.filter.filter_prefab_html_generator import FilterPrefabHtmlGenerator
from lib.physics.filter.filter_prefab_xml_reader import FilterPrefabXmlReader
from lib.physics.fixture.fixture_prefab_html_generator import FixturePrefabHtmlGenerator
from lib.physics.fixture.fixture_prefab_xml_reader import FixturePrefabXmlReader
from lib.physics.fixture.hit_box_prefab_html_generator import HitBoxPrefabHtmlGenerator
from lib.physics.fixture.hit_box_prefab_xml_reader import HitBoxPrefabXmlReader
from lib.physics.fixture.sensor_prefab_html_generator import SensorPrefabHtmlGenerator
from lib.physics.fixture.sensor_prefab_xml_reader import SensorPrefabXmlReader
from lib.physics.light.light_handler_prefab_html_generator import LightHandlerPrefabHtmlGenerator
from lib.physics.light.light_handler_prefab_xml_reader import LightHandlerPrefabXmlReader
from lib.physics.light.light_prefab_html_generator import LightPrefabHtmlGenerator, \
    SubDirectionalLightPrefabHtmlGenerator, SubPointLightPrefabHtmlGenerator, SubConeLightPrefabHtmlGenerator
from lib.physics.light.light_prefab_xml_reader import LightPrefabXmlReader, SubDirectionalLightPrefabXmlReader, \
    SubPointLightPrefabXmlReader, SubConeLightPrefabXmlReader
from lib.physics.shape.shape_prefab_html_generator import ShapePrefabHtmlGenerator, \
    SubRectangleShapePrefabHtmlGenerator, SubCircleShapePrefabHtmlGenerator, SubPolygonShapePrefabHtmlGenerator, \
    SubChainShapePrefabHtmlGenerator
from lib.physics.shape.shape_prefab_xml_reader import ShapePrefabXmlReader, SubRectangleShapePrefabXmlReader, \
    SubCircleShapePrefabXmlReader, SubPolygonShapePrefabXmlReader, SubChainShapePrefabXmlReader
from lib.physics.shape.vertex_prefab_html_generator import VertexPrefabHtmlGenerator
from lib.physics.shape.vertex_prefab_xml_reader import VertexPrefabXmlReader
from lib.utility.surface.position.position_prefab_html_generator import PositionPrefabHtmlGenerator
from lib.utility.surface.position.position_prefab_xml_reader import PositionPrefabXmlReader


class ContextComponents(object):
    @staticmethod
    def init_image_html_generator(components, configuration):
        return "ImageHtmlGenerator", ImageHtmlGenerator()

    @staticmethod
    def init_position_prefab_xml_reader(components, configuration):
        return "PositionPrefabXmlReader", PositionPrefabXmlReader()

    @staticmethod
    def init_position_prefab_html_generator(components, configuration):
        return "PositionPrefabHtmlGenerator", PositionPrefabHtmlGenerator()

    @staticmethod
    def init_sound_prefab_xml_reader(components, configuration):
        return "SoundPrefabXmlReader", SoundPrefabXmlReader()

    @staticmethod
    def init_sound_prefab_html_generator(components, configuration):
        return "SoundPrefabHtmlGenerator", SoundPrefabHtmlGenerator()

    @staticmethod
    def init_music_prefab_xml_reader(components, configuration):
        return "MusicPrefabXmlReader", MusicPrefabXmlReader()

    @staticmethod
    def init_music_prefab_html_generator(components, configuration):
        return "MusicPrefabHtmlGenerator", MusicPrefabHtmlGenerator()

    @staticmethod
    def init_shader_program_xml_reader(components, configuration):
        return "ShaderProgramXmlReader", ShaderProgramPrefabXmlReader()

    @staticmethod
    def init_shader_program_html_generator(components, configuration):
        return "ShaderProgramPrefabHtmlGenerator", ShaderProgramPrefabHtmlGenerator()

    @staticmethod
    def init_animation_prefab_xml_reader(components, configuration):
        return "AnimationPrefabXmlReader", AnimationPrefabXmlReader([
            SubFileAnimationPrefabXmlReader(),
            SubAtlasAnimationPrefabXmlReader()
        ])

    @staticmethod
    def init_animation_prefab_html_generator(components, configuration):
        return "AnimationPrefabHtmlGenerator", AnimationPrefabHtmlGenerator([
            SubFileAnimationPrefabHtmlGenerator(),
            SubAtlasAnimationPrefabHtmlGenerator()
        ])

    @staticmethod
    def init_camera_effect_prefab_xml_reader(components, configuration):
        return "CameraEffectPrefabXmlReader", CameraEffectPrefabXmlReader([
            SubShakeCameraEffectPrefabXmlReader()
        ])

    @staticmethod
    def init_camera_effect_prefab_html_generator(components, configuration):
        return "CameraEffectPrefabHtmlGenerator", CameraEffectPrefabHtmlGenerator([
            SubShakeCameraEffectPrefabHtmlGenerator()
        ])

    @staticmethod
    def init_color_prefab_xml_reader(components, configuration):
        return "ColorPrefabXmlReader", ColorPrefabXmlReader([
            SubRgbColorPrefabXmlReader(),
            SubRgbaColorPrefabXmlReader(),
            SubHexColorPrefabXmlReader()
        ])

    @staticmethod
    def init_color_prefab_html_generator(components, configuration):
        return "ColorPrefabHtmlGenerator", ColorPrefabHtmlGenerator([
            SubRgbColorPrefabHtmlGenerator(),
            SubRgbaColorPrefabHtmlGenerator(),
            SubHexColorPrefabHtmlGenerator()
        ])

    @staticmethod
    def init_effect_prefab_xml_reader(components, configuration):
        return "EffectPrefabXmlReader", EffectPrefabXmlReader([
            SubAlphaEffectPrefabXmlReader(),
            SubTintEffectPrefabXmlReader(components["ColorPrefabXmlReader"]),
            SubShaderEffectPrefabXmlReader(components["ShaderProgramXmlReader"])
        ])

    @staticmethod
    def init_effect_prefab_html_generator(components, configuration):
        return "EffectPrefabHtmlGenerator", EffectPrefabHtmlGenerator([
            SubTintEffectPrefabHtmlGenerator(components["ColorPrefabHtmlGenerator"]),
            SubShaderEffectPrefabHtmlGenerator(components["ShaderProgramPrefabHtmlGenerator"]),
            SubAlphaEffectPrefabHtmlGenerator()
        ])

    @staticmethod
    def init_particle_effect_prefab_xml_reader(components, configuration):
        return "ParticleEffectPrefabXmlReader", ParticleEffectPrefabXmlReader([
            SubFileParticleEffectPrefabXmlReader(),
            SubAtlasParticleEffectPrefabXmlReader()
        ])

    @staticmethod
    def init_particle_effect_prefab_html_generator(components, configuration):
        return "ParticleEffectPrefabHtmlGenerator", ParticleEffectPrefabHtmlGenerator([
            SubFileParticleEffectPrefabHtmlGenerator(),
            SubAtlasParticleEffectPrefabHtmlGenerator()
        ])

    @staticmethod
    def init_sprite_prefab_xml_reader(components, configuration):
        return "SpritePrefabXmlReader", SpritePrefabXmlReader([
            SubFileSpritePrefabXmlReader(),
            SubAtlasSpritePrefabXmlReader()
        ])

    @staticmethod
    def init_sprite_prefab_html_generator(components, configuration):
        return "SpritePrefabHtmlGenerator", SpritePrefabHtmlGenerator([
            SubFileSpritePrefabHtmlGenerator(),
            SubAtlasSpritePrefabHtmlGenerator()
        ])

    @staticmethod
    def init_view_prefab_xml_reader(components, configuration):
        return "ViewPrefabXmlReader", ViewPrefabXmlReader([
            SubSpriteViewPrefabXmlReader(components["PositionPrefabXmlReader"],
                                         components["SpritePrefabXmlReader"]),
            SubAnimationViewPrefabXmlReader(components["PositionPrefabXmlReader"],
                                            components["AnimationPrefabXmlReader"]),
            SubParticleEffectViewPrefabXmlReader(components["PositionPrefabXmlReader"],
                                                 components["ParticleEffectPrefabXmlReader"])
        ])

    @staticmethod
    def init_view_prefab_html_generator(components, configuration):
        return "ViewPrefabHtmlGenerator", ViewPrefabHtmlGenerator([
            SubSpriteViewPrefabHtmlGenerator(components["PositionPrefabHtmlGenerator"],
                                             components["SpritePrefabHtmlGenerator"]),
            SubAnimationViewPrefabHtmlGenerator(components["PositionPrefabHtmlGenerator"],
                                                components["AnimationPrefabHtmlGenerator"]),
            SubParticleEffectViewPrefabHtmlGenerator(components["PositionPrefabHtmlGenerator"],
                                                     components["ParticleEffectPrefabHtmlGenerator"])
        ])

    @staticmethod
    def init_body_prefab_xml_reader(components, configuration):
        return "BodyPrefabXmlReader", BodyPrefabXmlReader()

    @staticmethod
    def init_body_prefab_html_generator(components, configuration):
        return "BodyPrefabHtmlGenerator", BodyPrefabHtmlGenerator()

    @staticmethod
    def init_vertex_prefab_xml_reader(components, configuration):
        return "VertexPrefabXmlReader", VertexPrefabXmlReader()

    @staticmethod
    def init_vertex_prefab_html_generator(components, configuration):
        return "VertexPrefabHtmlGenerator", VertexPrefabHtmlGenerator()

    @staticmethod
    def init_shape_prefab_xml_reader(components, configuration):
        return "ShapePrefabXmlReader", ShapePrefabXmlReader([
            SubRectangleShapePrefabXmlReader(components["PositionPrefabXmlReader"]),
            SubCircleShapePrefabXmlReader(components["PositionPrefabXmlReader"]),
            SubPolygonShapePrefabXmlReader(components["PositionPrefabXmlReader"], components["VertexPrefabXmlReader"]),
            SubChainShapePrefabXmlReader(components["PositionPrefabXmlReader"], components["VertexPrefabXmlReader"])
        ])

    @staticmethod
    def init_shape_prefab_html_generator(components, configuration):
        return "ShapePrefabHtmlGenerator", ShapePrefabHtmlGenerator([
            SubRectangleShapePrefabHtmlGenerator(components["PositionPrefabHtmlGenerator"]),
            SubCircleShapePrefabHtmlGenerator(components["PositionPrefabHtmlGenerator"]),
            SubPolygonShapePrefabHtmlGenerator(components["PositionPrefabHtmlGenerator"],
                                               components["VertexPrefabHtmlGenerator"]),
            SubChainShapePrefabHtmlGenerator(components["PositionPrefabHtmlGenerator"],
                                             components["VertexPrefabHtmlGenerator"])
        ])

    @staticmethod
    def init_filter_prefab_xml_reader(components, configuration):
        return "FilterPrefabXmlReader", FilterPrefabXmlReader()

    @staticmethod
    def init_filter_prefab_html_generator(components, configuration):
        return "FilterPrefabHtmlGenerator", FilterPrefabHtmlGenerator()

    @staticmethod
    def init_fixture_prefab_xml_reader(components, configuration):
        return "FixturePrefabXmlReader", FixturePrefabXmlReader(
            components["FilterPrefabXmlReader"],
            components["ShapePrefabXmlReader"])

    @staticmethod
    def init_fixture_prefab_html_generator(components, configuration):
        return "FixturePrefabHtmlGenerator", FixturePrefabHtmlGenerator(
            components["ShapePrefabHtmlGenerator"],
            components["FilterPrefabHtmlGenerator"]
        )

    @staticmethod
    def init_hit_box_prefab_xml_reader(components, configuration):
        return "HitBoxPrefabXmlReader", HitBoxPrefabXmlReader(components["FixturePrefabXmlReader"])

    @staticmethod
    def init_hit_box_prefab_html_generator(components, configuration):
        return "HitBoxPrefabHtmlGenerator", HitBoxPrefabHtmlGenerator(components["FixturePrefabHtmlGenerator"])

    @staticmethod
    def init_sensor_prefab_xml_reader(components, configuration):
        return "SensorPrefabXmlReader", SensorPrefabXmlReader(components["FixturePrefabXmlReader"])

    @staticmethod
    def init_sensor_prefab_html_generator(components, configuration):
        return "SensorPrefabHtmlGenerator", SensorPrefabHtmlGenerator(components["FixturePrefabHtmlGenerator"])

    @staticmethod
    def init_light_prefab_xml_reader(components, configuration):
        return "LightPrefabXmlReader", LightPrefabXmlReader([
            SubDirectionalLightPrefabXmlReader(components["ColorPrefabXmlReader"]),
            SubPointLightPrefabXmlReader(components["ColorPrefabXmlReader"],
                                         components["PositionPrefabXmlReader"]),
            SubConeLightPrefabXmlReader(components["ColorPrefabXmlReader"],
                                        components["PositionPrefabXmlReader"])
        ])

    @staticmethod
    def init_light_prefab_html_generator(components, configuration):
        return "LightPrefabHtmlGenerator", LightPrefabHtmlGenerator([
            SubDirectionalLightPrefabHtmlGenerator(components["ColorPrefabHtmlGenerator"]),
            SubPointLightPrefabHtmlGenerator(components["ColorPrefabHtmlGenerator"],
                                             components["PositionPrefabHtmlGenerator"]),
            SubConeLightPrefabHtmlGenerator(components["ColorPrefabHtmlGenerator"],
                                            components["PositionPrefabHtmlGenerator"])
        ])

    @staticmethod
    def init_light_handler_prefab_xml_reader(components, configuration):
        return "LightHandlerPrefabXmlReader", LightHandlerPrefabXmlReader(components["LightPrefabXmlReader"])

    @staticmethod
    def init_light_handler_prefab_html_generator(components, configuration):
        return "LightHandlerPrefabHtmlGenerator", LightHandlerPrefabHtmlGenerator(
            components["LightPrefabHtmlGenerator"]
        )

    @staticmethod
    def init_create_entry_prefab_xml_reader(components, configuration):
        return "CreateEntryPrefabXmlReader", CreateEntryPrefabXmlReader(components["PositionPrefabXmlReader"])

    @staticmethod
    def init_create_entry_prefab_html_generator(components, configuration):
        return "CreateEntryPrefabHtmlGenerator", CreateEntryPrefabHtmlGenerator(
            components["PositionPrefabHtmlGenerator"])

    @staticmethod
    def init_direction_xml_reader(components, configuration):
        return "DirectionXmlReader", DirectionXmlReader()

    @staticmethod
    def init_state_xml_reader(components, configuration):
        return "StateXmlReader", StateXmlReader()

    @staticmethod
    def init_message_prefab_xml_reader(components, configuration):
        return "MessagePrefabXmlReader", MessagePrefabXmlReader()

    @staticmethod
    def init_message_prefab_html_generator(components, configuration):
        return "MessagePrefabHtmlGenerator", MessagePrefabHtmlGenerator()

    @staticmethod
    def init_entity_event_prefab_xml_reader(components, configuration):
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
            SubChangeLevelStateEntityEventPrefabXmlReader(),
            SubRandomCreateEntityEventPrefabXmlReader(components["CreateEntryPrefabXmlReader"])
        ])

    @staticmethod
    def init_entity_event_prefab_html_generator(components, configuration):
        return "EntityEventPrefabHtmlGenerator", EntityEventPrefabHtmlGenerator([
            SubAmmoLevelUpEntityEventPrefabHtmlGenerator(),
            SubSpawnAirplaneEntityEventPrefabHtmlGenerator(),
            SubAddCameraEffectEntityEventPrefabHtmlGenerator(components["CameraEffectPrefabHtmlGenerator"]),
            SubCreateEntityEventPrefabHtmlGenerator(components["CreateEntryPrefabHtmlGenerator"]),
            SubDestroyEntityEventPrefabHtmlGenerator(),
            SubDestroyEntityByIdEntityEventPrefabHtmlGenerator(),
            SubDestroyFamilyEntityEventPrefabHtmlGenerator(),
            SubAddLifeEntityEventPrefabHtmlGenerator(),
            SubAddMessageEntityEventPrefabHtmlGenerator(components["MessagePrefabHtmlGenerator"]),
            SubPlayMusicEntityEventPrefabHtmlGenerator(components["MusicPrefabHtmlGenerator"]),
            SubAddPointsEntityEventPrefabHtmlGenerator(),
            SubIncreasePointsMultiplierEntityEventPrefabHtmlGenerator(),
            SubPlaySoundEntityEventPrefabHtmlGenerator(components["SoundPrefabHtmlGenerator"]),
            SubActivateSpawnerEntityEventPrefabHtmlGenerator(),
            SubChangeLevelStateEntityEventPrefabHtmlGenerator(),
            SubRandomCreateEntityEventPrefabHtmlGenerator(components["CreateEntryPrefabHtmlGenerator"])
        ])

    @staticmethod
    def init_component_prefab_xml_reader(components, configuration):
        return "ComponentPrefabXmlReader", ComponentPrefabXmlReader([
            SubSpeedComponentPrefabXmlReader(),
            SubSpeedModifierComponentPrefabXmlReader(),
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
        ])

    @staticmethod
    def init_component_prefab_html_generator(components, configuration):
        return "ComponentPrefabHtmlGenerator", ComponentPrefabHtmlGenerator([
            SubSpeedComponentPrefabHtmlGenerator(),
            SubSpeedModifierComponentPrefabHtmlGenerator(),
            SubCameraTrackComponentPrefabHtmlGenerator(components["PositionPrefabHtmlGenerator"]),
            SubLeaveBonusComponentPrefabHtmlGenerator(),
            SubAmmoComponentPrefabHtmlGenerator(),
            SubAutoShootComponentPrefabHtmlGenerator(),
            SubDamageComponentPrefabHtmlGenerator(),
            SubHealthComponentPrefabHtmlGenerator(),
            SubHitComponentPrefabHtmlGenerator(components["EffectPrefabHtmlGenerator"]),
            SubProtectionComponentPrefabHtmlGenerator(),
            SubRandomShootComponentPrefabHtmlGenerator(),
            SubDirectionComponentPrefabHtmlGenerator(),
            SubChangeBehaviorComponentPrefabHtmlGenerator(
                ComponentPrefabHtmlGenerator([
                    SubSpeedModifierComponentPrefabHtmlGenerator(),
                    SubDirectionComponentPrefabHtmlGenerator()
                ])
            ),
            SubRandomDirectionComponentPrefabHtmlGenerator(),
            SubEnemyComponentPrefabHtmlGenerator(),
            SubPlayerComponentPrefabHtmlGenerator(),
            SubIdentityComponentPrefabHtmlGenerator(),
            SubInputComponentPrefabHtmlGenerator(),
            SubCreateComponentPrefabHtmlGenerator(),
            SubDestroyComponentPrefabHtmlGenerator(),
            SubDestroyOnContactComponentPrefabHtmlGenerator(),
            SubDestroyOnContactLostComponentPrefabHtmlGenerator(),
            SubLifetimeComponentPrefabHtmlGenerator(),
            SubRandomCreateComponentPrefabHtmlGenerator(components["CreateEntryPrefabHtmlGenerator"]),
            SubAutoMoveComponentPrefabHtmlGenerator(),
            SubPhysicsComponentPrefabHtmlGenerator(components["BodyPrefabHtmlGenerator"],
                                               components["HitBoxPrefabHtmlGenerator"],
                                               components["SensorPrefabHtmlGenerator"],
                                               components["LightHandlerPrefabHtmlGenerator"]),
            SubAirplaneRenderLayerComponentPrefabHtmlGenerator(),
            SubBombRenderLayerComponentPrefabHtmlGenerator(),
            SubBonusRenderLayerComponentPrefabHtmlGenerator(),
            SubBulletRenderLayerComponentPrefabHtmlGenerator(),
            SubCloudRenderLayerComponentPrefabHtmlGenerator(),
            SubExplosionRenderLayerComponentPrefabHtmlGenerator(),
            SubGroundRenderLayerComponentPrefabHtmlGenerator(),
            SubObstacleRenderLayerComponentPrefabHtmlGenerator(),
            SubVehicleRenderLayerComponentPrefabHtmlGenerator(),
            SubViewComponentPrefabHtmlGenerator(components["ViewPrefabHtmlGenerator"]),
            SubAirplaneSpawnerComponentPrefabHtmlGenerator(),
            SubRespawnComponentPrefabHtmlGenerator(),
            SubAutoSpawnerComponentPrefabHtmlGenerator(),
            SubStateComponentPrefabHtmlGenerator(),
            SubCreateTriggerComponentPrefabHtmlGenerator(components["EntityEventPrefabHtmlGenerator"]),
            SubDestroyTriggerComponentPrefabHtmlGenerator(components["EntityEventPrefabHtmlGenerator"]),
            SubHitTriggerComponentPrefabHtmlGenerator(components["EntityEventPrefabHtmlGenerator"]),
        ])

    @staticmethod
    def init_preload_data_xml_reader(components, configuration):
        return "PreloadDataXmlReader", PreloadDataXmlReader()

    @staticmethod
    def init_preload_data_html_generator(components, configuration):
        return "PreloadDataHtmlGenerator", PreloadDataHtmlGenerator()

    @staticmethod
    def init_entity_prefab_repository_xml_reader(components, configuration):
        return "EntityPrefabRepositoryXmlReader", EntityPrefabRepositoryXmlReader()

    @staticmethod
    def init_entity_prefab_xml_reader(components, configuration):
        return "EntityPrefabXmlReader", EntityPrefabXmlReader(components["PreloadDataXmlReader"],
                                                              components["ComponentPrefabXmlReader"])

    @staticmethod
    def init_entity_prefab_html_generator(components, configuration):
        return "EntityPrefabHtmlGenerator", EntityPrefabHtmlGenerator(
            components["PreloadDataHtmlGenerator"], components["ComponentPrefabHtmlGenerator"])

    @staticmethod
    def init_entity_prefab_storage_factory(components, configuration):
        return "EntityPrefabStorageFactory", EntityPrefabStorageFactory(components["EntityPrefabXmlReader"])

    @staticmethod
    def init_entity_prefab_repository(components, configuration):
        return "EntityPrefabRepository", components["EntityPrefabRepositoryXmlReader"].read_from_file(
            "{}/{}".format(
                configuration.get_option("source.directory"),
                configuration.get_option("entity.prefab.repository.filename")
            )
        )

    @staticmethod
    def init_entity_prefab_storage(components, configuration):
        return "EntityPrefabStorage", components["EntityPrefabStorageFactory"].create_entity_prefab_storage(
            components["EntityPrefabRepository"], configuration.get_option("source.directory")
        )

    @staticmethod
    def init_layout_html_generator(components, configuration):
        return "LayoutHtmlGenerator", LayoutHtmlGenerator(
            configuration.get_option("includes.css").split(";"),
            configuration.get_option("includes.js").split(";")
        )

    @staticmethod
    def init_texture_atlas_reader(components, configuration):
        return "TextureAtlasReader", TextureAtlasReader()

    @staticmethod
    def init_texture_atlas_unpacker(components, configuration):
        return "TextureAtlasUnpacker", TextureAtlasUnpacker(components["TextureAtlasReader"])

    @staticmethod
    def init_menu_entity_prefabs_html_generator(components, configuration):
        return "MenuEntityPrefabsHtmlGenerator", MenuEntityPrefabsHtmlGenerator()

    @staticmethod
    def init_footer_html_generator(components, configuration):
        return "FooterHtmlGenerator", FooterHtmlGenerator()

    @staticmethod
    def init_menu_html_generator(components, configuration):
        return "MenuHtmlGenerator", MenuHtmlGenerator()

    @staticmethod
    def init_header_html_generator(components, configuration):
        return "HeaderHtmlGenerator", HeaderHtmlGenerator()

    @staticmethod
    def init_html_generator(components, configuration):
        return "HtmlGenerator", HtmlGenerator()

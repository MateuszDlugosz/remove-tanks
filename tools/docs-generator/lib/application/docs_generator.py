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
from lib.graphics.texture.texture_atlas import TextureAtlasReader
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


class DocsGeneratorAssembler(object):
    def assembly(self):
        position_prefab_xml_reader = PositionPrefabXmlReader()

        sound_prefab_xml_reader = SoundPrefabXmlReader()
        music_prefab_xml_reader = MusicPrefabXmlReader()

        shader_program_prefab_xml_reader = ShaderProgramPrefabXmlReader()
        animation_prefab_xml_reader = AnimationPrefabXmlReader([
            SubFileAnimationPrefabXmlReader(),
            SubAtlasAnimationPrefabXmlReader()
        ])
        camera_effect_prefab_xml_reader = CameraEffectPrefabXmlReader([
            SubShakeCameraEffectPrefabXmlReader()
        ])
        color_prefab_xml_reader = ColorPrefabXmlReader([
            SubRgbColorPrefabXmlReader(),
            SubRgbaColorPrefabXmlReader(),
            SubHexColorPrefabXmlReader()
        ])
        effect_prefab_xml_reader = EffectPrefabXmlReader([
            SubAlphaEffectPrefabXmlReader(),
            SubTintEffectPrefabXmlReader(color_prefab_xml_reader),
            SubShaderEffectPrefabXmlReader(shader_program_prefab_xml_reader)
        ])
        particle_effect_prefab_xml_reader = ParticleEffectPrefabXmlReader([
            SubFileParticleEffectPrefabXmlReader(),
            SubAtlasParticleEffectPrefabXmlReader()
        ])
        sprite_prefab_xml_reader = SpritePrefabXmlReader([
            SubFileSpritePrefabXmlReader(),
            SubAtlasSpritePrefabXmlReader()
        ])
        texture_atlas_reader = TextureAtlasReader()
        view_prefab_xml_reader = ViewPrefabXmlReader([
            SubSpriteViewPrefabXmlReader(position_prefab_xml_reader, sprite_prefab_xml_reader),
            SubAnimationViewPrefabXmlReader(position_prefab_xml_reader, animation_prefab_xml_reader),
            SubParticleEffectViewPrefabXmlReader(position_prefab_xml_reader, particle_effect_prefab_xml_reader)
        ])

        body_prefab_xml_reader = BodyPrefabXmlReader()
        vertex_prefab_xml_reader = VertexPrefabXmlReader()
        shape_prefab_xml_reader = ShapePrefabXmlReader([
            SubRectangleShapePrefabXmlReader(position_prefab_xml_reader),
            SubCircleShapePrefabXmlReader(position_prefab_xml_reader),
            SubPolygonShapePrefabXmlReader(position_prefab_xml_reader, vertex_prefab_xml_reader),
            SubChainShapePrefabXmlReader(position_prefab_xml_reader, vertex_prefab_xml_reader)
        ])
        filter_prefab_xml_reader = FilterPrefabXmlReader()
        fixture_prefab_xml_reader = FixturePrefabXmlReader(filter_prefab_xml_reader, shape_prefab_xml_reader)
        hit_box_prefab_xml_reader = HitBoxPrefabXmlReader(fixture_prefab_xml_reader)
        sensor_prefab_xml_reader = SensorPrefabXmlReader(fixture_prefab_xml_reader)
        light_prefab_xml_reader = LightPrefabXmlReader([
            SubDirectionalLightPrefabXmlReader(color_prefab_xml_reader),
            SubPointLightPrefabXmlReader(color_prefab_xml_reader, position_prefab_xml_reader),
            SubConeLightPrefabXmlReader(color_prefab_xml_reader, position_prefab_xml_reader)
        ])
        light_handler_prefab_xml_reader = LightHandlerPrefabXmlReader(light_prefab_xml_reader)

        create_entry_prefab_xml_reader = CreateEntryPrefabXmlReader(position_prefab_xml_reader)
        direction_xml_reader = DirectionXmlReader()
        state_xml_reader = StateXmlReader()
        message_prefab_xml_reader = MessagePrefabXmlReader()

        entity_event_prefab_xml_reader = EntityEventPrefabXmlReader([
            SubAmmoLevelUpEntityEventPrefabXmlReader(),
            SubSpawnAirplaneEntityEventPrefabXmlReader(),
            SubAddCameraEffectEntityEventPrefabXmlReader(camera_effect_prefab_xml_reader),
            SubCreateEntityEventPrefabXmlReader(create_entry_prefab_xml_reader),
            SubDestroyEntityEventPrefabXmlReader(),
            SubDestroyEntityByIdEntityEventPrefabXmlReader(),
            SubDestroyFamilyEntityEventPrefabXmlReader(),
            SubAddLifeEntityEventPrefabXmlReader(),
            SubAddMessageEntityEventPrefabXmlReader(message_prefab_xml_reader),
            SubPlayMusicEntityEventPrefabXmlReader(music_prefab_xml_reader),
            SubAddPointsEntityEventPrefabXmlReader(),
            SubIncreasePointsMultiplierEntityEventPrefabXmlReader(),
            SubPlaySoundEntityEventPrefabXmlReader(sound_prefab_xml_reader),
            SubActivateSpawnerEntityEventPrefabXmlReader(),
            SubChangeLevelStateEntityEventPrefabXmlReader()
        ])

        component_prefab_xml_reader = ComponentPrefabXmlReader([
            SubCameraTrackComponentPrefabXmlReader(position_prefab_xml_reader),
            SubLeaveBonusComponentPrefabXmlReader(),
            SubAmmoComponentPrefabXmlReader(),
            SubAutoShootComponentPrefabXmlReader(),
            SubDamageComponentPrefabXmlReader(),
            SubHealthComponentPrefabXmlReader(),
            SubHitComponentPrefabXmlReader(effect_prefab_xml_reader),
            SubProtectionComponentPrefabXmlReader(),
            SubRandomShootComponentPrefabXmlReader(),
            SubDirectionComponentPrefabXmlReader(direction_xml_reader),
            SubChangeBehaviorComponentPrefabXmlReader(
                ComponentPrefabXmlReader([
                    SubSpeedModifierComponentPrefabXmlReader(),
                    SubDirectionComponentPrefabXmlReader(direction_xml_reader)
                ])
            ),
            SubRandomDirectionComponentPrefabXmlReader(direction_xml_reader),
            SubEnemyComponentPrefabXmlReader(),
            SubPlayerComponentPrefabXmlReader(),
            SubIdentityComponentPrefabXmlReader(),
            SubInputComponentPrefabXmlReader(),
            SubCreateComponentPrefabXmlReader(),
            SubDestroyComponentPrefabXmlReader(),
            SubDestroyOnContactComponentPrefabXmlReader(),
            SubDestroyOnContactLostComponentPrefabXmlReader(),
            SubLifetimeComponentPrefabXmlReader(),
            SubRandomCreateComponentPrefabXmlReader(create_entry_prefab_xml_reader),
            SubAutoMoveComponentPrefabXmlReader(),
            SubPhysicsComponentPrefabXmlReader(body_prefab_xml_reader, hit_box_prefab_xml_reader, sensor_prefab_xml_reader,
                                               light_handler_prefab_xml_reader),
            SubAirplaneRenderLayerComponentPrefabXmlReader(),
            SubBombRenderLayerComponentPrefabXmlReader(),
            SubBonusRenderLayerComponentPrefabXmlReader(),
            SubBulletRenderLayerComponentPrefabXmlReader(),
            SubCloudRenderLayerComponentPrefabXmlReader(),
            SubExplosionRenderLayerComponentPrefabXmlReader(),
            SubGroundRenderLayerComponentPrefabXmlReader(),
            SubObstacleRenderLayerComponentPrefabXmlReader(),
            SubVehicleRenderLayerComponentPrefabXmlReader(),
            SubViewComponentPrefabXmlReader(view_prefab_xml_reader),
            SubAirplaneSpawnerComponentPrefabXmlReader(),
            SubRespawnComponentPrefabXmlReader(),
            SubAutoSpawnerComponentPrefabXmlReader(),
            SubStateComponentPrefabXmlReader(state_xml_reader),
            SubCreateTriggerComponentPrefabXmlReader(entity_event_prefab_xml_reader),
            SubDestroyTriggerComponentPrefabXmlReader(entity_event_prefab_xml_reader),
            SubHitTriggerComponentPrefabXmlReader(entity_event_prefab_xml_reader),
            SubSpeedComponentPrefabXmlReader(),
            SubSpeedModifierComponentPrefabXmlReader()
        ])

        preload_data_xml_reader = PreloadDataXmlReader()

        entity_prefab_repository_xml_reader = EntityPrefabRepositoryXmlReader()
        entity_prefab_xml_reader = EntityPrefabXmlReader(preload_data_xml_reader, component_prefab_xml_reader)
        entity_prefab_storage_factory = EntityPrefabStorageFactory(entity_prefab_xml_reader)
        entity_prefab_repository = entity_prefab_repository_xml_reader.read_from_file("../../core/assets/prefabs/entities/entity-prefab-repository.xml")
        entity_prefab_storage_factory.create_entity_prefab_storage(entity_prefab_repository, "../../core/assets/")


class DocsGenerator:
    def __init__(self, assets_dir, target_dir, configuration):
        self.assets_dir = assets_dir
        self.target_dir = target_dir
        self.configuration = configuration

    def get_assets_dir(self):
        return self.assets_dir

    def get_target_dir(self):
        return self.target_dir

    def get_configuration(self):
        return self.configuration

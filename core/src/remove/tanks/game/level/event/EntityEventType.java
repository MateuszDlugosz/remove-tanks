package remove.tanks.game.level.event;

/**
 * @author Mateusz Długosz
 */
public enum EntityEventType {
    PlaySoundEntityEvent,
    PlayMusicEntityEvent,
    CreateEntityEvent,
    RandomCreateEntityEvent,
    DestroyEntityEvent,
    DestroyEntityByIdEntityEvent,
    DestroyFamilyEntityEvent,
    AddCameraEffectEntityEvent,
    AddPointsEntityEvent,
    AddLifeEntityEvent,
    RemoveLifeEntityEvent,
    AmmoLevelUpEntityEvent,
    IncreasePointsMultiplierEntityEvent,
    ResetPointsMultiplierEntityEvent,
    SpawnAirplaneEntityEvent,
    ChangeLevelStateEntityEvent,
    AddMessageEntityEvent,
    ClearMessagesEntityEvent,
    ActivateSpawnerEntityEvent,
    ActivateSystemEntityEvent,
    DeactivateSystemEntityEvent,
    AddWeatherEffectEntityEvent,
    ClearWeatherEffectsEntityEvent,
    RemoveWeatherEffectEntityEvent,
    ArtilleryShootEntityEvent
}

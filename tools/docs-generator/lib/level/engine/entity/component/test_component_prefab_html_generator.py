import unittest

from lib.graphics.color.color_prefab import HexColorPrefab
from lib.graphics.color.color_prefab_html_generator import ColorPrefabHtmlGenerator, SubHexColorPrefabHtmlGenerator
from lib.graphics.effect.effect_prefab import AlphaEffectPrefab
from lib.graphics.effect.effect_prefab_html_generator import EffectPrefabHtmlGenerator, \
    SubAlphaEffectPrefabHtmlGenerator
from lib.graphics.sprite.sprite_prefab import FileSpritePrefab
from lib.graphics.sprite.sprite_prefab_html_generator import SpritePrefabHtmlGenerator, SubFileSpritePrefabHtmlGenerator
from lib.graphics.view.view_prefab import SpriteViewPrefab
from lib.graphics.view.view_prefab_html_generator import ViewPrefabHtmlGenerator, SubSpriteViewPrefabHtmlGenerator
from lib.html.html import HtmlGenerator
from lib.level.engine.entity.component.component_prefab import InputComponentPrefab, StateComponentPrefab
from lib.level.engine.entity.component.component_prefab_html_generator import *
from lib.level.event.entity_event_prefab import DestroyEntityEventPrefab
from lib.level.event.entity_event_prefab_html_generator import EntityEventPrefabHtmlGenerator, \
    SubDestroyEntityEventPrefabHtmlGenerator
from lib.level.utility.create.create_entry_prefab import CreateEntryPrefab
from lib.level.utility.create.create_entry_prefab_html_generator import CreateEntryPrefabHtmlGenerator
from lib.physics.body.body_prefab import BodyPrefab
from lib.physics.body.body_prefab_html_generator import BodyPrefabHtmlGenerator
from lib.physics.filter.filter_prefab import FilterPrefab
from lib.physics.filter.filter_prefab_html_generator import FilterPrefabHtmlGenerator
from lib.physics.fixture.fixture_prefab import FixturePrefab
from lib.physics.fixture.fixture_prefab_html_generator import FixturePrefabHtmlGenerator
from lib.physics.fixture.hit_box_prefab import HitBoxPrefab
from lib.physics.fixture.hit_box_prefab_html_generator import HitBoxPrefabHtmlGenerator
from lib.physics.fixture.sensor_prefab import SensorPrefab
from lib.physics.fixture.sensor_prefab_html_generator import SensorPrefabHtmlGenerator
from lib.physics.light.light_handler_prefab import LightHandlerPrefab
from lib.physics.light.light_handler_prefab_html_generator import LightHandlerPrefabHtmlGenerator
from lib.physics.light.light_prefab import PointLightPrefab
from lib.physics.light.light_prefab_html_generator import LightPrefabHtmlGenerator, SubPointLightPrefabHtmlGenerator
from lib.physics.shape.shape_prefab import CircleShapePrefab
from lib.physics.shape.shape_prefab_html_generator import ShapePrefabHtmlGenerator, SubCircleShapePrefabHtmlGenerator
from lib.utility.surface.position.position_prefab import PositionPrefab
from lib.utility.surface.position.position_prefab_html_generator import PositionPrefabHtmlGenerator


class TestSubSpeedComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = SpeedComponentPrefab(10)
        html_generator = HtmlGenerator()
        sub_generator = SubSpeedComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Speedcomponent</h5><hr/><dl><dt>Speed</dt><dd>10.0</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubSpeedModifierComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = SpeedModifierComponentPrefab(10)
        html_generator = HtmlGenerator()
        sub_generator = SubSpeedModifierComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Speedmodifiercomponent</h5><hr/><dl><dt>Speedmodifier</dt>'
            '<dd>10.0</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubCameraTrackComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = CameraTrackComponentPrefab(1, PositionPrefab(1, 2))
        html_generator = HtmlGenerator()
        sub_generator = SubCameraTrackComponentPrefabHtmlGenerator(PositionPrefabHtmlGenerator())

        self.assertEqual(
            '<divclass="doc-component"><h5>Cameratrackcomponent</h5><hr/><dl><dt>Priority</dt><dd>1</dd><dt>'
            'Position</dt><dd><divclass="doc-position"><h6>Position</h6><hr/><dl><dt>X</dt><dd>1.0</dd><dt>Y'
            '</dt><dd>2.0</dd></dl></div></dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubLeaveBonusComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = LeaveBonusComponentPrefab(1)
        html_generator = HtmlGenerator()
        sub_generator = SubLeaveBonusComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Leavebonuscomponent</h5><hr/><dl><dt>Chancemodifier<'
            '/dt><dd>1.0</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAmmoComponentComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AmmoComponentPrefab(1, 2, {1: {"Left": "LeftBullet0", "Right": "RightBullet0"},
                                            2: {"Left": "LeftBullet1", "Right": "RightBullet1"}})
        html_generator = HtmlGenerator()
        sub_generator = SubAmmoComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Ammocomponent</h5><hr/><dt>Ammotable</dt><dd><table><tr><th>Level</th><th>'
            'EntityPrefabCodes</th></tr><tr><td>1</td><td><table><tr><th>Direction</th><th>Entityprefabcode</th></tr>'
            '<tr><td>Left</td><td>LeftBullet0</td></tr><tr><td>Right</td><td>RightBullet0</td></tr></table></td></tr>'
            '<tr><td>2</td><td><table><tr><th>Direction</th><th>Entityprefabcode</th></tr><tr><td>Left</td><td>'
            'LeftBullet1</td></tr><tr><td>Right</td><td>RightBullet1</td></tr></table></td></tr></table></dd><dl><dt>'
            'Currentlevel</dt><dd>1</dd><dt>Maxlevel</dt><dd>2</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAutoShootComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AutoShootComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubAutoShootComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Autoshootcomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDamageComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DamageComponentPrefab(2)
        html_generator = HtmlGenerator()
        sub_generator = SubDamageComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Damagecomponent</h5><hr/><dl><dt>Damage</dt><dd>2</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubHealthComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = HealthComponentPrefab(2, 6)
        html_generator = HtmlGenerator()
        sub_generator = SubHealthComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Healthcomponent</h5><hr/><dl><dt>Health</dt><dd>2</dd><dt>Maxhealth</dt>'
            '<dd>6</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubHitComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = HitComponentPrefab(AlphaEffectPrefab(1), 10)
        html_generator = HtmlGenerator()
        sub_generator = SubHitComponentPrefabHtmlGenerator(EffectPrefabHtmlGenerator(
            [SubAlphaEffectPrefabHtmlGenerator()]))

        self.assertEqual(
            '<divclass="doc-component"><h5>Hitcomponent</h5><hr/><dl><dt>Time</dt><dd>10.0</dd><dt>Effect</dt><dd>'
            '<divclass="doc-effect"><h6>Alphaeffect</h6><hr/><dl><dt>Alphavalue</dt><dd>1</dd></dl></div></dd></dl>'
            '</div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubProtectionComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ProtectionComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubProtectionComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Protectioncomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubRandomShootComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = RandomShootComponentPrefab(1, 2)
        html_generator = HtmlGenerator()
        sub_generator = SubRandomShootComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Randomshootcomponent</h5><hr/><dl><dt>Minshootfrequency</dt><dd>1.0</dd>'
            '<dt>Maxshootfrequency</dt><dd>2.0</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDirectionComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DirectionComponentPrefab("Left")
        html_generator = HtmlGenerator()
        sub_generator = SubDirectionComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Directioncomponent</h5><hr/><dl><dt>Direction</dt><dd>Left</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubChangeBehaviorComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html_valid(self):
        prefab = ChangeBehaviorComponentPrefab([SpeedComponentPrefab(1), DamageComponentPrefab(2)])
        html_generator = HtmlGenerator()
        sub_generator = SubChangeBehaviorComponentPrefabHtmlGenerator(ComponentPrefabHtmlGenerator([
            SubSpeedComponentPrefabHtmlGenerator(), SubDamageComponentPrefabHtmlGenerator()
        ]))

        self.assertEqual(
            '<divclass="doc-component"><h5>Changebehaviorcomponent</h5><hr/><dl><dt>Components</dt><dd>'
            '<divclass="doc-component"><h5>Speedcomponent</h5><hr/><dl><dt>Speed</dt><dd>1.0</dd></dl></div>'
            '<divclass="doc-component"><h5>Damagecomponent</h5><hr/><dl><dt>Damage</dt><dd>2</dd></dl></div>'
            '</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )

    def test_generate_html_invalid(self):
        prefab = ChangeBehaviorComponentPrefab([SpeedComponentPrefab(1), DamageComponentPrefab(2)])
        html_generator = HtmlGenerator()
        sub_generator = SubChangeBehaviorComponentPrefabHtmlGenerator(ComponentPrefabHtmlGenerator([
            SubSpeedComponentPrefabHtmlGenerator()
        ]))

        with self.assertRaises(ComponentPrefabHtmlGenerationException):
            html_generator.generate_html(sub_generator.generate_html(prefab))


class TestSubRandomDirectionComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = RandomDirectionComponentPrefab(1, 2, ["Left", "Right"])
        html_generator = HtmlGenerator()
        sub_generator = SubRandomDirectionComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Randomdirectioncomponent</h5><hr/><dl><dt>Mindirectionfrequency</dt><dd>'
            '1.0</dd><dt>Maxdirectionfrequency</dt><dd>2.0</dd><dt>Directions</dt><dd>Left,Right</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubPlayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = PlayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubPlayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Playercomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubEnemyComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = EnemyComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubEnemyComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Enemycomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubIdentityComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = IdentityComponentPrefab("ID")
        html_generator = HtmlGenerator()
        sub_generator = SubIdentityComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Identitycomponent</h5><hr/><dl><dt>Id</dt><dd>ID</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubInputComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = InputComponentPrefab(5)
        html_generator = HtmlGenerator()
        sub_generator = SubInputComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Inputcomponent</h5><hr/><dl><dt>Shootdelay</dt><dd>5.0</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubCreateComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = CreateComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubCreateComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Createcomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDestroyComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DestroyComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubDestroyComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Destroycomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDestroyOnContactComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DestroyOnContactComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubDestroyOnContactComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Destroyoncontactcomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDestroyOnContactLostComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DestroyOnContactLostComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubDestroyOnContactLostComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Destroyoncontactlostcomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubLifetimeComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = LifetimeComponentPrefab(4)
        html_generator = HtmlGenerator()
        sub_generator = SubLifetimeComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Lifetimecomponent</h5><hr/><dl><dt>Lifetime</dt><dd>4.0</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubRandomCreateComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = RandomCreateComponentPrefab(1, 2, [CreateEntryPrefab("PREFAB_CODE", PositionPrefab(1, 2))])
        html_generator = HtmlGenerator()
        sub_generator = SubRandomCreateComponentPrefabHtmlGenerator(
            CreateEntryPrefabHtmlGenerator(PositionPrefabHtmlGenerator())
        )

        self.assertEqual(
            '<divclass="doc-component"><h5>Randomcreatecomponent</h5><hr/><dl><dt>Mincreatefrequency</dt><dd>1.0'
            '</dd><dt>Maxcreatefrequency</dt><dd>2.0</dd><dt>Createentries</dt><dd><divclass="doc-create-entry"><h6>'
            'Createentry</h6><hr/><dl><dt>Position</dt><dd><divclass="doc-position"><h6>Position</h6><hr/><dl><dt>X'
            '</dt><dd>1.0</dd><dt>Y</dt><dd>2.0</dd></dl></div></dd><dt>Entityprefabcode</dt><dd>PREFAB_CODE</dd>'
            '</dl></div></dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAutoMoveComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AutoMoveComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubAutoMoveComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Automovecomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubPhysicsComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = PhysicsComponentPrefab(
            BodyPrefab("StaticBody", True, False, False, True, False, 1, 45, 1, 2),
            [
                HitBoxPrefab(
                    "HB0",
                    FixturePrefab(
                        FilterPrefab("category", "mask"),
                        CircleShapePrefab(PositionPrefab(10, 20), 2),
                        1, 2, 3, False
                    )
                )
            ],
            [
                SensorPrefab(
                    "S0",
                    FixturePrefab(
                        FilterPrefab("category", "mask"),
                        CircleShapePrefab(PositionPrefab(10, 20), 2),
                        1, 2, 3, True
                    )
                )
            ],
            [
                LightHandlerPrefab(
                    "LH0",
                    PointLightPrefab(
                        HexColorPrefab("CCAAFFEE"),
                        True,
                        PositionPrefab(1, 2),
                        10
                    )
                )
            ]
        )
        html_generator = HtmlGenerator()
        sub_generator = SubPhysicsComponentPrefabHtmlGenerator(
            BodyPrefabHtmlGenerator(),
            HitBoxPrefabHtmlGenerator(
                FixturePrefabHtmlGenerator(
                    ShapePrefabHtmlGenerator([SubCircleShapePrefabHtmlGenerator(PositionPrefabHtmlGenerator())]),
                    FilterPrefabHtmlGenerator()
                )
            ),
            SensorPrefabHtmlGenerator(
                FixturePrefabHtmlGenerator(
                    ShapePrefabHtmlGenerator([SubCircleShapePrefabHtmlGenerator(PositionPrefabHtmlGenerator())]),
                    FilterPrefabHtmlGenerator()
                )
            ),
            LightHandlerPrefabHtmlGenerator(
                LightPrefabHtmlGenerator([
                    SubPointLightPrefabHtmlGenerator(
                        ColorPrefabHtmlGenerator([
                            SubHexColorPrefabHtmlGenerator()
                        ]),
                        PositionPrefabHtmlGenerator()
                    )
                ])
            )
        )

        self.assertEqual(
            '<divclass="doc-component"><h5>Physicscomponent</h5><hr/><dl><dt>Body</dt><dd><divclass="doc-body">'
            '<h6>Body</h6><hr/><dl><dt>Bodytype</dt><dd>StaticBody</dd><dt>Active</dt><dd>True</dd><dt>Awake</dt>'
            '<dd>False</dd><dt>Allowsleep</dt><dd>False</dd><dt>Fixedrotation</dt><dd>False</dd><dt>Bullet</dt>'
            '<dd>True</dd><dt>Gravityscale</dt><dd>1.0</dd><dt>Angle</dt><dd>45.0</dd><dt>Lineardamping</dt><dd>2.0'
            '</dd><dt>Angulardamping</dt><dd>1.0</dd></dl></div></dd><dt>Hitboxes</dt><dd><divclass="doc-hit-box">'
            '<h6>Hitbox</h6><hr/><dl><dt>Id</dt><dd>HB0</dd><dt>Fixture</dt><dd><divclass="doc-fixture"><h6>'
            'Fixture</h6><hr/><dl><dt>Shape</dt><dd><divclass="doc-shape"><h6>Circleshape</h6><hr/><dl><dt>Radius'
            '</dt><dd>2.0</dd><dt>Position</dt><dd><divclass="doc-position"><h6>Position</h6><hr/><dl><dt>X</dt>'
            '<dd>10.0</dd><dt>Y</dt><dd>20.0</dd></dl></div></dd></dl></div></dd><dt>Filter</dt><dd>'
            '<divclass="doc-filter"><h6>Filter</h6><hr/><dl><dt>Categorybit</dt><dd>category</dd><dt>Maskbit'
            '</dt><dd>mask</dd></dl></div></dd><dt>Density</dt><dd>2.0</dd><dt>Restitution</dt><dd>1.0</dd>'
            '<dt>Friction</dt><dd>3.0</dd><dt>Issensor</dt><dd>False</dd></dl></div></dd></dl></div></dd><dt>Sensors'
            '</dt><dd><divclass="doc-sensor"><h6>Sensor</h6><hr/><dl><dt>Id</dt><dd>S0</dd><dt>Fixture</dt><dd>'
            '<divclass="doc-fixture"><h6>Fixture</h6><hr/><dl><dt>Shape</dt><dd><divclass="doc-shape"><h6>'
            'Circleshape</h6><hr/><dl><dt>Radius</dt><dd>2.0</dd><dt>Position</dt><dd><divclass="doc-position">'
            '<h6>Position</h6><hr/><dl><dt>X</dt><dd>10.0</dd><dt>Y</dt><dd>20.0</dd></dl></div></dd></dl></div>'
            '</dd><dt>Filter</dt><dd><divclass="doc-filter"><h6>Filter</h6><hr/><dl><dt>Categorybit</dt><dd>category'
            '</dd><dt>Maskbit</dt><dd>mask</dd></dl></div></dd><dt>Density</dt><dd>2.0</dd><dt>Restitution</dt>'
            '<dd>1.0</dd><dt>Friction</dt><dd>3.0</dd><dt>Issensor</dt><dd>True</dd></dl></div></dd></dl></div>'
            '</dd><dt>Lighthandlers</dt><dd><divclass="doc-light-handler"><h6>Lighthandler</h6><hr/><dl><dt>Id'
            '</dt><dd>LH0</dd><dt>Light</dt><dd><divclass="doc-light"><h6>Pointlight</h6><hr/><dl><dt>XRay</dt>'
            '<dd>True</dd><dt>Color</dt><dd><divclass="doc-color"><h6>Hexcolor</h6><hr/><dl><dt>Hexvalue</dt><dd>'
            'CCAAFFEE</dd></dl></div></dd><dt>Position</dt><dd><divclass="doc-position"><h6>Position</h6><hr/><dl>'
            '<dt>X</dt><dd>1.0</dd><dt>Y</dt><dd>2.0</dd></dl></div></dd><dt>Distance</dt><dd>10.0</dd></dl></div>'
            '</dd></dl></div></dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAirplaneRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AirplaneRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubAirplaneRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Airplanerenderlayercomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubBombRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = BombRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubBombRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Bombrenderlayercomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubBonusRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = BonusRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubBonusRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Bonusrenderlayercomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubBulletRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = BulletRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubBulletRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Bulletrenderlayercomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubCloudRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = CloudRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubCloudRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Cloudrenderlayercomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubExplosionRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ExplosionRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubExplosionRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Explosionrenderlayercomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubGroundRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = GroundRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubGroundRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Groundrenderlayercomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubObstacleRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ObstacleRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubObstacleRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Obstaclerenderlayercomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubVehicleRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = VehicleRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubVehicleRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Vehiclerenderlayercomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubViewComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ViewComponentPrefab([SpriteViewPrefab(
            "ID", PositionPrefab(1, 2), FileSpritePrefab(False, True, "FILENAME")
        )])
        html_generator = HtmlGenerator()
        sub_generator = SubViewComponentPrefabHtmlGenerator(
            ViewPrefabHtmlGenerator([
                SubSpriteViewPrefabHtmlGenerator(
                    PositionPrefabHtmlGenerator(),
                    SpritePrefabHtmlGenerator([
                        SubFileSpritePrefabHtmlGenerator()
                    ])
                )
            ])
        )

        self.assertEqual(
            '<divclass="doc-component"><h5>Viewcomponent</h5><hr/><dl><dt>Views</dt><dd><divclass="doc-view"><h6>'
            'Spriteview</h6><hr/><dl><dt>Position</dt><dd><divclass="doc-position"><h6>Position</h6><hr/><dl><dt>X'
            '</dt><dd>1.0</dd><dt>Y</dt><dd>2.0</dd></dl></div></dd><dt>Sprite</dt><dd><divclass="doc-sprite"><h6>'
            'Filesprite</h6><hr/><dl><dt>Flipx</dt><dd>False</dd><dt>Flipy</dt><dd>True</dd><dt>Filename</dt><dd>'
            'FILENAME</dd></dl></div></dd></dl></div></dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAirplaneSpawnerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AirplaneSpawnerComponentPrefab("CODE")
        html_generator = HtmlGenerator()
        sub_generator = SubAirplaneSpawnerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Airplanespawnercomponent</h5><hr/><dl><dt>Entityprefabcode'
            '</dt><dd>CODE</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubRespawnComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = RespawnComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubRespawnComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Respawncomponent</h5><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAutoSpawnerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AutoSpawnerComponentPrefab("ID")
        html_generator = HtmlGenerator()
        sub_generator = SubAutoSpawnerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Autospawnercomponent</h5><hr/><dl><dt>Id</dt><dd>ID</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubStateComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = StateComponentPrefab("STATE")
        html_generator = HtmlGenerator()
        sub_generator = SubStateComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><h5>Statecomponent</h5><hr/><dl><dt>State</dt><dd>STATE</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubCreateTriggerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = CreateTriggerComponentPrefab([DestroyEntityEventPrefab()])
        html_generator = HtmlGenerator()
        sub_generator = SubCreateTriggerComponentPrefabHtmlGenerator(
            EntityEventPrefabHtmlGenerator([
                SubDestroyEntityEventPrefabHtmlGenerator()
            ])
        )

        self.assertEqual(
            '<divclass="doc-component"><h5>Createtriggercomponent</h5><hr/><dl><dt>Entityevents</dt><dd>'
            '<divclass="doc-entity-event"><h6>Destroyentityevent</h6><hr/></div></dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubHitTriggerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = HitTriggerComponentPrefab([DestroyEntityEventPrefab()])
        html_generator = HtmlGenerator()
        sub_generator = SubHitTriggerComponentPrefabHtmlGenerator(
            EntityEventPrefabHtmlGenerator([
                SubDestroyEntityEventPrefabHtmlGenerator()
            ])
        )

        self.assertEqual(
            '<divclass="doc-component"><h5>Hittriggercomponent</h5><hr/><dl><dt>Entityevents</dt><dd>'
            '<divclass="doc-entity-event"><h6>Destroyentityevent</h6><hr/></div></dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDestroyTriggerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DestroyTriggerComponentPrefab([DestroyEntityEventPrefab()])
        html_generator = HtmlGenerator()
        sub_generator = SubDestroyTriggerComponentPrefabHtmlGenerator(
            EntityEventPrefabHtmlGenerator([
                SubDestroyEntityEventPrefabHtmlGenerator()
            ])
        )

        self.assertEqual(
            '<divclass="doc-component"><h5>Destroytriggercomponent</h5><hr/><dl><dt>Entityevents</dt><dd>'
            '<divclass="doc-entity-event"><h6>Destroyentityevent</h6><hr/></div></dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html_valid(self):
        prefab = CreateComponentPrefab()
        html_generator = HtmlGenerator()
        generator = ComponentPrefabHtmlGenerator([
            SubCreateComponentPrefabHtmlGenerator()
        ])

        self.assertEqual(
            '<divclass="doc-component"><h5>Createcomponent</h5><hr/></div>',
            html_generator.generate_html(generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


    def test_generate_html_invalid(self):
        prefab = CreateComponentPrefab()
        html_generator = HtmlGenerator()
        generator = ComponentPrefabHtmlGenerator([])

        with self.assertRaises(ComponentPrefabHtmlGenerationException):
            html_generator.generate_html(generator.generate_html(prefab))


if __name__ == "__main__":
    unittest.main()

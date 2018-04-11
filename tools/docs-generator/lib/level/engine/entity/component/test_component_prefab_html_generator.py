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
            '<divclass="doc-component"><p>Speedcomponent</p><div><table><tr><th>Speed</th><td>10.0</td></tr>'
            '</table></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubSpeedModifierComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = SpeedModifierComponentPrefab(10)
        html_generator = HtmlGenerator()
        sub_generator = SubSpeedModifierComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Speedmodifiercomponent</p><div><table><tr><th>Speedmodifier</th><td>10.0'
            '</td></tr></table></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubCameraTrackComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = CameraTrackComponentPrefab(1, PositionPrefab(1, 2))
        html_generator = HtmlGenerator()
        sub_generator = SubCameraTrackComponentPrefabHtmlGenerator(PositionPrefabHtmlGenerator())

        self.assertEqual(
            '<divclass="doc-component"><p>Speedcomponent</p><div><table><tr><th>Priority</th><td>1</td></tr></table'
            '></div><divclass="doc-position"><p>Position</p><div><table><tr><th>X</th><td>1.0</td></tr><tr><th>Y</t'
            'h><td>2.0</td></tr></table></div></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubLeaveBonusComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = LeaveBonusComponentPrefab(1)
        html_generator = HtmlGenerator()
        sub_generator = SubLeaveBonusComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Leavebonuscomponent</p><div><table><tr><th>Chancemodifier</th><td>1.0'
            '</td></tr></table></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAmmoComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AmmoComponentPrefab(1, 2, {1: {"Left": "LeftBullet0", "Right": "RightBullet0"},
                                            2: {"Left": "LeftBullet1", "Right": "RightBullet1"}})
        html_generator = HtmlGenerator()
        sub_generator = SubAmmoComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Ammocomponent</p><div><table><tr><th>Currentlevel</th><td>1</td></tr><tr>'
            '<th>Maxlevel</th><td>2</td></tr></table></div><div><p>Ammotable</p><table><tr><th>Level</th><th>Entity'
            'prefabcodes</th></tr><tr><td>1</td><td><table><th>Direction</th><th>Entityprefabcode</th><tr><td>Left<'
            '/td><td>LeftBullet0</td></tr><tr><td>Right</td><td>RightBullet0</td></tr></table></td></tr><tr><td>2</'
            'td><td><table><th>Direction</th><th>Entityprefabcode</th><tr><td>Left</td><td>LeftBullet1</td></tr><tr'
            '><td>Right</td><td>RightBullet1</td></tr></table></td></tr></table></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAutoShootComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AutoShootComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubAutoShootComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Autoshootcomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDamageComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DamageComponentPrefab(2)
        html_generator = HtmlGenerator()
        sub_generator = SubDamageComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Damagecomponent</p><div><table><tr><th>Damage</th><td>2</td>'
            '</tr></table></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubHealthComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = HealthComponentPrefab(2, 6)
        html_generator = HtmlGenerator()
        sub_generator = SubHealthComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Healthcomponent</p><div><table><tr><th>Health</th><td>2</td></tr><tr><th>'
            'Maxhealth</th><td>6</td></tr></table></div></div>',
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
            '<divclass="doc-component"><p>Hitcomponent</p><div><table><tr><th>Time</th><td>10.0</td></tr></table>'
            '</div><divclass="doc-effect"><p>Alphaeffect</p><div><table><tr><th>Alphavalue</th><td>1</td></tr></t'
            'able></div></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubProtectionComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ProtectionComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubProtectionComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Protectioncomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubRandomShootComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = RandomShootComponentPrefab(1, 2)
        html_generator = HtmlGenerator()
        sub_generator = SubRandomShootComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Randomshootcomponent</p><div><table><tr><th>Minshootfrequency</th><td>1.0'
            '</td></tr><tr><th>Maxshootfrequency</th><td>2.0</td></tr></table></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDirectionComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DirectionComponentPrefab("Left")
        html_generator = HtmlGenerator()
        sub_generator = SubDirectionComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Directioncomponent</p><div><table><tr><th>Direction</th><td>Left</td></tr>'
            '</table></div></div>',
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
            '<divclass="doc-component"><p>Changebehaviorcomponent</p><div><divclass="doc-component"><p>Speedcomponent'
            '</p><div><table><tr><th>Speed</th><td>1.0</td></tr></table></div></div><divclass="doc-component"><p>Dama'
            'gecomponent</p><div><table><tr><th>Damage</th><td>2</td></tr></table></div></div></div></div>',
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
            '<divclass="doc-component"><p>Randomdirectioncomponent</p><div><table><tr><th>Minchangedirectionfreque'
            'ncy</th><td>1.0</td></tr><tr><th>Maxchangedirectionfrequency</th><td>2.0</td></tr><tr><th>Directions<'
            '/th><td>Left,Right</td></tr></table></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubPlayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = PlayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubPlayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Playercomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubEnemyComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = EnemyComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubEnemyComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Enemycomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubIdentityComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = IdentityComponentPrefab("ID")
        html_generator = HtmlGenerator()
        sub_generator = SubIdentityComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Identitycomponent</p><table><tr><th>Id</th><td>ID</td></tr></table></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubInputComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = InputComponentPrefab(5)
        html_generator = HtmlGenerator()
        sub_generator = SubInputComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Inputcomponent</p><table><tr><th>Shootdelay</th><td>5.0</td></tr>'
            '</table></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubCreateComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = CreateComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubCreateComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Createcomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDestroyComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DestroyComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubDestroyComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Destroycomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDestroyOnContactComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DestroyOnContactComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubDestroyOnContactComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Destroyoncontactcomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDestroyOnContactLostComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DestroyOnContactLostComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubDestroyOnContactLostComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Destroyoncontactlostcomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubLifetimeComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = LifetimeComponentPrefab(4)
        html_generator = HtmlGenerator()
        sub_generator = SubLifetimeComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Lifetimecomponent</p><table><tr><th>Lifetime</th><td>4.0</td>'
            '</tr></table></div>',
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
            '<divclass="doc-component"><p>Changebehaviorcomponent</p><table><tr><th>Mincreatefrequency</th><td>1.0'
            '</td></tr><tr><th>Maxcreatefrequency</th><td>2.0</td></tr></table><div><p>Components</p><divclass="do'
            'c-create-entry"><p>Createentry</p><div><table><tr><th>Entityprefabcode</th><td>PREFAB_CODE</td></tr><'
            '/table></div><divclass="doc-position"><p>Position</p><div><table><tr><th>X</th><td>1.0</td></tr><tr><'
            'th>Y</th><td>2.0</td></tr></table></div></div></div></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAutoMoveComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AutoMoveComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubAutoMoveComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Automovecomponent</p></div>',
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
            '<divclass="doc-component"><p>Physicscomponent</p><divclass="doc-body"><p>Body</p><div><table><tr><th>Bo'
            'dytype</th><td>StaticBody</td></tr><tr><th>Active</th><td>True</td></tr><tr><th>Awake</th><td>False</td'
            '></tr><tr><th>Allowsleep</th><td>False</td></tr><tr><th>Fixedrotation</th><td>False</td></tr><tr><th>Bu'
            'llet</th><td>True</td></tr><tr><th>Gravityscale</th><td>1.0</td></tr><tr><th>Angle</th><td>2.0</td></tr'
            '><tr><th>Lineardamping</th><td>2.0</td></tr><tr><th>Angulardamping</th><td>1.0</td></tr></table></div><'
            '/div><div><p>Hitboxes</p><divclass="doc-hit-box"><p>Hitbox</p><div><table><tr><th>Id</th><td>HB0</td></'
            'tr></table></div><divclass="doc-fixture"><p>Fixture</p><div><table><tr><th>Density</th><td>2.0</td></tr'
            '><tr><th>Restitution</th><td>1.0</td></tr><tr><th>Friction</th><td>3.0</td></tr></table></div><divclass'
            '="doc-filter"><p>Filter</p><div><table><tr><th>Categorybit</th><td>category</td></tr><tr><th>Maskbit</t'
            'h><td>mask</td></tr></table></div></div><divclass="doc-shape"><p>Circleshape</p><div><table><tr><th>Rad'
            'ius</th><td>2.0</td></tr></table></div><divclass="doc-position"><p>Position</p><div><table><tr><th>X</t'
            'h><td>10.0</td></tr><tr><th>Y</th><td>20.0</td></tr></table></div></div></div></div></div></div><div><p'
            '>Sensors</p><divclass="doc-sensor"><p>Sensor</p><div><table><tr><th>Id</th><td>S0</td></tr></table></di'
            'v><divclass="doc-fixture"><p>Fixture</p><div><table><tr><th>Density</th><td>2.0</td></tr><tr><th>Restit'
            'ution</th><td>1.0</td></tr><tr><th>Friction</th><td>3.0</td></tr></table></div><divclass="doc-filter"><'
            'p>Filter</p><div><table><tr><th>Categorybit</th><td>category</td></tr><tr><th>Maskbit</th><td>mask</td>'
            '</tr></table></div></div><divclass="doc-shape"><p>Circleshape</p><div><table><tr><th>Radius</th><td>2.0'
            '</td></tr></table></div><divclass="doc-position"><p>Position</p><div><table><tr><th>X</th><td>10.0</td>'
            '</tr><tr><th>Y</th><td>20.0</td></tr></table></div></div></div></div></div></div><div><p>Lighthandlers<'
            '/p><divclass="doc-light-handler"><p>Lighthandler</p><div><table><tr><th>Id</th><td>LH0</td></tr></table'
            '></div><divclass="doc-light"><p>Pointlight</p><div><table><tr><th>XRay</th><td>True</td></tr><tr><th>Di'
            'stance</th><td>10.0</td></tr></table></div><div><p>Position</p><divclass="doc-position"><p>Position</p>'
            '<div><table><tr><th>X</th><td>1.0</td></tr><tr><th>Y</th><td>2.0</td></tr></table></div></div></div><di'
            'vclass="doc-color"><p>Hexcolor</p><div><table><tr><th>Hexvalue</th><td>CCAAFFEE</td></tr></table></div>'
            '</div></div></div></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAirplaneRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AirplaneRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubAirplaneRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Airplanerenderlayercomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubBombRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = BombRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubBombRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Bombrenderlayercomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubBonusRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = BonusRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubBonusRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Bonusrenderlayercomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubBulletRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = BulletRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubBulletRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Bulletrenderlayercomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubCloudRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = CloudRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubCloudRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Cloudrenderlayercomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubExplosionRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ExplosionRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubExplosionRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Explosionrenderlayercomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubGroundRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = GroundRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubGroundRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Groundrenderlayercomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubObstacleRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ObstacleRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubObstacleRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Obstaclerenderlayercomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubVehicleRenderLayerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = VehicleRenderLayerComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubVehicleRenderLayerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Vehiclerenderlayercomponent</p></div>',
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
            '<divclass="doc-component"><p>Viewcomponent</p><div><p>Views</p><divclass="doc-view"><p>Spriteview</p>'
            '<divclass="doc-position"><p>Position</p><div><table><tr><th>X</th><td>1.0</td></tr><tr><th>Y</th><td>'
            '2.0</td></tr></table></div></div><divclass="doc-sprite"><p>Filesprite</p><div><table><tr><th>Flipx</t'
            'h><td>False</td></tr><tr><th>Flipy</th><td>True</td></tr><tr><th>Filename</th><td>FILENAME</td></tr><'
            '/table></div></div></div></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAirplaneSpawnerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AirplaneSpawnerComponentPrefab("CODE")
        html_generator = HtmlGenerator()
        sub_generator = SubAirplaneSpawnerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Airplanespawnercomponent</p><table><tr><th>Entityprefabcode</th><td>'
            'CODE</td></tr></table></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubRespawnComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = RespawnComponentPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubRespawnComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Respawncomponent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAutoSpawnerComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AutoSpawnerComponentPrefab("ID")
        html_generator = HtmlGenerator()
        sub_generator = SubAutoSpawnerComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Autospawnercomponent</p><table><tr><th>Id</th><td>ID</td></tr></table></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubStateComponentPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = StateComponentPrefab("STATE")
        html_generator = HtmlGenerator()
        sub_generator = SubStateComponentPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-component"><p>Statecomponent</p><table><tr><th>State</th><td>STATE</td></tr></table></div>',
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
            '<divclass="doc-component"><p>Createtriggercomponent</p><div><p>Entityevents</p><divclass="doc-entity-'
            'event"><p>Destroyentityevent</p></div></div></div>',
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
            '<divclass="doc-component"><p>Hittriggercomponent</p><div><p>Entityevents</p><divclass="doc-entity-event"'
            '><p>Destroyentityevent</p></div></div></div>',
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
            '<divclass="doc-component"><p>Destroytriggercomponent</p><div><p>Entityevents</p><divclass="doc-entity-ev'
            'ent"><p>Destroyentityevent</p></div></div></div>',
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
            '<divclass="doc-component"><p>Createcomponent</p></div>',
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

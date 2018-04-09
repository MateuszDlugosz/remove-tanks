from lib.graphics.camera.camera_effect_prefab import ShakeCameraEffectPrefab
from lib.html.html import HtmlElement

CAMERA_EFFECT_HTML_CLASS_ATTRIBUTE = "doc-camera-effect"


class CameraEffectPrefabHtmlGenerator(object):
    def __init__(self, sub_generators):
        self.sub_generators = {}
        for sub_generator in sub_generators:
            self.sub_generators[sub_generator.get_type()] = sub_generator

    def generate_html(self, camera_effect_prefab):
        try:
            if camera_effect_prefab.__class__.__name__ not in self.sub_generators:
                raise CameraEffectPrefabHtmlGeneratorNotFoundException(camera_effect_prefab)

            return self.sub_generators[camera_effect_prefab.__class__.__name__].generate_html(camera_effect_prefab)
        except Exception as e:
            raise CameraEffectPrefabHtmlGenerationException(camera_effect_prefab, e)


class SubCameraEffectPrefabHtmlGenerator(object):
    def generate_html(self, camera_effect_prefab):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class SubShakeCameraEffectPrefabHtmlGenerator(SubCameraEffectPrefabHtmlGenerator):
    def generate_html(self, camera_effect_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": CAMERA_EFFECT_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Shake camera effect"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Time"),
                            HtmlElement("td", camera_effect_prefab.get_time())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Power"),
                            HtmlElement("td", camera_effect_prefab.get_power())
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise CameraEffectPrefabHtmlGenerationException(camera_effect_prefab, e)

    def get_type(self):
        return ShakeCameraEffectPrefab.__name__


class CameraEffectPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from camera effect prefab {}. Cause: {}."

    def __init__(self, camera_effect_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(camera_effect_prefab), cause))


class CameraEffectPrefabHtmlGeneratorNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Camera effect prefab html generator of type {} not found."

    def __init__(self, camera_effect_prefab):
        super().__init__(self.MESSAGE_TEMPLATE.format(camera_effect_prefab.__class__.__name__))

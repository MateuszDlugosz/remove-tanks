from lib.html.html import HtmlElement
from lib.physics.shape.shape_prefab import RectangleShapePrefab, CircleShapePrefab, PolygonShapePrefab, ChainShapePrefab

SHAPE_HTML_CLASS_ATTRIBUTE = "doc-shape"


class ShapePrefabHtmlGenerator(object):
    def __init__(self, sub_generators):
        self.sub_generators = {}
        for sub_generator in sub_generators:
            self.sub_generators[sub_generator.get_type()] = sub_generator

    def generate_html(self, shape_prefab):
        try:
            if shape_prefab.__class__.__name__ not in self.sub_generators:
                raise ShapePrefabHtmlGeneratorNotFoundException(shape_prefab)

            return self.sub_generators[shape_prefab.__class__.__name__].generate_html(shape_prefab)
        except Exception as e:
            raise ShapePrefabHtmlGenerationException(shape_prefab, e)


class SubShapePrefabHtmlGenerator(object):
    def generate_html(self, shape_prefab):
        raise NotImplementedError("Not implemented yet")

    def get_type(self):
        raise NotImplementedError("Not implemented yet")


class SubRectangleShapePrefabHtmlGenerator(SubShapePrefabHtmlGenerator):
    def __init__(self, position_prefab_html_generator):
        self.position_prefab_html_generator = position_prefab_html_generator

    def generate_html(self, shape_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": SHAPE_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Rectangle shape"),
                    HtmlElement("div", children=[
                        HtmlElement("table", children=[
                            HtmlElement("tr", children=[
                                HtmlElement("th", "Width"),
                                HtmlElement("td", shape_prefab.get_width())
                            ]),
                            HtmlElement("tr", children=[
                                HtmlElement("th", "Height"),
                                HtmlElement("td", shape_prefab.get_height())
                            ])
                        ]),
                    self.position_prefab_html_generator.generate_html(shape_prefab.get_position_prefab())
                ]),
            ])
        except Exception as e:
            raise ShapePrefabHtmlGenerationException(shape_prefab, e)

    def get_type(self):
        return RectangleShapePrefab.__name__


class SubCircleShapePrefabHtmlGenerator(SubShapePrefabHtmlGenerator):
    def __init__(self, position_prefab_html_generator):
        self.position_prefab_html_generator = position_prefab_html_generator

    def generate_html(self, shape_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": SHAPE_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Circle shape"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Radius"),
                            HtmlElement("td", shape_prefab.get_radius())
                        ])
                    ]),
                    self.position_prefab_html_generator.generate_html(shape_prefab.get_position_prefab())
                ]),
            ])
        except Exception as e:
            raise ShapePrefabHtmlGenerationException(shape_prefab, e)

    def get_type(self):
        return CircleShapePrefab.__name__


class SubPolygonShapePrefabHtmlGenerator(SubShapePrefabHtmlGenerator):
    def __init__(self, position_prefab_html_generator, vertex_prefab_html_generator):
        self.position_prefab_html_generator = position_prefab_html_generator
        self.vertex_prefab_html_generator = vertex_prefab_html_generator

    def generate_html(self, shape_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": SHAPE_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Polygon shape"),
                HtmlElement("div", children=[
                    self.position_prefab_html_generator.generate_html(shape_prefab.get_position_prefab()),
                    self.vertex_prefab_html_generator.generate_html(shape_prefab.get_vertices())
                ])
            ])
        except Exception as e:
            raise ShapePrefabHtmlGenerationException(shape_prefab, e)

    def get_type(self):
        return PolygonShapePrefab.__name__


class SubChainShapePrefabHtmlGenerator(SubShapePrefabHtmlGenerator):
    def __init__(self, position_prefab_html_generator, vertex_prefab_html_generator):
        self.position_prefab_html_generator = position_prefab_html_generator
        self.vertex_prefab_html_generator = vertex_prefab_html_generator

    def generate_html(self, shape_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": SHAPE_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Chain shape"),
                HtmlElement("div", children=[
                    self.position_prefab_html_generator.generate_html(shape_prefab.get_position_prefab()),
                    self.vertex_prefab_html_generator.generate_html(shape_prefab.get_vertices())
                ])
            ])
        except Exception as e:
            raise ShapePrefabHtmlGenerationException(shape_prefab, e)

    def get_type(self):
        return ChainShapePrefab.__name__


class ShapePrefabHtmlGeneratorNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Shape prefab html generator og shape prefab type {} not found."

    def __init__(self, shape_prefab):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(shape_prefab)))


class ShapePrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from shape prefab {}. Cause: {}."

    def __init__(self, shape_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(shape_prefab), cause))

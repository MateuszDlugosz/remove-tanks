from lib.html.html import HtmlElement

PAGE_DIV_CLASS_HTML_ATTRIBUTES = "doc-page container-fluid"
HEADER_CLASS_HTML_ATTRIBUTES = "doc-header"
MAIN_CLASS_HTML_ATTRIBUTES = "doc-main row"
ARTICLE_CLASS_HTML_ATTRIBUTES = "doc-article col-8"
ARTICLE_SECTION_CLASS_HTML_ATTRIBUTES = "doc-article-section"
ASIDE_CLASS_HTML_ATTRIBUTES = "doc-aside col-4"
ASIDE_SECTION_CLASS_HTML_ATTRIBUTES = "doc-aside-section"


class LayoutHtmlGenerator(object):
    def __init__(self, css_filenames, js_filenames):
        self.css_filenames = css_filenames
        self.js_filenames = js_filenames

    def generate_html(self, header_html, menu_html, content_html, footer_html):
        try:
            html = HtmlElement("html")
            html.set_attribute("lang", "en")
            html.add_child(self.generate_head_html())
            html.add_child(self.generate_body_html(
                header_html, menu_html, content_html, footer_html))

            return html
        except Exception as e:
            raise LayoutHtmlGenerationException(e)

    def generate_head_html(self):
        html = HtmlElement("head", children=[
            HtmlElement("meta", attributes={"charset": "utf-8"}),
            HtmlElement("meta", attributes={
                "content": "width=device-width, initial-scale=1, shrink-to-fit=no"
            }),
            HtmlElement("link", attributes={
                "rel": "stylesheet",
                "integrity": "sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm",
                "href": "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css",
                "crossorigin": "anonymous"
            })
        ])

        for filename in self.css_filenames:
            css = HtmlElement("link")
            css.set_attribute("rel", "stylesheet")
            css.set_attribute("href", filename)
            html.add_child(css)

        return html

    def generate_body_html(self, header_html, menu_html, content_html, footer_html):
        html = HtmlElement("body", children=[
            header_html,
            HtmlElement("div", attributes={
                "class": PAGE_DIV_CLASS_HTML_ATTRIBUTES
            }, children=[
                HtmlElement("main", attributes={
                    "class": MAIN_CLASS_HTML_ATTRIBUTES
                }, children=[
                    HtmlElement("aside", attributes={
                        "class": ASIDE_CLASS_HTML_ATTRIBUTES
                    }, children=[
                        HtmlElement("section", attributes={
                            "class": ASIDE_SECTION_CLASS_HTML_ATTRIBUTES
                        }, children=[
                            menu_html
                        ])
                    ]),
                    HtmlElement("article", attributes={
                        "class": ARTICLE_CLASS_HTML_ATTRIBUTES
                    }, children=[
                        HtmlElement("section", attributes={
                            "class": ARTICLE_SECTION_CLASS_HTML_ATTRIBUTES
                        }, children=[
                            content_html
                        ])
                    ])
                ])
            ]),
            footer_html
        ])

        jquery = HtmlElement("script", " ")
        jquery.set_attribute("src", "https://code.jquery.com/jquery-3.2.1.slim.min.js")
        jquery.set_attribute("integrity",
                             "sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN")
        jquery.set_attribute("crossorigin", "anonymous")

        popper = HtmlElement("script", " ")
        popper.set_attribute("src",
                             "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js")
        popper.set_attribute("integrity",
                             "sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q")
        popper.set_attribute("crossorigin", "anonymous")

        bootstrap = HtmlElement("script", " ")
        bootstrap.set_attribute("src", "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js")
        bootstrap.set_attribute("integrity",
                                "sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl")
        bootstrap.set_attribute("crossorigin", "anonymous")

        html.add_child(jquery)
        html.add_child(popper)
        html.add_child(bootstrap)

        for filename in self.js_filenames:
            js = HtmlElement("script", " ")
            js.set_attribute("src", filename)
            html.add_child(js)

        return html


class LayoutHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate layout html. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))

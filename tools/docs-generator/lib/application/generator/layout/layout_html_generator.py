from lib.html.html import HtmlElement

PAGE_DIV_CLASS_HTML_ATTRIBUTE = "doc-page"
HEADER_CLASS_HTML_ATTRIBUTE = "doc-header"
MAIN_CLASS_HTML_ATTRIBUTE = "doc-main"
ARTICLE_CLASS_HTML_ATTRIBUTE = "doc-article"
ASIDE_CLASS_HTML_ATTRIBUTE = "doc-aside"


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
        html = HtmlElement("head")

        charset = HtmlElement("meta")
        charset.set_attribute("charset", "utf-8")

        for filename in self.css_filenames:
            css = HtmlElement("link")
            css.set_attribute("rel", "stylesheet")
            css.set_attribute("href", filename)
            html.add_child(css)

        html.add_child(charset)

        return html

    def generate_body_html(self, header_html, menu_html, content_html, footer_html):
        html = HtmlElement("body")
        html = HtmlElement("div")
        html.set_attribute("class", PAGE_DIV_CLASS_HTML_ATTRIBUTE)

        header = HtmlElement("header")
        header.set_attribute("class", HEADER_CLASS_HTML_ATTRIBUTE)
        header.add_child(header_html)

        main = HtmlElement("main")
        main.set_attribute("class", MAIN_CLASS_HTML_ATTRIBUTE)

        menu = HtmlElement("aside")
        menu.set_attribute("class", ASIDE_CLASS_HTML_ATTRIBUTE)
        menu_section = HtmlElement("section")
        menu_section.add_child(menu_html)
        menu.add_child(menu_section)

        content = HtmlElement("article")
        content.set_attribute("class", ARTICLE_CLASS_HTML_ATTRIBUTE)
        content_section = HtmlElement("section")
        content_section.add_child(content_html)
        content.add_child(content_section)

        main.add_child(menu)
        main.add_child(content)

        footer = HtmlElement("footer")
        footer.add_child(footer_html)

        html.add_child(header)
        html.add_child(main)
        html.add_child(footer)

        jquery = HtmlElement("script", " ")
        jquery.set_attribute("src", "https://code.jquery.com/jquery-3.2.1.slim.min.js")
        jquery.set_attribute("integrity",
                             "sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN")
        jquery.set_attribute("crossorigin", "anonymous")

        html.add_child(jquery)

        for filename in self.js_filenames:
            js = HtmlElement("script", " ")
            js.set_attribute("src", filename)
            html.add_child(js)

        return html


class LayoutHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate layout html. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))

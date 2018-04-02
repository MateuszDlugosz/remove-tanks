from lib.html.html import HtmlElement

PAGE_DIV_CLASS_HTML_ATTRIBUTE = "doc-page"


class LayoutHtmlGenerator(object):
    def __init__(self, css_filenames):
        self.css_filenames = css_filenames

    def generate_html(self, header_html, menu_html, content_html, footer_html):
        try:
            html = HtmlElement("html")
            html.add_child(self.generate_head_html())
            html.add_child(self.generate_body_html(
                header_html, menu_html, content_html, footer_html))

            return html
        except Exception as e:
            raise LayoutHtmlGenerationException(e)

    def generate_head_html(self):
        html = HtmlElement("head")

        for css_filename in self.css_filenames:
            css = HtmlElement("link")
            css.set_attribute("rel", "stylesheet")
            css.set_attribute("type", "text/css")
            css.set_attribute("href", css_filename)
            html.add_child(css)

        return html

    def generate_body_html(self, header_html, menu_html, content_html, footer_html):
        html = HtmlElement("body")
        page_div = HtmlElement("div")
        page_div.set_attribute("class", PAGE_DIV_CLASS_HTML_ATTRIBUTE)

        headers = HtmlElement("header")
        headers.add_child(header_html)

        main = HtmlElement("main")

        menu = HtmlElement("aside")
        menu.add_child(menu_html)

        content = HtmlElement("article")
        content.add_child(content_html)

        main.add_child(menu)
        main.add_child(content)

        footer = HtmlElement("footer")
        footer.add_child(footer_html)

        page_div.add_child(headers)
        page_div.add_child(main)
        page_div.add_child(footer)

        html.add_child(page_div)

        return html


class LayoutHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate layout html. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))

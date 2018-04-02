from lib.html.html import HtmlElement

PAGE_DIV_CLASS_HTML_ATTRIBUTE = "doc-page"
HEADER_CLASS_HTML_ATTRIBUTE = "doc-header"
MAIN_CLASS_HTML_ATTRIBUTE = "doc-main"
ARTICLE_CLASS_HTML_ATTRIBUTE = "doc-article"
ASIDE_CLASS_HTML_ATTRIBUTE = "doc-aside"


class LayoutHtmlGenerator(object):
    def __init__(self, css_filenames):
        self.css_filenames = css_filenames

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

        viewport = HtmlElement("meta")
        viewport.set_attribute("content", "width=device-width, initial-scale=1, shrink-to-fit=no")

        bootstrap_css = HtmlElement("link")
        bootstrap_css.set_attribute("rel", "stylesheet")
        bootstrap_css.set_attribute("integrity",
                                    "sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm")
        bootstrap_css.set_attribute("href", "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css")
        bootstrap_css.set_attribute("crossorigin", "anonymous")

        html.add_child(charset)
        html.add_child(viewport)
        html.add_child(bootstrap_css)

        return html

    def generate_body_html(self, header_html, menu_html, content_html, footer_html):
        html = HtmlElement("body")
        page_div = HtmlElement("div")
        page_div.set_attribute("class", PAGE_DIV_CLASS_HTML_ATTRIBUTE)

        header = HtmlElement("header")
        header.set_attribute("class", HEADER_CLASS_HTML_ATTRIBUTE)
        header.add_child(header_html)

        main = HtmlElement("main")
        main.set_attribute("class", MAIN_CLASS_HTML_ATTRIBUTE)

        menu = HtmlElement("aside")
        menu.set_attribute("class", ASIDE_CLASS_HTML_ATTRIBUTE)
        menu.add_child(menu_html)

        content = HtmlElement("article")
        content.set_attribute("class", ARTICLE_CLASS_HTML_ATTRIBUTE)
        content.add_child(content_html)

        main.add_child(menu)
        main.add_child(content)

        footer = HtmlElement("footer")
        footer.add_child(footer_html)

        page_div.add_child(header)
        page_div.add_child(main)
        page_div.add_child(footer)

        html.add_child(page_div)

        jquery = HtmlElement("script", " ")
        jquery.set_attribute("src", "https://code.jquery.com/jquery-3.2.1.slim.min.js")
        jquery.set_attribute("integrity", "sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN")
        jquery.set_attribute("crossorigin", "anonymous")

        popper = HtmlElement("script", " ")
        popper.set_attribute("src", "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js")
        popper.set_attribute("integrity", "sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q")
        popper.set_attribute("crossorigin", "anonymous")

        bootstrap = HtmlElement("script", " ")
        bootstrap.set_attribute("src", "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js")
        bootstrap.set_attribute("integrity", "sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl")
        bootstrap.set_attribute("crossorigin", "anonymous")

        styles = HtmlElement("script", " ")
        styles.set_attribute("src", "./js/styles.js")

        html.add_child(jquery)
        html.add_child(popper)
        html.add_child(bootstrap)
        html.add_child(styles)

        return html


class LayoutHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate layout html. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))

import logging
import os


class PageHtmlGenerator(object):
    def __init__(self, html_layout_generator, header_html_generator, menu_html_generator, footer_html_generator,
                 html_generator):
        self.html_layout_generator = html_layout_generator
        self.header_html_generator = header_html_generator
        self.menu_html_generator = menu_html_generator
        self.footer_html_generator = footer_html_generator
        self.html_generator = html_generator

    def generate_html(self, html_menu, html_content, filename):
        try:
            logging.info(f"Generating page {filename} started.")
            html_string = self.html_generator.generate_html(self.html_layout_generator.generate_html(
                self.header_html_generator.generate_html(),
                self.menu_html_generator.generate_html(html_menu),
                html_content,
                self.footer_html_generator.generate_html()
            ))

            os.makedirs(os.path.dirname(filename), exist_ok=True)

            with open(filename, "w+") as file:
                file.write(html_string)
            logging.info(f"Generating page {filename} ended.")
        except Exception as e:
            raise PageHtmlGeneratingException(filename, e)


class PageHtmlGeneratingException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate page {}. Cause: {}."

    def __init__(self, filename, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(filename, cause))

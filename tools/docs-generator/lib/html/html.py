class HtmlElement(object):
    def __init__(self, name, text=None, attributes=None, children=None):
        if children is None:
            children = []
        if attributes is None:
            attributes = {}
        self.name = name
        self.attributes = attributes
        self.children = children
        self.text = text

    def get_name(self):
        return self.name

    def set_attribute(self, name, value):
        self.attributes[name] = value

    def get_attribute(self, name):
        if name not in self.attributes:
            return None
        return self.attributes[name]

    def get_attributes(self):
        return self.attributes

    def add_child(self, child):
        self.children.append(child)

    def get_children(self):
        return self.children

    def get_text(self):
        return self.text


class HtmlGenerator(object):
    def generate_html(self, html_element, deep=0):
        attributes = ""
        end_element = " /"
        sub_elements = ""

        if len(html_element.get_attributes()) > 0:
            attributes += " "
            for key, value in html_element.get_attributes().items():
                attributes += '{}="{}" '.format(key, value)

        if html_element.get_text() is not None:
            sub_elements += f'{"  " * (deep + 1)}{html_element.get_text()}\n'
            end_element = ""

        if len(html_element.get_children()) > 0:
            end_element = ""
            for child in html_element.get_children():
                sub_elements += self.generate_html(child, deep=(deep+1))
                sub_elements += "\n"

        html = ""
        html += f"{'  ' * deep}<{html_element.get_name()}{attributes}{end_element}>"

        if len(html_element.get_children()) > 0 or html_element.get_text() is not None:
            html += "\n"
            html += sub_elements
            html += f"{'  ' * deep}</{html_element.get_name()}>"

        return html

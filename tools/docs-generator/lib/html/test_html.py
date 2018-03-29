import unittest

from lib.html.html import HtmlElement, HtmlGenerator


class TestHtmlElement(unittest.TestCase):
    def test_html_element(self):
        element = HtmlElement("test")
        element.set_attribute("attr1", "val1")
        element.set_attribute("attr2", "val2")

        sub_element = HtmlElement("sub_element")
        sub_element.set_attribute("sub_attr_0", "val0")

        element.add_child(sub_element)

        self.assertEqual(element.get_attribute("attr1"), "val1")
        self.assertEqual(element.get_attribute("attr2"), "val2")
        self.assertEqual(element.get_children()[0].get_attribute("sub_attr_0"), "val0")


class TestHtmlGenerator(unittest.TestCase):
    def test_html_generator(self):
        gen = HtmlGenerator()
        el = HtmlElement("testElement")
        el.set_attribute("testAttr", "testVal")
        sel0 = HtmlElement("subEl0")
        sel0.set_attribute("sAttr", "sVal")
        sel1 = HtmlElement("subEl1")
        sel1.set_attribute("sAttr", "sVal")
        sel2 = HtmlElement("deep")
        sel2.set_attribute("a", "BB")
        sel0.add_child(sel2)
        el.add_child(sel0)
        el.add_child(sel1)

        expected = """
        <testElement testAttr="testVal">
          <subEl0 sAttr="sVal">
            <deep a="BB" />
          </subEl0>
          <subEl1 sAttr="sVal" />
        </testElement>
        """.strip()

        self.assertEqual(gen.generate_html(el).replace(" ", ""), expected.replace(" ", ""))


if __name__ == "__main__":
    unittest.main()

import unittest

from lib.application.context.context import Context, ContextComponentNotFoundException


class TestContext(unittest.TestCase):
    def test_assign_and_get_component(self):
        context = Context({"TestComponent": (2 + 5)})

        self.assertEqual(context.get_component("TestComponent"), 7)

    def test_get_component_that_is_not_exists(self):
        context = Context({})

        with self.assertRaises(ContextComponentNotFoundException):
            context.get_component("TestComponent")

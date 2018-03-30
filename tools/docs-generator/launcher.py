import os

import logging

from lib.application.configuration.configuration_xml_reader import ConfigurationXmlReader
from lib.application.context.context import ContextInitializer
from lib.application.context.context_components import ContextComponents
from lib.application.docs_generator import DocsGeneratorInitializer

CONFIGURATION_FILENAME = os.path.join(os.path.dirname(__file__), 'configuration.xml')


def main():
    logging.basicConfig(level=logging.INFO)

    configuration = ConfigurationXmlReader().read_from_file(CONFIGURATION_FILENAME)
    docs_generator_initializer = DocsGeneratorInitializer(ContextInitializer())
    docs_generator = docs_generator_initializer.initialize_docs_generator(configuration, ContextComponents)
    docs_generator.generate_docs()

main()

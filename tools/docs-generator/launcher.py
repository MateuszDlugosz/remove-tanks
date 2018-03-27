from lib.application.configuration.configuration import ConfigurationXmlReader
from lib.application.docs_generator import DocsGeneratorAssembler


def main():
    configuration = ConfigurationXmlReader().read_from_file("./configuration.xml")
    docs_generator_assembler = DocsGeneratorAssembler()
    docs_generator = docs_generator_assembler.assembly(configuration)
    docs_generator.generate_docs()

main()

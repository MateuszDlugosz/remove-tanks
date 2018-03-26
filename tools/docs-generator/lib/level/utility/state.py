import xml.etree.ElementTree as EXml


class StateXmlReader(object):
    STATE_ELEMENT = "state"
    STATES_ELEMENT = "states"

    def read_states_from_string(self, xml_string):
        try:
            states = []
            for state_element in EXml.fromstring(xml_string).findall(self.STATE_ELEMENT):
                states.append(self.read_state_from_string(EXml.tostring(state_element)))

            return states
        except Exception as e:
            raise StateXmlReadException(xml_string, e)

    def read_state_from_string(self, xml_string):
        try:
            return EXml.fromstring(xml_string).text.strip()
        except Exception as e:
            raise StateXmlReadException(xml_string, e)


class StateXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read state from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))

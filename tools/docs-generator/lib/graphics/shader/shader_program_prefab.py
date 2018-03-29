class ShaderProgramPrefab(object):
    def __init__(self, vertex_shader_filename, fragment_shader_filename):
        self.vertex_shader_filename = str(vertex_shader_filename)
        self.fragment_shader_filename = str(fragment_shader_filename)

    def get_vertex_shader_filename(self):
        return self.vertex_shader_filename

    def get_fragment_shader_filename(self):
        return self.fragment_shader_filename

    def __str__(self):
        return "ShaderProgramPrefab(vertex_shader_filename={}, fragment_shader_filename={})" \
                    .format(self.vertex_shader_filename, self.fragment_shader_filename)

class AnimationPrefab(object):
    def __init__(self, flip_x, flip_y):
        self.flip_x = bool(flip_x)
        self.flip_y = bool(flip_y)

    def get_flip_x(self):
        return self.flip_x

    def get_flip_y(self):
        return self.flip_y


class AtlasAnimationPrefab(AnimationPrefab):
    def __init__(self, flip_x, flip_y, atlas_filename, region_names, frame_duration, play_mode):
        super().__init__(flip_x, flip_y)
        self.atlas_filename = str(atlas_filename)
        self.region_names = region_names
        self.frame_duration = float(frame_duration)
        self.play_mode = str(play_mode)

    def get_atlas_filename(self):
        return self.atlas_filename

    def get_region_names(self):
        return self.region_names

    def get_frame_duration(self):
        return self.frame_duration

    def get_play_mode(self):
        return self.play_mode

    def __str__(self):
        return "AtlasAnimationPrefab(flip_x={}, flip_y={}, atlas_filename={}, region_names=[{}], " \
               "frame_duration={}, play_mode={})" \
                    .format(self.flip_x, self.flip_y, self.atlas_filename, ", ".join(self.region_names),
                            self.frame_duration, self.play_mode)


class FileAnimationPrefab(AnimationPrefab):
    def __init__(self, flip_x, flip_y, filenames, frame_duration, play_mode):
        super().__init__(flip_x, flip_y)
        self.filenames = filenames
        self.frame_duration = float(frame_duration)
        self.play_mode = str(play_mode)

    def get_filenames(self):
        return self.filenames

    def get_frame_duration(self):
        return self.frame_duration

    def get_play_mode(self):
        return self.play_mode

    def __str__(self):
        return "FileAnimationPrefab(flip_x={}, flip_y={}, filenames=[{}], frame_duration={}, play_mode={})" \
                .format(self.flip_x, self.flip_y, ", ".join(self.filenames), self.frame_duration, self.play_mode)

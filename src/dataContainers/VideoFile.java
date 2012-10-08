package dataContainers;

import java.io.File;

public class VideoFile extends MediaFile {
	
	public String director = null;
	public String title = null;
	
	public String language = null;
	public boolean hasSubtitles = false;
	
	int durationTime = 0; // In seconds

	public VideoFile(File file) {
		super(file);
	}

}

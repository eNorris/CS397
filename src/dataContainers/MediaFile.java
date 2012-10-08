package dataContainers;

import java.awt.Image;
import java.io.File;

public class MediaFile {
	
	/**Enumeration of possible file size types (Byte, kByte, MByte, GByte)*/
	public static enum FileSizeEnum{
		BYTE, KB, MB, GB
	}
	
	public File file = null;
	public Image thumbnail = null;
	public String description = null;
	public int fileSize = 0;
	public FileSizeEnum fileSizeType = FileSizeEnum.BYTE;
	
	/**Name of the file without extension ("C:\temp\file.txt" => "file")*/
	public String fileName = null;
	
	/**Extension of the file ("C:\temp\file.txt" => "txt")*/
	public String fileExt = null;
	
	public MediaFile(File file){
		setFile(file);
	}
	
	public void setThumbnail(Image thumbnail){
		this.thumbnail = thumbnail;
	}
	
	public void setFile(File file){
		this.file = file;
		setThumbnail(null);
		resolveFileSize();
		
		description = null;
		fileName = null;
		fileExt = null;
	}
	
	public void fetchMetaData(){
		
	}
	
	protected void resolveFileSize(){
		long sizeB = file.length();
		long sizeKB = sizeB / 1024;
		long sizeMB = sizeKB / 1024;
		long sizeGB = sizeMB / 1024;
		
		if(sizeKB < 10){
			fileSize = (int) sizeB;
			fileSizeType = FileSizeEnum.BYTE;
		}else if(sizeMB < 10){
			fileSize = (int) sizeKB;
			fileSizeType = FileSizeEnum.KB;
		}else if(sizeGB < 10){
			fileSize = (int) sizeMB;
			fileSizeType = FileSizeEnum.MB;
		}else{
			fileSize = (int) sizeGB;
			fileSizeType = FileSizeEnum.GB;
		}
	}
}
















